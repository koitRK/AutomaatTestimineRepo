package pckgTwo;

import java.time.LocalDate;

public class Teacher extends PersonImpl {

    public Teacher(String firstName, String lastname, LocalDate dateOfBirth) {
        super(firstName, lastname, dateOfBirth);
    }

    @Override
    public void sayHello() {
        System.out.println(String.format("Hello, teacher %s", getFullName()));
    }

}
