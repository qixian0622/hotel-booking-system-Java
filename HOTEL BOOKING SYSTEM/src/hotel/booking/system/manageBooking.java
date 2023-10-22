/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;
import static hotel.booking.system.StaffManageRoom.jTableManageRoom;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;

import java.util.*;

/**
 *
 * @author qi xian
 */
public class manageBooking extends javax.swing.JFrame {
    boolean disablebutton = false;
    DefaultTableModel dm;
    /**
     * Creates new form manageBooking
     */
    public manageBooking() {
        initComponents();
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAddRoom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableManageBooking = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearchBookingRecord = new javax.swing.JTextField();
        btnSearchRoom = new javax.swing.JButton();
        btnchangeroombookingday = new javax.swing.JButton();
        btncheckout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 181, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblAddRoom.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        lblAddRoom.setForeground(new java.awt.Color(0, 182, 204));
        lblAddRoom.setText("Manage Booking");
        lblAddRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 181, 204));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jTableManageBooking.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTableManageBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking Id", "Customer Name", "IC / Passport", "Contact No", "Email", "Room", "Duration (Days)", "Check In", "Check Out", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableManageBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableManageBookingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableManageBooking);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 182, 204));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 182, 204));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtSearchBookingRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchBookingRecordActionPerformed(evt);
            }
        });

        btnSearchRoom.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchRoom.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnSearchRoom.setForeground(new java.awt.Color(0, 182, 204));
        btnSearchRoom.setText("Search");
        btnSearchRoom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btnSearchRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSearchRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchRoomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchRoomMouseExited(evt);
            }
        });
        btnSearchRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRoomActionPerformed(evt);
            }
        });

        btnchangeroombookingday.setBackground(new java.awt.Color(255, 255, 255));
        btnchangeroombookingday.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnchangeroombookingday.setForeground(new java.awt.Color(0, 182, 204));
        btnchangeroombookingday.setText("Change Room / Booking day");
        btnchangeroombookingday.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btnchangeroombookingday.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnchangeroombookingday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnchangeroombookingdayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnchangeroombookingdayMouseExited(evt);
            }
        });
        btnchangeroombookingday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeroombookingdayActionPerformed(evt);
            }
        });

        btncheckout.setBackground(new java.awt.Color(255, 255, 255));
        btncheckout.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btncheckout.setForeground(new java.awt.Color(0, 182, 204));
        btncheckout.setText("Check Out");
        btncheckout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btncheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncheckoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncheckoutMouseExited(evt);
            }
        });
        btncheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(628, Short.MAX_VALUE)
                .addComponent(lblAddRoom)
                .addGap(269, 269, 269)
                .addComponent(txtSearchBookingRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnchangeroombookingday, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(btncheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchRoom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAddRoom)
                        .addComponent(jLabel1)
                        .addComponent(txtSearchBookingRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnchangeroombookingday, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btncheckout, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 140, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        
            btnDelete.setBackground(Color.cyan);
        btnDelete.setForeground(Color.white);
        
        
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        
        btnDelete.setBackground(new Color(255,255,255));
        btnDelete.setForeground(new Color(0,182,204));
        
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
        int selectedRowIndex = jTableManageBooking.getSelectedRow();
        if (selectedRowIndex >= 0) {
            
        
        String duration = (model.getValueAt(selectedRowIndex, 6).toString());
        int durationint = Integer.parseInt(duration);
        
        
        
        
        String bookingIDToDeleteFrom = (model.getValueAt(selectedRowIndex, 0).toString());
        
        
        int bookingIDToDeleteFromint = Integer.parseInt(bookingIDToDeleteFrom);
        
         //for checkout
        String oldcheckinday = model.getValueAt(selectedRowIndex, 7).toString();
        String oldduration = model.getValueAt(selectedRowIndex, 6).toString();
        int olddurationint = Integer.parseInt(oldduration);
        
        String oldselectedRoom = model.getValueAt(selectedRowIndex, 5).toString();
        String [] oldselected_room_data = oldselectedRoom.split(";");
        
        String oldfloorLevel = oldselected_room_data[2];
        int oldfloorLevellengthh = oldfloorLevel.length();
        String oldfloorLevelCompleted = oldfloorLevel.substring(12,oldfloorLevellengthh-1);
        int oldfloorlevleintt = Integer.parseInt(oldfloorLevelCompleted);
        
        String oldroomnumberqqq = oldselected_room_data[0];
        int oldroomnumberqqqlengthh = oldroomnumberqqq.length();
        String oldroomnumberqqqCompleted = oldroomnumberqqq.substring(9, oldroomnumberqqqlengthh-1);
        int oldroomnumberqqqint = Integer.parseInt(oldroomnumberqqqCompleted);
        
        String oldroomtypezz = oldselected_room_data[1];
        int oldroomtypezzlength = oldroomtypezz.length();
        String oldroomTypezzCompleted = oldroomtypezz.substring(7,oldroomtypezzlength-1);
        
        
        String oldroomiddddd = oldselected_room_data[3];
        int oldroomidddddLength = oldroomiddddd.length();
        String oldroomidddddCompleted = oldroomiddddd.substring(5,oldroomidddddLength);
        
        

        payment obj = new payment(durationint );
        
        
        obj.CheckeOut(oldcheckinday, olddurationint, oldroomidddddCompleted , oldroomnumberqqqint,  oldroomTypezzCompleted, oldfloorlevleintt);
         
        obj.DeleteBookingRecord(bookingIDToDeleteFromint);
        
           
        //refresh jtable
        model.setRowCount(0);
        String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\booking.txt";
        File file = new File(filePath);
        jTableManageBooking.setRowHeight(30);
         jTableManageBooking.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            Object[] tableLines = br.lines().toArray();
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                
                String bookingId = dataRow[0];
                int bookingIdLength = bookingId.length();
                String bookingIdComplete = bookingId.substring(13,bookingIdLength);
                dataRow[0] = bookingIdComplete;
                
                
                
                
                String durationkk = dataRow[6];
                int durationkkLength = durationkk.length();
                String durationkkComplete = durationkk.substring(11,durationkkLength);
                dataRow[6] = durationkkComplete;
                
                String checkindaykk = dataRow[7];
                int checkindaykkLength = checkindaykk.length();
                String checkindaykkComplete = checkindaykk.substring(15,checkindaykkLength);
                dataRow[7] = checkindaykkComplete;
                
                String checkoutdaykk = dataRow[8];
                int checkoutdaykkLength = checkoutdaykk.length();
                String checkoutdaykkComplete = checkoutdaykk.substring(16,checkoutdaykkLength);
                dataRow[8] = checkoutdaykkComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row!");
        
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchBookingRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBookingRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchBookingRecordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\booking.txt";
        File file = new File(filePath);
        jTableManageBooking.setRowHeight(30);
         jTableManageBooking.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
            Object[] tableLines = br.lines().toArray();
            
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
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
        int selectedRowIndex = jTableManageBooking.getSelectedRow();

        if (selectedRowIndex >= 0) {
            
        
        //passing value form staffManageroom.java to all textbox and combob
        staffUpdateBooking transfer = new staffUpdateBooking();
        staffUpdateBooking.txtBookingId.setText(model.getValueAt(selectedRowIndex, 0).toString());
        staffUpdateBooking.txtCustomerName.setText(model.getValueAt(selectedRowIndex, 1).toString());
        staffUpdateBooking.txtIcPassport.setText(model.getValueAt(selectedRowIndex, 2).toString());
        staffUpdateBooking.txtContactNumber.setText(model.getValueAt(selectedRowIndex, 3).toString());
        staffUpdateBooking.txtContactNumber.setText(model.getValueAt(selectedRowIndex, 3).toString());
        staffUpdateBooking.txtEmail.setText(model.getValueAt(selectedRowIndex, 4).toString());


        transfer.setVisible(true);
        
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row!");
        
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        
        btnUpdate.setBackground(new Color(255,255,255));
        btnUpdate.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
       
            
        
        btnUpdate.setBackground(Color.cyan);
        btnUpdate.setForeground(Color.white);
       
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnchangeroombookingdayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchangeroombookingdayMouseEntered
         btnchangeroombookingday.setBackground(Color.cyan);
        btnchangeroombookingday.setForeground(Color.white);
    }//GEN-LAST:event_btnchangeroombookingdayMouseEntered

    private void btnchangeroombookingdayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchangeroombookingdayMouseExited
       btnchangeroombookingday.setBackground(new Color(255,255,255));
        btnchangeroombookingday.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnchangeroombookingdayMouseExited

    private void btnchangeroombookingdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeroombookingdayActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
        int selectedRowIndex = jTableManageBooking.getSelectedRow();

        if (selectedRowIndex >= 0) {
            
        
        //passing value form staffManageroom.java to all textbox and combob
        staffupdatebookingChangeDayRoom transfer = new staffupdatebookingChangeDayRoom();
        
                
                String duration = model.getValueAt(selectedRowIndex, 6).toString();
                 int durationInt = Integer.parseInt(duration);
                 
        for (int i = 0; i < staffupdatebookingChangeDayRoom.cmbDuration.getItemCount(); i++) {
            if (staffupdatebookingChangeDayRoom.cmbDuration.getItemAt(i).toString().equalsIgnoreCase(duration)) {
                staffupdatebookingChangeDayRoom.cmbDuration.setSelectedIndex(i);
            }
        }
                
        
                String checkinday = model.getValueAt(selectedRowIndex, 7).toString();
                for (int i = 0; i < staffupdatebookingChangeDayRoom.cmbSelectedDAy.getItemCount(); i++) {
            if (staffupdatebookingChangeDayRoom.cmbSelectedDAy.getItemAt(i).toString().equalsIgnoreCase(checkinday)) {
                staffupdatebookingChangeDayRoom.cmbSelectedDAy.setSelectedIndex(i);
            }
        }
                
                 //for checkout
        String oldcheckinday = model.getValueAt(selectedRowIndex, 7).toString();
        String oldduration = model.getValueAt(selectedRowIndex, 6).toString();
        int olddurationint = Integer.parseInt(oldduration);
        
        String oldselectedRoom = model.getValueAt(selectedRowIndex, 5).toString();
        String [] oldselected_room_data = oldselectedRoom.split(";");
        
        String oldfloorLevel = oldselected_room_data[2];
        int oldfloorLevellengthh = oldfloorLevel.length();
        String oldfloorLevelCompleted = oldfloorLevel.substring(12,oldfloorLevellengthh-1);
        int oldfloorlevleintt = Integer.parseInt(oldfloorLevelCompleted);
        
        String oldroomnumberqqq = oldselected_room_data[0];
        int oldroomnumberqqqlengthh = oldroomnumberqqq.length();
        String oldroomnumberqqqCompleted = oldroomnumberqqq.substring(9, oldroomnumberqqqlengthh-1);
        int oldroomnumberqqqint = Integer.parseInt(oldroomnumberqqqCompleted);
        
        String oldroomtypezz = oldselected_room_data[1];
        int oldroomtypezzlength = oldroomtypezz.length();
        String oldroomTypezzCompleted = oldroomtypezz.substring(7,oldroomtypezzlength-1);
        
        
        String oldroomiddddd = oldselected_room_data[3];
        int oldroomidddddLength = oldroomiddddd.length();
        String oldroomidddddCompleted = oldroomiddddd.substring(5,oldroomidddddLength);
        
        //
        payment obj = new payment(durationInt);
                
        
               obj.CheckeOut(oldcheckinday, olddurationint, oldroomidddddCompleted , oldroomnumberqqqint,  oldroomTypezzCompleted, oldfloorlevleintt);
         
               
               
               
               
               

        transfer.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row!");
        
        }
        
    }//GEN-LAST:event_btnchangeroombookingdayActionPerformed

    private void btncheckoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncheckoutMouseEntered
         btncheckout.setBackground(Color.cyan);
         btncheckout.setForeground(Color.white);
    }//GEN-LAST:event_btncheckoutMouseEntered

    private void btncheckoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncheckoutMouseExited
       btncheckout.setBackground(new Color(255,255,255));
        btncheckout.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btncheckoutMouseExited

    private void btncheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncheckoutActionPerformed
        int selectedRowIndex = jTableManageBooking.getSelectedRow();
            if (selectedRowIndex >= 0) {
                
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure want to check out this booking?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
        DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
        
            
        
         String duration = (model.getValueAt(selectedRowIndex, 6).toString());
        int durationint = Integer.parseInt(duration);
        


            //for checkout
        String oldcheckinday = model.getValueAt(selectedRowIndex, 7).toString();
        String oldduration = model.getValueAt(selectedRowIndex, 6).toString();
        int olddurationint = Integer.parseInt(oldduration);
        
        String oldselectedRoom = model.getValueAt(selectedRowIndex, 5).toString();
        String [] oldselected_room_data = oldselectedRoom.split(";");
        
        String oldfloorLevel = oldselected_room_data[2];
        int oldfloorLevellengthh = oldfloorLevel.length();
        String oldfloorLevelCompleted = oldfloorLevel.substring(12,oldfloorLevellengthh-1);
        int oldfloorlevleintt = Integer.parseInt(oldfloorLevelCompleted);
        
        String oldroomnumberqqq = oldselected_room_data[0];
        int oldroomnumberqqqlengthh = oldroomnumberqqq.length();
        String oldroomnumberqqqCompleted = oldroomnumberqqq.substring(9, oldroomnumberqqqlengthh-1);
        int oldroomnumberqqqint = Integer.parseInt(oldroomnumberqqqCompleted);
        
        String oldroomtypezz = oldselected_room_data[1];
        int oldroomtypezzlength = oldroomtypezz.length();
        String oldroomTypezzCompleted = oldroomtypezz.substring(7,oldroomtypezzlength-1);
        
        
        String oldroomiddddd = oldselected_room_data[3];
        int oldroomidddddLength = oldroomiddddd.length();
        String oldroomidddddCompleted = oldroomiddddd.substring(5,oldroomidddddLength);
        
        

        payment obj = new payment(durationint);
        
        
        obj.CheckeOut(oldcheckinday, olddurationint, oldroomidddddCompleted , oldroomnumberqqqint,  oldroomTypezzCompleted, oldfloorlevleintt);
         
        
        //for update booking file status to checkout instead of ongoing
         String selectedRoom = model.getValueAt(selectedRowIndex, 5).toString();
       
        
      

        String bookingID = model.getValueAt(selectedRowIndex, 0).toString();

        String customerName = model.getValueAt(selectedRowIndex, 1).toString();

        String icpassport = model.getValueAt(selectedRowIndex, 2).toString();
        String contactno = model.getValueAt(selectedRowIndex, 3).toString();
        String email = model.getValueAt(selectedRowIndex, 4).toString();
        String checkinday = model.getValueAt(selectedRowIndex, 7).toString();
        String checkoutday = model.getValueAt(selectedRowIndex, 8).toString();
        
        
       

      

        obj.UpdateBookingRecord(bookingID , customerName, icpassport, contactno, email, checkinday, checkoutday,  selectedRoom, true);
        
           
        //refresh jtable
        model.setRowCount(0);
        String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\booking.txt";
        File file = new File(filePath);
        jTableManageBooking.setRowHeight(30);
         jTableManageBooking.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            Object[] tableLines = br.lines().toArray();
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                
                String bookingId = dataRow[0];
                int bookingIdLength = bookingId.length();
                String bookingIdComplete = bookingId.substring(13,bookingIdLength);
                dataRow[0] = bookingIdComplete;
                
                
                
                
                String durationkk = dataRow[6];
                int durationkkLength = durationkk.length();
                String durationkkComplete = durationkk.substring(11,durationkkLength);
                dataRow[6] = durationkkComplete;
                
                String checkindaykk = dataRow[7];
                int checkindaykkLength = checkindaykk.length();
                String checkindaykkComplete = checkindaykk.substring(15,checkindaykkLength);
                dataRow[7] = checkindaykkComplete;
                
                String checkoutdaykk = dataRow[8];
                int checkoutdaykkLength = checkoutdaykk.length();
                String checkoutdaykkComplete = checkoutdaykk.substring(16,checkoutdaykkLength);
                dataRow[8] = checkoutdaykkComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
        }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row!");
        
        }
    }//GEN-LAST:event_btncheckoutActionPerformed
  
    private void jTableManageBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableManageBookingMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
        int selectedRowIndex = jTableManageBooking.getSelectedRow();

        
        //if booking status = checkedout, user shud not be able to perform any opeartion to it except delete.
        String bookingstatus = (model.getValueAt(selectedRowIndex, 9).toString());
        String checkout = "CheckedOut";
        if (bookingstatus.equals(checkout)) {
            btnUpdate.setEnabled(false);
            btnchangeroombookingday.setEnabled(false);
            btncheckout.setEnabled(false);
            
            
        }else{
            btnUpdate.setEnabled(true);
            btnchangeroombookingday.setEnabled(true);
            btncheckout.setEnabled(true);
        }
    }//GEN-LAST:event_jTableManageBookingMouseClicked

    private void btnSearchRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRoomActionPerformed

        DefaultTableModel model = (DefaultTableModel)jTableManageBooking.getModel();
        int selectedRowIndex = jTableManageBooking.getSelectedRow();

        //fk
        int durationint = 1;

        booking obj = new booking(durationint);

        obj.SerchBookingRecord();
    }//GEN-LAST:event_btnSearchRoomActionPerformed

    private void btnSearchRoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRoomMouseExited
        btnSearchRoom.setBackground(new Color(255,255,255));
        btnSearchRoom.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnSearchRoomMouseExited

    private void btnSearchRoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRoomMouseEntered
        btnSearchRoom.setBackground(Color.cyan);
        btnSearchRoom.setForeground(Color.white);
    }//GEN-LAST:event_btnSearchRoomMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manageBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearchRoom;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnchangeroombookingday;
    private javax.swing.JButton btncheckout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableManageBooking;
    private javax.swing.JLabel lblAddRoom;
    public static javax.swing.JTextField txtSearchBookingRecord;
    // End of variables declaration//GEN-END:variables
}
