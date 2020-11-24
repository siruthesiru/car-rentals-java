/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.ui;

import com.lentrix.demos.db.CustomerDAO;
import com.lentrix.demos.models.Customer;
import javax.swing.JOptionPane;

/**
 *
 * @author lentrix
 */
public class CustomersForm extends javax.swing.JDialog {
    Customer current = null;
    /**
     * Creates new form CustomersForm
     */
    public CustomersForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        jLabel1 = new javax.swing.JLabel();
        lnameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneNumberTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        licNoTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        findBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customers Form");

        jPanel1.setLayout(new java.awt.GridLayout(10, 1, 5, 5));

        jLabel1.setText("Last Name");
        jPanel1.add(jLabel1);
        jPanel1.add(lnameTxt);

        jLabel2.setText("First Name");
        jPanel1.add(jLabel2);
        jPanel1.add(fnameTxt);

        jLabel3.setText("Phone Number");
        jPanel1.add(jLabel3);
        jPanel1.add(phoneNumberTxt);

        jLabel4.setText("Address");
        jPanel1.add(jLabel4);
        jPanel1.add(addressTxt);

        jLabel5.setText("License Number");
        jPanel1.add(jLabel5);
        jPanel1.add(licNoTxt);

        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 8, 3));

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });
        jPanel2.add(newBtn);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel2.add(saveBtn);

        findBtn.setText("Find");
        jPanel2.add(findBtn);

        deleteBtn.setText("Delete");
        jPanel2.add(deleteBtn);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel6.setFont(new java.awt.Font("Raleway Semi-Bold", 0, 36)); // NOI18N
        jLabel6.setText("Customers Form");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1238, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        current = null;
        clearFields();
    }//GEN-LAST:event_newBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if(current==null) {
            //Insert
            Customer c = new Customer(
                    -1,
                    lnameTxt.getText(),
                    fnameTxt.getText(),
                    phoneNumberTxt.getText(),
                    addressTxt.getText(),
                    licNoTxt.getText()
            );
            
            try{
                StringBuffer errors = new StringBuffer();
                if(c.validate(errors)){
                    CustomerDAO.add(c);
                    JOptionPane.showMessageDialog(this, "A new customer has been added to the record.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                }else {
                    JOptionPane.showMessageDialog(this, errors.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            //TODO Update
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearFields() {
        lnameTxt.setText(null);
        fnameTxt.setText(null);
        phoneNumberTxt.setText(null);
        addressTxt.setText(null);
        licNoTxt.setText(null);
        lnameTxt.grabFocus();
    }
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
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomersForm dialog = new CustomersForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton findBtn;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField licNoTxt;
    private javax.swing.JTextField lnameTxt;
    private javax.swing.JButton newBtn;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
