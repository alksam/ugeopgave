package model.dao;

<<<<<<< HEAD
=======
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
>>>>>>> 84fe40a (her mi projekt bb)
import model.driver;

import java.math.BigDecimal;
import java.util.List;

public class DriverDAOImpl implements IDriverDAO{
<<<<<<< HEAD
    @Override
    public void saveDriver(String name, String surname, BigDecimal salary) {

    }

    @Override
    public driver getDriverById(String id) {
        return null;
=======

    private static EntityManagerFactory emf;
    private static DriverDAOImpl driverDAO;

    private DriverDAOImpl(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public static DriverDAOImpl getInstance(EntityManagerFactory emf)
    {
        if (driverDAO == null)
        {
            driverDAO = new DriverDAOImpl(emf);
        }
        return driverDAO;
    }
    @Override
    public String saveDriver(String name, String surname, BigDecimal salary)
    {
        driver driver = new driver(name, salary, surname);
        try (EntityManager em = emf.createEntityManager())
        {

            em.getTransaction().begin();
            em.persist(driver);
            em.getTransaction().commit();

        }
        return driver.getName();
    }


    @Override
    public driver getDriverById(String id) {

        try (EntityManager em = emf.createEntityManager())
        {
            return em.find(driver.class, id);
        }

>>>>>>> 84fe40a (her mi projekt bb)
    }

    @Override
    public driver updateDriver(driver driver) {
        return null;
    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public List<driver> findAllDriversEmployedAtTheSameYear(String year) {
        return null;
    }

    @Override
    public List<driver> fetchAllDriversWithSalaryGreaterThan10000() {
        return null;
    }

    @Override
    public double fetchHighestSalary() {
        return 0;
    }

    @Override
    public List<String> fetchFirstNameOfAllDrivers() {
        return null;
    }

    @Override
    public long calculateNumberOfDrivers() {
        return 0;
    }

    @Override
    public driver fetchDriverWithHighestSalary() {
<<<<<<< HEAD
        return null;
=======
        try (EntityManager em = emf.createEntityManager())
        {
            TypedQuery<driver> query = em.createQuery("SELECT d FROM driver d ORDER BY d.Salary DESC", driver.class);
            return query.setMaxResults(1).getSingleResult();
        }
>>>>>>> 84fe40a (her mi projekt bb)
    }
}
