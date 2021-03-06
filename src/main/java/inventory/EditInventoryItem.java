/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package inventory;

import controller.View;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.event.InternalFrameListener;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class EditInventoryItem extends javax.swing.JInternalFrame implements View{

    /**
     * Creates new form EditInventoryItemView
     */
    public EditInventoryItem() {
        initComponents();
        
        this.editInventoryItemPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        
        this.itemNoLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.itemNoTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        this.nameLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.nameTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        this.descriptionLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.descriptionTextArea.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        this.unitPriceLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.unitPriceTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.qtyLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.qtyTextField.setBackground(ColourPalatte.PALE_WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editInventoryItemPanel = new javax.swing.JPanel();
        itemNoLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        itemNoTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        unitPriceLabel = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        unitPriceTextField = new javax.swing.JTextField();
        qtyTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edit inventory item");

        itemNoLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        itemNoLabel.setText("Item no.");

        nameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameLabel.setText("Name");

        descriptionLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        descriptionLabel.setText("Description");

        itemNoTextField.setEditable(false);
        itemNoTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        itemNoTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        descriptionTextArea.setRows(5);
        descriptionTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(descriptionTextArea);

        unitPriceLabel.setText("Unit price");

        qtyLabel.setText("Qty");

        unitPriceTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        unitPriceTextField.setText(" ");
        unitPriceTextField.setBorder(null);

        qtyTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        qtyTextField.setText(" ");
        qtyTextField.setBorder(null);

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

        javax.swing.GroupLayout editInventoryItemPanelLayout = new javax.swing.GroupLayout(editInventoryItemPanel);
        editInventoryItemPanel.setLayout(editInventoryItemPanelLayout);
        editInventoryItemPanelLayout.setHorizontalGroup(
            editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editInventoryItemPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(descriptionLabel)
                    .addGroup(editInventoryItemPanelLayout.createSequentialGroup()
                        .addComponent(itemNoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editInventoryItemPanelLayout.createSequentialGroup()
                        .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editInventoryItemPanelLayout.createSequentialGroup()
                                .addComponent(qtyLabel)
                                .addGap(60, 60, 60))
                            .addGroup(editInventoryItemPanelLayout.createSequentialGroup()
                                .addComponent(unitPriceLabel)
                                .addGap(33, 33, 33)))
                        .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editInventoryItemPanelLayout.createSequentialGroup()
                                .addComponent(unitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        editInventoryItemPanelLayout.setVerticalGroup(
            editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editInventoryItemPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNoLabel)
                    .addComponent(nameLabel)
                    .addComponent(itemNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtyLabel)
                    .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(unitPriceLabel)
                        .addComponent(unitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editInventoryItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editInventoryItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editInventoryItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel descriptionLabel;
    javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JPanel editInventoryItemPanel;
    private javax.swing.JLabel itemNoLabel;
    javax.swing.JTextField itemNoTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel qtyLabel;
    javax.swing.JTextField qtyTextField;
    private javax.swing.JLabel unitPriceLabel;
    javax.swing.JTextField unitPriceTextField;
    // End of variables declaration//GEN-END:variables
}
