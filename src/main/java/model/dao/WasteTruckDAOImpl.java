package model.dao;

import model.driver;
import model.truck;

import java.util.List;

public class WasteTruckDAOImpl implements IWasteTruckDAO{
    @Override
    public void saveWasteTruck(String brand, String registrationNumber, int capacity) {

    }

    @Override
    public truck getWasteTruckById(int id) {
        return null;
    }

    @Override
    public void setWasteTruckAvailable(truck wasteTruck, boolean available) {

    }

    @Override
    public void deleteWasteTruck(int id) {

    }

    @Override
    public void addDriverToWasteTruck(truck wasteTruck, driver driverr) {

    }

    @Override
    public void removeDriverFromWasteTruck(truck wasteTruck, String id) {

    }

    @Override
    public List<truck> getAllAvailableTrucks() {
        return null;
    }
}
