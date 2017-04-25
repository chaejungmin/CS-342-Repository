package sample;

import java.sql.*;
import java.lang.String;

/**
 * Created by alishirsalimian on 4/23/17.
 */
public class Reservation extends ResturantAPI{

    private String firstName,lastName,contact,email,howMany,memo;


    public void reservation_insert(String username,String restaurantName){
        Connection c = null;
        Statement stmt = null;

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            String sql = "INSERT INTO Reservations (UserName, NumGuests,Phone_Num,Resturant_Name,Memo) VALUES ('"+username+"','"+getHowMany()+"','"+getContact()+"','"+restaurantName+"','"+getMemo()+"')";
            stmt.executeUpdate(sql);
            System.out.println("success");

            stmt.close();
            c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public void reservation_delete(String username,String restaurantName){
        Connection c = null;
        Statement stmt = null;

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            String sql = "DELETE FROM Reservations WHERE UserName = '"+username+"' and Resturant_Name = '"+ restaurantName +"' ";
            stmt.executeUpdate(sql);
            System.out.println("success");

            stmt.close();
            c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public void insertreservation(){
        reservation_insert(ValidLoginController.getMyusername(),RestaurantList_Controller.getResturant_selected());

    }


    public void deletereservation(){
        reservation_delete(ValidLoginController.getMyusername(),RestaurantList_Controller.getResturant_selected());

    }


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
