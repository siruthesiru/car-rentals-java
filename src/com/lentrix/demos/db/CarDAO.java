/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.db;
import com.lentrix.demos.models.Car;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public static List<Car> getAll() throws Exception {
        Statement st = DB.conn().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM cars ORDER BY make, model");
        
        ArrayList<Car> cars = new ArrayList();
        
        while(rs.next()) {
            Car c = new Car(
                    rs.getInt("id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getString("color"),
                    rs.getString("plate"),
                    rs.getInt("year")
            );
            
            cars.add(c);
        }
        
        st.close();
        rs.close();
        
        return cars;
    }
    
    public static void update(Car car) throws Exception {
        PreparedStatement ps = DB.conn().prepareStatement(
                "UPDATE cars SET make=?, model=?, color=?, plate=?, year=? "
                        + "WHERE id=?");
        ps.setString(1, car.getMake());
        ps.setString(2, car.getModel());
        ps.setString(3, car.getColor());
        ps.setString(4, car.getPlate());
        ps.setInt(5, car.getYear());
        ps.setInt(6, car.getId());
        
        ps.executeUpdate();
        
        ps.close();
    }
}
