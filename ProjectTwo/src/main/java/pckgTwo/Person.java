package pckgTwo;

import java.time.LocalDate;

interface Person {
    String getFirstName();
    String getLastName();
    String getFullName();
    LocalDate getDateOfBirth();
    Long getAge();
    void sayHello();
}
