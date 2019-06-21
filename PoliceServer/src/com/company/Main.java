package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("90","benz", Color.BLUE );
//        CarDao carDao = new CarDao();
//        carDao.save(car);
        //carDao.findCar("1");
        CarBl carBl = new CarBl();
//        if(carBl.addCar(car)){
//            System.out.println("car is added");
//        }else {
//            System.out.println("car is not added");
//        }

        try {
            carBl.getCar("567889");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        CarView carView = new CarView();
//        try {
//            carView.getCarInftormation();
//        } catch (MyException e) {
//            e.printStackTrace();
//        }
        carView.showCar();
//        System.out.println(carDao.findCar("24242"));
    }
}
