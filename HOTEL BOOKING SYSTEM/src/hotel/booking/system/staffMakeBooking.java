/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.*;

import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author qi xian
 */
public class staffMakeBooking extends javax.swing.JFrame {

    /**
     * Creates new form staffMakeBooking
     */
    public staffMakeBooking() {
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
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        txtIcNumber = new javax.swing.JTextField();
        lblRole1 = new javax.swing.JLabel();
        lblRole2 = new javax.swing.JLabel();
        lblRole3 = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        txtfullname = new javax.swing.JTextField();
        txtcontactnumber = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtSelectedRoom = new javax.swing.JTextField();
        txtSelectedDay = new javax.swing.JTextField();
        txtCheckOutDay = new javax.swing.JTextField();
        btnProceedToPayment = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1758, 920));
        setResizable(false);
        setSize(new java.awt.Dimension(1400, 900));

        jPanel1.setBackground(new java.awt.Color(0, 181, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 182, 204));
        jLabel4.setText("Make Booking");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblFullName.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblFullName.setText("Full Name:");

        lblEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblEmail.setText("IC/Passport:");

        lblUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblUsername.setText("Contact No:");

        lblPassword.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblPassword.setText("Email:");

        lblRole.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblRole.setText("Selected Room:");

        txtIcNumber.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtIcNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIcNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtIcNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtIcNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIcNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIcNumberFocusLost(evt);
            }
        });
        txtIcNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIcNumberActionPerformed(evt);
            }
        });

        lblRole1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblRole1.setText("Day (Check In):");

        lblRole2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblRole2.setText("Duration (Days):");

        lblRole3.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblRole3.setText("Day (Check Out):");

        txtDuration.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuration.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtDuration.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDuration.setEnabled(false);
        txtDuration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDurationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDurationFocusLost(evt);
            }
        });
        txtDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDurationActionPerformed(evt);
            }
        });

        txtfullname.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtfullname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfullname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtfullname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtfullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfullnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfullnameFocusLost(evt);
            }
        });
        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });

        txtcontactnumber.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtcontactnumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcontactnumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtcontactnumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtcontactnumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcontactnumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontactnumberFocusLost(evt);
            }
        });
        txtcontactnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactnumberActionPerformed(evt);
            }
        });

        txtemail.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtemail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailFocusLost(evt);
            }
        });
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        txtSelectedRoom.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtSelectedRoom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSelectedRoom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtSelectedRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSelectedRoom.setEnabled(false);
        txtSelectedRoom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSelectedRoomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSelectedRoomFocusLost(evt);
            }
        });
        txtSelectedRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSelectedRoomActionPerformed(evt);
            }
        });

        txtSelectedDay.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtSelectedDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSelectedDay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtSelectedDay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSelectedDay.setEnabled(false);
        txtSelectedDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSelectedDayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSelectedDayFocusLost(evt);
            }
        });
        txtSelectedDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSelectedDayActionPerformed(evt);
            }
        });

        txtCheckOutDay.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        txtCheckOutDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCheckOutDay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        txtCheckOutDay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCheckOutDay.setEnabled(false);
        txtCheckOutDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCheckOutDayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCheckOutDayFocusLost(evt);
            }
        });
        txtCheckOutDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckOutDayActionPerformed(evt);
            }
        });

        btnProceedToPayment.setBackground(new java.awt.Color(255, 255, 255));
        btnProceedToPayment.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnProceedToPayment.setForeground(new java.awt.Color(0, 182, 204));
        btnProceedToPayment.setText("Proceed To Payment");
        btnProceedToPayment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 182, 204), 4, true));
        btnProceedToPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProceedToPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProceedToPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProceedToPaymentMouseExited(evt);
            }
        });
        btnProceedToPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedToPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(611, 611, 611)
                .addComponent(btnProceedToPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblFullName)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)))
                    .addComponent(lblRole1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtIcNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcontactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSelectedDay, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSelectedRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRole2)
                    .addComponent(lblRole3))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCheckOutDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFullName))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIcNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole2))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRole3)
                            .addComponent(txtCheckOutDay, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSelectedRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSelectedDay, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnProceedToPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 181, 204));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(736, 736, 736)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 209, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIcNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIcNumberFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIcNumberFocusGained

    private void txtIcNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIcNumberFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIcNumberFocusLost

    private void txtIcNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIcNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIcNumberActionPerformed

    private void txtDurationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDurationFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurationFocusGained

    private void txtDurationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDurationFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurationFocusLost

    private void txtDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurationActionPerformed

    private void txtcontactnumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontactnumberFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactnumberFocusGained

    private void txtcontactnumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontactnumberFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactnumberFocusLost

    private void txtcontactnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactnumberActionPerformed

    private void txtemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailFocusGained

    private void txtemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailFocusLost

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtSelectedRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSelectedRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedRoomActionPerformed

    private void txtSelectedRoomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSelectedRoomFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedRoomFocusLost

    private void txtSelectedRoomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSelectedRoomFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedRoomFocusGained

    private void txtSelectedDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSelectedDayFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedDayFocusGained

    private void txtSelectedDayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSelectedDayFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedDayFocusLost

    private void txtSelectedDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSelectedDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectedDayActionPerformed

    private void txtCheckOutDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCheckOutDayFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckOutDayFocusGained

    private void txtCheckOutDayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCheckOutDayFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckOutDayFocusLost

    private void txtCheckOutDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckOutDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckOutDayActionPerformed

    private void btnProceedToPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProceedToPaymentMouseEntered
        btnProceedToPayment.setBackground(Color.cyan);
        btnProceedToPayment.setForeground(Color.white);
    }//GEN-LAST:event_btnProceedToPaymentMouseEntered

    private void btnProceedToPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProceedToPaymentMouseExited
        btnProceedToPayment.setBackground(new Color(255,255,255));
        btnProceedToPayment.setForeground(new Color(0,182,204));
    }//GEN-LAST:event_btnProceedToPaymentMouseExited

    private void btnProceedToPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedToPaymentActionPerformed
        if ((txtfullname.getText().equals("") || txtIcNumber.getText().equals("") || txtcontactnumber.getText().equals("")  || txtemail.getText().equals("") || txtSelectedRoom.getText().equals("") || txtSelectedDay.getText().equals("") || txtDuration.getText().equals("") || txtCheckOutDay.getText().equals("")) ) {
            JOptionPane.showMessageDialog(null, "Please Fill Up All Field!");} 
        
        else{
            String customerName = txtfullname.getText();
            String contactNumber = txtcontactnumber.getText();
            int contactNumberLength = contactNumber.length();
            char contactNumberFirstChar = contactNumber.charAt(0);//check if the first chracter of the phone number is 0
            char contactNumberSecondChar = contactNumber.charAt(1);//check if the first chracter of the phone number is 1
            
            
            String email = txtemail.getText();
            String icnumber = txtIcNumber.getText();
            int icnumberLength = icnumber.length();
            
            String regex1 = "[0-9]+";  //must be all digits
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(icnumber);
            Matcher matcher2 = pattern1.matcher(contactNumber);
            
            String regex = "^(.+)@(.+)$";//email
            Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(email);
             
             String regex2 = "[A-Za-z ]*";//for only letter and spaces
             Pattern pattern3 = Pattern.compile(regex2);
             Matcher matcher3 = pattern3.matcher(customerName);
             
             
             
             if (matcher.matches()== false  ) {
                JOptionPane.showMessageDialog(null, "Invalid Email Format!");
            }else if(matcher1.matches() == false){
            JOptionPane.showMessageDialog(null, "Icnumber must be all digits!");
            }else if(icnumberLength != 12){
                JOptionPane.showMessageDialog(null, "Invalid Ic number Length! It must be 12 digits long!");
            }else if(matcher2.matches() == false){
                JOptionPane.showMessageDialog(null, "Contact Number must be all digits!");
            }else if(contactNumberLength != 10 && contactNumberLength != 11){
                JOptionPane.showMessageDialog(null, "Invalid Contact Number Lenth! It must be either 10 or 11 digits long!");}
            else if(contactNumberFirstChar != '0' || contactNumberSecondChar != '1'){
                JOptionPane.showMessageDialog(null, "Invalid Contact Number");
            }else if(matcher3.matches() == false){
                JOptionPane.showMessageDialog(null, "Name should only contain letter!");
            }
            else{
                 
                
        
        String duration = txtDuration.getText();
       int durationInt = Integer.parseInt(duration);
       
       bookingpayment frame = new bookingpayment();

//pass the value of all the booking details to the booking classs using constructor from its child class payment
       payment obj = new payment(durationInt);
       
       double calculatedRoomCharges = obj.CalculateRoomCharges();
       String calculatedRoomChargesString = String.valueOf(calculatedRoomCharges);
       bookingpayment.txtRoomCharge.setText(calculatedRoomChargesString);
       
       
       double calculatedServiceTax = obj.CalculateServiceTax();
       String calculatedServiceTaxString = String.valueOf(calculatedServiceTax);
       bookingpayment.txtServiceTax.setText(calculatedServiceTaxString);
       
       double calculatedTourismTax = obj.CalculateTourismTax();
       String calculatedTourismTaxString = String.valueOf(calculatedTourismTax);
       bookingpayment.txtTourismTax.setText(calculatedTourismTaxString);
       
       double calculatedTotalCharges = obj.CalculateTotalCharges();
       String calculatedTotalChargesString = String.valueOf(calculatedTotalCharges);
       bookingpayment.txtTotalCharges.setText(calculatedTotalChargesString);
       
       frame.setVisible(true);
       this.dispose();
             }
        }
       
       
       
       
    }//GEN-LAST:event_btnProceedToPaymentActionPerformed

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void txtfullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfullnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameFocusLost

    private void txtfullnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfullnameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameFocusGained

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(staffMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffMakeBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceedToPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblRole1;
    private javax.swing.JLabel lblRole2;
    private javax.swing.JLabel lblRole3;
    private javax.swing.JLabel lblUsername;
    public static javax.swing.JTextField txtCheckOutDay;
    public static javax.swing.JTextField txtDuration;
    public static javax.swing.JTextField txtIcNumber;
    public static javax.swing.JTextField txtSelectedDay;
    public static javax.swing.JTextField txtSelectedRoom;
    public static javax.swing.JTextField txtcontactnumber;
    public static javax.swing.JTextField txtemail;
    public static javax.swing.JTextField txtfullname;
    // End of variables declaration//GEN-END:variables
}
