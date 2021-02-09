package ru.progwards.java1.lessons.Lesson16;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class lesson16 {
    Date createDate(){
        Calendar calc = Calendar.getInstance();
        calc.clear();
        calc.set(1986,1,28);
        return calc.getTime();
    }

    //Создайте метод с сигнатурой Instant createInstant(),
    // который возвращает Instant, соответствующий 1 января 2020 года, 15 часов и одна наносекунда по Московскому времени
    Instant createInstant(){
        LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 1, 15, 0, 0, 1);
        return localDateTime.toInstant(java.time.ZoneOffset.of("+03:00:00"));
    }

    static ZonedDateTime parseZDT(String str) {
        Locale l = Locale.forLanguageTag("EN");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD.MM.yyyy HH:mm:ss.SSS Z zzzz", l);
        return ZonedDateTime.parse(str, dtf.withZone(ZoneId.of("Europe/Moscow")));
    }

    public static void main(String[] args) {
        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println();
    }
}


//Правильные ответы:
// Date - это дата и время одновременно,
// Calendar позволяет работать с частями даты,
// TimeZone - часовой пояс, хранит смещение и правила переключение зимнее/летнее время

//Date now = new Date();
//[long] unixTS = now.[getTime()] [/] [1000L];

//Правильный ответ:
// правила переключения зимнее/летнее время и смещение от GMT → ZoneRules,
// Промежуток времени между 2-мя точками в днях → Period,
// местная дата-время → LocalDateTime,
// Промежуток времени между 2-мя точками в часах-минутах-секундах → Duration,
// местное время → LocalTime,
// количество наносекунд с 01.01.1970 00:00 GMT → Instant,
// часовой пояс → ZoneId,
// дата-время со сдвигом по времени → OffsetDateTime,
// дата-время в часовом поясе → ZonedDateTime,
// местная дата → LocalDate

//Что будет выведено в результате выполнения фрагмента кода
//
//LocalDateTime ldt1= LocalDateTime.now();
//LocalDateTime ldt2= ldt1.plusDays(4);
//Duration duration = Duration.between(ldt1,ldt2);
//System.out.println(duration.toHours());
//96

//Что будет выведено в результате выполнения фрагмента кода
//
//LocalDateTime ldt2= LocalDateTime.of(2019, 05, 05, 22, 24);
//System.out.println(ldt2);
//2019-05-05T22:24

//Что будет выведено в результате выполнения фрагмента кода
//
//ZoneId zid1 = ZoneId.of("Europe/Moscow");
//System.out.println(zid1.getRules().getOffset(Instant.now()));
//+03:00

//Правильные ответы:
// Класс SimpleDateFormat предназначен для форматирования java.util.Date,
// Класс DateTimeFormatter предназначен для форматирования классов из java.time,
// Locale позволяет получать названия месяцев, дней недели и др. на нужном языке

// "dd.MM.yyyy HH:mm:ss.SSS"

//"'От''езд' - EEEE dd MMMM 'в' ha"

//"yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'"