/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.models;

/**
 *
 * @author lentrix
 */
public class Customer {
    private String lname;
    private String fname;
    private String phone;
    private String address;
    private String licNo;
    private int id;
    

    public Customer(int id, String lname, String fname, String phone, String address, String licNo) {
        this.id = id;
        this.lname = lname;
        this.fname = fname;
        this.phone = phone;
        this.address = address;
        this.licNo = licNo;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicNo() {
        return licNo;
    }

    public void setLicNo(String licNo) {
        this.licNo = licNo;
    }

    @Override
    public String toString() {
        return fname + " " + lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
