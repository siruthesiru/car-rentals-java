/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.models;

import java.sql.Date;
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
    
    
    
}
