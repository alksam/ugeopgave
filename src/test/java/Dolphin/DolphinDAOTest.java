package Dolphin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DolphinDAOTest {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private DolphinDAO dolphinDAO;

    @Before
    public void setUp() {
        entityManagerFactory = HibernateConfig.getEntityManagerFactoryConfig();
        entityManager = entityManagerFactory.createEntityManager();
        dolphinDAO = new DolphinDAO();
    }

    @After
    public void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }


    @Test
    void create() {
     DolphinDAO dolphinDAO = new DolphinDAO();
        Person person = new Person("Hans");
         dolphinDAO.create(person);
        Person persistedpersonn = dolphinDAO.read(person.getId());
        assertNotNull(persistedpersonn);
        assertEquals(person.getName(), persistedpersonn.getName());


    }

    @Test
    void read() {
        DolphinDAO dolphinDAO = new DolphinDAO();
        Person person = new Person("Hans");
        dolphinDAO.create(person);

        Person readPerson = dolphinDAO.read(person.getId());
        assertNotNull(readPerson);
        assertEquals(person.getName(), readPerson.getName());

    }

    @Test
    void update() {
        DolphinDAO dolphinDAO = new DolphinDAO();
        Person person = new Person("Hans");
        Person savedPerson = dolphinDAO.create(person);
        savedPerson.setName("Morten");
        Person updatedPerson = dolphinDAO.update(savedPerson);
        assertNotNull(updatedPerson);
        assertEquals(savedPerson.getName(), updatedPerson.getName());
    }

    @Test
    void delete() {
        DolphinDAO dolphinDAO = new DolphinDAO();
        Person person = new Person("Hans");
        Person savedPerson = dolphinDAO.create(person);
       dolphinDAO.delete(savedPerson.getId());
        Person foundPerson = dolphinDAO.read(savedPerson.getId());
        assertNull(foundPerson);
    }
}