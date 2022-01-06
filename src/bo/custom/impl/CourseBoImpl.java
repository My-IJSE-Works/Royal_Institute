package bo.custom.impl;

import dto.CourseDTO;
import entity.Course;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CourseBoImpl implements CourseBo {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public boolean addPrograme(CourseDTO courseDTO) {


//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Course course=new Course(courseDTO.getCourseID(),courseDTO.getCourseName(),courseDTO.getFee(),courseDTO.getDuration());
//
//        session.save(course);
//
//        session.getTransaction().commit();
//        session.close();
        return false;

    }

    @Override
    public boolean deletePrograme(String id) {
        return false;
    }

    @Override
    public boolean updatePrograme(CourseDTO course, String id) {
        return false;
    }

    @Override
    public ObservableList<CourseDTO> getPrograme() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<Course> list = session.createQuery("FROM lk.ijse.hibernate.entity.Course").list();
//        ObservableList<CourseDTO> l = FXCollections.observableArrayList();
////        for (Course course : list) {
////            l.add(new CourseDTO(course.getCourseID(),course.getCourseName(),course.getFee(),course.getDuration()));
////        }
//        transaction.commit();
//        session.close();
        return null;
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Course course = new Course(
                    courseDTO.getCourseId(),
                    courseDTO.getCourseName(),
                    courseDTO.getCourseFee(),
                    courseDTO.getCourseDuration()
            );
            session.save(course);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<CourseDTO> getCourses() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Course> list = session.createQuery("FROM entity.Course", Course.class).list();
        transaction.commit();
        session.close();
        if (list == null) return null;
        if (list.size() == 0) return null;
        ArrayList<CourseDTO> courses = new ArrayList<>();
        for (Course course : list) {
            courses.add(new CourseDTO(
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCourseFee(),
                    course.getCourseDuration()
            ));
        }
        return courses;
    }
}
