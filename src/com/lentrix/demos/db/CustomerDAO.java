/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.db;

import com.lentrix.demos.models.Customer;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lentrix
 */
public class CustomerDAO {
    public static void add(Customer customer) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "INSERT INTO customers (lname, fname, phone, address, lic_no) "
                        + "VALUES (?,?,?,?,?)");
        ps.setString(1, customer.getLname());
        ps.setString(2, customer.getFname());
        ps.setString(3, customer.getPhone());
        ps.setString(4, customer.getAddress());
        ps.setString(5, customer.getLicNo());
        
        ps.executeUpdate();
    }
    
    public static List<Customer> getAll() throws Exception {
        Statement st = DB.conn().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customers ORDER BY lname, fname");
        
        ArrayList<Customer> customers = new ArrayList();
        
        while(rs.next()) {
            Customer c = new Customer(
                    rs.getInt("id"),
                    rs.getString("lname"),
                    rs.getString("fname"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("lic_no")
            );
            
            customers.add(c);
        }
        
        st.close();
        rs.close();
        
        return customers;
    }
    
    public static void update(Customer cust) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "UPDATE customers SET lname=?, fname=?, phone=?, address=?, lic_no=? "
                        + "WHERE id=?");
        
        ps.setString(1, cust.getLname());
        ps.setString(2, cust.getFname());
        ps.setString(3, cust.getPhone());
        ps.setString(4, cust.getAddress());
        ps.setString(5, cust.getLicNo());
        ps.setInt(6, cust.getId());
        
        ps.executeUpdate();
        
        ps.close();
    }
    
    public static void delete(Customer customer) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement("DELETE FROM customers WHERE id=?");
        ps.setInt(1, customer.getId());
        
        ps.execute();
        
        ps.close();
    }
}
