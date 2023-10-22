/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;




 abstract class user {
    
    protected String username;
    protected String password;
    protected String fullName;
    protected String email;
    protected String CurrentlyLoggedInUser;
    protected String CurrentlyLoggedInUserRole;
   

    user(String usernamex, String passwordx, String fullNamex, String emailx){
        
        username = usernamex;
        password = passwordx;
        fullName = fullNamex;
        email = emailx;

    }
    
    user(){
        
    }

    abstract void determineUserID();
    abstract void AddUser();
    abstract void verifyCredential(String usernamex, String passwordx, String rolex);
    abstract void  verifyOldPassword(String usernamezz, String passwordzz, String rolezz);
    abstract void  resetPassword(String usernamezz, String passwordzz, String rolezz);
    abstract  void saveVerificationCodeandEmail(String email,int OTP);
    abstract String verifyOldEmail(String email);
    abstract void UpdateForgotPassword(String emailtt,String passwordtt);
    
    
//    public void determineStaffID(){
//         
//        try{
//            
//          Scanner scanner = new Scanner(new File("staff.txt"));
//        while (scanner.hasNextLine()) {
//        String line = scanner.nextLine();
//            if (line != "") {
//                countStaffuserID++;
//            }
//}
//           }catch(FileNotFoundException ex ){
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
    
//    public void AddUser(){
//       
//        
//        if ((AdminCreateUser.txtFullName.getText().equals("") || AdminCreateUser.txtEmail.getText().equals("") || AdminCreateUser.txtUsername.getText().equals("") || AdminCreateUser.txtPassword.getText().equals("") 
//                || AdminCreateUser.cmbRole.getSelectedItem().toString().equals("")) ) {
//            JOptionPane.showMessageDialog(null, "Please Fill Up All Field!");
//            
//            
//            
//        }else{
//            if (AdminCreateUser.cmbRole.getSelectedItem().toString().equals("Staff")) {
//                determineStaffID();
//                staff obj1 = new staff(AdminCreateUser.txtFullName.getText(), AdminCreateUser.txtEmail.getText(), AdminCreateUser.txtUsername.getText(), AdminCreateUser.txtPassword.getText(), countStaffuserID);
//                try {
//            FileWriter fw = new FileWriter("staff.txt", true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.newLine();
//            
//            bw.write(obj1.getfullName()+",");
//            bw.write(obj1.getemail()+",");
//            bw.write(obj1.getusername()+",");
//            bw.write(obj1.getpassword()+",");
//            bw.write(obj1.getUserType()+",");
//            bw.write("(Staff ID):"+ String.valueOf(obj1.getstaffID()));
//            bw.newLine();
//            bw.close();
//            JOptionPane.showMessageDialog(null, "Data Saved To File Staff.txt");
//            
//            AdminCreateUser.txtFullName.setText("");
//            AdminCreateUser.txtEmail.setText("");
//            AdminCreateUser.txtUsername.setText("");
//            AdminCreateUser.txtPassword.setText("");
//
//            
//
//        } catch (IOException ex) {
//            System.out.println("Unable to create file due to " + ex);
//        }
//            }else{
//                determineAdminID();
//                
//                
//                
//                admin obj1 = new admin(AdminCreateUser.txtFullName.getText(), AdminCreateUser.txtEmail.getText(), AdminCreateUser.txtUsername.getText(), AdminCreateUser.txtPassword.getText(), countAdminuserID);
//                try {
//            FileWriter fw = new FileWriter("admin.txt", true);
//            BufferedWriter bw = new BufferedWriter(fw);
//           bw.newLine();
//            
//            bw.write(obj1.getfullName()+",");
//            bw.write(obj1.getemail()+",");
//            bw.write(obj1.getusername()+",");
//            bw.write(obj1.getpassword()+",");
//            bw.write(obj1.getUserType()+",");
//            bw.write("(Admin ID):" + String.valueOf(obj1.getadminID()));
//            
//            bw.close();
//            System.out.println("Date written to the file");
//            JOptionPane.showMessageDialog(null, "Data Saved To File Admin.txt");
//            AdminCreateUser.txtFullName.setText("");
//            AdminCreateUser.txtEmail.setText("");
//            AdminCreateUser.txtUsername.setText("");
//            AdminCreateUser.txtPassword.setText("");
//
//           
//            
//        } catch (IOException ex) {
//            System.out.println("Unable to create file due to " + ex);
//        }
//                
//            }
//            
//        }
//        
//    }
//    
  
//     public void verifyCredential(String usernamex, String passwordx, String rolex){
//        int credentialFound = 0;
//        String record = null;
//        FileReader in = null;
//        try{
//            if (rolex == "Staff") {
//                in = new FileReader("staff.txt");
//            } else{
//                in = new FileReader("admin.txt");
//            }
//        
//        BufferedReader br = new BufferedReader(in);
//        
//        while((record = br.readLine())!= null){
//            // Split line by a . delimiter
//            // split[0] <- username
//            // split[1] <- password
//            String[] split = record.split(",");
//            
//            if (usernamex.equals(split[0]) && passwordx.equals(split[1])) {
//                JOptionPane.showMessageDialog(null, "Valid Credentials!");
//                credentialFound = 1;
//                CurrentlyLoggedInUserRole = rolex;
//                 CurrentlyLoggedInUser = usernamex;
//                 
//                 
//                 ArrayList<String> room = storage("currentlyLoggedInUser.txt");
//                String [] sub_room;
//                
//                for (int i = 0; i < room.size(); i++) {
////                sub_room = room.get(i).split(",");
//                 room.set(i,usernamex+","+rolex);
//                write_to_file("currentlyLoggedInUser.txt", room);
//                
//                 
//                 
//                 if (rolex == "Staff") {
//                    staffDashboard frame = new staffDashboard();
//                    frame.setVisible(true);
//                }else{
//                     newAdminDashboard frame = new newAdminDashboard();
//                    frame.setVisible(true);
//                 }
//                break;
//            }
//            }
//           
//            
//        }
//         if (credentialFound != 1) {
//                JOptionPane.showMessageDialog(null, "Wrong Credentials!");
//            }
//        } catch(IOException ex){
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        
//        
//    }
     
     
//     public void verifyOldPassword(String usernamezz, String passwordzz, String rolezz){
//        int credentialFound = 0;
//        String record = null;
//        FileReader in = null;
//        String staff = "Staff";
//        try{
//            if (rolezz.equals(staff)) {
//                in = new FileReader("staff.txt");
//            } else{
//                in = new FileReader("admin.txt");
//            }
//        
//        BufferedReader br = new BufferedReader(in);
//        
//        while((record = br.readLine())!= null){
//            // Split line by a . delimiter
//            // split[0] <- username
//            // split[1] <- password
//            String[] split = record.split(",");
//            
//            if (usernamezz.equals(split[0]) && passwordzz.equals(split[1])) {
//                JOptionPane.showMessageDialog(null, "Valid Old Password");
//                credentialFound = 1;
//                resetpassword.txtifvalidcloseform.setText("true");
//                changepassword frame = new changepassword();
//                frame.setVisible(true);
//                break;
//            }
//           
//            
//        }
//         if (credentialFound != 1) {
//                JOptionPane.showMessageDialog(null, "Invalid Old Password!");
//            }
//        } catch(IOException ex){
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        
//        
//    }
     
     
//     public void saveVerificationCodeandEmail(String email,int OTP){
//         ArrayList<String> room = storage("forgotpasswordactivationcode.txt");
//                String [] sub_room;
//                
//                for (int i = 0; i < room.size(); i++) {
////                sub_room = room.get(i).split(",");
//                 room.set(i,email+","+OTP);
//                write_to_file("forgotpasswordactivationcode.txt", room);
//                
//         
//         
//         
//     }
//                
//                
//     }
//     
     
//     public String verifyOldEmail(String email){
//        int credentialFound = 0;
//        String record = null;
//        FileReader in = null;
//      
//        
//           
//               ArrayList<String> room = storage("staff.txt");
//                String [] sub_room;
//                
//                for (int i = 0; i < room.size(); i++) {
//                sub_room = room.get(i).split(",");
//            
//            if (email.equals(sub_room[3])) {
//                JOptionPane.showMessageDialog(null, "Valid Existing Email");
//                credentialFound = 1;
//                
//                  
//                 
//                
////                changepassword frame = new changepassword();
////                frame.setVisible(true);
//               
//                break;
//                
//            }
//        } 
//        
//            
//        
//         if (credentialFound != 1) {
//             
//             
//              ArrayList<String> rooma = storage("admin.txt");
//                String [] sub_rooma;
//                
//                for (int i = 0; i < rooma.size(); i++) {
//                sub_rooma = rooma.get(i).split(",");
//            
//            if (email.equals(sub_rooma[3])) {
//                JOptionPane.showMessageDialog(null, "Valid Existing Email");
//                credentialFound = 1;
//                
//                  
//                 
//                
////                changepassword frame = new changepassword();
////                frame.setVisible(true);
//               
//                break;
//                
//            }
//        } 
//        }
//            
//         
//         
//            
//         if (credentialFound != 1) {
//             
//                JOptionPane.showMessageDialog(null, "Account with this email not found!");
//                return "NotFound";
//            }else{
//             return "Found";
//         }
//                
//            
//
//    }

        
       
        
        
   
     
//     public  void resetPassword(String usernamezz, String passwordzz, String rolezz){
//         int credentialFound = 0;
//        String record = null;
//        FileReader in = null;
//        String staff = "Staff";
//        
//         if (rolezz.equals(staff)) {
//             
//         
//        
//        try{
//            
//            
//            
//              ArrayList<String> room = storage("staff.txt");
//            String [] sub_room;
//            
//             for (int i = 0; i < room.size(); i++) {
//            sub_room = room.get(i).split(",");
//            
//                
//                
//            if (sub_room[0].equals(usernamezz)) {
//              String fullName = sub_room[2];
//              String email = sub_room[3];
//              String usertype = sub_room[4];
//              String userid = sub_room[5];
//                
//                
//                room.set(i,usernamezz +","+passwordzz+","+fullName +","+email+","+usertype +","+userid);
//                write_to_file("staff.txt", room);
//                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
//                
//            }
//        
//       
//           
//            
//        }
//        }catch (Exception ex){
//            
//        }
//         }else{
//             
//              try{
//            
//            
//            
//              ArrayList<String> room = storage("admin.txt");
//            String [] sub_room;
//            
//             for (int i = 0; i < room.size(); i++) {
//            sub_room = room.get(i).split(",");
//            
//                
//                
//            if (sub_room[0].equals(usernamezz)) {
//              String fullName = sub_room[2];
//              String email = sub_room[3];
//              String usertype = sub_room[4];
//              String userid = sub_room[5];
//                
//                
//                room.set(i,usernamezz +","+passwordzz+","+fullName +","+email+","+usertype +","+userid);
//                write_to_file("admin.txt", room);
//                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
//                
//            }
//        
//       
//           
//            
//        }
//        }catch (Exception ex){
//            
//        }
//         }
//         
//        
//     }
//     
     
//      public  void UpdateForgotPassword(String emailtt,String passwordtt){
//          //reset user password is user typed in correct verification code
//         int credentialFound = 0;
//        String record = null;
//        FileReader in = null;
//        String staff = "Staff";
//        boolean doneUpdateNewPassword = false;
//        
//         
//             
//         
//        
//        try{
//            
//           
//            
//              ArrayList<String> room = storage("staff.txt");
//            String [] sub_room;
//            
//             for (int i = 0; i < room.size(); i++) {
//            sub_room = room.get(i).split(",");
//            
//                
//                
//            if (sub_room[3].equals(emailtt)) {
//              String fullName = sub_room[2];
//              String username = sub_room[0];
//              String usertype = sub_room[4];
//              String userid = sub_room[5];
//                
//                
//                room.set(i,username +","+passwordtt+","+fullName +","+emailtt+","+usertype +","+userid);
//                write_to_file("staff.txt", room);
//                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
//                doneUpdateNewPassword = true;
//                
//            }
//        
//       
//           
//            
//        }
//        }catch (Exception ex){
//            
//        }
//        
//          if (doneUpdateNewPassword == false) {
//               try{
//            
//            
//            
//              ArrayList<String> room = storage("admin.txt");
//            String [] sub_room;
//            
//             for (int i = 0; i < room.size(); i++) {
//            sub_room = room.get(i).split(",");
//            
//                
//                
//            if (sub_room[3].equals(emailtt)) {
//              String fullName = sub_room[2];
//              String username = sub_room[0];
//              String usertype = sub_room[4];
//              String userid = sub_room[5];
//                
//                
//                room.set(i,username +","+passwordtt+","+fullName +","+emailtt+","+usertype +","+userid);
//                 write_to_file("admin.txt", room);
//                JOptionPane.showMessageDialog(null, "Password sucessfully Reset!");
//                
//            }
//        
//       
//           
//            
//        }
//        }catch (Exception ex){
//            
//        }
//         
//          }
//        
//        
         
             
             
         
        
     
     
    public void setusername(String usernamexx){
        username = usernamexx;
 }

    public void setpassword(String passwordxx){
        password = passwordxx;
    }
    
    public void setfullName(String fullNamexx){
        fullName = fullNamexx;
    }
    
    public void setemail(String emailxx){
        email = emailxx;
    }
    
    public String getusername(){
        return username;
    }
    
    public String getpassword(){
        return password;
    }
    
    public String getfullName(){
        return fullName;
    }
    
    public String getemail(){
        return email;
    }
    
    


     
   




}


