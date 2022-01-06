package bo.custom.impl;

import dto.CourseDTO;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface CourseBo {
    public boolean addPrograme(CourseDTO course);
    public boolean deletePrograme(String id);
    public boolean updatePrograme(CourseDTO course,String id);
    public ObservableList getPrograme();

    boolean addCourse(CourseDTO courseDTO);
    ArrayList<CourseDTO> getCourses();

}
