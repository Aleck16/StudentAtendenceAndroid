package com.iti.android.studentatendence.entity;

/**
 * Created by Aleck_ on 2017/4/2.
 */

public class TeacherAttendanceDetail {

    //[{"id":2,"CourseId":5,"S_Num":"201632103011","Sname":"胡坚剑","ClassName":"S1627","CourseName":"计算机仿真技术","Term":"2016-2017-1-1","WeekDetail":"7","CourseTimeDate":3,"State":1},{"id":3,"CourseId":5,"S_Num":"201632104005","Sname":"李茹婷","ClassName":"S1628","CourseName":"计算机仿真技术","Term":"2016-2017-1-1","WeekDetail":"7","CourseTimeDate":3,"State":0},{"id":5,"CourseId":5,"S_Num":"201632104008","Sname":"彭伟桃","ClassName":"S1628","CourseName":"计算机仿真技术","Term":"2016-2017-1-1","WeekDetail":"7","CourseTimeDate":3,"AttendantTime":"","State":2}]

    /**
     * id : 2
     * CourseId : 5
     * S_Num : 201632103011
     * Sname : 胡坚剑
     * ClassName : S1627
     * CourseName : 计算机仿真技术
     * Term : 2016-2017-1-1
     * WeekDetail : 7
     * CourseTimeDate : 3
     * State : 1
     * AttendantTime :
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
    private String AttendantTime;

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

    public String getAttendantTime() {
        return AttendantTime;
    }

    public void setAttendantTime(String AttendantTime) {
        this.AttendantTime = AttendantTime;
    }
}
