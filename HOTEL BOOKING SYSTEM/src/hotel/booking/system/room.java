/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;


import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;





import java.io.*;

import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author qi xian
 */
public class room {
    
    protected int roomId;
    protected int roomNumber;
    protected String roomStatus;
    protected String roomType; //cabana, villa, suite
    protected int floorLevel;
    protected String roomDescription;
    
    //for add room method
    protected int countRoomID = 1;
    protected boolean found = false;
    
    //for search room method
     protected boolean searchedRoomresultFound = true;
    
    room(){
        
    }
    
     public void determineRoomID(){
         
        try{
            
          Scanner scanner = new Scanner(new File("room.txt"));
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
            if (line != "") {
                countRoomID++;
            }
}
           }catch(FileNotFoundException ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public void checkIfRoomNumberExisted(int newRoomNumberx){
        
        String ExistedroomNumberString;
        String ExistedroomNumber;
        long number;
        int index1, index2;
        File filezz = new File("room.txt");
        try {
        RandomAccessFile raf = new RandomAccessFile(filezz, "rw");
        
        
        while(raf.getFilePointer() < raf.length()){
            ExistedroomNumberString = raf.readLine();
            
            index1 = ExistedroomNumberString.indexOf(':');
            index2 = ExistedroomNumberString.indexOf(',');
            
            ExistedroomNumber = ExistedroomNumberString.substring(index1+1,index2);
            
            String ExistedroomNumberS = ExistedroomNumber;
            int  ExistedroomNumberInt = Integer.parseInt(ExistedroomNumberS);
            
            if (newRoomNumberx == ExistedroomNumberInt) {
                found = true;
                break;
            }
            
            
            
            
        } 
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
  
  
     
     public void CreateRoom(int newroomNumberx, String newroomStatusx, String newroomTypex, int newfloorLevelx, String newroomDescriptionx){
    
    roomNumber = newroomNumberx;
    roomStatus = newroomStatusx;
    roomType = newroomTypex;
    floorLevel = newfloorLevelx;
    roomDescription = newroomDescriptionx;
    
   checkIfRoomNumberExisted(roomNumber);
                
                if (found == true) {
                JOptionPane.showMessageDialog(null, "Room number existed!");
                found = false;
                
                
            }else{
            determineRoomID();
      
                  try {
            FileWriter fwmonday = new FileWriter("roomschedule.txt", true);
            BufferedWriter bwmonday = new BufferedWriter(fwmonday);
            bwmonday.write("(Room Number):" + roomNumber+",");
                    if (roomStatus == "Inactive") {
                        bwmonday.write("Inactive,");
                    } else  {
                        bwmonday.write("Active,");
                    }
            bwmonday.write(roomType+",");
            bwmonday.write(floorLevel+",");
            bwmonday.write(String.valueOf(countRoomID));
            bwmonday.write(",mon:Available,tue:Available,wed:Available,thur:Available,fri:Available,sat:Available,sun:Available");
            bwmonday.newLine();
            bwmonday.close();
            
             } catch (IOException ex) {
            System.out.println("Unable to create file due to " + ex +"roomschedule.txt");
            }
                 
                  
                
             
                  
                  
                  
                
                try {
            FileWriter fw = new FileWriter("room.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("(Room Number):" +roomNumber+",");
            bw.write(roomType+",");
            bw.write(floorLevel+",");
            bw.write(roomDescription+",");
            bw.write(roomStatus+",");
            bw.write(String.valueOf(countRoomID));
            bw.newLine();
            bw.close();
            JOptionPane.showMessageDialog(null, "Data Saved To File Room.txt");
            StaffAddRoom.txtRoomNumber.setText("");
                 StaffAddRoom.txtRoomDescription.setText("");
            
            
            

            

        } catch (IOException ex) {
            System.out.println("Unable to create file due to " + ex);
        }
           
                     
            }
     }
        
     public void UpdateRoom(int newroomIdx, int newroomNumberx, String newroomStatusx, String newroomTypex, int newfloorLevelx, String newroomDescriptionx){
    roomId = newroomIdx;
    roomNumber = newroomNumberx;
    roomStatus = newroomStatusx;
    roomType = newroomTypex;
    floorLevel = newfloorLevelx;
    roomDescription = newroomDescriptionx;
    
    //the roomid passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String roomIdString = String.valueOf(roomId);
    
    ArrayList<String> room = storage("room.txt");
        String [] sub_room;
        for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            if (sub_room[5].equals(roomIdString)) {
                room.set(i,"(Room Number):"+roomNumber+","+ roomType+","+floorLevel+","+roomDescription+","+roomStatus+","+roomId);
                write_to_file("room.txt", room);
                JOptionPane.showMessageDialog(null, "Room Updated!");
                
            }
        } 
        
        
         ArrayList<String> roomschedule = storage("roomschedule.txt");
        String [] sub_roomschedule;
        for (int i = 0; i < roomschedule.size(); i++) {
            sub_roomschedule = roomschedule.get(i).split(",");
            
            String mondayoldStatus = sub_roomschedule[5];
                int mondayoldStatuslength = mondayoldStatus.length();
                String mondayoldStatusCompleted = mondayoldStatus.substring(4,mondayoldStatuslength);
                
                String tuesdayoldStatus = sub_roomschedule[6];
                int tuesdayoldStatuslength = tuesdayoldStatus.length();
                String tuesdayoldStatusCompleted = tuesdayoldStatus.substring(4,tuesdayoldStatuslength);
                
                String wednesdayoldStatus = sub_roomschedule[7];
                int wednesdayoldStatuslength = wednesdayoldStatus.length();
                String wednesdayoldStatusCompleted = wednesdayoldStatus.substring(4,wednesdayoldStatuslength);
                
                String thursdayoldStatus = sub_roomschedule[8];
                int thursdayoldStatuslength = thursdayoldStatus.length();
                String thursdayoldStatusCompleted = thursdayoldStatus.substring(5,thursdayoldStatuslength);
                
                String fridayoldStatus = sub_roomschedule[9];
                int fridayoldStatuslength = fridayoldStatus.length();
                String fridayoldStatusCompleted = fridayoldStatus.substring(4,fridayoldStatuslength);
                
                String saturdayoldStatus = sub_roomschedule[10];
                int saturdayoldStatuslength = saturdayoldStatus.length();
                String saturdayoldStatusCompleted = saturdayoldStatus.substring(4,saturdayoldStatuslength);
                
                String sundayoldStatus = sub_roomschedule[11];
                int sundayoldStatuslength = sundayoldStatus.length();
                String sundayoldStatusCompleted = sundayoldStatus.substring(4,sundayoldStatuslength);
                
                
               
            if (sub_roomschedule[4].equals(roomIdString)) {
                 roomschedule.set(i,"(Room Number):"+roomNumber+","+ roomStatus+"," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"
                        +tuesdayoldStatusCompleted
                        +",wed:"+wednesdayoldStatusCompleted+",thur:"
                        +thursdayoldStatusCompleted
                                + ",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
                write_to_file("roomschedule.txt", roomschedule);
                
            }
        } 
  }
  
     public void UpdateRoomStatusForBookedDay(String selectedDay, int durationkk, String roomId, int newroomNumberx,  String newroomTypex, int newfloorLevelx){
         
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:"
                        +tuesdayoldStatusCompleted
                        +",wed:"+wednesdayoldStatusCompleted+",thur:"
                        +thursdayoldStatusCompleted+""
                                + ",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ 
                        roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:"+thursdayoldStatusCompleted+""
                                + ",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+""
                                        + ",sun:"+sundayoldStatusCompleted);
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:"+sundayoldStatusCompleted);
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
                
                
                room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Occupied,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Occupied,wed:Occupied,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Occupied,wed:Occupied,thur:Occupied,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:"+sundayoldStatusCompleted);
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
               room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Occupied,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Occupied,thur:Occupied,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Occupied,thur:Occupied,fri:Occupied,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:"+tuesdayoldStatusCompleted+",wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");;
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");;
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Occupied,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Occupied,fri:Occupied,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Occupied,fri:Occupied,sat:Occupied,sun:"+sundayoldStatusCompleted);
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:"+wednesdayoldStatusCompleted+",thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
              room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Occupied,sat:"+saturdayoldStatusCompleted+",sun:"+sundayoldStatusCompleted);
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Occupied,sat:Occupied,sun:"+sundayoldStatusCompleted);
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:"+thursdayoldStatusCompleted+",fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Occupied,sun:"+sundayoldStatusCompleted);
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:"+fridayoldStatusCompleted+",sat:Occupied,sun:Occupied");
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
                
                
             room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:"+mondayoldStatusCompleted+",tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:"+tuesdayoldStatusCompleted+",wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:"+wednesdayoldStatusCompleted+",thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:"+thursdayoldStatusCompleted+",fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:"+fridayoldStatusCompleted+",sat:"+saturdayoldStatusCompleted+",sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:"+saturdayoldStatusCompleted+",sun:Occupied");
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
                
                
            room.set(i,"(Room Number):"+roomNumber+","+ "Active," + roomType+","+floorLevel+","+ roomId +",mon:Occupied,tue:Occupied,wed:Occupied,thur:Occupied,fri:Occupied,sat:Occupied,sun:Occupied");
                 write_to_file("roomschedule.txt", room);
                //JOptionPane.showMessageDialog(null, "Booking Record Updated On roomschedule.txt File!");
                
            }
        } 
             }
     }
         
         
         
         
         
         
     }

      public void DeleteRoom(int deleteroomIdx){
    //the roomid passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String deleteroomIdString = String.valueOf(deleteroomIdx);
    
    ArrayList<String> room = storage("room.txt");
        String [] sub_room;
         ArrayList<String> roomschedule = storage("roomschedule.txt");
        String [] sub_roomschedule;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete This Room Record?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            if (sub_room[5].equals(deleteroomIdString)) {
                room.remove(i);
                
                write_to_file("room.txt", room);
                JOptionPane.showMessageDialog(null, "Room Deleted!");
                
            }
        } 
            
            
             for (int j = 0; j < roomschedule.size(); j++) {
            sub_roomschedule = roomschedule.get(j).split(",");
            if (sub_roomschedule[4].equals(deleteroomIdString)) {
                roomschedule.remove(j);
                
                write_to_file("roomschedule.txt", roomschedule);
                
                
            }
        } 
            }
        
        
       
        
        
           
            
        
  }
      
      public void SerchRoom(){
          if (StaffManageRoom.txtSearchRoom.getText().equals("") ) {
             String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\room.txt";
        File file = new File(filePath);
        StaffManageRoom.jTableManageRoom.setRowHeight(30);
         StaffManageRoom.jTableManageRoom.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)StaffManageRoom.jTableManageRoom.getModel();
            Object[] tableLines = br.lines().toArray();
            
             model.setRowCount(0);
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                String roomNumber = dataRow[0];
                String rooomNumberComplete = roomNumber.substring(14,index1);
                dataRow[0] = rooomNumberComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
            
        }else{
            String SearchedRoomNumber = StaffManageRoom.txtSearchRoom.getText();
            
            String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\room.txt";
        File file = new File(filePath);
        StaffManageRoom.jTableManageRoom.setRowHeight(30);
         StaffManageRoom.jTableManageRoom.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
      try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)StaffManageRoom.jTableManageRoom.getModel();
            Object[] tableLines = br.lines().toArray();
             model.setRowCount(0);
            for (int i = 0; i < tableLines.length; i++) {
                
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                String roomNumber = dataRow[0];
                String rooomNumberComplete = roomNumber.substring(14,index1);
                if (!( rooomNumberComplete.contains(SearchedRoomNumber) || dataRow[1].contains(SearchedRoomNumber) || dataRow[2].contains(SearchedRoomNumber) 
                        || dataRow[3].contains(SearchedRoomNumber) || dataRow[4].contains(SearchedRoomNumber) || dataRow[5].contains(SearchedRoomNumber)
                        
                        
                        ) ) {
//                      searchedRoomresultFound = false;
                 
                } else {
                    //to clear the the content first, else it will add up the room u serach for, which cause duplication
                   
                    
//                    searchedRoomresultFound = true;
                    dataRow[0] = rooomNumberComplete;
                    model.addRow(dataRow);
//                    break;
                }
                
               
                
               
                
            } 
            
             if ( searchedRoomresultFound == false) {
                    JOptionPane.showMessageDialog(null, "Room Not Found!");
                    StaffManageRoom.txtSearchRoom.setText("");
                    model.setRowCount(0);
                    
        StaffManageRoom.jTableManageRoom.setRowHeight(30);
         StaffManageRoom.jTableManageRoom.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        
            
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                String roomNumber = dataRow[0];
                String rooomNumberComplete = roomNumber.substring(14,index1);
                dataRow[0] = rooomNumberComplete;
                
               
                model.addRow(dataRow);
            
            
            
            
        } 
                    
                }
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
      }
      
      public String[] CheckIfRoomIsAvailableOnADay(String day, String duration){
          //to store all room which is avialable on the particular day in an arraylist by their roomNumber;
          //and then create an array which receive all the element of the arraylist thorugh for loop;
          //and then return the array, when this method is being called, so the the element of the array 
          //can be displayed in the combobox in StaffSelectAvailalbeRoom.java page
            if (day == "Monday") {
                if (duration == "1") {
                    
                //the duration is needed, in order to see, for instance customer select monday 
               //the duration is 2 days, so this if statement find which room is not occupied from monday to tuesday. 
               //and return it to the combobox whicch can be selected by the staff
          
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
                
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                //the duration is needed, in order to see, for instance customer select monday 
               //the duration is 2 days, so this if statement find which room is not occupied from monday to tuesday. 
               //and return it to the combobox whicch can be selected by the staff
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                 String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) && sub_room[6].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                //the duration is needed, in order to see, for instance customer select monday 
               //the duration is 2 days, so this if statement find which room is not occupied from monday to tuesday. 
               //and return it to the combobox whicch can be selected by the staff
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                 String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                 String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                 String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
            }else if (day == "Tuesday") {
                if (duration == "1") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                 String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) && sub_room[7].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                } else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
                else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
                else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
            
            
      }else if (day == "Wednesday") {
                if (duration == "1") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status) && sub_room[8].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
            
            
            
      }else if (day == "Thursday") {
                if (duration == "1") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) && sub_room[9].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
            
            
            
      }else if (day == "Friday") {
               if (duration == "1") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status) && sub_room[10].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status)) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[9].equals(status) && sub_room[10].equals(status) && sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
            
            
            
            
      }else if (day == "Saturday") {
                if (duration == "1") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status)  ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status) &&  sub_room[11].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status) &&  sub_room[11].equals(status) &&  sub_room[5].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status) &&  sub_room[11].equals(status) &&  sub_room[5].equals(status) &&  sub_room[6].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status) &&  sub_room[11].equals(status) &&  sub_room[5].equals(status) &&  sub_room[6].equals(status) &&  sub_room[7].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status) &&  sub_room[11].equals(status) &&  sub_room[5].equals(status) &&  sub_room[6].equals(status) &&  sub_room[7].equals(status) &&  sub_room[8].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[10].equals(status) &&  sub_room[11].equals(status) &&  sub_room[5].equals(status) &&  sub_room[6].equals(status) &&  sub_room[7].equals(status) &&  sub_room[8].equals(status) &&  sub_room[9].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
            
            
            
            
      }else{
                if (duration == "1") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status)  ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "2") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status) && sub_room[5].equals(status)  ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "3") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status)  ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "4") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status)  ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "5") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "6") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }else if (duration == "7") {
                    
                
                
                String status = "Available";
                String activeStatus ="Active";
          ArrayList<String> mondayroom = storage("roomschedule.txt");
          ArrayList<String> mondayavailableroom = new ArrayList<String>();
        String [] sub_room;
              for (int i = 0; i < mondayroom .size(); i++) {
            sub_room = mondayroom.get(i).split(",");
            
            if (sub_room[1].equals(activeStatus)) {
                String roomNumber = sub_room[0];
                String roomType = sub_room[2];
                String floorLevel = sub_room[3];
                String roomId = sub_room[4];
                
                  String mon = sub_room[5];
                int monLength = mon.length();
                String monCompleted = mon.substring(4, monLength);
                sub_room[5] = monCompleted;
                
                String tue = sub_room[6];
                int tueLength = tue.length();
                String tueCompleted = tue.substring(4, tueLength);
                sub_room[6] = tueCompleted;
                        
                String wed = sub_room[7];
                int wedLength = wed.length();
                String wedComplete = wed.substring(4,wedLength);
                sub_room[7] = wedComplete;
                
                String thurs = sub_room[8];
                int thursLength = thurs.length();
                String thursComplete = thurs.substring(5,thursLength);
                sub_room[8] = thursComplete; 
                
                String fri = sub_room[9];
                int friLength = fri.length();
                String friComplete = fri.substring(4,friLength);
                sub_room[9] = friComplete;
                
                String sat = sub_room[10];
                int satLength = sat.length();
                String satComplete = sat.substring(4,satLength);
                sub_room[10] = satComplete;
                
                String sun = sub_room[11];
                int sunLength = sun.length();
                String sunComplete = sun.substring(4,sunLength);
                sub_room[11] = sunComplete;
               
                int length = roomNumber.length();
                String rooomNumberComplete = roomNumber.substring(14,length);
                
              if (sub_room[11].equals(status) && sub_room[5].equals(status) && sub_room[6].equals(status) && sub_room[7].equals(status) && sub_room[8].equals(status) && sub_room[9].equals(status) && sub_room[10].equals(status) ) {
                
                mondayavailableroom.add("Room No: " +rooomNumberComplete + " ; Type: " + roomType + " ; Floor Lvl: " + floorLevel + " ; Id: " +roomId);
                
              
               
                
                
                
            }
                
                
            }
                
        }
             
              
              String[] array = new String[mondayavailableroom.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = mondayavailableroom.get(k);
                    
                    }
                
                return array;
                
                }
                
                
                
            
            
      }
             return null;
            }
           
     //storage
    public static ArrayList<String> storage(String name_of_file){
        ArrayList<String> all_data = new ArrayList<>();
        String data;
        try{
          Scanner s = new Scanner(new File(name_of_file));
          while (s.hasNext()){
              data=s.nextLine();
              all_data.add(data);
          }
          return all_data;
        } 
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        return null;
        
        
    }
    
    //write to file
    public static void write_to_file(String name, ArrayList<String> data){
        try{
            FileWriter f = new FileWriter(new File(name));
            BufferedWriter w = new BufferedWriter(f);
            for (String x : data){
                w.write(x+"\r\n");
                
            }
            w.close();
            
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
//  public int getroomID(){
//      return roomId;
//  }
//  
//  public int getroomNumber(){
//      return roomNumber;
//  }
//  
//  public String getroomStatus(){
//      return roomStatus;
//  }
//  
//  public String getroomType(){
//      return roomType;
//  }
//  
//  public int getfloorLevel(){
//      return floorLevel;
//  }
//  
//  public String getroomDescription(){
//      return roomDescription;
//  }
    
}

