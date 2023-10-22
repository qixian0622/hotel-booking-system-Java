/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;

import static hotel.booking.system.staffupdatebookingChangeDayRoom.cmbDuration;
import static hotel.booking.system.staffupdatebookingChangeDayRoom.cmbSelectedDAy;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author qi xian
 */
public class StaffSearchAvailableRoom extends javax.swing.JFrame {

    /**
     * Creates new form SearchAvailableRoom
     */
    public StaffSearchAvailableRoom() {
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
        jButton1 = new javax.swing.JButton();
        cmbSelectedDAy = new javax.swing.JComboBox<>();
        lblSelectDay1 = new javax.swing.JLabel();
        cmbDuration = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSelectDay.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay.setText("Select Day:");

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbSelectedDAy.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        cmbSelectedDAy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        cmbSelectedDAy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectedDAyActionPerformed(evt);
            }
        });

        lblSelectDay1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        lblSelectDay1.setText("Duration (day) :");

        cmbDuration.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        cmbDuration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(214, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSelectDay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbSelectedDAy, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSelectDay1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectDay)
                    .addComponent(cmbSelectedDAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectDay1)
                    .addComponent(cmbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       room obj = new room();
        String day = cmbSelectedDAy.getSelectedItem().toString();
        String duration = cmbDuration.getSelectedItem().toString();
        
        
        
       String[] returnedArray;
        returnedArray = obj.CheckIfRoomIsAvailableOnADay(day,duration);
        
        StaffSelectAvailableRoom frame = new StaffSelectAvailableRoom();
        frame.setVisible(true);
         DefaultComboBoxModel mod= new DefaultComboBoxModel(returnedArray);
                StaffSelectAvailableRoom.cmbSelectAvailableRoom.setModel(mod);
                
                this.dispose();
                
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbSelectedDAyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectedDAyActionPerformed
       String selectedday = cmbSelectedDAy.getSelectedItem().toString();
        ArrayList<String> durationaa = new ArrayList<String>();
    
        if (selectedday == "Monday") {
            int count = 7;
             
                 
                durationaa.add("1");
                durationaa.add("2");
                durationaa.add("3");
                durationaa.add("4");
                durationaa.add("5");
                durationaa.add("6");
                durationaa.add("7");
               
               
            
                
         }else if(selectedday == "Tuesday"){
              
                durationaa.add("1");
                durationaa.add("2");
                durationaa.add("3");
                durationaa.add("4");
                durationaa.add("5");
                durationaa.add("6");
               
         }else if(selectedday == "Wednesday"){
               durationaa.add("1");
                durationaa.add("2");
                durationaa.add("3");
                durationaa.add("4");
                durationaa.add("5");
                
         }else if(selectedday == "Thursday"){
            durationaa.add("1");
                durationaa.add("2");
                durationaa.add("3");
                durationaa.add("4");
                
         }else if(selectedday == "Friday"){
             durationaa.add("1");
                durationaa.add("2");
                durationaa.add("3");
                
         }else if(selectedday == "Saturday"){
              durationaa.add("1");
                durationaa.add("2");
                
         }else if(selectedday == "Sunday"){
             durationaa.add("1");
               
         }
        
         
              
        
        String[] array = new String[durationaa.size()];
                for(int k = 0; k < array.length; k++) {
                    array[k] = durationaa.get(k);}
        
            
      DefaultComboBoxModel mod= new DefaultComboBoxModel(array);
                cmbDuration.setModel(mod);
    }//GEN-LAST:event_cmbSelectedDAyActionPerformed

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
            java.util.logging.Logger.getLogger(StaffSearchAvailableRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffSearchAvailableRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffSearchAvailableRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffSearchAvailableRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffSearchAvailableRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cmbDuration;
    public static javax.swing.JComboBox<String> cmbSelectedDAy;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSelectDay;
    private javax.swing.JLabel lblSelectDay1;
    // End of variables declaration//GEN-END:variables
}
