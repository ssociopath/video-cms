package org.video.cms.common.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author bobo
 * @date 2020/12/21
 */

public class DateUtil {
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static java.sql.Date util2Sql(Date date){
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Date str2Sql(String date) throws ParseException {
        return util2Sql(df.parse(date));
    }

    public static LocalDate date2LocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate strDate2LocalDate(String date) throws ParseException {
        return date2LocalDate(df.parse(date));
    }
}
