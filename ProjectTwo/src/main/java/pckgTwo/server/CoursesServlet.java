package pckgTwo.server;

import pckgTwo.Course;
import pckgTwo.GenerateCourses;
import pckgTwo.Greeter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CoursesServlet extends HttpServlet {

    private final GenerateCourses generator = new GenerateCourses();

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Course> courses = generator.generateCourses();


        StringBuilder result = new StringBuilder();
        for (Course course: courses){
            result.append(course.toString()).append("\n");
        }

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(result);
    }
}