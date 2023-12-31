/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;

import java.awt.Desktop;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author qi xian
 */
public class bookingpayment extends javax.swing.JFrame {

    /**
     * Creates new form bookingpayment
     */
    public bookingpayment() {
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
        lblSelectDay = new javax.swing.JLabel();
        btncalculateChange = new javax.swing.JButton();
        lblSelectDay1 = new javax.swing.JLabel();
        txtRoomCharge = new javax.swing.JTextField();
        txtServiceTax = new javax.swing.JTextField();
        txtTotalCharges = new javax.swing.JTextField();
        lblSelectDay2 = new javax.swing.JLabel();
        lblSelectDay3 = new javax.swing.JLabel();
        lblSelectDay4 = new javax.swing.JLabel();
        lblSelectDay5 = new javax.swing.JLabel();
        txtTourismTax = new javax.swing.JTextField();
        txtTotalPayment = new javax.swing.JTextField();
        txtTotalChange = new javax.swing.JTextField();
        btnGenerateReceipt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSelectDay.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay.setText("Room Charges:");

        btncalculateChange.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btncalculateChange.setText("Calculate");
        btncalculateChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalculateChangeActionPerformed(evt);
            }
        });

        lblSelectDay1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay1.setText("Service Tax:");

        txtRoomCharge.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        txtRoomCharge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRoomCharge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtRoomCharge.setEnabled(false);
        txtRoomCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomChargeActionPerformed(evt);
            }
        });

        txtServiceTax.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        txtServiceTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtServiceTax.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtServiceTax.setEnabled(false);

        txtTotalCharges.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        txtTotalCharges.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCharges.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTotalCharges.setEnabled(false);
        txtTotalCharges.setMinimumSize(new java.awt.Dimension(308, 123));
        txtTotalCharges.setPreferredSize(new java.awt.Dimension(308, 123));
        txtTotalCharges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalChargesActionPerformed(evt);
            }
        });

        lblSelectDay2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay2.setText("Tourism Tax:");

        lblSelectDay3.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay3.setText("Total Charges:");

        lblSelectDay4.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay4.setText("Total Payment:");

        lblSelectDay5.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay5.setText("Total Change:");

        txtTourismTax.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        txtTourismTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTourismTax.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTourismTax.setEnabled(false);
        txtTourismTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTourismTaxActionPerformed(evt);
            }
        });

        txtTotalPayment.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        txtTotalPayment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalPayment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTotalPayment.setMinimumSize(new java.awt.Dimension(308, 123));
        txtTotalPayment.setPreferredSize(new java.awt.Dimension(308, 123));
        txtTotalPayment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalPaymentFocusLost(evt);
            }
        });
        txtTotalPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPaymentActionPerformed(evt);
            }
        });
        txtTotalPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalPaymentKeyTyped(evt);
            }
        });

        txtTotalChange.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        txtTotalChange.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalChange.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTotalChange.setEnabled(false);
        txtTotalChange.setMinimumSize(new java.awt.Dimension(308, 123));
        txtTotalChange.setPreferredSize(new java.awt.Dimension(308, 123));
        txtTotalChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalChangeActionPerformed(evt);
            }
        });
        txtTotalChange.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalChangeKeyPressed(evt);
            }
        });

        btnGenerateReceipt.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnGenerateReceipt.setText("Generate Receipt");
        btnGenerateReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReceiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSelectDay)
                            .addComponent(lblSelectDay1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelectDay2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelectDay4)
                            .addComponent(lblSelectDay5)
                            .addComponent(lblSelectDay3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRoomCharge, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(txtServiceTax)
                    .addComponent(txtTourismTax, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotalCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btncalculateChange, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerateReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectDay)
                    .addComponent(txtRoomCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServiceTax, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectDay1))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTourismTax, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectDay2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lblSelectDay3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtTotalCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblSelectDay4)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(txtTotalChange, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblSelectDay5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncalculateChange, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerateReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncalculateChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalculateChangeActionPerformed
        
        
        if ((txtTotalPayment.getText().equals("")|| txtRoomCharge.getText().equals("") || txtServiceTax.getText().equals("") || txtTourismTax.getText().equals("") || txtTotalCharges.getText().equals("")  ) ) {
            JOptionPane.showMessageDialog(null, "Please fill up all field!");
        
        
        
        }else{
            String totalpaymentzz = txtTotalPayment.getText();
            
                
            String regex1 = "[0-9]+";  //must be all digits
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(totalpaymentzz);
            
            if (matcher1.matches()== false) {
                JOptionPane.showMessageDialog(null, "Please only enter digits!");
            }else{
            
            String totalCharges = txtTotalCharges.getText();
        double totalChargesInt = Double.parseDouble(totalCharges);
        
        String totalPayment = txtTotalPayment.getText();
        double totalPaymentInt = Double.parseDouble(totalPayment);
        
            if (totalPaymentInt >= totalChargesInt) {
                String duration = staffMakeBooking.txtDuration.getText();
                int durationInt = Integer.parseInt(duration);
                
            payment obj = new payment(durationInt);
            double totalchange = obj.CalculateTotalChange(totalPaymentInt,totalChargesInt );
            String totalchangeString = String.valueOf(totalchange);
            txtTotalChange.setText(totalchangeString);}
            
            
            
        else{
            JOptionPane.showMessageDialog(null, "Invalid Total Payment! Total Payment Should Be Equal Than Or Equal Than Total Charges!");
        }
            }
        }
    }//GEN-LAST:event_btncalculateChangeActionPerformed

    private void txtTotalChargesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalChargesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalChargesActionPerformed

    private void txtRoomChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomChargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomChargeActionPerformed

    private void txtTourismTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTourismTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTourismTaxActionPerformed

    private void txtTotalPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPaymentActionPerformed

    private void txtTotalChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalChangeActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void txtTotalPaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPaymentKeyTyped
        
    }//GEN-LAST:event_txtTotalPaymentKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void txtTotalPaymentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalPaymentFocusLost
        
    }//GEN-LAST:event_txtTotalPaymentFocusLost

    private void txtTotalChangeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalChangeKeyPressed
        
    }//GEN-LAST:event_txtTotalChangeKeyPressed

    private void btnGenerateReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReceiptActionPerformed
               
        if ((txtTotalPayment.getText().equals("")|| txtRoomCharge.getText().equals("") || txtServiceTax.getText().equals("") || txtTourismTax.getText().equals("") || txtTotalCharges.getText().equals("") || txtTotalChange.getText().equals("")  ) ) {
            JOptionPane.showMessageDialog(null, "Please fill up all field!");
        
        
        
        }else{


        String duration = staffMakeBooking.txtDuration.getText();
        int durationInt = Integer.parseInt(duration);
        
        String checkindayzz = staffMakeBooking.txtSelectedDay.getText();
        String selectedRoom = staffMakeBooking.txtSelectedRoom.getText();
        String [] selected_room_data = selectedRoom.split(";");
        
        
        
        
       
        payment obj = new payment(durationInt);
        
        
        
        int bookindideee = obj.SaveBookingRecord(staffMakeBooking.txtfullname.getText(), staffMakeBooking.txtIcNumber.getText(), staffMakeBooking.txtcontactnumber.getText(), staffMakeBooking.txtemail.getText(), staffMakeBooking.txtSelectedDay.getText(), staffMakeBooking.txtCheckOutDay.getText(), staffMakeBooking.txtSelectedRoom.getText());
        
        String Roomcharges = txtRoomCharge.getText();
        double RoomchargesDouble = Double.parseDouble(Roomcharges);
        
        String servicetax = txtServiceTax.getText();
        double servicetaxDouble = Double.parseDouble(servicetax);
        
        String tourismtax = txtTourismTax.getText();
        double tourismtaxDouble = Double.parseDouble(tourismtax);
        
        String totalcharges = txtTotalCharges.getText();
        double totalchargesDouble = Double.parseDouble(totalcharges);
        
        String totalpayment = txtTotalPayment.getText();
        double totalpaymentDouble = Double.parseDouble(totalpayment);
        
         String totalchange = txtTotalChange.getText();
        double totalchangeDouble = Double.parseDouble(totalchange);
        
        
        obj.SavePaymentRecord(staffMakeBooking.txtfullname.getText(), staffMakeBooking.txtemail.getText(), RoomchargesDouble, servicetaxDouble, tourismtaxDouble, totalchargesDouble,totalpaymentDouble,totalchangeDouble, bookindideee);
        
        String floorLevel = selected_room_data[2];
        int floorLevellengthh = floorLevel.length();
        String floorLevelCompleted = floorLevel.substring(12,floorLevellengthh-1);
        int floorlevleintt = Integer.parseInt(floorLevelCompleted);
        
        String roomnumberqqq = selected_room_data[0];
        int roomnumberqqqlengthh = roomnumberqqq.length();
        String roomnumberqqqCompleted = roomnumberqqq.substring(9, roomnumberqqqlengthh-1);
        int roomnumberqqqint = Integer.parseInt(roomnumberqqqCompleted);
        
        String roomtypezz = selected_room_data[1];
        int roomtypezzlength = roomtypezz.length();
        String roomTypezzhalfCompleted = roomtypezz.substring(7,roomtypezzlength);
        String roomTypezzCompleted = roomTypezzhalfCompleted.strip();
        
        
        String roomiddddd = selected_room_data[3];
        int roomidddddLength = roomiddddd.length();
        String roomidddddCompleted = roomiddddd.substring(5,roomidddddLength);
        
        obj.UpdateRoomStatusForBookedDay(checkindayzz, durationInt, roomidddddCompleted, roomnumberqqqint,  roomTypezzCompleted, floorlevleintt);
        
        
        
          
        Generate_PDF objk = new Generate_PDF();
        
        String bokingideeString = String.valueOf(bookindideee);
        
     
        
        
       objk.SavePdf( bokingideeString, staffMakeBooking.txtfullname.getText(), staffMakeBooking.txtemail.getText(), staffMakeBooking.txtSelectedRoom.getText(), staffMakeBooking.txtSelectedDay.getText(), staffMakeBooking.txtDuration.getText(), staffMakeBooking.txtCheckOutDay.getText(), totalcharges , totalpayment , totalchange );
       
        try {
            JOptionPane.showMessageDialog(null, "Payment Succesfullly Made!");
            Desktop.getDesktop().open(new java.io.File("BookingReceipt.pdf"));
            
        } catch (Exception ex){
        
    }
         
        this.dispose();
        
       
        }
       
    }//GEN-LAST:event_btnGenerateReceiptActionPerformed

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
            java.util.logging.Logger.getLogger(bookingpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookingpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookingpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookingpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookingpayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateReceipt;
    private javax.swing.JButton btncalculateChange;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSelectDay;
    private javax.swing.JLabel lblSelectDay1;
    private javax.swing.JLabel lblSelectDay2;
    private javax.swing.JLabel lblSelectDay3;
    private javax.swing.JLabel lblSelectDay4;
    private javax.swing.JLabel lblSelectDay5;
    public static javax.swing.JTextField txtRoomCharge;
    public static javax.swing.JTextField txtServiceTax;
    public static javax.swing.JTextField txtTotalChange;
    public static javax.swing.JTextField txtTotalCharges;
    public static javax.swing.JTextField txtTotalPayment;
    public static javax.swing.JTextField txtTourismTax;
    // End of variables declaration//GEN-END:variables
}
