package com.romanbielyi;

import java.util.*;

public class CarGenerator {
    private final List<Car.CarBrand> carBrands = Collections.unmodifiableList(Arrays.asList(Car.CarBrand.values()));
    private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    private Car car;

    private UUID generateId() {
        return UUID.randomUUID();
    }

    private Car.CarBrand generateBrand() {
        final int size = carBrands.size();
        final Random random = new Random();
        return carBrands.get(random.nextInt(size));
    }

    private int generateYear() {
        int minYear;

        if (car.getBrand() == Car.CarBrand.TESLA) {
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

class Car {
    private UUID id;
    private CarBrand brand;
    private int year;
    private int mileage;
    private int price;

    @Override
    public String toString() {
        return String.format("ID: %s\nBRAND: %s\nYEAR: %d\nMILEAGE: %d\nPRICE: %d\n",
                id.toString(),
                brand,
                year,
                mileage,
                price);
    }

    enum CarBrand {
        TESLA,
        AUDI,
        BMW,
        TOYOTA,
        NISSAN
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
