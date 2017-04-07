package com.iti.android.studentatendence.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.entity.StudentAttendanceHistory;

import java.util.List;

/**
 * Created by Aleck_ on 2017/4/5.
 */

public class TeacherViewHistoryAdapter extends RecyclerView.Adapter<TeacherViewHistoryAdapter.TeacherViewHistoryHolder> {

    private List<StudentAttendanceHistory> mStudentAttendanceList;
    private StudentAttendanceHistory mStudentAttendance;

    public TeacherViewHistoryAdapter(List<StudentAttendanceHistory> studentAttendances) {
        mStudentAttendanceList = studentAttendances;
    }

    @Override
    public TeacherViewHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_course_history, parent, false);
        final TeacherViewHistoryAdapter.TeacherViewHistoryHolder holder = new TeacherViewHistoryAdapter.TeacherViewHistoryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeacherViewHistoryHolder holder, int position) {
        StudentAttendanceHistory studentAttendanceHistory=mStudentAttendanceList.get(position);
        holder.bindData(studentAttendanceHistory);
    }

    @Override
    public int getItemCount() {
        return mStudentAttendanceList.size();
    }

    class TeacherViewHistoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvStudentName;
        private TextView mTvSNum;
        private TextView mTvClassName;
        private TextView mTvNum;



        public TeacherViewHistoryHolder(View itemView) {
            super(itemView);

            mTvStudentName = (TextView) itemView.findViewById(R.id.tv_studentName);
            mTvSNum = (TextView) itemView.findViewById(R.id.tv_sNum);
            mTvClassName = (TextView) itemView.findViewById(R.id.tv_className);
            mTvNum = (TextView) itemView.findViewById(R.id.tv_num);

            itemView.setOnClickListener(this);
        }
        public void bindData(StudentAttendanceHistory studentAttendanceHistory) {
            mTvStudentName.setText(studentAttendanceHistory.getSname());
            mTvSNum.setText(studentAttendanceHistory.getS_Num());
            mTvClassName.setText(studentAttendanceHistory.getClassName());
            mTvNum.setText(studentAttendanceHistory.getCount0()+"/"+Integer.valueOf(studentAttendanceHistory.getCount1())+Integer.valueOf(studentAttendanceHistory.getCount3()));
        }

        @Override
        public void onClick(View view) {

        }


    }
}
