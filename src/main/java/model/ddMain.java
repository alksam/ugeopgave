package model;

import Dolphin.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.dao.DriverDAOImpl;
import model.dao.IDriverDAO;
import model.dao.IWasteTruckDAO;
import model.dao.WasteTruckDAOImpl;

import java.math.BigDecimal;
import java.util.List;

public class ddMain {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public static void main(String[] args) {

        IDriverDAO driverDAO = DriverDAOImpl.getInstance(emf);
        IWasteTruckDAO wasteTruckDAO = WasteTruckDAOImpl.getInstance(emf);

        String dId = driverDAO.saveDriver("Egon", "Olsen", new BigDecimal(25000));
        driver d = driverDAO.getDriverById(dId);
        System.out.println(d);

        int wId = wasteTruckDAO.saveWasteTruck("Volvo", 123 - 45 - 6, 1000);

        truck wasteTruck = wasteTruckDAO.getWasteTruckById(wId);

        wasteTruckDAO.addDriverToWasteTruck(wasteTruck, d);

        List<truck> wasteTruckList = wasteTruckDAO.getAllAvailableTrucks();
        for (truck truck : wasteTruckList) {
            System.out.println(truck);
        }

        wasteTruck = wasteTruckDAO.getWasteTruckById(wId);


        //  wasteTruckDAO.removeDriverFromWasteTruck(wasteTruck, dId);


        emf.close();

    }
}
