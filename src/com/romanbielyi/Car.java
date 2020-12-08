package com.romanbielyi;

import java.util.UUID;

public class Car {
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
