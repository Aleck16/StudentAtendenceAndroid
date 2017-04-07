package com.iti.android.studentatendence.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.adapter.TeacherCourseAdapter;
import com.iti.android.studentatendence.entity.BaseJson;
import com.iti.android.studentatendence.entity.TeacherLookAllCourseActionJson;
import com.iti.android.studentatendence.helper.BaseService;
import com.iti.android.studentatendence.http.BaseCallBack;
import com.iti.android.studentatendence.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;


/**
 * 历史记录
 *
 * @author Kevin
 * @date 2015-10-27
 */
public class TeacherHistoryFragment extends Fragment {

    @BindView(R.id.sp_term)
    Spinner mSpTerm;
    @BindView(R.id.sp_week)
    Spinner mSpWeek;
    @BindView(R.id.rv_course)
    RecyclerView mRvCourse;
    private View mView;

    private LinearLayoutManager manager;

    private TeacherCourseAdapter mAdapter;
    private TeacherLookAllCourseActionJson mTeacherCourses = new TeacherLookAllCourseActionJson();
    private int mWeek;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.teacher_history, container, false);
        ButterKnife.bind(this, mView);

        manager=new LinearLayoutManager(UIUtils.getContext());
        if(mTeacherCourses.getCourseList()!=null){
            mAdapter=new TeacherCourseAdapter(mTeacherCourses.getCourseList(),mTeacherCourses.getAttendancedetail());
            mRvCourse.setLayoutManager(manager);
            mRvCourse.setAdapter(mAdapter);
        }


        initTeacherCourse("2014-2015-1-1",7);


        mSpWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mWeek = i+1;

                initTeacherCourse("2014-2015-1-1",mWeek);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        return mView;
    }

    public void initTeacherCourse(String term,int week) {
        //http://localhost:8080/Community/TeacherLookAllCourseAction.action?teacherCode=87021&term=2014-2015-1-1&week=7
        OkHttpUtils.get().url(BaseService.TEACHERALLCOURSELIST_URL)
                .addParams("teacherCode", "87021")
                .addParams("term", term)
                .addParams("week", String.valueOf(week))
                .build().execute(new BaseCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(UIUtils.getContext(), "获取所有课程失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(BaseJson response, int id) {
                if (response.getResponState().equals("REQ_SUCCESS")) {        //获取成功
                    if(mTeacherCourses.getCourseList()!=null){
                        mTeacherCourses.getCourseList().clear();        //清空原来的数据
                        mTeacherCourses.getAttendancedetail().clear();        //清空原来的数据
                    }

                    mTeacherCourses = new Gson().fromJson(response.getResponResult(),TeacherLookAllCourseActionJson.class);
                    String d=mTeacherCourses.getCurrentWeek();
//                    mAdapter = new TeacherCourseAdapter(mTeacherCourses);
//                    mRvCourse.setAdapter(mAdapter);
                    if(mTeacherCourses.getCourseList()!=null){
//                        mTeacherCourses.getCourseList().clear();
                        mAdapter=new TeacherCourseAdapter(mTeacherCourses.getCourseList(),mTeacherCourses.getAttendancedetail());
                        mRvCourse.setLayoutManager(manager);
                        mRvCourse.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();    //更新数据
                    }

                } else {
                    if(mTeacherCourses.getCourseList()!=null){
                        mTeacherCourses.getCourseList().clear();        //清空原来的数据
                        mTeacherCourses.getAttendancedetail().clear();        //清空原来的数据
                        mAdapter.notifyDataSetChanged();    //更新数据
                    }

                    Toast.makeText(UIUtils.getContext(), "没有数据", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
