/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.db;

import com.lentrix.demos.models.Customer;
import java.sql.PreparedStatement;

/**
 *
 * @author lentrix
 */
public class CustomerDAO {
    public static void add(Customer customer) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "INSERT INTO customers (lname, fname, phone, address, lic_no) "
                        + "VALUES (?,?,?,?,?");
        ps.setString(1, customer.getLname());
        ps.setString(2, customer.getFname());
        ps.setString(3, customer.getPhone());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getLicNo());
        
        ps.executeUpdate();
    }
}
