package com.romanbielyi;

import java.util.*;

public class CarGenerator {
    private final List<CarBrand> carBrands = Collections.unmodifiableList(Arrays.asList(CarBrand.values()));
    private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    private Car car;

    private UUID generateId() {
        return UUID.randomUUID();
    }

    private CarBrand generateBrand() {
        final int size = carBrands.size();
        final Random random = new Random();
        return carBrands.get(random.nextInt(size));
    }

    private int generateYear() {
        int minYear;

        if (car.getBrand() == CarBrand.TESLA) {
            minYear = 2009;
        } else {
            minYear = 2000;
        }

        return (int) (Math.random() * (currentYear - minYear + 1) + minYear);
    }

    private int generateMileage() {
        int minMileage = 0;
        int maxMileage = 55000;
        return (int) (Math.random() * (maxMileage - minMileage + 1) + minMileage);
    }

    private int generatePrice() {
        int minPrice = 60000;
        int maxPrice = 400000;
        return (int) (Math.random() * (maxPrice - minPrice + 1) + minPrice);
    }

    public Car generateCar() {

        car = new Car();
        car.setId(generateId());
        car.setBrand(generateBrand());
        car.setYear(generateYear());
        car.setMileage(generateMileage());
        car.setPrice(generatePrice());
        return car;
    }
}

