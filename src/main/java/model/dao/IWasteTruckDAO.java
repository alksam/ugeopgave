package model.dao;

import model.driver;
import model.truck;

import java.math.BigDecimal;
import java.util.List;

public interface IWasteTruckDAO {
    // WasteTruck
    void saveWasteTruck(String brand, String registrationNumber, int capacity);
    truck getWasteTruckById(int id);
    void setWasteTruckAvailable(truck wasteTruck, boolean available);
    void deleteWasteTruck(int id);
    void addDriverToWasteTruck(truck wasteTruck, driver driverr);
    void removeDriverFromWasteTruck(truck wasteTruck, String id);
    List<truck> getAllAvailableTrucks();
}
