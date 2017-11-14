/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.customer;

import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameListener;
import controller.View;
import javax.swing.BorderFactory;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class EditCustomer extends javax.swing.JInternalFrame implements View{

    /**
     * Creates new form EditCutomersView
     */
    public EditCustomer() {
        initComponents();
        
        this.editCustomerPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editCustomerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edit customer");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Telephone");

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

        nameTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameTextField.setText(" ");
        nameTextField.setBorder(null);

        addressTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addressTextField.setText(" ");
        addressTextField.setBorder(null);

        telephoneTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        telephoneTextField.setText(" ");
        telephoneTextField.setBorder(null);

        javax.swing.GroupLayout editCustomerPanelLayout = new javax.swing.GroupLayout(editCustomerPanel);
        editCustomerPanel.setLayout(editCustomerPanelLayout);
        editCustomerPanelLayout.setHorizontalGroup(
            editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(editCustomerPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editCustomerPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        editCustomerPanelLayout.setVerticalGroup(
            editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCustomerPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(editCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    javax.swing.JTextField addressTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel editCustomerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateViewInternalFrameListener(InternalFrameListener ifl) {
        this.addInternalFrameListener(ifl);
    }
   
    public void addOKButtonActionListener(ActionListener al){
        okButton.addActionListener(al);
    }
    
    public void addClearButtonActionListener(ActionListener al){
        clearButton.addActionListener(al);
    } 
}