package com.iti.android.studentatendence.helper;

/**
 * Created by xueli on 2016/12/15.
 */

public class BaseService {


//    StudentSearchInfoAction.action?studentCode=201632103011&term=2016-2017-1-1&courseId=6&state=0

    //    private String HEAD = "http://localhost/";
    private static String HEAD = "http://10.1.14.163:8081/Community/";      //我的地址
//    private static String HEAD = "http://10.1.14.99:8080/Community/";      //子琪的地址
//    private static String HEAD = "http://10.200.68.29:8081/Community/";      //剑剑的地址

    public final static String TEACHERALLCOURSELIST_URL = HEAD + "TeacherLookAllCourseAction" +
            ".action";

    //http://localhost:8080/Community/GetCurrentCouseDetailAction.action?teacherCode=5070
    public final static String GETCURRENTCOURSEDETAILACTION_URL = HEAD + "GetCurrentCouseDetailAction" +
            ".action";

    //获取当前签到的详细信息
    //http://10.200.68.29:8081/Community/CurrentCourseAllStudentAttendRecordAction.action?courseId=5
    public final static String CURRENTCOURSEALLSTUDENTATTENDRECORDACTION_URL = HEAD + "CurrentCourseAllStudentAttendRecordAction" +
            ".action";
    //签到接口
    //http://10.200.68.29:8081/Community/SetAttendStateAction.action?attendantId=1&state=1
    public final static String SETATTENDSTATEACTION_URL = HEAD + "SetAttendStateAction" +
            ".action";

    //获取某一门课的所有签到记录接口
    //http://10.1.14.163:8081/Community/TeacherGetCourseAllAttendRecordAction.action?teacherCode=5070&courseCode=0806000423&term=2016-2017-1-1
    public final static String GETHISTORYATTENDANCE_URL = HEAD + "TeacherGetCourseAllAttendRecordAction" +
            ".action";
}
