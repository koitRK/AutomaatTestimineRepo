package pckgTwo.server;

import pckgTwo.Course;
import pckgTwo.GenerateCourses;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WorkdaysServlet extends HttpServlet {

    private final GenerateCourses generator = new GenerateCourses();

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("name");

        List<Course> courses = generator.generateCourses();

        String result = "Invalid course";
        for (Course course: courses){
            if (course.getCourseName().equals(code)){
                result = "Working days for course " + course.getName() + " is: " + course.getLength().toString();
                break;
            }
        }

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(result);
    }
}