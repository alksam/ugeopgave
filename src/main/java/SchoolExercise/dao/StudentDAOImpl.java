package SchoolExercise.dao;

import Dolphin.HibernateConfig;
import SchoolExercise.Semester;
import SchoolExercise.Student;
import SchoolExercise.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static EntityManager em = emf.createEntityManager();
    public List<Student> findAllStudentsByFirstName(String firstname) {

        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.Firstname = :firstName", Student.class);
        query.setParameter("firstName", firstname);
        return query.getResultList();
        }



    public List<Student> findAllStudentsByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.Lastname = :lastname", Student.class);
        query.setParameter("lastname", lastName);
        return query.getResultList();



    }

    public long findTotalNumberOfStudentsBySemester(String semester) {
        Query query = em.createQuery("SELECT SUM(s.id) FROM Student s WHERE s.semester = :semester", long.class);
        query.setParameter("semester", semester);
        return (long) query.getSingleResult();
    }

    public long findTotalNumberOfStudentsByTeacher(Teacher teacher) {
        Query query =em.createQuery("SELECT count (s) FROM Student s WHERE s = :teacher");
            query.setParameter("teacher", teacher);
        return  (long)query.getSingleResult();
    }

    public Teacher findTeacherWithMostSemesters() {
        Query query =em.createQuery("SELECT count (s) FROM Teacher s WHERE s = :Semester");
        query.setParameter("Semester", Semester.class);
        return (Teacher) query.getSingleResult();


    }

    public Semester findSemesterWithFewestStudents() {

        Query query =em.createQuery("SELECT count (s) FROM Semester s WHERE s = :Student");
        query.setParameter("Student", Student.class);
        return (Semester) query.getSingleResult();
    }

    public StudentInfo getAllStudentInfo() {

        TypedQuery<StudentInfo> query = em.createQuery(   "SELECT s.id, s.fullName, s.studentId, s.thisSemesterName, s.thisSemesterDescription " +
                "FROM StudentInfo s WHERE s = :id", StudentInfo.class);

        return query.getResultList().get(0);


    }

}
