package hello;

public class Greeter {

  Counter counter = new Counter();

  public String sayHello(String username) {

    int len;
    try {
      len = counter.countLetters(username);
    } catch (Exception x) {
      return "Caught exception";
    }

    if (len < 2 || len > 20) {
      return "Incorrect name";
    }

    return String.format("Greetings, %s, I see you have %d character(s) in your name!", username, len);
  }

}