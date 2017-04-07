package com.iti.android.studentatendence.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.entity.BaseJson;
import com.iti.android.studentatendence.entity.TeacherCurrentCourse;
import com.iti.android.studentatendence.helper.BaseService;
import com.iti.android.studentatendence.http.BaseCallBack;
import com.iti.android.studentatendence.ui.activity.TeacherViewDetail;
import com.iti.android.studentatendence.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


/**
 * 首页签到
 *
 * @author Kevin
 * @date 2015-10-27
 */
public class TeacherHomeFragment extends Fragment {

    @BindView(R.id.tv_courseName)
    TextView mTvCourseName;
    @BindView(R.id.tv_classroom)
    TextView mTvClassroom;
    @BindView(R.id.tv_begin)
    TextView mTvBegin;
    @BindView(R.id.tv_end)
    TextView mTvEnd;
    @BindView(R.id.tv_view)
    TextView mTvView;
    @BindView(R.id.tv_Notpunch)
    TextView mTvNotpunch;
    @BindView(R.id.tv_Late)
    TextView mTvLate;
    @BindView(R.id.tv_Leave)
    TextView mTvLeave;
    @BindView(R.id.rv_view)
    RelativeLayout mRvView;
    private View mView;

    private TeacherCurrentCourse mTeacherCourse;

    private int mAttendenceNum;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.teacher_main, container, false);
        ButterKnife.bind(this, mView);

        initView();

        //定时刷新
        new Thread(new ThreadShow()).start();

        return mView;
    }

    // handler类接收数据
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //要做的事情
                initView();
                System.out.println("receive....");
            }
        };
    };

    class ThreadShow implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                    System.out.println("send...");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("thread error...");
                }
            }
        }
    }


    public void initView() {
        //http://localhost:8080/Community/TeacherLookAllCourseAction.action?teacherCode=87021&term=2014-2015-1-1&week=7
        OkHttpUtils.get().url(BaseService.GETCURRENTCOURSEDETAILACTION_URL)
                .addParams("teacherCode", "5070")
                .build().execute(new BaseCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(UIUtils.getContext(), "获取当前课程失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(BaseJson response, int id) {
                if (response.getResponState().equals("REQ_SUCCESS")) {        //获取成功


                    mTeacherCourse = new Gson().fromJson(response.getResponResult(), TeacherCurrentCourse.class);

                    //签到人数
                    mAttendenceNum = Integer.valueOf(mTeacherCourse.getAttendancedetail().get(0).getAttendant().toString().trim()) + Integer.valueOf(mTeacherCourse.getAttendancedetail().get(0).getLates().toString().trim());

                    mTvCourseName.setText(mTeacherCourse.getCourseList().get(0).getCourseName());
                    mTvClassroom.setText(mTeacherCourse.getCourseList().get(0).getClassRome());
//                    mTv.setText(mTeacherCourse.getCourseList().get(0).getClassRome());
                    mTvBegin.setText("上课时间："+mTeacherCourse.getCourseList().get(0).getCourseTimePeriod());
                    mTvView.setText(mAttendenceNum + "/" + mTeacherCourse.getAttendancedetail().get(0).getStudentTotal());

                    mTvLeave.setText(mTeacherCourse.getAttendancedetail().get(0).getLeave());

                    mTvLate.setText(mTeacherCourse.getAttendancedetail().get(0).getLates());

                    mTvNotpunch.setText(Integer.valueOf(mTeacherCourse.getAttendancedetail().get(0).getStudentTotal())-mAttendenceNum+"");


                } else {
                    Toast.makeText(UIUtils.getContext(), "没有数据", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //点击进入详情页面
    @OnClick(R.id.rv_view)
    public void onClick() {
        Intent intent = new Intent(UIUtils.getContext(), TeacherViewDetail.class);
        intent.putExtra("courseId", mTeacherCourse.getCourseList().get(0).getCourseId());
        startActivity(intent);


    }
}
