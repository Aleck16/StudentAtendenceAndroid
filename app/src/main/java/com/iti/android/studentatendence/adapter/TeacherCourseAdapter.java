package com.iti.android.studentatendence.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.entity.TeacherLookAllCourseActionJson.AttendancedetailBean;
import com.iti.android.studentatendence.entity.TeacherLookAllCourseActionJson.CourseListBean;
import com.iti.android.studentatendence.ui.activity.HistoryActivity;
import com.iti.android.studentatendence.utils.UIUtils;
import com.iti.android.studentatendence.utils.dataUtils;

import java.util.List;

/**
 * Created by Aleck_ on 2017/4/2.
 */

public class TeacherCourseAdapter extends RecyclerView.Adapter<TeacherCourseAdapter.TeacherCourseHolder> {

    private List<CourseListBean> mTeacherCourses;
    private List<AttendancedetailBean> mAttendancedetails;
    private CourseListBean mTeacherCourse;

    public TeacherCourseAdapter(List<CourseListBean> teacherCourses, List<AttendancedetailBean> attendancedetailBeen) {
        mTeacherCourses = teacherCourses;
        mAttendancedetails = attendancedetailBeen;
    }

    @Override
    public TeacherCourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_course, parent, false);
        final TeacherCourseHolder holder = new TeacherCourseHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeacherCourseHolder holder, int position) {
        mTeacherCourse = mTeacherCourses.get(position);
        AttendancedetailBean attendancedetailBean = mAttendancedetails.get(position);
        holder.bindData(mTeacherCourse, attendancedetailBean);
    }

    @Override
    public int getItemCount() {
        return mTeacherCourses.size();
    }

    class TeacherCourseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTvCourseName;
        private TextView mTvRatio;
        //        private TextView mTvWeek;
        private TextView mTvDay;
        private TextView mTvTime;

        public TeacherCourseHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTvCourseName = (TextView) itemView.findViewById(R.id.tv_courseName);
            mTvRatio = (TextView) itemView.findViewById(R.id.tv_ratio);
//            mTvWeek = (TextView) itemView.findViewById(R.id.tv_week);
            mTvDay = (TextView) itemView.findViewById(R.id.tv_day);
            mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
        }

        public void bindData(CourseListBean teacherCourse, AttendancedetailBean attendancedetailBean) {
            mTvCourseName.setText(teacherCourse.getCourseName());
            mTvRatio.setText(attendancedetailBean.getAttendant() + "/" + attendancedetailBean.getLates() + "/" + attendancedetailBean.getStudentTotal());
//            mTvWeek.setText(teacherCourse.getCiurseWeekDetail());
            mTvDay.setText("星期" + dataUtils.getDay(teacherCourse.getCourseTimeDate()));
            mTvTime.setText("上课时间：" + teacherCourse.getCourseTimePeriod());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(UIUtils.getContext(), HistoryActivity.class);
            intent.putExtra("teacherCode",mTeacherCourse.getTeacherCode());
            intent.putExtra("courseCode", mTeacherCourse.getCourseCode());
            intent.putExtra("term", "2016-2017-1-1");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            UIUtils.getContext().startActivity(intent);
        }
    }
}
