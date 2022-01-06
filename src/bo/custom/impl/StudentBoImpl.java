package bo.custom.impl;

import dto.CourseDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import dto.RegisterDTO;
//import lk.ijse.hibernate.HibernateUtil;
//import lk.ijse.hibernate.entity.Course;
//import lk.ijse.hibernate.entity.CourseStudent;
//import lk.ijse.hibernate.entity.Register;
//import lk.ijse.hibernate.entity.Student;

public class StudentBoImpl implements StudentBo {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public boolean addStudent(StudentDTO studentDTO, String regId, String courseId) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            Student student = new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getStudentName(),
                    studentDTO.getStudentAddress(),
                    studentDTO.getStudentNIC(),
                    studentDTO.getStudentContact(),
                    studentDTO.getStudentGender()
            );
            Registration registration = new Registration(
                    regId,
                    LocalDate.now(),
                    student,
                    course
            );
            session.save(registration);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<StudentDTO> getStudents() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> list = session.createQuery("FROM entity.Student", Student.class).list();
        transaction.commit();
        session.close();
        if(list == null)return null;
        if(list.size() == 0) return null;
        ArrayList<StudentDTO> students = new ArrayList<>();
        for (Student student : list) {
            students.add(new StudentDTO(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentAddress(),
                    student.getStudentNIC(),
                    student.getStudentContact(),
                    student.getStudentGender()
            ));
        }
        return students;
    }

    @Override
    public ArrayList<CourseDTO> getCourses() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Course> list = session.createQuery("FROM entity.Course", Course.class).list();
        transaction.commit();
        session.close();
        if(list == null)return null;
        if(list.size() == 0) return null;
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
//    SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();


//    public boolean addStudent(String regId,StudentDTO studentDTO, String courseId){
////        Session session = sessionFactory.openSession();
////        session.beginTransaction();
////        Student student=new Student(
////                studentDTO.getStID(),
////                studentDTO.getName(),
////                studentDTO.getAddress(),
////                studentDTO.getNic(),
////                studentDTO.getContact(),
////                studentDTO.getGender());
////
////        RegisterDTO registerDTO = new RegisterDTO(id,course.getStID(),courseDTO.getCourseID(),new Date());
////        session.save(student);
//
////        Course course = session.get(Course.class, courseId);
////        CourseStudent courseStudent = new CourseStudent(student.getStID(),course.getCourseID());
////        Register register = new Register(courseStudent,new Date(),course, student);
////        session.save(register);
////
////        session.getTransaction().commit();
////        session.close();
//        return false;
//    }
//
//    @Override
//    public boolean deletePrograme(String id) {
//        return false;
//    }
//
//    @Override
//    public boolean updatePrograme(StudentDTO course, String id) {
//        return false;
//    }
//
//    @Override
//    public ObservableList getStudent() {
//        return null;
//    }
}
