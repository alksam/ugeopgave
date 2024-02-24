package SchoolExercise;

import Dolphin.HibernateConfig;
import SchoolExercise.dao.StudentDAOImpl;
import SchoolExercise.dao.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class Populate {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public static void main(String[] args) {
        System.out.println("Hello School!");


        populate();
        emf.close();
    }
    public static void populate() {
        try (EntityManager em = emf.createEntityManager()) {


            Semester semester = new Semester("mat", "2023");
            Teacher teacher = new Teacher("Hans", "Hansen");
            StudentDAOImpl Impl = new StudentDAOImpl();


            List<Student> students = new ArrayList<>();
            Student student12 = new Student("John", "mikel",19);
            Student student13 = new Student("John", "dkds", 20);
            Student student2 =new Student("mike", "salma", 25);
            Student student1 =new  Student("sarah", "ahmad", 45);
            List<StudentInfo> studentInfos = new ArrayList<>();
            StudentInfo studentInfo = new StudentInfo( "cscae", 1, "Spring 2024", "Haascacns");
            StudentInfo studentInfo1 = new StudentInfo( "afsa smsas", 3, "Spring 2024", "Haascacns");
            StudentInfo studentInfo2 = new StudentInfo( "amjad mohasa", 2, "Spring 2024", "Haascacns");

            em.getTransaction().begin();

            student1.setSemester(semester);
            semester.addTeacher(teacher);

            semester.addStudent(student1);
            teacher.setSemester(semester);

            Impl.findAllStudentsByFirstName("John");
            Impl.findAllStudentsByLastName("Doe");
            Impl.findTotalNumberOfStudentsBySemester("Spring 2024");
            Impl.findTotalNumberOfStudentsByTeacher(teacher);
            Impl.findTeacherWithMostSemesters();
            Impl.findSemesterWithFewestStudents();
            Impl.getAllStudentInfo();






            em.persist(students);
            em.persist(studentInfos);
            em.getTransaction().commit();





        }
    }
}