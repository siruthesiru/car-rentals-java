/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.db;
import com.lentrix.demos.models.Car;
import com.lentrix.demos.models.Customer;
import com.lentrix.demos.models.Rental;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lentrix
 */
public class RentalDAO {
    public static void add(Rental rental) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "INSERT INTO rentals (customer_id, car_id, date_taken, date_returned, deposit) "
                        + "VALUE (?,?,?,?,?)");
        ps.setInt(1, rental.getCustomer().getId());
        ps.setInt(2, rental.getCar().getId());
        ps.setDate(3, rental.getDateTaken());
        ps.setDate(4, rental.getDateReturned());
        ps.setFloat(5, rental.getDeposit());
        
        ps.executeUpdate();
        
        ps.close();
    }
    
    public static List<Rental> getAll() throws Exception {
        Statement st = DB.conn().createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT rentals.*, cars.*, customers.* FROM rentals "
                        + "LEFT JOIN cars ON cars.id = rentals.car_id "
                        + "LEFT JOIN customers ON customers.id=rentals.customer_id "
                        + "ORDER BY date_taken DESC");
        
        ArrayList<Rental> rentals = new ArrayList();
        
        while(rs.next()) {
            Car car = new Car(
                    rs.getInt("cars.id"),
                    rs.getString("cars.make"),
                    rs.getString("cars.model"),
                    rs.getString("cars.color"),
                    rs.getString("cars.plate"),
                    rs.getInt("cars.year")
            );
            
            Customer cust = new Customer(
                    rs.getInt("customers.id"),
                    rs.getString("customers.lname"),
                    rs.getString("customers.fname"),
                    rs.getString("customers.phone"),
                    rs.getString("customers.address"),
                    rs.getString("customers.lic_no")
            );
            
            Rental rental = new Rental(
                    rs.getInt("rentals.id"), 
                    cust, 
                    car, 
                    rs.getDate("date_taken"), 
                    rs.getDate("date_returned"), 
                    rs.getFloat("deposit"));
            
            rentals.add(rental);
        }
        
        st.close();
        rs.close();
        
        return rentals;
        
    }
    
    public static void update(Rental rental) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "UPDATE rentals SET customer_id=?, car_id=?, date_taken=?, date_returned=?, deposit=?"
                + "WHERE id=?"
        );
        ps.setInt(1, rental.getCustomer().getId());
        ps.setInt(2, rental.getCar().getId());
        ps.setDate(3, rental.getDateTaken());
        ps.setDate(4, rental.getDateReturned());
        ps.setFloat(5, rental.getDeposit());
        ps.setInt(6, rental.getId());
        
        ps.executeUpdate();
        
        ps.close();
    }
    
    public static void delete(Rental rental) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement("DELETE FROM rentals WHERE id=?");
        ps.setInt(1, rental.getId());
        
        ps.execute();
        
        ps.close();
    }
}
