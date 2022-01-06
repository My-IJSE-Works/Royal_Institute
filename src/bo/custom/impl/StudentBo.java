package bo.custom.impl;

import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface StudentBo {
//    public boolean addStudent(String regId,StudentDTO studentDTO, String courseId);
//    public boolean deletePrograme(String id);
//    public boolean updatePrograme(StudentDTO course,String id);
//    public ObservableList getStudent();

    boolean addStudent(StudentDTO studentDTO, String regId, String courseId);

    ArrayList<StudentDTO> getStudents();

    ArrayList<CourseDTO> getCourses();
}
