/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lentrix.demos.ui;

import com.lentrix.demos.db.CarDAO;
import com.lentrix.demos.db.CustomerDAO;
import com.lentrix.demos.db.RentalDAO;
import com.lentrix.demos.models.Car;
import com.lentrix.demos.models.Customer;
import com.lentrix.demos.models.Rental;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;

/**
 *
 * @author lentrix
 */
public class RentalsForm extends javax.swing.JDialog {
    private Rental current = null;
    private List<Rental> rentals = null;
    /**
     * Creates new form CustomersForm
     */
    public RentalsForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateComboBoxes();
        
        try {
            rentals = RentalDAO.getAll();
            tabulate();
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void tabulate() {
        String[] headers = {"Customer", "Car", "Date Taken", "Date Returned"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        
        for(Rental r: rentals) {
            model.addRow(new Object[] {r.getCustomer(), r.getCar(), r.getDateTaken(), r.getDateReturned()});
        }
        
        rentalsTable.setModel(model);
        rentalsTable.revalidate();
    }
    
    private void populateComboBoxes() {
        try {
            List<Car> cars = CarDAO.getAll();
            cars.add(0, null);
            carCB.setModel(new DefaultComboBoxModel(cars.toArray()));
            
            
            List<Customer> customers = CustomerDAO.getAll();
            customers.add(0, null);
            
            customerCB.setModel(new DefaultComboBoxModel(customers.toArray()));
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);            
        }
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
        customerCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        carCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateTakenTxt = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        dateReturnedTxt = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        amountTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        findBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rentalsTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customers Form");

        jPanel1.setLayout(new java.awt.GridLayout(10, 1, 5, 5));

        jLabel1.setText("Customer");
        jPanel1.add(jLabel1);

        jPanel1.add(customerCB);

        jLabel2.setText("Car");
        jPanel1.add(jLabel2);

        jPanel1.add(carCB);

        jLabel3.setText("Date Taken");
        jPanel1.add(jLabel3);

        dateTakenTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y-MM-dd"))));
        jPanel1.add(dateTakenTxt);

        jLabel4.setText("Date Returned");
        jPanel1.add(jLabel4);

        dateReturnedTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y-MM-dd"))));
        jPanel1.add(dateReturnedTxt);

        jLabel5.setText("Amount Deposited");
        jPanel1.add(jLabel5);
        jPanel1.add(amountTxt);

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

        rentalsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        rentalsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentalsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rentalsTable);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel6.setFont(new java.awt.Font("Raleway Semi-Bold", 0, 36)); // NOI18N
        jLabel6.setText("Rentals Form");

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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)))
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

        setSize(new java.awt.Dimension(1307, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        current = null;
        clearFields();
    }//GEN-LAST:event_newBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if(current==null) {
            try {
                Rental r = new Rental(
                        -1,
                        (Customer)customerCB.getSelectedItem(),
                        (Car)carCB.getSelectedItem(),
                        Date.valueOf(dateTakenTxt.getText()),
                        Date.valueOf(dateReturnedTxt.getText()),
                        Float.parseFloat(amountTxt.getText())
                );
                
                StringBuffer errors = new StringBuffer();
                if(r.validate(errors)) {
                    RentalDAO.add(r);
                    JOptionPane.showMessageDialog(this, "New Rental record added.", "Success!", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, errors.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "The value for amount deposited is invalid.", "Error!", JOptionPane.ERROR_MESSAGE);
            }catch(IllegalArgumentException ex) { 
                JOptionPane.showMessageDialog(this, "One or more of the date entries are invalid.\n", "Error!", JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            //TODO update rental
            System.out.println("Wala");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void rentalsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentalsTableMouseClicked
        int index = rentalsTable.getSelectedRow();
        current = rentals.get(index);
        if(current!=null) {
            
            customerCB.setSelectedIndex( getCustomerIndex(current.getCustomer().getId()) );
            carCB.setSelectedIndex( getCarIndex(current.getCar().getId()) );
            dateTakenTxt.setText(current.getDateTaken().toString());
            dateReturnedTxt.setText(current.getDateReturned().toString());
            amountTxt.setText(String.valueOf(current.getDeposit()));
        }
    }//GEN-LAST:event_rentalsTableMouseClicked

    private void clearFields() {
        customerCB.setSelectedIndex(0);
        carCB.setSelectedIndex(0);
        dateTakenTxt.setText(null);
        dateReturnedTxt.setText(null);
        amountTxt.setText(null);
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
            java.util.logging.Logger.getLogger(RentalsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RentalsForm dialog = new RentalsForm(new javax.swing.JFrame(), true);
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
    
    private int getCarIndex(int id) {
        for(int i=1; i<carCB.getItemCount(); i++) {
            if(carCB.getItemAt(i).getId() == id) return i;
        }
        return 0;
    }
    
    private int getCustomerIndex(int id) {
        for(int i=1; i<customerCB.getItemCount(); i++) {
            if(customerCB.getItemAt(i).getId() == id) return i;
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTxt;
    private javax.swing.JComboBox<Car> carCB;
    private javax.swing.JComboBox<Customer> customerCB;
    private javax.swing.JFormattedTextField dateReturnedTxt;
    private javax.swing.JFormattedTextField dateTakenTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton findBtn;
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
    private javax.swing.JButton newBtn;
    private javax.swing.JTable rentalsTable;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
