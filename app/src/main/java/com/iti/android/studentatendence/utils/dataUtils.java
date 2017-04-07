package com.iti.android.studentatendence.utils;

/**
 * 数据处理工具类
 * Created by Aleck_ on 2017/4/5.
 */

public class dataUtils {

    public static String getDay(int day){
        switch (day){
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
            default:

        }
        return null;
    }

}
