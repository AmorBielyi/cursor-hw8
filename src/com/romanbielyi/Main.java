package com.romanbielyi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        CarGenerator carGenerator = new CarGenerator();

        List<Car> cars = new ArrayList<>();

        Map<UUID, Car> finalMatchedCars;

        for (int i = 0; i < 1000; i++) {
            cars.add(carGenerator.generateCar());
        }

        System.out.println("****** All unsorted generated cars ******");
        for (Car car : cars) {
            System.out.println(car + "\n");
        }

        List<Car> matchedCars = cars.stream()
                .filter(car -> car.getBrand() == CarBrand.TESLA || car.getBrand() == CarBrand.AUDI)
                .filter(car -> car.getYear() > 2018 && car.getMileage() < 40000)
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());

        if (matchedCars.isEmpty()) {
            System.out.println("****** No matching cars ******");
        } else {
            System.out.println("****** Tesla and/or AUDI cars with year > 2018 and mileage " +
                    "< 40000 that sorted by price in descending order ******");
            for (Car car : matchedCars) {
                System.out.println(car);
            }
        }

        finalMatchedCars = matchedCars.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(3)
                .collect(Collectors.toMap(Car::getId,
                        Function.identity(),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));


        if (finalMatchedCars.isEmpty()) {
            System.out.println("****** No final matching cars ******");
        } else {
            System.out.println(" ****** Final matching cars ******");
            for (Car car : finalMatchedCars.values()) {
                System.out.println(car);
            }
        }
    }
}

