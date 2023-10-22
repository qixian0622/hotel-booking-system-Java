
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author qi xian
 */
public class payment extends booking{
    
    
    private double roomCharges;
    private double serviceTax;
    private double tourismTax;
    private double totalcharges;
   
    private double totalChange;
    
    //for save paymentrecord method
    private int countPaymentID = 1;
    private boolean found = false;
    
    private boolean searchedPaymentRecordresultFound = false;
    
    //pass the durationxxx to the consturctor of parent class booking
    payment(int durationxxx){
        super(durationxxx);
    }
    
    public double CalculateTotalChange(double totalPaymentx, double totalchargesxx){
        if (totalPaymentx == totalchargesxx) {
            totalChange = 0;
        }else {
            totalChange = totalPaymentx  - totalchargesxx ; 
            DecimalFormat df = new DecimalFormat("0.00");
            String totalChangestring = df.format(totalChange);
            totalChange = Double.parseDouble(totalChangestring);
        }
        return totalChange;
    }
    
    public void SavePaymentRecord(String customerNamexx, String emailxx, double roomchargesxx, double servicetaxxx, double tourismtaxx, double totalchargesxx, double totalpaymentxx, double changexx, int bookingid){
        
           
    customerName = customerNamexx;
    
    email = emailxx;
    roomCharges = roomchargesxx;
     serviceTax = servicetaxxx;
    tourismTax = tourismtaxx;
    totalcharges = totalchargesxx;
    totalChange = changexx;
    
    
    
     
        determinePaymentID();
        
        try {
            FileWriter fw = new FileWriter("payment.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
           
            bw.write("(Payment Id):" +countPaymentID+",");
            bw.write(customerName+",");
            
            bw.write(email +",");
            
            bw.write("(Room Charges):" +roomCharges+",");
            bw.write("(Service Tax):" +serviceTax+",");
            bw.write("(Tourism Tax):" +tourismTax+",");
            bw.write("(Total Charges):" +totalcharges+",");
            bw.write("(Total Payment):" +totalpaymentxx+",");
            bw.write("(Total Change):" +totalChange);
             bw.write("," +bookingid);
            bw.newLine();
            bw.close();
//            JOptionPane.showMessageDialog(null, "Data Saved To File payment.txt");
            
            
             } catch (IOException ex) {
            System.out.println("Unable to create file due to " + ex);
        
    }
    
}
    
    
  
      public void determinePaymentID(){
         
        try{
            
          Scanner scanner = new Scanner(new File("payment.txt"));
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
            if (line != "") {
                countPaymentID++;
            }
}
           }catch(FileNotFoundException ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
 
 
 public void DeletePaymentRecord(int deletedpaymentidx){
    
    
    //the booking passed form the jtable is in int form, gotta change it to string form in order to allow comparison to occur below in the loop
    String paymentIdString = String.valueOf(deletedpaymentidx);
    
    ArrayList<String> payment = storage("payment.txt");
        String [] sub_room;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete This payment Record?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            for (int i = 0; i < payment.size(); i++) {
            sub_room = payment.get(i).split(",");
            String paymentIdfromfile = sub_room[0];
            int paymentIdfromfilelength = paymentIdfromfile.length();
            sub_room[0] = paymentIdfromfile.substring(13,paymentIdfromfilelength);
            if (sub_room[0].equals(paymentIdString)) {
                payment.remove(i);
                
                write_to_file("payment.txt", payment);
                JOptionPane.showMessageDialog(null, "Payment Record Deleted!");
                
            }
        } 
            }
        
  }
 
 
 
 public void SerchPaymentRecord(){
          if (managePaymentRecord.txtserachPaymentRecord.getText().equals("") ) {
             String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\payment.txt";
        File file = new File(filePath);
        managePaymentRecord.JTableManagePaymentRecord.setRowHeight(30);
         managePaymentRecord.JTableManagePaymentRecord.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)managePaymentRecord.JTableManagePaymentRecord.getModel();
            Object[] tableLines = br.lines().toArray();
            model.setRowCount(0);
            for (int i = 0; i < tableLines.length; i++) {
                
                String line = tableLines[i].toString().trim();
                
                String[] dataRow = line.split(",");
                
                 String paymentId = dataRow[0];
                int paymentIdLength = paymentId.length();
                String paymentIdComplete = paymentId.substring(13,paymentIdLength);
                dataRow[0] = paymentIdComplete;
                
                
                
                
                String roomChargeszz = dataRow[3];
                int roomChargesLength = roomChargeszz.length();
                String roomChargesComplete = roomChargeszz.substring(15,roomChargesLength);
                dataRow[3] = roomChargesComplete;
                
                String serviceTaxzz = dataRow[4];
                int serviceTaxLength = serviceTaxzz.length();
                String serviceTaxComplete = serviceTaxzz.substring(14,serviceTaxLength);
                dataRow[4] = serviceTaxComplete;
                
                String tourismTaxzz = dataRow[5];
                int tourismTaxLength = tourismTaxzz.length();
                String tourismTaxComplete = tourismTaxzz.substring(14,tourismTaxLength);
                dataRow[5] = tourismTaxComplete;
                
                String totalCharges = dataRow[6];
                int totalChargesLength = totalCharges.length();
                String totalChargesComplete = totalCharges.substring(16,totalChargesLength);
                dataRow[6] = totalChargesComplete;
                
                String totalPayment = dataRow[7];
                int totalPaymentLength = totalPayment.length();
                String totalPaymentComplete = totalPayment.substring(16,totalPaymentLength);
                dataRow[7] = totalPaymentComplete;
                
                String totalChangezz = dataRow[8];
                int totalChangeLength = totalChangezz.length();
                String totalChangeComplete = totalChangezz.substring(15,totalChangeLength);
                dataRow[8] = totalChangeComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
            
        }else{
            String SearchedPaymentId = managePaymentRecord.txtserachPaymentRecord.getText();
            
            String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\payment.txt";
        File file = new File(filePath);
        managePaymentRecord.JTableManagePaymentRecord.setRowHeight(30);
        managePaymentRecord.JTableManagePaymentRecord.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) managePaymentRecord.JTableManagePaymentRecord.getModel();
            Object[] tableLines = br.lines().toArray();
            
            for (int i = 0; i < tableLines.length; i++) {
                
                
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                String paymentid = dataRow[0];
                
                String paymentidComplete = paymentid.substring(13,index1);
                if (!paymentidComplete.equals(SearchedPaymentId)) {
                      searchedPaymentRecordresultFound = false;
                    
                    
                } else {
                    //to clear the the content first, else it will add up the room u serach for, which cause duplication
                    model.setRowCount(0);
                    
                    searchedPaymentRecordresultFound = true;
                    
                
                 String paymentId = dataRow[0];
                int paymentIdLength = paymentId.length();
                String paymentIdComplete = paymentId.substring(13,paymentIdLength);
                dataRow[0] = paymentIdComplete;
                
                
                
                
                String roomChargeszz = dataRow[3];
                int roomChargesLength = roomChargeszz.length();
                String roomChargesComplete = roomChargeszz.substring(15,roomChargesLength);
                dataRow[3] = roomChargesComplete;
                
                String serviceTaxzz = dataRow[4];
                int serviceTaxLength = serviceTaxzz.length();
                String serviceTaxComplete = serviceTaxzz.substring(14,serviceTaxLength);
                dataRow[4] = serviceTaxComplete;
                
                String tourismTaxzz = dataRow[5];
                int tourismTaxLength = tourismTaxzz.length();
                String tourismTaxComplete = tourismTaxzz.substring(14,tourismTaxLength);
                dataRow[5] = tourismTaxComplete;
                
                String totalCharges = dataRow[6];
                int totalChargesLength = totalCharges.length();
                String totalChargesComplete = totalCharges.substring(16,totalChargesLength);
                dataRow[6] = totalChargesComplete;
                
                String totalPayment = dataRow[7];
                int totalPaymentLength = totalPayment.length();
                String totalPaymentComplete = totalPayment.substring(16,totalPaymentLength);
                dataRow[7] = totalPaymentComplete;
                
                String totalChangezz = dataRow[8];
                int totalChangeLength = totalChangezz.length();
                String totalChangeComplete = totalChangezz.substring(15,totalChangeLength);
                dataRow[8] = totalChangeComplete;
                
               
                model.addRow(dataRow);
                    break;
                }
                
               
                
               
                
            } 
            
             if ( searchedPaymentRecordresultFound == false) {
                    JOptionPane.showMessageDialog(null, "Payment Record Not Found!");
                    managePaymentRecord.txtserachPaymentRecord.setText("");
                    model.setRowCount(0);
                    
        managePaymentRecord.JTableManagePaymentRecord.setRowHeight(30);
         managePaymentRecord.JTableManagePaymentRecord.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        
            
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                
                String[] dataRow = line.split(",");
                 
                
                String paymentId = dataRow[0];
                int paymentIdLength = paymentId.length();
                String paymentIdComplete = paymentId.substring(13,paymentIdLength);
                dataRow[0] = paymentIdComplete;
                
                
                
                
                String roomChargeszz = dataRow[3];
                int roomChargesLength = roomChargeszz.length();
                String roomChargesComplete = roomChargeszz.substring(15,roomChargesLength);
                dataRow[3] = roomChargesComplete;
                
                String serviceTaxzz = dataRow[4];
                int serviceTaxLength = serviceTaxzz.length();
                String serviceTaxComplete = serviceTaxzz.substring(14,serviceTaxLength);
                dataRow[4] = serviceTaxComplete;
                
                String tourismTaxzz = dataRow[5];
                int tourismTaxLength = tourismTaxzz.length();
                String tourismTaxComplete = tourismTaxzz.substring(14,tourismTaxLength);
                dataRow[5] = tourismTaxComplete;
                
                String totalCharges = dataRow[6];
                int totalChargesLength = totalCharges.length();
                String totalChargesComplete = totalCharges.substring(16,totalChargesLength);
                dataRow[6] = totalChargesComplete;
                
                String totalPayment = dataRow[7];
                int totalPaymentLength = totalPayment.length();
                String totalPaymentComplete = totalPayment.substring(16,totalPaymentLength);
                dataRow[7] = totalPaymentComplete;
                
                String totalChangezz = dataRow[8];
                int totalChangeLength = totalChangezz.length();
                String totalChangeComplete = totalChangezz.substring(15,totalChangeLength);
                dataRow[8] = totalChangeComplete;
                
               
                model.addRow(dataRow);
                
               
               
            
            
            
            
        } 
                    
                }
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }
      } 
 
    //variable duration inherited from parent class booking
    public double CalculateRoomCharges(){
        roomCharges = (duration * 350);
        return roomCharges;
    }
    
   
    public double CalculateServiceTax(){
        serviceTax = (roomCharges * 0.1);
        return serviceTax;
    }
    
    public double CalculateTourismTax(){
        tourismTax = (10 * duration);
        return tourismTax;
        
    }
    
    public double CalculateTotalCharges(){
       totalcharges = (roomCharges + serviceTax + tourismTax);
       return totalcharges;
    }
    
    
      
      
      
    
    
}

