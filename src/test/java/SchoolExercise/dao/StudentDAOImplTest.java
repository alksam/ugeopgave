package SchoolExercise.dao;

import Dolphin.DolphinDAO;
import Dolphin.HibernateConfig;
import SchoolExercise.Semester;
import SchoolExercise.Student;
import SchoolExercise.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private StudentDAOImpl studentDAOimpl;
    private StudentDAO studentDAO;


    @Before
    public void setUp() {
        entityManagerFactory = HibernateConfig.getEntityManagerFactoryConfig();
        entityManager = entityManagerFactory.createEntityManager();

        studentDAOimpl = new StudentDAOImpl();

    }

    @After
    public void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findAllStudentsByFirstName() {
        StudentDAOImpl studentDAOimpl = new StudentDAOImpl();
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("John", "Doe", 19);
        Student student2 =new Student("mike", "Doe", 19);
        Student student =new  Student("sarah", "Doe", 19);

        students.add(student1);
        students.add(student2);
        students.add(student);
        studentDAOimpl.findAllStudentsByFirstName("John");








    }

    @Test
    void findAllStudentsByLastName() {
    }

    @Test
    void findTotalNumberOfStudentsBySemester() {
    }

    @Test
    void findTotalNumberOfStudentsByTeacher() {
    }

    @Test
    void findTeacherWithMostSemesters() {
    }

    @Test
    void findSemesterWithFewestStudents() {
    }

    @Test
    void getAllStudentInfo() {
    }
}