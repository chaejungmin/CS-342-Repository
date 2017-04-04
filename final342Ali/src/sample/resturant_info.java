package sample;

import java.lang.String;
/**
 * Created by alishirsalimian on 4/3/17.
 */
public class resturant_info {

    private int resturantID;

    private int waitTime;
    private String openTime;
    private String closingTime;

    private String street;
    private String city;
    private String state;
    private int zipcode;


    private int numReservation;
    private int[] reservationInfo;

    private String menu;



    public resturant_info(){

        waitTime = 30;

        openTime = "11:00 AM";
        closingTime = "9:00 PM";

        street = "343 W Rosevelt St";
        zipcode = 60077;
        state = "IL";
        city = "Chicago";
        menu = "http://www.buffalowildwings.com/en/menu/";
    }

    public void setWaitTime(int waitTime){
        this.waitTime = waitTime;
    }

    public void setOpenTime(String openTime ){
        this.openTime = openTime;
    }

    public void setclosingTime(String closingTime){
        this.closingTime = closingTime;
    }

    public void setstreet(String address){
        this.street = address;
    }

    public void setcity(String city){
        this.city = city;
    }

    public void setstate(String state){
        this.state = state;
    }

    public void setZipcode(int zipcode){
         this.zipcode = zipcode;
    }

    public String getMenu(){
        return menu;
    }

    public int getWaitTime(){
        return waitTime;
    }

    public String getOpenTime(){
        return openTime;
    }

    public String getclosingTime(){
        return closingTime;
    }

    public String getstreet(){
        return street;
    }

    public String getcity(){
        return city;
    }

    public String getstate(){
        return state;
    }

    public int getZipcode(){
        return zipcode;
    }

    public int numreservation(){
        return numReservation;
    }

    public int[] getReservationInfo(){
        return reservationInfo;
    }


}
