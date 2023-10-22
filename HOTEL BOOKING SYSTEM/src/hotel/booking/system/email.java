/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;

import com.email.durgesh.Email;
import javax.swing.JOptionPane;

/**
 *
 * @author qi xian
 */
public class email {
    
    public void sendEmail(String OTP, String userEmail){
    try{
     JOptionPane.showMessageDialog(null,"Sending Verification Code To Your Email...........");
     JOptionPane.showMessageDialog(null,"Please Wait...........");
    Email emel = new Email("hotelreservationsystem88@gmail.com","HudsonodoI35#");
    emel.setFrom("hotelreservationsystem88@gmail.com", "HOTEL MANAGEMENT SYSTEM");
    emel.setSubject("This is your verification code to reset password......");
    emel.setContent("Verification Code:"+ OTP, "text/html");
    emel.addRecipient(userEmail);
    emel.send();
    JOptionPane.showMessageDialog(null,"A Verification Code Has Been Sent To Your Email!");
    
    
    
        }catch(Exception e){
    
        }
    }
    
}
