package com.romanbielyi;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        CarGenerator carGenerator = new CarGenerator();

        List<Car> cars = new ArrayList<>();

        Map<UUID, Car> uniqueThreeMatchedCars = new LinkedHashMap<>();

        for (int i = 0; i < 15; i++) {
            cars.add(carGenerator.generateCar());
        }

        System.out.println("****** All unsorted generated cars ******");
        for (Car car : cars) {
            System.out.println(car + "\n");
        }

       List<Car> matchedCars =  cars.stream()
                .filter(car -> car.getBrand() == Car.CarBrand.TESLA || car.getBrand() == Car.CarBrand.AUDI)
                .filter(car -> car.getYear() < 2018 && car.getMileage() < 40000d)
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());

        if (matchedCars.isEmpty()) {
            System.out.println("****** No matching cars ******");
        } else {
            System.out.println("****** Tesla and/or AUDI cars with year < 2018 and mileage " +
                    "< 40000 that sorted by price in ascending order ******");
            for (Car car : matchedCars) {
                System.out.println(car);
            }
        }

        if (matchedCars.size() == 3) {
            matchedCars = matchedCars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());
            for (Car car : matchedCars) {
                uniqueThreeMatchedCars.put(car.getId(), car);
            }

        }

        if (uniqueThreeMatchedCars.isEmpty()) {
            System.out.println("****** No three matching cars ******");
        } else {
            System.out.println(" ****** Three matching cars ******");
            for (Car car : uniqueThreeMatchedCars.values()) {
                System.out.println(car);
            }
        }
    }
}

