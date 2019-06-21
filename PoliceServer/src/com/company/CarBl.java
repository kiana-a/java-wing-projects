package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 1/30/18.
 */
public class CarBl {
    //private final String carFile = "carFile.json";
    //private List<Car> carList = new ArrayList<>();

    private CarDao carDao = new CarDao();

//    public void loadFromFile() {
//        File file = new File(carFile);
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        while (scanner.hasNext()) {
//            String s = scanner.nextLine();
//            Car[] cars = new Gson().fromJson(s, Car[].class);
//            this.carList = new ArrayList<>();
//            for (Car car : cars
//                    ) {
//                this.carList.add(car);
//            }
//        }
//    }

    public boolean addCar(Car car) {
        if (carDao.findCar(car.getChassisNum()) != null) {
            return false;
        } else {
            carDao.save(car);
            return true;
        }
    }

    public Car getCar(String chassisNum) throws MyException {
        Car car = carDao.findCar(chassisNum);
        if(car == null)
            throw new MyException("getCar Exception");
        return car;
    }

}
