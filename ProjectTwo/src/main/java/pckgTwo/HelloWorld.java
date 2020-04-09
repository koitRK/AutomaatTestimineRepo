package pckgTwo;

public class HelloWorld {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
    Course cours = new Course("CSCI", 4);
    long date = 123456;
    Student stud = new Student("Tamm", "Jaan", date, cours);

    Course cours2 = new Course("BIO", 5);
    long date2 = 000000;
    Student stud2 = new Student("Tulnuk", "Uus", date2, cours2);

    System.out.println(stud.firstName + stud.lastName + stud.birthDate + stud.course.courseName + stud.course.EAP);
    System.out.println(stud2.firstName + stud2.lastName + stud2.birthDate + stud2.course.courseName + stud2.course.EAP);
  }
}