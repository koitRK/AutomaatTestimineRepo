package pckgTwo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateCourses {

    public List<Course> generateCourses(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS", "Computer Science", LocalDate.of(2020, 4, 1), LocalDate.of(2020, 5, 30), 3, new Teacher("Jaan", "Tamm", LocalDate.of(1980, 7,23))));
        courses.add(new Course("ECON", "Economics", LocalDate.of(2020, 5, 15), LocalDate.of(2020, 6, 6), 2, new Teacher("Peep", "Kask", LocalDate.of(1963, 12,7))));
        courses.add(new Course("MKT", "Marketing", LocalDate.of(2020, 3, 24), LocalDate.of(2020, 4, 20), 3, new Teacher("Mart", "Puusepp", LocalDate.of(1978, 3,1))));
        return courses;
    }
}
