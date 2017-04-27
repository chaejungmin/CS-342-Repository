package sample;

import java.sql.*;
import java.lang.String;
import java.util.ArrayList;

/**
 * Created by alishirsalimian on 4/23/17.
 */
public class Reservation extends ResturantAPI {

    private String firstName, lastName, contact, email, howMany, memo;


    //inserts reservation to the database
    public void reservation_insert(String username, String restaurantName) {
        Connection c = null;
        Statement stmt = null;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            String sql = "INSERT INTO Reservations (UserName, NumGuests,Phone_Num,Resturant_Name,Memo) VALUES ('" + username + "','" + getHowMany() + "','" + getContact() + "','" + restaurantName + "','" + getMemo() + "')";
            stmt.executeUpdate(sql);
            System.out.println("success");

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //deletes reservation to the database
    public void reservation_delete(String username, String restaurantName) {
        Connection c = null;
        Statement stmt = null;

        System.out.println("DELETE FROM Reservations WHERE UserName = '" + username + "' and Resturant_Name = '" + restaurantName + "' ");

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            String sql = "DELETE FROM Reservations WHERE UserName = '" + username + "' and Resturant_Name = '" + restaurantName + "' ";
            stmt.executeUpdate(sql);
            System.out.println("success");

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static ArrayList get_reservations(String restaurantName) {
        ArrayList reservations = new ArrayList();


        Connection c = null;
        Statement stmt = null;

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            String sql = "Select UserName From Reservations WHERE Resturant_Name = '"+restaurantName +"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("UserName") != null) {
                    reservations.add(rs.getString("UserName"));
                }
            }

            System.out.println("success");
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return reservations;

    }






    public void insert_reservation(){
        reservation_insert(ValidLoginController.getMyusername(),RestaurantList_Controller.getResturant_selected());
    }


    public void deletereservation(String username){
        System.out.println("UN:" + username);
        reservation_delete(username,getAdminResturantName(ValidLoginController.getMyusername()));
    }

    public static ArrayList get_reservations(){
        ArrayList reservations = get_reservations(getAdminResturantName(ValidLoginController.getMyusername()));
        return reservations;
    }




    // get  and set reservations infomation from the user
    public void setContact(String lm){
        this.contact = lm;
    }
    public void setHowMany(String lm){
        this.howMany = lm;
    }
    public void setMemo(String Memo){
        this.memo = Memo;
    }
    public String getContact(){
        return contact;
    }
    public String getHowMany(){
        return howMany;
    }
    public String getMemo(){
        return memo ;
    }

}
