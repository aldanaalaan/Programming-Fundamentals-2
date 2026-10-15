package Exercises.Calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class TestCalendar {
  public static void main(String[] args) {
    Calendar calendar = new GregorianCalendar(2004, 4, 21, 23,24,05);

    System.out.println("Current time is: " + new Date());
    System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
    System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
    System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
    System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
    System.out.println("HOUR OF DATE: " + calendar.get(Calendar.HOUR_OF_DAY));

    System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
    System.out.println("HOUR: " + calendar.get(Calendar.HOUR));

    System.out.println("DAY OF WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
    System.out.println("DAY OF MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println("DAY OF YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
    System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));



  }

}
