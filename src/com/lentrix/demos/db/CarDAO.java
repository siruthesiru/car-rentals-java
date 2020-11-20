/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.db;
import com.lentrix.demos.models.Car;
import java.sql.PreparedStatement;

/**
 *
 * @author lentrix
 */
public class CarDAO {
    public static void add(Car car) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "INSERT INTO cars (make, model, color, plate, year) "
                        + "VALUE (?,?,?,?,?)");
        
        ps.setString(1, car.getMake());
        ps.setString(2, car.getModel());
        ps.setString(3, car.getColor());
        ps.setString(4, car.getPlate());
        ps.setInt(5, car.getYear());
        
        ps.executeUpdate();
    }
}
