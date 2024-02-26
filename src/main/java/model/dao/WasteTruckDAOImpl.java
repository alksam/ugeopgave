package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.driver;
import model.truck;

import java.util.List;

public class WasteTruckDAOImpl implements IWasteTruckDAO {
    private static EntityManagerFactory emf;
    private static WasteTruckDAOImpl wasteTruckDAO;

    private WasteTruckDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static WasteTruckDAOImpl getInstance(EntityManagerFactory emf) {
        if (wasteTruckDAO == null) {
            wasteTruckDAO = new WasteTruckDAOImpl(emf);
        }
        return wasteTruckDAO;
    }

    @Override
    public int saveWasteTruck(String brand, int registrationNumber, int capacity) {
        int newId;
        truck wasteTruck = new truck(brand, capacity, registrationNumber);

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(wasteTruck);
            em.getTransaction().commit();
        }
        return wasteTruck.getId();
    }

    @Override
    public truck getWasteTruckById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(truck.class, id);
        }
    }

    @Override
    public void setWasteTruckAvailable(truck wasteTruck, boolean available) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            truck wasteTruckToUpdate = em.find(truck.class, wasteTruck.getId());
            wasteTruckToUpdate.setAvailable(available);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteWasteTruck(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            truck wasteTruck = em.find(truck.class, id);
            em.remove(wasteTruck);
            em.getTransaction().commit();
        }
    }

    @Override
    public void addDriverToWasteTruck(truck wasteTruck, driver driver) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            wasteTruck = em.find(truck.class, wasteTruck.getId());
            driver = em.find(driver.class, driver.getId());
            wasteTruck.addDriverr(driver);
            em.getTransaction().commit();
        }
    }

    @Override
    public void removeDriverFromWasteTruck(truck wasteTruck, String driverId) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            wasteTruck = em.find(truck.class, wasteTruck.getId());
            driver driver = em.find(driver.class, driverId);
            wasteTruck.removeDriver(driver);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<truck> getAllAvailableTrucks() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<truck> query = em.createQuery(
                    "SELECT w FROM truck w WHERE w.available = :isAvailable",
                    truck.class);
            return query.getResultList();
        }
    }
}