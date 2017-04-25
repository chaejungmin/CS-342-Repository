package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.String;
import java.sql.DriverManager;

import java.io.IOException;
import java.sql.*;

/**
 * Created by alishirsalimian on 4/3/17.
 */
public class ResturantAPI {

    private int resturantID;
    private String resturantName;

    private int waitTime;
    private String openTime;
    private String closingTime;

    private String street;
    private String city;
    private String state;
    private int zipcode;

    private String phoneNumber;


    private int numReservation;
    private int[] reservationInfo;

    private String menu;

    public void restaurant_Setter(String variable, String query,String resturant_name){
        Connection c = null;
        Statement stmt = null;
        System.out.println("Update Resturants Set "+query+ " = '" + variable + "' WHERE Resturant_Names = '" +resturant_name+ "'");

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            String website = "";
            System.out.println("Getting Webste");
            System.out.println(variable+" : " +query);

            int status = stmt.executeUpdate("Update Resturants Set "+query+ " = '" + variable + "' WHERE Resturant_Names = '" +resturant_name+ "'");
            System.out.println("success");

            stmt.close();
            c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public String restaurant_Getter(String query,String resturant_name){
        Connection c = null;
        Statement stmt = null;
        String website = "";
        System.out.println("Select "+query +" From Resturants WHERE Resturant_Names= "+ resturant_name +"");

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();


            System.out.println("Getting Webste");


            ResultSet rs = stmt.executeQuery(String.format("Select %s From Resturants WHERE Resturant_Names = '%s'", query, resturant_name));
            System.out.println("Getting 2");

            while (rs.next()) {
                if (rs.getString(query) != null) {
                    website = rs.getString(query);
                    System.out.println(website);
                }
            }
            rs.close();
            stmt.close();
            c.close();
        }catch(Exception e){
            System.out.println(e);
        }


        return website;
    }



    public void setWaitTime(int waitTime,String resturantName){
        this.waitTime = waitTime;
        restaurant_Setter(Integer.toString(waitTime), "Wait_Time", resturantName);
    }

    public void setOpenTime(String openTime,String resturantName ){
        this.openTime = openTime;
        restaurant_Setter(openTime, "Open_Time",resturantName);
    }

    public void setclosingTime(String closingTime,String resturantName){
        this.closingTime = closingTime;
        restaurant_Setter(closingTime, "Close_Time",resturantName);
    }

    public void setstreet(String address,String resturantName){
        this.street = address;
        restaurant_Setter(address, "Address_Street",resturantName);
    }

    public void setcity(String city,String resturantName){
        this.city = city;
        restaurant_Setter(city, "Address_City",resturantName);
    }

    public void setstate(String state,String resturantName){
        this.state = state;
        restaurant_Setter(state, "Address_State",resturantName);
    }

    public void setZipcode(int zipcode,String resturantName){
        this.zipcode = zipcode;

        restaurant_Setter(Integer.toString(zipcode), "Address_ZipCode",resturantName);
    }

    public void setPhoneNumber(String phoneNumber,String resturantName){
        this.phoneNumber = phoneNumber;
        restaurant_Setter(phoneNumber,"Phone_Number" ,resturantName);

    }

    public void setMenu(String Menu,String resturantName){
        this.menu = Menu;
    }


    public String getMenu(String resturantName){
        return restaurant_Getter("Menu",resturantName);
    }

    public int getWaitTime(String resturantName){
        return Integer.parseInt( restaurant_Getter("Wait_Time",resturantName));
    }

    public String getOpenTime(String resturantName){
        return restaurant_Getter("Open_Time",resturantName);

    }

    public String getclosingTime(String resturantName){
        return restaurant_Getter("Close_Time",resturantName);
    }

    public String getstreet(String resturantName){
        return restaurant_Getter("Address_Street",resturantName);
    }

    public String getcity(String resturantName){
        return restaurant_Getter("Address_City",resturantName);
    }

    public String getstate(String resturantName){
        return restaurant_Getter("Address_State",resturantName);
    }

    public int getZipcode(String resturantName){
        return Integer.parseInt(restaurant_Getter("Address_ZipCode",resturantName));
    }

    public int numreservation(){
        return numReservation;
    }

    public int[] getReservationInfo(){
        return reservationInfo;
    }

    public String getResturantName(String resturantName){
        return restaurant_Getter("Resturant_Names",resturantName);
    }

    public String getPhoneNumber(String resturantName){return restaurant_Getter("Phone_Number",resturantName);}


    public void goButton(ActionEvent event, String fxmlPage)throws IOException, SQLException {
        Parent admin_parent = FXMLLoader.load(getClass().getResource(fxmlPage));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
        admin_stage.setScene(admin_scene);
        admin_stage.show();
    }


}
