package chapter2.dozer.joda;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * @version :1.0.0
 * @author: term
 * @time: 2018-04-15 11:54
 * @description :
 */
public class JodaTimeTest {

    @Test
    public void method() {

        DateTime dateTime = new DateTime(2018, 4, 15, 11, 58, 1);

        LocalDate start = new LocalDate(2018, 4, 15);
        LocalDate end = new LocalDate(2018, 4, 13);

        System.out.println(start.isBefore(end));

        System.out.println(Days.daysBetween(start, end).getDays());

        DateTime.Property property = new DateTime().plusDays(3)
                .dayOfWeek();

        System.out.println(property.withMinimumValue());
        System.out.println(property.withMaximumValue());

        org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        DateTime dateTime1 = DateTime.parse("2012-12-21 23:22:45", dateTimeFormatter);

        System.out.println(dateTime1.toString("yyyy/MM/dd HH:mm:ss EE", Locale.CHINESE));
    }

    @Test
    public void method2() {

        Date date = new Date();
        DateTime dateTime = new DateTime(date);

        Calendar calendar = Calendar.getInstance();
        dateTime = dateTime.plusDays(1) // 增加天
                .plusYears(1)// 增加年
                .plusMonths(1)// 增加月
                .plusWeeks(1)// 增加星期
                .minusMillis(1)// 减分钟
                .minusHours(1)// 减小时
                .minusSeconds(1);// 减秒数

        Date toDate = dateTime.toDate();

        Calendar calendar1 = dateTime.toCalendar(Locale.CHINESE);


    }

    /**
     * joda -time
     * instant 表示时间轴上的
     */
    @Test
    public void method4() {

        LocalDate.now().plusDays(1).toDate();

        new DateTime();

        System.out.println(new DateTime(System.currentTimeMillis()));


        System.out.println(new DateTime("2018-04-15T13:23:12"));

        DateTime dateTime2000Year = new DateTime(2000, 2, 29, 0, 0, 0);
        System.out.println(dateTime2000Year);

        System.out.println(dateTime2000Year.withYear(1997));
        System.out.println(LocalDateTime.now());
        System.out.println(java.time.LocalDate.now());
        System.out.println(LocalTime.now());
    }

    @Test
    public void method3() {

        DateTime now = new DateTime();

        System.out.println(now.monthOfYear().getAsText(Locale.US));
        System.out.println(now.dayOfWeek().getAsText());
        System.out.println(now.dayOfWeek().getAsShortText(Locale.CHINESE));

        DateTime dateTime = now.minusDays(0);
        //  11:12
        DateTime dateTime1 = dateTime.withTime(11, 11, 30, 0);
        System.out.println(dateTime1.minuteOfHour().roundCeilingCopy());
        System.out.println(dateTime1.minuteOfHour().roundFloorCopy());
        System.out.println(dateTime1.minuteOfHour().roundHalfCeilingCopy());
        System.out.println(dateTime1.minuteOfHour().roundHalfFloorCopy());
        System.out.println(dateTime1.minuteOfHour().roundHalfEvenCopy());

    }

    @Test
    public void method5() {
        DateTime start = new DateTime();
        DateTime end = new DateTime().plusDays(5);
        Interval interval = new Interval(start, end);

        System.out.println(interval.contains(new DateTime().plusDays(1)));


        Period period = new Period(3, 1, 4, 5);

        System.out.println(period.getHours());
        System.out.println(period.getMillis());
        Duration duration = new Duration(24 * 60 * 60 * 1000L);
        System.out.println(duration.getStandardDays());
        System.out.println(duration.getStandardSeconds());
    }

    @Test
    public void method6() {
        DateTime dateTime = new DateTime(2018, 4, 15, 15, 4, 30);
//        System.out.println(dateTime.toString("dd-MM-yyyy HH:mm:ss"));

        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(formatter.print(dateTime));

        DateTime dateTime2 = DateTime.parse("2017-7-22 7:22:45", formatter);

        System.out.println(dateTime2);
        LocalDate start = new LocalDate(2017, 7, 22);
        LocalDate end = new LocalDate(2018, 6, 6);
        System.out.println(Days.daysBetween(start, end).getDays());
    }

    @Test
    public void  method7(){
        DateTime dt4 = new DateTime();
        org.joda.time.DateTime.Property month = dt4.monthOfYear();
//        System.out.println("是否闰月:" + month.isLeap());
        DateTime dt5 = dt4.secondOfMinute().addToCopy(-3);
        System.out.println(dt4);
        System.out.println(dt5);

        Duration duration = new Duration(dt4.plusDays(1).plusHours(3)
                .plusMinutes(3).plusSeconds(4).toDate().getTime() - dt4.toDate().getTime()
        );

        System.out.println("天--->"+duration.getStandardDays());
        System.out.println("小时--->"+duration.getStandardHours());
        System.out.println("分钟--->"+duration.getStandardMinutes());
        System.out.println("秒---->"+duration.getStandardSeconds());

        System.out.println(Seconds.secondsBetween(dt4,dt5).getSeconds());
    }



    @Test
    public void method8(){

//        System.out.println(org.joda.time.LocalDateTime.now());
////
////        System.out.println(new DateTime());
////
////
////        System.out.println(java.time.LocalDate.now());
////        System.out.println(java.time.LocalTime.now());
////        System.out.println(LocalDateTime.now());




    }

}
