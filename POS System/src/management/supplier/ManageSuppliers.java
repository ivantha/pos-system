/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.supplier;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.event.InternalFrameListener;
import controller.View;
import javax.swing.BorderFactory;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class ManageSuppliers extends javax.swing.JInternalFrame implements View{

    /**
     * Creates new form ManageSuppliersView
     */
    public ManageSuppliers() {
        initComponents();
        
        this.manageSuppliersPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        this.searchPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        
        this.supplierIDLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.supplierIDTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.nameLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.nameTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.telephoneLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.telephoneTextField.setBackground(ColourPalatte.PALE_WHITE);
        this.addressLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.addressTextField.setBackground(ColourPalatte.PALE_WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageSuppliersPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        supplierIDLabel = new javax.swing.JLabel();
        supplierIDTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        telephoneLabel = new javax.swing.JLabel();
        telephoneTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Suppliers");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icon/suppliers_button_dark.png"))); // NOI18N

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Name", "Address", "Telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplierTable.setRowHeight(20);
        jScrollPane1.setViewportView(supplierTable);
        if (supplierTable.getColumnModel().getColumnCount() > 0) {
            supplierTable.getColumnModel().getColumn(0).setMinWidth(100);
            supplierTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            supplierTable.getColumnModel().getColumn(0).setMaxWidth(100);
            supplierTable.getColumnModel().getColumn(3).setMinWidth(100);
            supplierTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            supplierTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);

        newButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        newButton.setText("New");
        newButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newButtonMouseExited(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeButton.setText("Remove");
        removeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeButtonMouseExited(evt);
            }
        });

        historyButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        historyButton.setText("History");
        historyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyButtonMouseExited(evt);
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

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search", 0, 0, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        supplierIDLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        supplierIDLabel.setText("Supplier ID");

        supplierIDTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        supplierIDTextField.setText(" ");
        supplierIDTextField.setBorder(null);

        nameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameLabel.setText("Name");

        nameTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameTextField.setText(" ");
        nameTextField.setBorder(null);

        telephoneLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        telephoneLabel.setText("Telephone");

        telephoneTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        telephoneTextField.setText(" ");
        telephoneTextField.setBorder(null);

        addressLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addressLabel.setText("Address");

        addressTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addressTextField.setText(" ");
        addressTextField.setBorder(null);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneLabel)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierIDLabel)
                    .addComponent(supplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(supplierIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(telephoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout manageSuppliersPanelLayout = new javax.swing.GroupLayout(manageSuppliersPanel);
        manageSuppliersPanel.setLayout(manageSuppliersPanelLayout);
        manageSuppliersPanelLayout.setHorizontalGroup(
            manageSuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageSuppliersPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(manageSuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(manageSuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(manageSuppliersPanelLayout.createSequentialGroup()
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        manageSuppliersPanelLayout.setVerticalGroup(
            manageSuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageSuppliersPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(manageSuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(manageSuppliersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageSuppliersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageSuppliersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void newButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newButtonMouseEntered
        this.newButton.setBackground(ColourPalatte.VERY_DARK_BLUE);
        this.newButton.setForeground(ColourPalatte.FONT_BLUE);
        this.newButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.FONT_BLUE, 1));
    }//GEN-LAST:event_newButtonMouseEntered

    private void newButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newButtonMouseExited
        this.newButton.setBackground(ColourPalatte.DARK_BLUE);
        this.newButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.newButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_newButtonMouseExited

    private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseEntered
        this.editButton.setBackground(ColourPalatte.VERY_DARK_BLUE);
        this.editButton.setForeground(ColourPalatte.FONT_BLUE);
        this.editButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.FONT_BLUE, 1));
    }//GEN-LAST:event_editButtonMouseEntered

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseExited
        this.editButton.setBackground(ColourPalatte.DARK_BLUE);
        this.editButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.editButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_editButtonMouseExited

    private void removeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseEntered
        this.removeButton.setBackground(ColourPalatte.VERY_DARK_BLUE);
        this.removeButton.setForeground(ColourPalatte.FONT_BLUE);
        this.removeButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.FONT_BLUE, 1));
    }//GEN-LAST:event_removeButtonMouseEntered

    private void removeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseExited
        this.removeButton.setBackground(ColourPalatte.DARK_BLUE);
        this.removeButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.removeButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_removeButtonMouseExited

    private void historyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseEntered
        this.historyButton.setBackground(ColourPalatte.VERY_DARK_BLUE);
        this.historyButton.setForeground(ColourPalatte.FONT_BLUE);
        this.historyButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.FONT_BLUE, 1));
    }//GEN-LAST:event_historyButtonMouseEntered

    private void historyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseExited
        this.historyButton.setBackground(ColourPalatte.DARK_BLUE);
        this.historyButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.historyButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_historyButtonMouseExited
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    javax.swing.JTextField addressTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton historyButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel manageSuppliersPanel;
    private javax.swing.JLabel nameLabel;
    javax.swing.JTextField nameTextField;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel supplierIDLabel;
    javax.swing.JTextField supplierIDTextField;
    javax.swing.JTable supplierTable;
    private javax.swing.JLabel telephoneLabel;
    javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateViewInternalFrameListener(InternalFrameListener ifl) {
        this.addInternalFrameListener(ifl);
    }
    
    public void addClearButtonActionListener(ActionListener al){
        clearButton.addActionListener(al);
    }
    
    public void addNewButtonActionListener(ActionListener al){
        newButton.addActionListener(al);
    }
    
    public void addEditButtonActionListener(ActionListener al){
        editButton.addActionListener(al);
    }
    
    public void addRemoveButtonActionListener(ActionListener al){
        removeButton.addActionListener(al);
    }
    
    public void addHistorybuttonActionListener(ActionListener al){
        historyButton.addActionListener(al);
    }
    
    public void addSupplierTableMouseListener(MouseListener ml){
        supplierTable.addMouseListener(ml);
    }
    
    public void addSearchKeyListener(KeyListener kl){
        supplierIDTextField.addKeyListener(kl);
        nameTextField.addKeyListener(kl);
        telephoneTextField.addKeyListener(kl);
        addressTextField.addKeyListener(kl);
    }
}
