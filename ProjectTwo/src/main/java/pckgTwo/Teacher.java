package pckgTwo;

import java.time.LocalDate;

public class Teacher extends PersonImpl {

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    @Override
    public void sayHello() {
        System.out.println(String.format("Hello, teacher %s", getFullName()));
    }

}
