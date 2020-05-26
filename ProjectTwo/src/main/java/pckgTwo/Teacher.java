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

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
