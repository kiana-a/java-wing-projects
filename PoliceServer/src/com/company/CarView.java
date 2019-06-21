package com.company;

import java.util.Scanner;

/**
 * Created by kiana on 2/5/18.
 */
public class CarView {

    public void getCarInftormation() throws MyException {

        System.out.println("Enter Car information :\n" +
                "car's chassis number\n");

        Scanner scanner = new Scanner(System.in);
        Car car = null;
        String chassis = null;
        String model = null;
        String color = null;

        chassis = scanner.nextLine();

        System.out.println("Enter Model ");
        model = scanner.nextLine();

        System.out.println("Enter Color");
        color = scanner.nextLine();
        car = new Car(chassis, model, Color.valueOf(color.toUpperCase()));

        CarBl carBl = new CarBl();
        if (carBl.addCar(car)){
            System.out.println(car.getChassisNum() + " " + car.getModel() + " " + car.getColor());
        }else {
            System.out.println("false :| ");
        }


    }
    public void showCar(){
        CarBl carBl = new CarBl();
        System.out.println("Enter Car information :\n" +
                "car's chassis number\n");
        String chassisNum = null;

        Scanner scanner = new Scanner(System.in);
        chassisNum = scanner.nextLine();

        try {
            Car car = carBl.getCar(chassisNum);

            System.out.println(car.getChassisNum() + " " + car.getModel() + " " + car.getColor());

        } catch (MyException e) {
            System.out.println("CarView  : ShowCar exp.");
        }
    }


}
