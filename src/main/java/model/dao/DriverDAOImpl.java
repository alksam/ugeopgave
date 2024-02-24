package model.dao;

import model.driver;

import java.math.BigDecimal;
import java.util.List;

public class DriverDAOImpl implements IDriverDAO{
    @Override
    public void saveDriver(String name, String surname, BigDecimal salary) {

    }

    @Override
    public driver getDriverById(String id) {
        return null;
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
        return null;
    }
}
