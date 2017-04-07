package com.iti.android.studentatendence.entity;

import java.util.List;

/**
 * Created by Aleck_ on 2017/4/2.
 */

public class TeacherCurrentCourse {

    /**
     * CurrentWeek : 7
     * Attendancedetail : [{"attendant":"0","courseName":"计算机仿真技术","lates":"0","studentTotal":"2"}]
     * CourseList : [{"CourseId":3,"CourseCode":"0806000420","CourseName":"计算机仿真技术","TeacherCode":"5070","TeacherName":"高楠","ClassNames":"S1627","ClassRome":"12-B302","CourseTimeDate":3,"CiurseWeekDetail":"111111111111111111100000","CourseTimePeriod":"000011000000000","Term":"2016-2017-1-1"}]
     */

    private String CurrentWeek;
    private List<AttendancedetailBean> Attendancedetail;
    private List<CourseListBean> CourseList;

    public String getCurrentWeek() {
        return CurrentWeek;
    }

    public void setCurrentWeek(String CurrentWeek) {
        this.CurrentWeek = CurrentWeek;
    }

    public List<AttendancedetailBean> getAttendancedetail() {
        return Attendancedetail;
    }

    public void setAttendancedetail(List<AttendancedetailBean> Attendancedetail) {
        this.Attendancedetail = Attendancedetail;
    }

    public List<CourseListBean> getCourseList() {
        return CourseList;
    }

    public void setCourseList(List<CourseListBean> CourseList) {
        this.CourseList = CourseList;
    }

    public static class AttendancedetailBean {
        /**
         * attendant : 0
         * courseName : 计算机仿真技术
         * lates : 0
         * studentTotal : 2
         */

        private String attendant;
        private String courseName;
        private String lates;
        private String studentTotal;
        private String leave;

        public String getLeave() {
            return leave;
        }

        public void setLeave(String leave) {
            this.leave = leave;
        }

        public String getAttendant() {
            return attendant;
        }

        public void setAttendant(String attendant) {
            this.attendant = attendant;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getLates() {
            return lates;
        }

        public void setLates(String lates) {
            this.lates = lates;
        }

        public String getStudentTotal() {
            return studentTotal;
        }

        public void setStudentTotal(String studentTotal) {
            this.studentTotal = studentTotal;
        }
    }

    public static class CourseListBean {
        /**
         * CourseId : 3
         * CourseCode : 0806000420
         * CourseName : 计算机仿真技术
         * TeacherCode : 5070
         * TeacherName : 高楠
         * ClassNames : S1627
         * ClassRome : 12-B302
         * CourseTimeDate : 3
         * CiurseWeekDetail : 111111111111111111100000
         * CourseTimePeriod : 000011000000000
         * Term : 2016-2017-1-1
         */

        private int CourseId;
        private String CourseCode;
        private String CourseName;
        private String TeacherCode;
        private String TeacherName;
        private String ClassNames;
        private String ClassRome;
        private int CourseTimeDate;
        private String CiurseWeekDetail;
        private String CourseTimePeriod;
        private String Term;

        public int getCourseId() {
            return CourseId;
        }

        public void setCourseId(int CourseId) {
            this.CourseId = CourseId;
        }

        public String getCourseCode() {
            return CourseCode;
        }

        public void setCourseCode(String CourseCode) {
            this.CourseCode = CourseCode;
        }

        public String getCourseName() {
            return CourseName;
        }

        public void setCourseName(String CourseName) {
            this.CourseName = CourseName;
        }

        public String getTeacherCode() {
            return TeacherCode;
        }

        public void setTeacherCode(String TeacherCode) {
            this.TeacherCode = TeacherCode;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public String getClassNames() {
            return ClassNames;
        }

        public void setClassNames(String ClassNames) {
            this.ClassNames = ClassNames;
        }

        public String getClassRome() {
            return ClassRome;
        }

        public void setClassRome(String ClassRome) {
            this.ClassRome = ClassRome;
        }

        public int getCourseTimeDate() {
            return CourseTimeDate;
        }

        public void setCourseTimeDate(int CourseTimeDate) {
            this.CourseTimeDate = CourseTimeDate;
        }

        public String getCiurseWeekDetail() {
            return CiurseWeekDetail;
        }

        public void setCiurseWeekDetail(String CiurseWeekDetail) {
            this.CiurseWeekDetail = CiurseWeekDetail;
        }

        public String getCourseTimePeriod() {
            return CourseTimePeriod;
        }

        public void setCourseTimePeriod(String CourseTimePeriod) {
            this.CourseTimePeriod = CourseTimePeriod;
        }

        public String getTerm() {
            return Term;
        }

        public void setTerm(String Term) {
            this.Term = Term;
        }
    }
}
