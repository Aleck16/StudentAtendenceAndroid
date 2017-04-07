package com.iti.android.studentatendence.entity;

/**
 * Created by Aleck_ on 2017/4/2.
 */

public class BaseJson {
    /**
     * responResult : [{"CourseId":8,"CourseCode":"0001022620","CourseName":"社会心理学","TeacherCode":"87021","TeacherName":"王自华","CampusAreaNum":2,"ClassNames":"","ClassRome":"12-B302","CourseDepartment":11,"CourseSeriaNum":"01","CourseTimeDate":4,"CourseTimeDuratio":3,"CourseTimeStartPer":9,"CiurseWeekDetail":"000000111111111100000000","GradeAndTerm":"2014-1","HistoryId":64570,"NumberOfClass":0,"State":0,"TeacherBuildingN":12,"TimeStamp":1441678993259,"SchoolCode":"10080","CourseTimePeriod":"000000001110000","CourseTimeName":"","Term":"2014-2015-1-1"},{"CourseId":9,"CourseCode":"0001024620","CourseName":"心理咨询与心理危机干预","TeacherCode":"87021","TeacherName":"王自华","CampusAreaNum":2,"ClassNames":"","ClassRome":"12-D114","CourseDepartment":11,"CourseSeriaNum":"01","CourseTimeDate":3,"CourseTimeDuratio":3,"CourseTimeStartPer":9,"CiurseWeekDetail":"000000111111111100000000","GradeAndTerm":"2014-1","HistoryId":64571,"NumberOfClass":0,"State":0,"TeacherBuildingN":12,"TimeStamp":1441678993264,"SchoolCode":"10080","CourseTimePeriod":"000000001110000","CourseTimeName":"","Term":"2014-2015-1-1"}]{"week":"8"}{"attendant":"0","lates":"0","studentTotal":"0","courseName":"社会心理学"}{"attendant":"0","lates":"0","studentTotal":"0","courseName":"心理咨询与心理危机干预"}
     * responState : REQ_SUCCESS
     */
    //jsonFormat的使用，先复制Json字符串，然后用快捷键alt+insert，就会自动弹出

    private String responResult;
    private String responState;

    public String getResponResult() {
        return responResult;
    }

    public void setResponResult(String responResult) {
        this.responResult = responResult;
    }

    public String getResponState() {
        return responState;
    }

    public void setResponState(String responState) {
        this.responState = responState;
    }
}
