package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
  public static Greeter greeter = new Greeter();
  public static Counter counter = new Counter();

  public static void main(String[] args) {
    LocalTime currentTime = new LocalTime();
    System.out.println("The current local time is: " + currentTime);

    String username = args[0];
    System.out.println(greeter.sayHello(username));    
  }


}