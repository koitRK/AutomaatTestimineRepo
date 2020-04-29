package pckgTwo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements Person {

    String firstName;
    String lastName;
    String fullName;
    LocalDate dateOfBirth;


    public PersonImpl(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getAge() {
        return ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
    }

    public void sayHello() {
        System.out.println(String.format("Hello, person %s", getFullName()));
    }
}
