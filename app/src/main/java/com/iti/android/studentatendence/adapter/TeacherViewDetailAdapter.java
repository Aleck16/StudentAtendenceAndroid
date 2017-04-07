package com.iti.android.studentatendence.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.entity.BaseJson;
import com.iti.android.studentatendence.entity.TeacherAttendanceDetail;
import com.iti.android.studentatendence.helper.BaseService;
import com.iti.android.studentatendence.http.BaseCallBack;
import com.iti.android.studentatendence.ui.activity.TeacherViewDetail;
import com.iti.android.studentatendence.utils.UIUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Aleck_ on 2017/4/5.
 */

public class TeacherViewDetailAdapter extends RecyclerView.Adapter<TeacherViewDetailAdapter.TeacherViewDetailHolder> {


    private List<TeacherAttendanceDetail> mTeacherAttendanceDetails;
    private int mAttendanceId;
    private int mState;

    public TeacherViewDetailAdapter(List<TeacherAttendanceDetail> teacherAttendanceDetails) {
        mTeacherAttendanceDetails = teacherAttendanceDetails;
    }

    @Override
    public TeacherViewDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_course_detail, parent, false);
        final TeacherViewDetailAdapter.TeacherViewDetailHolder holder = new TeacherViewDetailAdapter.TeacherViewDetailHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeacherViewDetailHolder holder, int position) {
        TeacherAttendanceDetail teacherViewDetail = mTeacherAttendanceDetails.get(position);

        holder.bindData(teacherViewDetail);
    }

    @Override
    public int getItemCount() {
        return mTeacherAttendanceDetails.size();
    }

    class TeacherViewDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvStudentName;
        private TextView mTvSNum;
        private TextView mTvClassName;
        private TextView mTvState;

        private TeacherAttendanceDetail mTeacherAttendanceDetail;


        public TeacherViewDetailHolder(View itemView) {
            super(itemView);

            mTvStudentName = (TextView) itemView.findViewById(R.id.tv_studentName);
            mTvSNum = (TextView) itemView.findViewById(R.id.tv_sNum);
            mTvClassName = (TextView) itemView.findViewById(R.id.tv_className);
            mTvState = (TextView) itemView.findViewById(R.id.tv_state);

            itemView.setOnClickListener(this);

        }

        public void bindData(TeacherAttendanceDetail teacherAttendanceDetail) {
            mTeacherAttendanceDetail=teacherAttendanceDetail;

            mTvStudentName.setText(teacherAttendanceDetail.getSname());
            mTvSNum.setText(teacherAttendanceDetail.getS_Num());
            mTvClassName.setText(teacherAttendanceDetail.getClassName());
            switch (teacherAttendanceDetail.getState()) {
                case 0:     //未签到
                    mTvState.setText("未签到");       //是否签到
                    mTvState.setTextColor(UIUtils.getColor(R.color.red));
                    break;
                case 1:     //已签到
                    mTvState.setText("已签到");       //是否签到
                    mTvState.setTextColor(UIUtils.getColor(R.color.gree));
                    break;
                case 2:      //迟到
                    mTvState.setText("迟到");       //是否签到
                    mTvState.setTextColor(UIUtils.getColor(R.color.yellow));
                    break;
                case 3:     //请假
                    mTvState.setText("请假");       //是否签到
                    mTvState.setTextColor(UIUtils.getColor(R.color.yellow));
                    break;
                default:        //其他

                    break;
            }

        }

        @Override
        public void onClick(View view) {
            mAttendanceId = mTeacherAttendanceDetail.getId();
            //设置成签到成功
            mState = 1;

            switch (mTeacherAttendanceDetail.getState()){
                case 0:
                    setState(mAttendanceId,mState);   //设置签到
                    break;
                case 1:
                    Toast.makeText(UIUtils.getContext(), "已签到，不能修改！", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(UIUtils.getContext(), "已签到，不能修改！", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(UIUtils.getContext(), "已请假，不能修改！", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        }
    }

//    /**
//     * 确认签到
//     */
//    public void dialog() {
//        new AlertDialog.Builder(UIUtils.getContext()).setTitle("确认退出吗？")
//                .setIcon(android.R.drawable.ic_dialog_info)
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 点击“确认”后的操作
//                        setState(mAttendanceId,mState);   //设置签到
//
//                    }
//                })
//                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 点击“返回”后的操作,这里不设置没有任何操作
//                    }
//                }).show();
//    }


    public void setState(int id,int state){
        OkHttpUtils.get().url(BaseService.SETATTENDSTATEACTION_URL)
                .addParams("attendantId", String.valueOf(id))
                .addParams("state", String.valueOf(state))
                .build().execute(new BaseCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(UIUtils.getContext(), "联网失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(BaseJson response, int id) {

                if (response.getResponState().equals("REQ_SUCCESS")) {        //获取成功
                    Toast.makeText(UIUtils.getContext(), "设置签到成功", Toast.LENGTH_SHORT).show();
                    //刷新界面
                    TeacherViewDetail.refresh();    //刷新页面

                } else {
                    Toast.makeText(UIUtils.getContext(), "设置签到失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
