package model.dao;

import model.driver;

import java.math.BigDecimal;
import java.util.List;

public interface IDriverDAO {
    // Driver
    void saveDriver(String name, String surname, BigDecimal salary);
    driver getDriverById(String id);
    driver updateDriver(driver driver);
    void deleteDriver(String id);
    List<driver> findAllDriversEmployedAtTheSameYear(String year);
    List<driver> fetchAllDriversWithSalaryGreaterThan10000();
    double fetchHighestSalary();
    List<String> fetchFirstNameOfAllDrivers();
    long calculateNumberOfDrivers();
    driver fetchDriverWithHighestSalary();
}
