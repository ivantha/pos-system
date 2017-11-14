/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.employee;

import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameListener;
import controller.View;
import javax.swing.BorderFactory;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class EditEmployee extends javax.swing.JInternalFrame implements View {

    /**
     * Creates new form EditEmployeeView
     */
    public EditEmployee() {
        initComponents();

        this.editEmployeePanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        
        this.employeeIDLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.employeeIDTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        this.nationalIDLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.nationIDTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.nameLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.nameTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.addressLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.addressTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.telephoneLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.telephoneTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.jobLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.jobComboBox.setBackground(ColourPalatte.PALE_WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editEmployeePanel = new javax.swing.JPanel();
        nationalIDLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        jobLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        nationIDTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JTextField();
        jobComboBox = new javax.swing.JComboBox();
        employeeIDLabel = new javax.swing.JLabel();
        employeeIDTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edit employee");

        nationalIDLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nationalIDLabel.setText("National ID");

        nameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameLabel.setText("Name");

        addressLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addressLabel.setText("Address");

        telephoneLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        telephoneLabel.setText("Telephone");

        jobLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jobLabel.setText("Job");

        okButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okButtonMouseExited(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButtonMouseExited(evt);
            }
        });

        nationIDTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nationIDTextField.setText(" ");
        nationIDTextField.setBorder(null);

        nameTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameTextField.setText(" ");
        nameTextField.setBorder(null);

        addressTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addressTextField.setText(" ");
        addressTextField.setBorder(null);

        telephoneTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        telephoneTextField.setText(" ");
        telephoneTextField.setBorder(null);

        jobComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jobComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "Assistant Manager", "Stock Keeper", "Cashier", "Bagger", "Delivery Driver", "Cleaner" }));

        employeeIDLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        employeeIDLabel.setText("Employee ID");

        employeeIDTextField.setEditable(false);
        employeeIDTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        employeeIDTextField.setText(" ");
        employeeIDTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout editEmployeePanelLayout = new javax.swing.GroupLayout(editEmployeePanel);
        editEmployeePanel.setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(editEmployeePanelLayout.createSequentialGroup()
                            .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nationalIDLabel)
                                .addComponent(nameLabel)
                                .addComponent(addressLabel)
                                .addComponent(telephoneLabel)
                                .addComponent(jobLabel))
                            .addGap(25, 25, 25)
                            .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nationIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(employeeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(editEmployeePanelLayout.createSequentialGroup()
                            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(employeeIDLabel))
                .addGap(25, 25, 25))
        );
        editEmployeePanelLayout.setVerticalGroup(
            editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIDLabel)
                    .addComponent(employeeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationalIDLabel)
                    .addComponent(nationIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneLabel)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel)
                    .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(editEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editEmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editEmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseEntered
        this.okButton.setBackground(ColourPalatte.VERY_DARK_BLUE);
        this.okButton.setForeground(ColourPalatte.FONT_BLUE);
        this.okButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.FONT_BLUE, 1));
    }//GEN-LAST:event_okButtonMouseEntered

    private void okButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseExited
        this.okButton.setBackground(ColourPalatte.DARK_BLUE);
        this.okButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.okButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_okButtonMouseExited

    private void clearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseEntered
        this.clearButton.setBackground(ColourPalatte.VERY_DARK_BLUE);
        this.clearButton.setForeground(ColourPalatte.FONT_BLUE);
        this.clearButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.FONT_BLUE, 1));
    }//GEN-LAST:event_clearButtonMouseEntered

    private void clearButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseExited
        this.clearButton.setBackground(ColourPalatte.DARK_BLUE);
        this.clearButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.clearButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_clearButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    javax.swing.JTextField addressTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel editEmployeePanel;
    private javax.swing.JLabel employeeIDLabel;
    javax.swing.JTextField employeeIDTextField;
    javax.swing.JComboBox jobComboBox;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JLabel nameLabel;
    javax.swing.JTextField nameTextField;
    javax.swing.JTextField nationIDTextField;
    private javax.swing.JLabel nationalIDLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel telephoneLabel;
    javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateViewInternalFrameListener(InternalFrameListener ifl) {
        this.addInternalFrameListener(ifl);
    }

    public void addOKButtonActionListener(ActionListener al) {
        okButton.addActionListener(al);
    }

    public void addClearButtonActionListener(ActionListener al) {
        clearButton.addActionListener(al);
    }
}