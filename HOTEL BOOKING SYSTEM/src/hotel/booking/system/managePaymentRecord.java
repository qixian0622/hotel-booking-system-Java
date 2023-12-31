/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel.booking.system;

import static hotel.booking.system.manageBooking.jTableManageBooking;
import static hotel.booking.system.room.storage;
import static hotel.booking.system.room.write_to_file;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author qi xian
 */
public class managePaymentRecord extends javax.swing.JFrame {

    /** Creates new form managePaymentRecord */
    public managePaymentRecord() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAddRoom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableManagePaymentRecord = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtserachPaymentRecord = new javax.swing.JTextField();
        btnSearchPaymentRecord = new javax.swing.JButton();

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
        lblAddRoom.setText("Manage Payment Record");
        lblAddRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 181, 204));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        JTableManagePaymentRecord.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        JTableManagePaymentRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment Id", "Customer Nmae", "Email", "Room Charges", "Service Tax", "Tourism Tax", "Total Charges", "Total Payment", "Change", "Booking Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTableManagePaymentRecord);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 182, 204));
        btnUpdate.setText("Generate Receipt");
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

        txtserachPaymentRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtserachPaymentRecordActionPerformed(evt);
            }
        });

        btnSearchPaymentRecord.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchPaymentRecord.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnSearchPaymentRecord.setForeground(new java.awt.Color(0, 182, 204));
        btnSearchPaymentRecord.setText("Search");
        btnSearchPaymentRecord.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btnSearchPaymentRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSearchPaymentRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchPaymentRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchPaymentRecordMouseExited(evt);
            }
        });
        btnSearchPaymentRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPaymentRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(490, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblAddRoom)
                        .addGap(143, 143, 143)
                        .addComponent(txtserachPaymentRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchPaymentRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(306, 306, 306)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(485, 485, 485))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchPaymentRecord, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAddRoom)
                        .addComponent(jLabel1)
                        .addComponent(txtserachPaymentRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
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

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(Color.cyan);
        btnUpdate.setForeground(Color.white);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(new Color(255,255,255));
        btnUpdate.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        DefaultTableModel model = (DefaultTableModel)JTableManagePaymentRecord.getModel();
        int selectedRowIndex = JTableManagePaymentRecord.getSelectedRow();

        boolean found = false;

        String bookingidx = model.getValueAt(selectedRowIndex, 9).toString();
        String customerNamex = model.getValueAt(selectedRowIndex, 1).toString();
        String emailx = model.getValueAt(selectedRowIndex, 2).toString();
        String TotalChargexx = model.getValueAt(selectedRowIndex, 6).toString();
        String Totalpaymentxx = model.getValueAt(selectedRowIndex, 7).toString();
        String totalChangex = model.getValueAt(selectedRowIndex, 8).toString();
        
        String bookedRooom = null;
        String checkindayComplete = null;
        String durationComplete = null;
        String checkoutdayComplete = null;
        
        ArrayList<String> room = storage("booking.txt");
        String [] sub_room;
        for (int i = 0; i < room.size(); i++) {
            sub_room = room.get(i).split(",");
            String bookingIda = sub_room[0];
                int bookingIdaLength = bookingIda.length();
                String bookingIdaComplete = bookingIda.substring(13,bookingIdaLength);
                sub_room[0] = bookingIdaComplete;
            if (sub_room[0].equals(bookingidx)) {
                 
                String duration = sub_room[6];
                int durationLength = duration.length();
                durationComplete = duration.substring(11,durationLength);
                
                bookedRooom= sub_room[5];
                
                
                String checkinday = sub_room[7];
                int checkindayLength = checkinday.length();
                checkindayComplete = checkinday.substring(15,checkindayLength);
                
                
                String checkoutday = sub_room[8];
                int checkoutdayLength = checkoutday.length();
                checkoutdayComplete = checkoutday.substring(16,checkoutdayLength);
                
                found = true;
            }
        } 
        
        if (found == true) {
            Generate_PDF obj = new Generate_PDF();
        
       obj.SavePdf(bookingidx, customerNamex, emailx, bookedRooom, 
               checkindayComplete, durationComplete, checkoutdayComplete, 
               TotalChargexx, Totalpaymentxx, totalChangex );
       
        try {
            Desktop.getDesktop().open(new java.io.File("BookingReceipt.pdf"));
            
        } catch (Exception ex){
        
    }
        }else{
            JOptionPane.showMessageDialog(null, "This booking record has been deleted");
        }
        
       
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        btnDelete.setBackground(Color.cyan);
        btnDelete.setForeground(Color.white);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        btnDelete.setBackground(new Color(255,255,255));
        btnDelete.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        DefaultTableModel model = (DefaultTableModel)JTableManagePaymentRecord.getModel();
        int selectedRowIndex = JTableManagePaymentRecord.getSelectedRow();

        String paymentIDToDeleteFrom = (model.getValueAt(selectedRowIndex, 0).toString());
        
        int paymentid = Integer.parseInt(paymentIDToDeleteFrom);

        //fk1
        payment obj = new payment(1);
        

        obj.DeletePaymentRecord(paymentid);
        
        model.setRowCount(0);
      
         String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\payment.txt";
        File file = new File(filePath);
        JTableManagePaymentRecord.setRowHeight(30);
         JTableManagePaymentRecord.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            Object[] tableLines = br.lines().toArray();
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                
                String paymentId = dataRow[0];
                int paymentIdLength = paymentId.length();
                String paymentIdComplete = paymentId.substring(13,paymentIdLength);
                dataRow[0] = paymentIdComplete;
                
                
                
                
                String roomCharges = dataRow[3];
                int roomChargesLength = roomCharges.length();
                String roomChargesComplete = roomCharges.substring(15,roomChargesLength);
                dataRow[3] = roomChargesComplete;
                
                String serviceTax = dataRow[4];
                int serviceTaxLength = serviceTax.length();
                String serviceTaxComplete = serviceTax.substring(14,serviceTaxLength);
                dataRow[4] = serviceTaxComplete;
                
                String tourismTax = dataRow[5];
                int tourismTaxLength = tourismTax.length();
                String tourismTaxComplete = tourismTax.substring(14,tourismTaxLength);
                dataRow[5] = tourismTaxComplete;
                
                String totalCharges = dataRow[6];
                int totalChargesLength = totalCharges.length();
                String totalChargesComplete = totalCharges.substring(16,totalChargesLength);
                dataRow[6] = totalChargesComplete;
                
                String totalPayment = dataRow[7];
                int totalPaymentLength = totalPayment.length();
                String totalPaymentComplete = totalPayment.substring(16,totalPaymentLength);
                dataRow[7] = totalPaymentComplete;
                
                String totalChange = dataRow[8];
                int totalChangeLength = totalChange.length();
                String totalChangeComplete = totalChange.substring(16,totalChangeLength);
                dataRow[8] = totalChangeComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtserachPaymentRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtserachPaymentRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtserachPaymentRecordActionPerformed

    private void btnSearchPaymentRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchPaymentRecordMouseEntered
        btnSearchPaymentRecord.setBackground(Color.cyan);
        btnSearchPaymentRecord.setForeground(Color.white);
    }//GEN-LAST:event_btnSearchPaymentRecordMouseEntered

    private void btnSearchPaymentRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchPaymentRecordMouseExited
        btnSearchPaymentRecord.setBackground(new Color(255,255,255));
        btnSearchPaymentRecord.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnSearchPaymentRecordMouseExited

    private void btnSearchPaymentRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPaymentRecordActionPerformed
         
        
        
        //fk
        payment obj = new payment(1);

        obj.SerchPaymentRecord();
    }//GEN-LAST:event_btnSearchPaymentRecordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String filePath = "C:\\Users\\qi xian\\Documents\\NetBeansProjects\\HOTEL BOOKING SYSTEM\\payment.txt";
        File file = new File(filePath);
        JTableManagePaymentRecord.setRowHeight(30);
         JTableManagePaymentRecord.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 16));
        
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel)JTableManagePaymentRecord.getModel();
            Object[] tableLines = br.lines().toArray();
            
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                int index1 = line.indexOf(',');
                String[] dataRow = line.split(",");
                
                String paymentId = dataRow[0];
                int paymentIdLength = paymentId.length();
                String paymentIdComplete = paymentId.substring(13,paymentIdLength);
                dataRow[0] = paymentIdComplete;
                
                
                
                
                String roomCharges = dataRow[3];
                int roomChargesLength = roomCharges.length();
                String roomChargesComplete = roomCharges.substring(15,roomChargesLength);
                dataRow[3] = roomChargesComplete;
                
                String serviceTax = dataRow[4];
                int serviceTaxLength = serviceTax.length();
                String serviceTaxComplete = serviceTax.substring(14,serviceTaxLength);
                dataRow[4] = serviceTaxComplete;
                
                String tourismTax = dataRow[5];
                int tourismTaxLength = tourismTax.length();
                String tourismTaxComplete = tourismTax.substring(14,tourismTaxLength);
                dataRow[5] = tourismTaxComplete;
                
                String totalCharges = dataRow[6];
                int totalChargesLength = totalCharges.length();
                String totalChargesComplete = totalCharges.substring(16,totalChargesLength);
                dataRow[6] = totalChargesComplete;
                
                String totalPayment = dataRow[7];
                int totalPaymentLength = totalPayment.length();
                String totalPaymentComplete = totalPayment.substring(16,totalPaymentLength);
                dataRow[7] = totalPaymentComplete;
                
                String totalChange = dataRow[8];
                int totalChangeLength = totalChange.length();
                String totalChangeComplete = totalChange.substring(15,totalChangeLength);
                dataRow[8] = totalChangeComplete;
                
               
                model.addRow(dataRow);
            }
            
            
            
        } catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(managePaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managePaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managePaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managePaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managePaymentRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTableManagePaymentRecord;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearchPaymentRecord;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddRoom;
    public static javax.swing.JTextField txtserachPaymentRecord;
    // End of variables declaration//GEN-END:variables

}
