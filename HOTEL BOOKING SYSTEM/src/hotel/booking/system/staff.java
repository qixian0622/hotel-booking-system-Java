
package hotel.booking.system;

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
import javax.swing.table.DefaultTableModel;
import static hotel.booking.system.manageStaff.jTableManageStaff;

/**
 *
 * @author qi xian
 */
public class staff extends user{
    
    
    
     
       private  int countStaffuserID = 1;
       private boolean searchedStaffesultFound = true;
       
   private String usertype ="Staff";
   private int staffID ;
    staff(String usernamexx, String passwordxx, String fullNamexx, String emailxx, int StaffIDxx) {
        super(usernamexx, passwordxx, fullNamexx,emailxx);
        staffID = StaffIDxx;
        

        
    }
    staff(){
        
    }
    
     public void determineUserID(){
        try{
            
          Scanner scanner = new Scanner(new File("staff.txt"));
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
            if (line != "") {
                countStaffuserID++;
            }
}
           }catch(FileNotFoundException ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
     public void AddUser(){
       determineUserID();//generate staff id
        
        if ((AdminCreateUser.txtFullName.getText().equals("") || AdminCreateUser.txtEmail.getText().equals("") || AdminCreateUser.txtUsername.getText().equals("") || AdminCreateUser.txtPassword.getText().equals("") 
                || AdminCreateUser.cmbRole.getSelectedItem().toString().equals("")) ) {
            JOptionPane.showMessageDialog(null, "Please Fill Up All Field!");
            
            
            
        }else{
            if (AdminCreateUser.cmbRole.getSelectedItem().toString().equals("Staff")) {
                determineUserID();
                staff obj1 = new staff(AdminCreateUser.txtFullName.getText(), AdminCreateUser.txtEmail.getText(), AdminCreateUser.txtUsername.getText(), AdminCreateUser.txtPassword.getText(), countStaffuserID);
                try {
            FileWriter fw = new FileWriter("staff.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            
            bw.write(obj1.getfullName()+",");
            bw.write(obj1.getemail()+",");
            bw.write(obj1.getusername()+",");
            bw.write(obj1.getpassword()+",");
            bw.write(obj1.getUserType()+",");
            bw.write("(Staff ID):"+ String.valueOf(obj1.getstaffID()));
            bw.newLine();
            bw.close();
            JOptionPane.showMessageDialog(null, "Data Saved To File Staff.txt");
            
            AdminCreateUser.txtFullName.setText("");
            AdminCreateUser.txtEmail.setText("");
            AdminCreateUser.txtUsername.setText("");
            AdminCreateUser.txtPassword.setText("");

            

        } catch (IOException ex) {
            System.out.println("Unable to create file due to " + ex);
        }
            }
                
            }
            
        }
     
     
       public void verifyCredential(String usernamex, String passwordx, String rolex){
        int credentialFound = 0;
        String record = null;
        FileReader in = null;
        try{
           
                in = new FileReader("staff.txt");
           
                
           
        
        BufferedReader br = new BufferedReader(in);
        
        while((record = br.readLine())!= null){
            // Split line by a . delimiter
            // split[0] <- username
            // split[1] <- password
            String[] split = record.split(",");
            
            if (usernamex.equals(split[0]) && passwordx.equals(split[1])) {
                
                credentialFound = 1;
                CurrentlyLoggedInUserRole = rolex;
                 CurrentlyLoggedInUser = usernamex;
                 
                 
                 ArrayList<String> room = storage("currentlyLoggedInUser.txt");
                String [] sub_room;
                
                for (int i = 0; i < room.size(); i++) {
//                sub_room = room.get(i).split(",");
                 room.set(i,usernamex+","+rolex);
                write_to_file("currentlyLoggedInUser.txt", room);
                
                 
                 
                
                    staffDashboard frame = new staffDashboard();
                    frame.setVisible(true);
                
                break;
            }
            }
           
            
        }
         if (credentialFound != 1) {
                JOptionPane.showMessageDialog(null, "Wrong Credentials!");
            }
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }
       
       
          
      public void verifyOldPassword(String usernamezz, String passwordzz, String rolezz){
        int credentialFound = 0;
        String record = null;
        FileReader in = null;
        
        try{
            
                in = new FileReader("staff.txt");
            
        
        BufferedReader br = new BufferedReader(in);
        
        while((record = br.readLine())!= null){
            // Split line by a . delimiter
            // split[0] <- username
            // split[1] <- password
            String[] split = record.split(",");
            
            if (usernamezz.equals(split[0]) && passwordzz.equals(split[1])) {
                JOptionPane.showMessageDialog(null, "Valid Old Password");
                credentialFound = 1;
                resetpassword.txtifvalidcloseform.setText("true");
                changepassword frame = new changepassword();
                frame.setVisible(true);
                break;
            }
           
            
        }
         if (credentialFound != 1) {
                JOptionPane.showMessageDialog(null, "Invalid Old Password!");
            }
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }
      
      
       
      public  void resetPassword(String usernamezz, String passwordzz, String rolezz){
         int credentialFound = 0;
        String record = null;
        FileReader in = null;
       
             
         
        
        try{
            
            
            
              ArrayList<String> room = storage("staff.txt");
            String [] sub_room;
            
             for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[0].equals(usernamezz)) {
              String fullName = sub_room[2];
              String email = sub_room[3];
              String usertype = sub_room[4];
              String userid = sub_room[5];
                
                
                room.set(i,usernamezz +","+passwordzz+","+fullName +","+email+","+usertype +","+userid);
                write_to_file("staff.txt", room);
                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
                
            }
        
       
           
            
        }
        }catch (Exception ex){
            
        }
         
         
         
        
     }
    
      
      public void saveVerificationCodeandEmail(String email,int OTP){
         ArrayList<String> room = storage("forgotpasswordactivationcode.txt");
                String [] sub_room;
                
                for (int i = 0; i < room.size(); i++) {
//                sub_room = room.get(i).split(",");
                 room.set(i,email+","+OTP);
                write_to_file("forgotpasswordactivationcode.txt", room);
                
         
         
         
     }
                
                
     }
     
           public String verifyOldEmail(String email){
        int credentialFound = 0;
        String record = null;
        FileReader in = null;
      
        
           
               ArrayList<String> room = storage("staff.txt");
                String [] sub_room;
                
                for (int i = 0; i < room.size(); i++) {
                sub_room = room.get(i).split(",");
            
            if (email.equals(sub_room[3])) {
                JOptionPane.showMessageDialog(null, "Valid Existing Email");
                credentialFound = 1;
                
                  
                 
                
//                changepassword frame = new changepassword();
//                frame.setVisible(true);
               
                break;
                
            }
        } 
        
            
        
         if (credentialFound != 1) {
             
             
              ArrayList<String> rooma = storage("admin.txt");
                String [] sub_rooma;
                
                for (int i = 0; i < rooma.size(); i++) {
                sub_rooma = rooma.get(i).split(",");
            
            if (email.equals(sub_rooma[3])) {
                JOptionPane.showMessageDialog(null, "Valid Existing Email");
                credentialFound = 1;
                
                  
                 
                
//                changepassword frame = new changepassword();
//                frame.setVisible(true);
               
                break;
                
            }
        } 
        }
            
         
         
            
         if (credentialFound != 1) {
             
                JOptionPane.showMessageDialog(null, "Account with this email not found!");
                return "NotFound";
            }else{
             return "Found";
         }
                
            

    }

           
             public  void UpdateForgotPassword(String emailtt,String passwordtt){
          //reset user password is user typed in correct verification code
         int credentialFound = 0;
        String record = null;
        FileReader in = null;
        String staff = "Staff";
        boolean doneUpdateNewPassword = false;

        
        try{
   
              ArrayList<String> room = storage("staff.txt");
            String [] sub_room;
            
             for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[3].equals(emailtt)) {
              String fullName = sub_room[2];
              String username = sub_room[0];
              String usertype = sub_room[4];
              String userid = sub_room[5];
                
                
                room.set(i,username +","+passwordtt+","+fullName +","+emailtt+","+usertype +","+userid);
                write_to_file("staff.txt", room);
                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
                doneUpdateNewPassword = true;
                
            }
        
       
           
            
        }
        }catch (Exception ex){
            
        }
        
          if (doneUpdateNewPassword == false) {
               try{
            
            
            
              ArrayList<String> room = storage("admin.txt");
            String [] sub_room;
            
             for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            
                
                
            if (sub_room[3].equals(emailtt)) {
              String fullName = sub_room[2];
              String username = sub_room[0];
              String usertype = sub_room[4];
              String userid = sub_room[5];
                
                
                room.set(i,username +","+passwordtt+","+fullName +","+emailtt+","+usertype +","+userid);
                 write_to_file("admin.txt", room);
                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
                
            }
        
       
           
            
        }
        }catch (Exception ex){
            
        }
         
          }
        
             }
        
    
    
   public void UpdateStaff( int staffId, String staffName, String staffUsername, String staffPassword, String staffEmail){
//the roomid passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String staffIdString = String.valueOf(staffId);
    
    ArrayList<String> staff = storage("staff.txt");
        String [] sub_staff;
        for (int i = 0; i < staff.size(); i++) {
            sub_staff = staff.get(i).split(",");
            
            String staffidfromfile = sub_staff[5];
            int staffidfromfileLength = staffidfromfile.length();
            String staffidfromfileComplete = staffidfromfile.substring(11,staffidfromfileLength);
            
            
            if (staffidfromfileComplete.equals(staffIdString)) {
                staff.set(i,staffUsername +","+staffPassword+","+staffName+","+staffEmail+",Staff,(Staff ID):"+staffId);
                write_to_file("staff.txt", staff);
                JOptionPane.showMessageDialog(null, "Staff Updated!");
                
            }
        } 
  }
          
               
               
     public void SerchStaff(){
          if (manageStaff.txtSearchStaff.getText().equals("") ) {
                DefaultTableModel model = (DefaultTableModel)jTableManageStaff.getModel();
        model.setRowCount(0);
        String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\staff.txt";
        File file = new File(filePath);
       jTableManageStaff.setRowHeight(30);
        jTableManageStaff.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            Object[] tableLines = br.lines().toArray();
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                
                
                
                
                String[] dataRow = line.split(",");
                
                    String[] tablerow ;
                    tablerow = new String[10];
                
                
                String email = dataRow[3];
                 tablerow[4] = email;
                
                
                String Password = dataRow[1];
                tablerow[3] = Password;
                
                
                 String Username = dataRow[0];
                  tablerow[2] = Username;
                
                
                 
                
                String staffId = dataRow[5];
                int staffIdLength = staffId.length();
                String staffIdComplete = staffId.substring(11,staffIdLength);
                tablerow[0] = staffIdComplete;
                
                
                String staffName = dataRow[2];
                 tablerow[1] = staffName;
                
               
                model.addRow(tablerow);
            
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
            
        }else{
            String SearchedStaffName = manageStaff.txtSearchStaff.getText();
            
            String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\staff.txt";
        File file = new File(filePath);
        manageStaff.jTableManageStaff.setRowHeight(30);
         manageStaff.jTableManageStaff.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)manageStaff.jTableManageStaff.getModel();
            Object[] tableLines = br.lines().toArray();
            model.setRowCount(0);
            for (int i = 0; i < tableLines.length; i++) {
                
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
           
                String[] dataRow = line.split(",");
                
                    String[] tablerow ;
                    tablerow = new String[10];
                
                
                String email = dataRow[3];
                 tablerow[4] = email;
                
                
                String Password = dataRow[1];
                tablerow[3] = Password;
                
                
                 String Username = dataRow[0];
                  tablerow[2] = Username;
                
                
                 
                
                String staffId = dataRow[5];
                int staffIdLength = staffId.length();
                String staffIdComplete = staffId.substring(11,staffIdLength);
                tablerow[0] = staffIdComplete;
                
                
                String staffName = dataRow[0];
                 tablerow[1] = staffName;
                
               
                
                if (!    ( staffName.contains(SearchedStaffName) || dataRow[1].contains(SearchedStaffName) || dataRow[2].contains(SearchedStaffName)  
                        || dataRow[3].contains(SearchedStaffName) || staffIdComplete.contains(SearchedStaffName) 
                        
                        )   ) {
//                      searchedStaffesultFound = false;
                    
                    
                } else {
                    //to clear the the content first, else it will add up the room u serach for, which cause duplication
                    
                    
//                    searchedStaffesultFound = true;
                    
                    
                    
                    
                    model.addRow(tablerow);
//                    break;
                }
                
               
                
               
                
            } 
            
             if ( searchedStaffesultFound == false) {
                    JOptionPane.showMessageDialog(null, "Staff Not Found!");
                    manageStaff.txtSearchStaff.setText("");
                    model.setRowCount(0);
                    
         manageStaff.jTableManageStaff.setRowHeight(30);
          manageStaff.jTableManageStaff.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        
            
            
            for (int i = 0; i < tableLines.length; i++) {
               String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                
                
                
                
                String[] dataRow = line.split(",");
                
                    String[] tablerow ;
                    tablerow = new String[10];
                
                
                String email = dataRow[3];
                 tablerow[4] = email;
                
                
                String Password = dataRow[1];
                tablerow[3] = Password;
                
                
                 String Username = dataRow[0];
                  tablerow[2] = Username;
                
                
                 
                
                String staffId = dataRow[5];
                int staffIdLength = staffId.length();
                String staffIdComplete = staffId.substring(11,staffIdLength);
                tablerow[0] = staffIdComplete;
                
                
                String staffName = dataRow[0];
                 tablerow[1] = staffName;
                
               
                model.addRow(tablerow);
            
            
            
            
        } 
                    
                }
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
      }
      
      
           public void DeleteStaff(int deletestaffIdx){
   //the staffid passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String deletestaffIdString = String.valueOf(deletestaffIdx);
    
    ArrayList<String> staff = storage("staff.txt");
        String [] sub_staff;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete This Staff Record?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            for (int i = 0; i < staff.size(); i++) {
            sub_staff = staff.get(i).split(",");
            
            String staffidfromfile = sub_staff[5];
            int staffidfromfileLength = staffidfromfile.length();
            String staffidfromfileComplete = staffidfromfile.substring(11, staffidfromfileLength);
            if (staffidfromfileComplete.equals(deletestaffIdString)) {
                staff.remove(i);
                
                write_to_file("staff.txt", staff);
                JOptionPane.showMessageDialog(null, "Staff Deleted!");
                
            }
        } 
            }
        
  }
    
    public String getUserType(){
        return usertype;
    }
    
    public int getstaffID(){
        return staffID;
    }


}
    
    
    
    
    
    


