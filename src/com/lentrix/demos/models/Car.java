/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.models;

import java.util.Calendar;

/**
 *
 * @author lentrix
 */
public class Car {
    private int id;
    private String make;
    private String model;
    private String color;
    private String plate;
    private int year;

    public Car(int id, String make, String model, String color, String plate, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return make + " " + model + " [" + plate + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean validate(StringBuffer errors) {
        boolean isValid = true;
        
        if(make.isBlank()) {
            errors.append("The make field should not be blank.\n");
            isValid = false;
        }
        
        if(model.isBlank()) {
            errors.append("The model field should not be blank.\n");
            isValid = false;
        }
        
        if(color.isBlank()) {
            errors.append("The color field should not be blank.\n");
            isValid = false;
        }
        
        if(plate.isBlank()) {
            errors.append("The plate number field should not be blank.\n");
            isValid = false;
        }
        
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        if(year<1950 || year>currentYear) {
            errors.append("The year value should be between " + 1950 + " and " + currentYear);
            isValid = false;
        }
        
        return isValid;
    }
}
