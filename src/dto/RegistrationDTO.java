package dto;

import entity.Course;
import entity.Student;

import java.time.LocalDate;

public class RegistrationDTO {
    private String registrationId;
    private LocalDate registrationDate;
    private Student student;
    private Course course;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registrationId, LocalDate registrationDate) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
    }

    public RegistrationDTO(String registrationId, LocalDate registrationDate, Student student, Course course) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.student = student;
        this.course = course;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "registrationId='" + registrationId + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
