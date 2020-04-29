package pckgTwo;

import junit.runner.Version;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

class StudentTest {

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    //@Mock
    //Teacher teacherMock1;// = new Teacher("Milvi", "Tisler", LocalDate.of(1950, 5, 10));
    //@Mock
    //Teacher teacherMock2;// = new Teacher("Liina", "Lindsalu", LocalDate.of(1985, 10, 25));
    @Mock
    Course courseMock1;// = new Course("RT-001", "ETTEVÕTLUSMOODUL", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 29), 15, teacherMock1);
    //@Mock
    //Course courseMock2;// = new Course("RT-002", "ENESEJUHTIMINE KÕRGKOOLIS",  LocalDate.of(2020, 1, 15), LocalDate.of(2020, 3, 7), 4, teacherMock2);

    //Course courseMock1 = Mockito.mock(Course.class);



    @Test
    void student_getTeacherNames_should_return_list_of_full_names() {
        //List<Course> courses = new ArrayList<>();
        //courses.add(courseMock1);
        //courses.add(courseMock2);
        //Student student = new Student("John", "Smith", LocalDate.of(2020, 1, 1), courses);


        when(courseMock1.getEAP()).thenReturn(123);
        int result = courseMock1.getEAP();
        assertEquals(1223, result);
        //when(courseMock2.getTeacher()).thenReturn(teacherMock2);
        //when(teacherMock1.getFullName()).thenReturn("Milvi Tisler");
        //when(teacherMock2.getFullName()).thenReturn("Liina Lindsalu");

        //List<String> result = student.getTeachersNames();
        //assertEquals(Arrays.asList("Milvi Tisler", "Liina Lindsalu"), result);
    }


    @Test
    public void student_sayHello_should_greet_student() {
        List<Course> courses = new ArrayList<>();
        courses.add(courseMock1);
        //courses.add(courseMock2);

        Student student = new Student("John", "Smith", LocalDate.of(2020, 1, 1), courses);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        student.sayHello();
        assertEquals("Hello, student John Smith\r\n", String.valueOf(outContent));
    }


}