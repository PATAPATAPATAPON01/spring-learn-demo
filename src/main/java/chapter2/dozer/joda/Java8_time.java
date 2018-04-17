package chapter2.dozer.joda;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @version :1.0.0
 * @author: term
 * @time: 2018-04-15 18:37
 * @description :
 */
public class Java8_time {

    @Test
    public void method(){


        LocalDate localDate = LocalDate.of(2018, 4, 15);
        LocalDate localDate2 = LocalDate.of(2018, 5, 16);

        Period period = Period.between(localDate, localDate2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        Period of = Period.of(1, 3, 12);
        System.out.println(of.getYears());
        System.out.println(of.getMonths());
        System.out.println(of.getDays());

        System.out.println("======");
//        org.joda.time.Period.hours()
        org.joda.time.Period jodaPeriod = org.joda.time.Period.minutes(1).withDays(2).withMinutes(100).withMillis(300);
        System.out.println(jodaPeriod.getDays());
        System.out.println(jodaPeriod.getMinutes());
        System.out.println(jodaPeriod.getMillis());
        //period java8是以年月日来建模  joda 支持到毫秒

        System.out.println("----------------");
        Duration duration = new Duration(24 * 60 * 60 * 1000L+100L);
        System.out.println(duration.getStandardDays());
        System.out.println(duration.getStandardHours());
        System.out.println(duration.getStandardMinutes());

        System.out.println(new Duration(1, 1001).getStandardSeconds());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        LocalDateTime localDateTime1 = LocalDateTime.of(2016, Month.MAY,12,11,13,11);
        LocalDateTime localDateTime2 = LocalDateTime.of(2017, Month.AUGUST,18,23,45,20);

        java.time.Duration javaDura = java.time.Duration.ofMinutes(1);
        System.out.println(javaDura.getSeconds());
    }

    @Test
    public void method888(){

        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Paris")));


    }

    @Test
    public void method999(){

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate); //2017-06-20

        System.out.println(localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));
        System.out.println(localDate.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)));

        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));


        System.out.println(localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY)));

        System.out.println(localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY)));
    }
}
