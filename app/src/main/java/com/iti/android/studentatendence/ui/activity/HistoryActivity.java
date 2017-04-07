package com.iti.android.studentatendence.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.adapter.TeacherViewHistoryAdapter;
import com.iti.android.studentatendence.entity.BaseJson;
import com.iti.android.studentatendence.entity.StudentAttendanceHistory;
import com.iti.android.studentatendence.helper.BaseService;
import com.iti.android.studentatendence.http.BaseCallBack;
import com.iti.android.studentatendence.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.history_toolbar)
    Toolbar mHistoryToolbar;
    @BindView(R.id.rv_history)
    RecyclerView mRvHistory;
    private String mTeacherCode;
    private String mCourseCode;
    private String mTerm;

    private LinearLayoutManager manager;

    private static TeacherViewHistoryAdapter mAdapter;
    private List<StudentAttendanceHistory> mStudentAttendances = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        //获取传递过来的surveyid
        Intent intent = getIntent();
        mTeacherCode = intent.getStringExtra("teacherCode");
        mCourseCode = intent.getStringExtra("courseCode");
        mTerm = intent.getStringExtra("term");

        mHistoryToolbar.setTitle("历史签到详情");
        setSupportActionBar(mHistoryToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); //不显示bar的返回按钮
        }

        manager = new LinearLayoutManager(UIUtils.getContext());
        mAdapter = new TeacherViewHistoryAdapter(mStudentAttendances);
        mRvHistory.setLayoutManager(manager);
        mRvHistory.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        //http://localhost:8081/Community/TeacherGetCourseAllAttendRecordAction.action?teacherCode=5070&courseCode=0806000420&term=2016-2017-1-1
        OkHttpUtils.get().url(BaseService.GETHISTORYATTENDANCE_URL)
//                .addParams("teacherCode", String.valueOf(mTeacherCode))
//                .addParams("courseCode", String.valueOf(mCourseCode))
                .addParams("teacherCode", "5070")
                .addParams("courseCode", "0806000423")
                .addParams("term", String.valueOf(mTerm))

                .build().execute(new BaseCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(UIUtils.getContext(), "获取签到详情失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(BaseJson response, int id) {

                if (response.getResponState().equals("REQ_SUCCESS")) {        //获取成功
                    mStudentAttendances.clear();      //清空数据

                    mStudentAttendances =
                            new Gson().fromJson(response.getResponResult(),new TypeToken<List<StudentAttendanceHistory>>(){}.getType());

                    mAdapter = new TeacherViewHistoryAdapter(mStudentAttendances);
                    mRvHistory.setLayoutManager(manager);
                    mRvHistory.setAdapter(mAdapter);

                    mAdapter.notifyDataSetChanged();    //更新数据

                } else {
                    Toast.makeText(UIUtils.getContext(), "没有数据", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:     //返回键
                finish();
                break;
            case R.id.setting:       //设置
                break;
            default:
                break;
        }
        return true;
    }
}
