package com.iti.android.studentatendence.entity;

/**
 * Created by Aleck_ on 2017/4/7.
 */

public class StudentAttendanceHistory {

    /**
     * id : 9
     * CourseId : 6
     * S_Num : 201632103011
     * Sname : 胡坚剑
     * ClassName : S1627
     * CourseName : 计算机仿真技术
     * Term : 2016-2017-1-1
     * WeekDetail : 7
     * CourseTimeDate : 5
     * State : 0
     */

    private int id;
    private int CourseId;
    private String S_Num;
    private String Sname;
    private String ClassName;
    private String CourseName;
    private String Term;
    private String WeekDetail;
    private int CourseTimeDate;
    private int State;
    private int Count0;     //未签
    private int Count1;     //已签
    private int Count2;     //迟到
    private int Count3;     //请假

    public int getCount0() {
        return Count0;
    }

    public void setCount0(int count0) {
        Count0 = count0;
    }

    public int getCount1() {
        return Count1;
    }

    public void setCount1(int count1) {
        Count1 = count1;
    }

    public int getCount2() {
        return Count2;
    }

    public void setCount2(int count2) {
        Count2 = count2;
    }

    public int getCount3() {
        return Count3;
    }

    public void setCount3(int count3) {
        Count3 = count3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public String getS_Num() {
        return S_Num;
    }

    public void setS_Num(String S_Num) {
        this.S_Num = S_Num;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }

    public String getWeekDetail() {
        return WeekDetail;
    }

    public void setWeekDetail(String WeekDetail) {
        this.WeekDetail = WeekDetail;
    }

    public int getCourseTimeDate() {
        return CourseTimeDate;
    }

    public void setCourseTimeDate(int CourseTimeDate) {
        this.CourseTimeDate = CourseTimeDate;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }
}
