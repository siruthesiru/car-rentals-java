/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.models;

import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author lentrix
 */
public class Rental {
    private int id;
    private Customer customer;
    private Car car;
    private Date dateTaken;
    private Date dateReturned;
    private float deposit;

    public Rental(int id, Customer customer, Car car, Date dateTaken, Date dateReturned, float deposit) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.dateTaken = dateTaken;
        this.dateReturned = dateReturned;
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return customer.getFname() + " " 
                + customer.getLname() + " - " 
                + car.getMake() + " " 
                + car.getModel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean validate(StringBuffer errors) {
        boolean isValid = true;
        
        if(customer==null) {
            errors.append("The customer should not be empty.\n");
            isValid = false;
        }
        
        if(car==null) {
            errors.append("The car should not be empty.\n");
            isValid = false;
        }
        
        
        LocalDate taken = dateTaken.toLocalDate();
        LocalDate returned = dateReturned.toLocalDate();
        LocalDate now = LocalDate.now();
        LocalDate earliest = LocalDate.of(now.getYear()-1, now.getMonth(), now.getDayOfMonth());
        
        if(taken.isBefore(earliest) || taken.isAfter(now)) {
            errors.append("The value for date taken is invalid.\n");
            isValid = false;
        }
        
        if(returned.isBefore(taken) || returned.isAfter(now)) {
            errors.append("The value for date returned is invalid.\n");
            isValid = false;
        }
        
        if(deposit <= 0) {
            errors.append("The deposit value is invalid.");
            isValid = false;
        }
        
        return isValid;
    }
    
}
