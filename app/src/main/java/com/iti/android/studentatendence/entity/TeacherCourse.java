package com.iti.android.studentatendence.entity;

/**
 * Created by Aleck_ on 2017/4/2.
 */

public class TeacherCourse {

    //[{"CourseId":8,"CourseCode":"0001022620","CourseName":"社会心理学","TeacherCode":"87021","TeacherName":"王自华","CampusAreaNum":2,"ClassNames":"","ClassRome":"12-B302","CourseDepartment":11,"CourseSeriaNum":"01","CourseTimeDate":4,"CourseTimeDuratio":3,"CourseTimeStartPer":9,"CiurseWeekDetail":"000000111111111100000000","GradeAndTerm":"2014-1","HistoryId":64570,"NumberOfClass":0,"State":0,"TeacherBuildingN":12,"TimeStamp":1441678993259,"SchoolCode":"10080","CourseTimePeriod":"000000001110000","CourseTimeName":"","Term":"2014-2015-1-1"},
    // {"CourseId":9,"CourseCode":"0001024620","CourseName":"心理咨询与心理危机干预","TeacherCode":"87021","TeacherName":"王自华","CampusAreaNum":2,"ClassNames":"","ClassRome":"12-D114","CourseDepartment":11,"CourseSeriaNum":"01","CourseTimeDate":3,"CourseTimeDuratio":3,"CourseTimeStartPer":9,"CiurseWeekDetail":"000000111111111100000000","GradeAndTerm":"2014-1","HistoryId":64571,"NumberOfClass":0,"State":0,"TeacherBuildingN":12,"TimeStamp":1441678993264,"SchoolCode":"10080","CourseTimePeriod":"000000001110000","CourseTimeName":"","Term":"2014-2015-1-1"}]
    // {"week":"8"}{"attendant":"0","lates":"0","studentTotal":"0","courseName":"社会心理学"}
    // {"attendant":"0","lates":"0","studentTotal":"0","courseName":"心理咨询与心理危机干预"}
    /**
     * CourseId : 8
     * CourseCode : 0001022620
     * CourseName : 社会心理学
     * TeacherCode : 87021
     * TeacherName : 王自华
     * CampusAreaNum : 2
     * ClassNames :
     * ClassRome : 12-B302
     * CourseDepartment : 11
     * CourseSeriaNum : 01
     * CourseTimeDate : 4
     * CourseTimeDuratio : 3
     * CourseTimeStartPer : 9
     * CiurseWeekDetail : 000000111111111100000000
     * GradeAndTerm : 2014-1
     * HistoryId : 64570
     * NumberOfClass : 0
     * State : 0
     * TeacherBuildingN : 12
     * TimeStamp : 1441678993259
     * SchoolCode : 10080
     * CourseTimePeriod : 000000001110000
     * CourseTimeName :
     * Term : 2014-2015-1-1
     */

    private int CourseId;
    private String CourseCode;
    private String CourseName;
    private String TeacherCode;
    private String TeacherName;
    private int CampusAreaNum;
    private String ClassNames;
    private String ClassRome;
    private int CourseDepartment;
    private String CourseSeriaNum;
    private int CourseTimeDate;
    private int CourseTimeDuratio;
    private int CourseTimeStartPer;
    private String CiurseWeekDetail;
    private String GradeAndTerm;
    private int HistoryId;
    private int NumberOfClass;
    private int State;
    private int TeacherBuildingN;
    private long TimeStamp;
    private String SchoolCode;
    private String CourseTimePeriod;
    private String CourseTimeName;
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

    public int getCampusAreaNum() {
        return CampusAreaNum;
    }

    public void setCampusAreaNum(int CampusAreaNum) {
        this.CampusAreaNum = CampusAreaNum;
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

    public int getCourseDepartment() {
        return CourseDepartment;
    }

    public void setCourseDepartment(int CourseDepartment) {
        this.CourseDepartment = CourseDepartment;
    }

    public String getCourseSeriaNum() {
        return CourseSeriaNum;
    }

    public void setCourseSeriaNum(String CourseSeriaNum) {
        this.CourseSeriaNum = CourseSeriaNum;
    }

    public int getCourseTimeDate() {
        return CourseTimeDate;
    }

    public void setCourseTimeDate(int CourseTimeDate) {
        this.CourseTimeDate = CourseTimeDate;
    }

    public int getCourseTimeDuratio() {
        return CourseTimeDuratio;
    }

    public void setCourseTimeDuratio(int CourseTimeDuratio) {
        this.CourseTimeDuratio = CourseTimeDuratio;
    }

    public int getCourseTimeStartPer() {
        return CourseTimeStartPer;
    }

    public void setCourseTimeStartPer(int CourseTimeStartPer) {
        this.CourseTimeStartPer = CourseTimeStartPer;
    }

    public String getCiurseWeekDetail() {
        return CiurseWeekDetail;
    }

    public void setCiurseWeekDetail(String CiurseWeekDetail) {
        this.CiurseWeekDetail = CiurseWeekDetail;
    }

    public String getGradeAndTerm() {
        return GradeAndTerm;
    }

    public void setGradeAndTerm(String GradeAndTerm) {
        this.GradeAndTerm = GradeAndTerm;
    }

    public int getHistoryId() {
        return HistoryId;
    }

    public void setHistoryId(int HistoryId) {
        this.HistoryId = HistoryId;
    }

    public int getNumberOfClass() {
        return NumberOfClass;
    }

    public void setNumberOfClass(int NumberOfClass) {
        this.NumberOfClass = NumberOfClass;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public int getTeacherBuildingN() {
        return TeacherBuildingN;
    }

    public void setTeacherBuildingN(int TeacherBuildingN) {
        this.TeacherBuildingN = TeacherBuildingN;
    }

    public long getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(long TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    public String getSchoolCode() {
        return SchoolCode;
    }

    public void setSchoolCode(String SchoolCode) {
        this.SchoolCode = SchoolCode;
    }

    public String getCourseTimePeriod() {
        return CourseTimePeriod;
    }

    public void setCourseTimePeriod(String CourseTimePeriod) {
        this.CourseTimePeriod = CourseTimePeriod;
    }

    public String getCourseTimeName() {
        return CourseTimeName;
    }

    public void setCourseTimeName(String CourseTimeName) {
        this.CourseTimeName = CourseTimeName;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }
}
