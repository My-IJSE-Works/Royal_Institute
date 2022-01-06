package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Registration {
    @Id
    private String registrationId;
    private LocalDate registrationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId", nullable = false)
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId", nullable = false)
    private Course course;

    public Registration() {
    }

    public Registration(String registrationId, LocalDate registrationDate) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
    }

    public Registration(String registrationId, LocalDate registrationDate, Student student, Course course) {
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
}
