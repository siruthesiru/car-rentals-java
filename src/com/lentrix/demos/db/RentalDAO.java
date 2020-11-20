/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.db;
import com.lentrix.demos.models.Rental;
import java.sql.PreparedStatement;
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
    }
}
