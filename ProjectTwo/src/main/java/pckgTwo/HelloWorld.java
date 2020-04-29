package pckgTwo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HelloWorld {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());

    LocalDate startDate = LocalDate.of(2020, 4, 1);
    LocalDate endDate = LocalDate.of(2020, 4, 10);
    //Course course = new Course(startDate, endDate);
    //System.out.println(course.getLength());
  }
}