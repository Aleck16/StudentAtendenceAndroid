package com.iti.android.studentatendence.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.iti.android.studentatendence.adapter.TeacherViewDetailAdapter;
import com.iti.android.studentatendence.entity.BaseJson;
import com.iti.android.studentatendence.entity.TeacherAttendanceDetail;
import com.iti.android.studentatendence.helper.BaseService;
import com.iti.android.studentatendence.http.BaseCallBack;
import com.iti.android.studentatendence.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class TeacherViewDetail extends AppCompatActivity {

    @BindView(R.id.teacher_detail_toolbar)
    Toolbar mTeacherDetailToolbar;
    @BindView(R.id.rv_detail)
    RecyclerView mRvDetail;

    private LinearLayoutManager manager;

    private static TeacherViewDetailAdapter mAdapter;
    private List<TeacherAttendanceDetail> mTeacherAttendanceDetails = new ArrayList<>();
    private int mCourseId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view_detail);
        ButterKnife.bind(this);



        //获取传递过来的surveyid
        Intent intent = getIntent();
        mCourseId = intent.getIntExtra("courseId", 0);

        mTeacherDetailToolbar.setTitle("考勤详情");
        setSupportActionBar(mTeacherDetailToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); //不显示bar的返回按钮
        }

        manager = new LinearLayoutManager(UIUtils.getContext());
        mAdapter = new TeacherViewDetailAdapter(mTeacherAttendanceDetails);
        mRvDetail.setLayoutManager(manager);
        mRvDetail.setAdapter(mAdapter);

        initData();
        //定时刷新
        new Thread(new ThreadShow()).start();
    }

    // handler类接收数据
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //要做的事情
                initData();
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

    private void initData() {

        //http://10.200.68.29:8081/Community/CurrentCourseAllStudentAttendRecordAction.action?courseId=5
            OkHttpUtils.get().url(BaseService.CURRENTCOURSEALLSTUDENTATTENDRECORDACTION_URL)
                    .addParams("courseId", String.valueOf(mCourseId))
                    .build().execute(new BaseCallBack() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    Toast.makeText(UIUtils.getContext(), "获取签到详情失败", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(BaseJson response, int id) {

                    if (response.getResponState().equals("REQ_SUCCESS")) {        //获取成功
                        mTeacherAttendanceDetails.clear();      //清空数据

                        mTeacherAttendanceDetails =
                                new Gson().fromJson(response.getResponResult(),new TypeToken<List<TeacherAttendanceDetail>>(){}.getType());

                        mAdapter = new TeacherViewDetailAdapter(mTeacherAttendanceDetails);
                        mRvDetail.setLayoutManager(manager);
                        mRvDetail.setAdapter(mAdapter);

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

    public static void refresh(){
        mAdapter.notifyDataSetChanged();
    }
}
