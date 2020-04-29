package pckgTwo;

import pckgTwo.servives.PublicHolidayService;
import java.time.LocalDate;


public class Course {
    private String courseName;
    private Integer EAP;
    private Teacher teacher;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private final PublicHolidayService publicHolidayService = new PublicHolidayService();

    public Course(String courseName, String name, LocalDate startDate, LocalDate endDate, Integer EAP, Teacher teacher) {
        this.courseName = courseName;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.EAP = EAP;
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getEAP() {
        System.out.println("If you see this during Testing, youre f*cked");
        return EAP;
    }

    public void setEAP(Integer EAP) {
        this.EAP = EAP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getLength() {
        return publicHolidayService.countWorkdays(startDate, endDate);
    }
}
