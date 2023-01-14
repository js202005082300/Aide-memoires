import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.time.Month;
import java.time.DayOfWeek;

import java.time.format.DateTimeFormatter;
/*
    LocalDate
    LocalTime
    LocalDateTime

    Duration
    Period

    ZoneId
    ZoneDateTime

    Month
    DayOfWeek
    Calendar
*/
public class Main
{
    public static void main(String args[])
    {
        LocalDate someDate = LocalDate.of(2008, 11, 16);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String texDate = someDate.format(fmt);
        System.out.println(texDate);

        LocalDateTime someDateTime = LocalDateTime.of(2008, 11, 16, 11, 45, 59);
        DateTimeFormatter fmt_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm:ss");
        String texDate_2 = someDateTime.format(fmt_2);
        System.out.println(texDate_2);
    }
}