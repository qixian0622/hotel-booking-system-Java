/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;

import static hotel.booking.system.manageBooking.jTableManageBooking;
import static hotel.booking.system.room.storage;
import static hotel.booking.system.room.write_to_file;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author qi xian
 */
public class booking extends room{
   
    protected String customerName;
    protected String icNumber;
    protected String contactNumber;
    protected String email;
    protected int duration;
    protected String CheckInDay;
    protected String checkOutDay;
    protected String selectedRoom;
    
    //for save room method
   protected int countBookingID = 1;
    protected boolean found = false;
    
    protected boolean searchedBookingRecordresultFound = true;
    
    
    
    booking(int durationx){
        duration = durationx;
    }
    
    
    public int SaveBookingRecord(String customerNamexx, String icNumberxx, String contactNumberxx, String emailxx, String checkindayxx, String checkoutdayxx, String selectedRoomxx){
        
           
    customerName = customerNamexx;
    icNumber = icNumberxx;
    contactNumber = contactNumberxx;
    email = emailxx;
    
    CheckInDay = checkindayxx;
    checkOutDay = checkoutdayxx;
    selectedRoom = selectedRoomxx;
     
        determineBookingID();
        
        try {
            FileWriter fw = new FileWriter("booking.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
           
            bw.write("(Booking Id):" +countBookingID+",");
            bw.write(customerName+",");
            bw.write(icNumber+",");
            bw.write(contactNumber +",");
            bw.write(email+",");
            bw.write(selectedRoom+",");
            bw.write("(Duration):" +duration+",");
            bw.write("(Check In Day):" +CheckInDay+",");
            bw.write("(Check Out Day):" +checkOutDay+",");
            bw.write("Ongoing");
            bw.newLine();
            bw.close();
//            JOptionPane.showMessageDialog(null, "Data Saved To File booking.txt");
            return countBookingID;
            
             } catch (IOException ex) {
            System.out.println("Unable to create file due to " + ex);
        }
    
    return countBookingID;
}
   
    public void determineBookingID(){
         
        try{
            
          Scanner scanner = new Scanner(new File("booking.txt"));
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
            if (line != "") {
                countBookingID++;
            }
}
           }catch(FileNotFoundException ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
 
    public void CheckeOut(String selectedDay, int durationkk, String roomId, int newroomNumberx,  String newroomTypex, int newfloorLevelx){
         
    roomNumber = newroomNumberx;
   
    roomType = newroomTypex;
    floorLevel = newfloorLevelx;
    String monday = "Monday";
    String tuesday = "Tuesday";
    String wednesday = "Wednesday";
    String thursday = "Thursday";
    String friday = "Friday";
    String saturday = "Saturday";
    String sunday = "Sunday";
    
         if (selectedDay.equals(monday)) {
                
        ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
                
                
        
             if (durationkk == 1) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if(durationkk == 2) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
            }
        } 
             }else if(durationkk == 3) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if(durationkk == 4) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if(durationkk == 5) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
               String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if(durationkk == 6) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if(durationkk == 7) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
         
         
         
         }else if (selectedDay.equals(tuesday)) {
              ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
             if (durationkk == 1) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
               
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Available,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 2) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Available,wed:Available,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
                
            }
        } 
             }else if (durationkk == 3) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Available,wed:Available,thur:Available,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 4) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Available,wed:Available,thur:Available,fri:Available,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 5) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
               String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 6) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                  String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 7) {
                 
                  
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
                
            }
        } 
             }
             
             
         }else if (selectedDay.equals(wednesday)) {
              ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
             if (durationkk == 1) {
                 
                  
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Available,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
                
            }
        } 
             }else if (durationkk == 2) {
                 
                  
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Available,thur:Available,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 3) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Available,thur:Available,fri:Available,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 4) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Available,thur:Available,fri:Available,sat:Available,sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 5) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 6) {
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:"+tuesdayoldStatusCompleted+",wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");;
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
                
            }
        } 
             }else if (durationkk == 7) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");;
                write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
    
    
   
 
        
  }else if (selectedDay.equals(thursday)) {
              ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
             if (durationkk == 1) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Available,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
                
            }
        } 
             }else if (durationkk == 2) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                  String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Available,fri:Available,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 3) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Available,fri:Available,sat:Available,sun:"+sundayoldStatusCompleted);
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 4) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Available,fri:Available,sat:Available,sun:Available");
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 5) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Available,fri:Available,sat:Available,sun:Available");
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 6) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:"+wednesdayoldStatusCompleted+",thur:Available,fri:Available,sat:Available,sun:Available");
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
                
            }
        } 
             }else if (durationkk == 7) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                     write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
         
         
         
     }else if (selectedDay.equals(friday)) {
              ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
             if (durationkk == 1) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Available,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 2) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Available,sat:Available,sun:"+sundayoldStatusCompleted);
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 3) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Available,sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 4) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Available,sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 5) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Available,sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 6) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:"+thursdayoldStatusCompleted+",fri:Available,sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 7) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
             
     }else if (selectedDay.equals(saturday)) {
              ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
             if (durationkk == 1) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Available,sun:"+sundayoldStatusCompleted);
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 2) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 3) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
               String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 4) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 5) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 6) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:"+fridayoldStatusCompleted+",sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 7) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                    write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
     }else  {
              ArrayList<String> room = storage("roomschedule.txt");
        String [] sub_room;
        
             if (selectedDay.equals(sunday)) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 2) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 3) {
                 
                for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 4) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 5) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else if (durationkk == 6) {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                 String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:"+saturdayoldStatusCompleted+",sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }else  {
                 
                 for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[4].equals(roomId)) {
                String mondayoldStatus = sub_room[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_room[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_room[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_room[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_room[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_room[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_room[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
     }
         
         
         
         
         
     }
 
 
    public void UpdateBookingRecord(String bookingIdxx, String customerNamexx, String icNumberxx, String contactNumberxx, String emailxx, String checkindayxx, String checkoutdayxx, String selectedRoomxx, boolean checkout){
         
         
         //if wanna check out, only execute the update statement where the status is updated to checkedout, else jsut update as ongoing
         if (checkout == false) {
             
         
         String bookingId  = bookingIdxx;
         customerName = customerNamexx;
    icNumber = icNumberxx;
    contactNumber = contactNumberxx;
    email = emailxx;
    
    CheckInDay = checkindayxx;
    checkOutDay = checkoutdayxx;
    selectedRoom = selectedRoomxx;
    
    
    //the roomid passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String roomIdString = String.valueOf(roomId);
    
    ArrayList<String> room = storage("booking.txt");
        String [] sub_room;
        for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            String bookingIda = sub_room[0];
                int bookingIdaLength = bookingIda.length();
                String bookingIdaComplete = bookingIda.substring(13,bookingIdaLength);
                sub_room[0] = bookingIdaComplete;
            if (sub_room[0].equals(bookingId)) {
                room.set(i,"(Booking Id):"+bookingId +","+ customerName+","+ icNumber+","+contactNumber+","+email+","+selectedRoom +",(Duration):"+duration+","+"(Check In Day):"+CheckInDay+","+"(Check Out Day):"+checkOutDay+",Ongoing");
                write_to_file("booking.txt", room);
                JOptionPane.showMessageDialog(null, "Booking Record Updated On Booking.txt File!");
                
            }
        } 
         } else{
              
         String bookingId  = bookingIdxx;
         customerName = customerNamexx;
    icNumber = icNumberxx;
    contactNumber = contactNumberxx;
    email = emailxx;
    
    CheckInDay = checkindayxx;
    checkOutDay = checkoutdayxx;
    selectedRoom = selectedRoomxx;
    
    
    //the roomid passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String roomIdString = String.valueOf(roomId);
    
    ArrayList<String> room = storage("booking.txt");
        String [] sub_room;
        for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            String bookingIda = sub_room[0];
                int bookingIdaLength = bookingIda.length();
                String bookingIdaComplete = bookingIda.substring(13,bookingIdaLength);
                sub_room[0] = bookingIdaComplete;
            if (sub_room[0].equals(bookingId)) {
                room.set(i,"(Booking Id):"+bookingId +","+ customerName+","+ icNumber+","+contactNumber+","+email+","+selectedRoom +",(Duration):"+duration+","+"(Check In Day):"+CheckInDay+","+"(Check Out Day):"+checkOutDay+",CheckedOut");
                write_to_file("booking.txt", room);
                JOptionPane.showMessageDialog(null, "Booking Record Updated On Booking.txt File!");
                
            }
        }
         }
  }
     
 
    public void DeleteBookingRecord(int deletedbookingidx){
    
    
    //the booking passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String deletebookingIdString = String.valueOf(deletedbookingidx);
    
    ArrayList<String> booking = storage("booking.txt");
        String [] sub_room;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete This Booking Record?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            for (int i = 0; i < booking.size(); i++) {
            sub_room = booking.get(i).split(",");
            String bookingIdfromfile = sub_room[0];
            int bookingIdfromfilelength = bookingIdfromfile.length();
            sub_room[0] = bookingIdfromfile.substring(13,bookingIdfromfilelength);
            if (sub_room[0].equals(deletebookingIdString)) {
                booking.remove(i);
                
                write_to_file("booking.txt", booking);
                JOptionPane.showMessageDialog(null, "Booking Record Deleted!");
                
            }
        } 
            }
        
  }
      
    public void SerchBookingRecord(){
          if (manageBooking.txtSearchBookingRecord.getText().equals("") ) {
             String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\booking.txt";
        File file = new File(filePath);
        manageBooking.jTableManageBooking.setRowHeight(30);
         manageBooking.jTableManageBooking.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
            Object[] tableLines = br.lines().toArray();
            model.setRowCount(0);
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                
                String bookingId = dataRow[0];
                int bookingIdLength = bookingId.length();
                String bookingIdComplete = bookingId.substring(13,bookingIdLength);
                dataRow[0] = bookingIdComplete;
                
                
                
                
                String durationaz = dataRow[6];
                int durationLength = durationaz.length();
                String durationComplete = durationaz.substring(11,durationLength);
                dataRow[6] = durationComplete;
                
                String checkinday = dataRow[7];
                int checkindayLength = checkinday.length();
                String checkindayComplete = checkinday.substring(15,checkindayLength);
                dataRow[7] = checkindayComplete;
                
                String checkoutday = dataRow[8];
                int checkoutdayLength = checkoutday.length();
                String checkoutdayComplete = checkoutday.substring(16,checkoutdayLength);
                dataRow[8] = checkoutdayComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
            
        }else{
            String SearchedBookingId = manageBooking.txtSearchBookingRecord.getText();
            
            String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\booking.txt";
        File file = new File(filePath);
        manageBooking.jTableManageBooking.setRowHeight(30);
        manageBooking.jTableManageBooking.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
         
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)manageBooking.jTableManageBooking.getModel();
            Object[] tableLines = br.lines().toArray();
            model.setRowCount(0);
            for (int i = 0; i < tableLines.length; i++) {
                
                
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                String bookingid = dataRow[0];
                
                String name = dataRow[1];
                String icnumber = dataRow[2];
                String contact = dataRow[3];
                String email = dataRow[4];
                String status = dataRow[9];
                 
                String duration = dataRow[6];
                int durationLength = duration.length();
                String durationComplete = duration.substring(11,durationLength);
                dataRow[6] = durationComplete;
                
                String checkinday = dataRow[7];
                int checkindayLength = checkinday.length();
                String checkindayComplete = checkinday.substring(15,checkindayLength);
                dataRow[7] = checkindayComplete;
                
                String checkoutday = dataRow[8];
                int checkoutdayLength = checkoutday.length();
                String checkoutdayComplete = checkoutday.substring(16,checkoutdayLength);
                dataRow[8] = checkoutdayComplete;
                
                
                String bookingidComplete = bookingid.substring(13,index1);
                if (!( bookingidComplete.contains(SearchedBookingId) ||name.contains(SearchedBookingId)|| icnumber.contains(SearchedBookingId)|| contact.contains(SearchedBookingId) 
                        || email.contains(SearchedBookingId) || status.contains(SearchedBookingId) || durationComplete.contains(SearchedBookingId) ||
                        checkindayComplete.contains(SearchedBookingId) || checkoutdayComplete.contains(SearchedBookingId)
                        )) {
//                      searchedBookingRecordresultFound = false;
                    
                    
                } else {
                    //to clear the the content first, else it will add up the room u serach for, which cause duplication
//                    model.setRowCount(0);
                    
//                    searchedBookingRecordresultFound = true;
                    
                
                String bookingId = dataRow[0];
                int bookingIdLength = bookingId.length();
                String bookingIdComplete = bookingId.substring(13,bookingIdLength);
                dataRow[0] = bookingIdComplete;
                
                
                
                
               
                    model.addRow(dataRow);
//                    break;
                }
                
               
                
               
                
            } 
            
             if ( searchedBookingRecordresultFound == false) {
                    JOptionPane.showMessageDialog(null, "Booking Record Not Found!");
                    manageBooking.txtSearchBookingRecord.setText("");
                    model.setRowCount(0);
                    
        manageBooking.jTableManageBooking.setRowHeight(30);
         manageBooking.jTableManageBooking.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        
            
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                 
                
                String bookingId = dataRow[0];
                int bookingIdLength = bookingId.length();
                String bookingIdComplete = bookingId.substring(13,bookingIdLength);
                dataRow[0] = bookingIdComplete;
                
                
                
                
                String duration = dataRow[6];
                int durationLength = duration.length();
                String durationComplete = duration.substring(11,durationLength);
                dataRow[6] = durationComplete;
                
                String checkinday = dataRow[7];
                int checkindayLength = checkinday.length();
                String checkindayComplete = checkinday.substring(15,checkindayLength);
                dataRow[7] = checkindayComplete;
                
                String checkoutday = dataRow[8];
                int checkoutdayLength = checkoutday.length();
                String checkoutdayComplete = checkoutday.substring(16,checkoutdayLength);
                dataRow[8] = checkoutdayComplete;
                
               
                model.addRow(dataRow);
                
               
               
            
            
            
            
        } 
                    
                }
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
      }
      
     
             
             
   
  
}