package me.whiteship.java8to11.Date_Time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        //기존 Date 와 관련된 라이브러리 -> 불편함 why?
        //작명이 제대로 되지 않음 date -> 날짜지만 시간도 표현가능
        //또한 date의 시간은 1970.01.01 기준으로 현재까지 miliseconds를 리턴해줌
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        after3Seconds.setTime(date.getTime());
        //위와같이 쓰레드를 잠재우고 setTime을 해주면 시간이 변경됨 위와같은것을 mutable하다고 함
        //이런 mutable한 객체는 멀티쓰레드 환경에서 쓰기 어렵다.Thread safe하지 않다
        Calendar keesunBirthDay = new GregorianCalendar(1982, 7, 15);
        //Calendar은 버그가 발생할 수 있다.. Month는 0부터 시작하기 때문에 상수를 쓰게 되어있고, 실수할 여지가 많다.
        //또한 int를 받는게 아닌 특정 enum을 받는게 좋다. 즉 Type safety가 없다.
        //새로운 Date_Time은 Clear, Fluent, Immutable,Extensible하게 설계됨
        Instant instant = Instant.now();
        //Instant.now() 로 가져 올 수 있음
        //Instant.of 는 특정 기준으로 출력해주는것
        //기계용 시간을 쓰는법, 기준시(UTC,GMT)를 출력해줌
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        //시스템 기준 시점으로 보려면 Zone 아이디를 넣어주면 된다.
        LocalDateTime now = LocalDateTime.now();
        //인간용 시간 now()로 가져올 수 있다. 현재 자신의 로컬 정보를 참고해서 가져옴
        LocalDateTime birthDay = LocalDateTime.of(1982, Month.JULY, 15, 0, 0, 0);
        //of()로 특정 시간을 만들 수 있음
        ZonedDateTime nowInKore = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        //ZonedDateTime은 특정 존의 시간을 볼 수 있음 존 아이디를 넣어주면 됨
        //물론 Instant 에서도 똑같은것을 할 수 있다.
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020, Month.JULY, 15);

        Period period = Period.between(today, thisYearBirthday);
        period.getDays();
        Period until = today.until(thisYearBirthday);
        until.get(ChronoUnit.DAYS);
        //기간을 표현하는방법은 Period/Duration이 있다.
        //Period는 인간용 Duration은 기계용 시간을 비교한다고 생각하자
        Instant now_1 = Instant.now();
        Instant plus = now_1.plus(10, ChronoUnit.SECONDS);
        //참고로 파라미터인 TemporalUnit은 그냥 ChronoUnit이라고 암기해두자
        //새로운 인스턴스가 나오는 개념
        Duration between = Duration.between(now, plus);
        //Duration의 기간 비교 방법
        LocalDateTime now_2 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        now_2.format(MMddyyyy);
        //현재시간을 포맷에 맞춰서 츨력하고싶을때는 위와같이 써주면 된다.
        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        //날짜를 Parsing하는 방법
        Date date_1 = new Date();
        Instant instant1 = date_1.toInstant();
        Date newDate = Date.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDate localDate = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        ZonedDateTime zonedDateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime1);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        //예전 API와 호환이 된다
    }
}
