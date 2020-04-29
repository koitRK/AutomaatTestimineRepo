package pckgTwo.utils;

import pckgTwo.Student;

import java.util.List;

public class Utils {
    public static void printStudentsNames(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getFullName());
        }
    }
}
