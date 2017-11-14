/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package history;

import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameListener;
import controller.View;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class PRNHistory extends javax.swing.JInternalFrame implements View{

    /**
     * Creates new form PRNHistoryView
     */
    public PRNHistory() {
        initComponents();
        
        this.prnHistoryPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        this.searchPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        this.searchScrollPane.setBackground(ColourPalatte.MEDIUM_BLUE);
        this.datePanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        this.amountPanel.setBackground(ColourPalatte.MEDIUM_BLUE);
        
        this.prnNoLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.poNoLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.employeeLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.fromLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.toLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.greaterThanLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.lessThanLabel.setForeground(ColourPalatte.BRIGHT_WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prnHistoryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prnTable = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        searchScrollPane = new javax.swing.JScrollPane();
        searchPanel = new javax.swing.JPanel();
        prnNoLabel = new javax.swing.JLabel();
        prnNoTextField = new javax.swing.JTextField();
        poNoLabel = new javax.swing.JLabel();
        poNoTextField = new javax.swing.JTextField();
        employeeLabel = new javax.swing.JLabel();
        employeeTextField = new javax.swing.JTextField();
        datePanel = new javax.swing.JPanel();
        fromLabel = new javax.swing.JLabel();
        fromDatePicker = new org.jdesktop.swingx.JXDatePicker();
        toDatePicker = new org.jdesktop.swingx.JXDatePicker();
        toLabel = new javax.swing.JLabel();
        amountPanel = new javax.swing.JPanel();
        greaterThanLabel = new javax.swing.JLabel();
        greaterThanTextField = new javax.swing.JTextField();
        lessThanLabel = new javax.swing.JLabel();
        lessThanTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Purchase return note history");

        prnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRN no.", "Date", "PO no.", "Payment", "Employee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prnTable.setRowHeight(20);
        jScrollPane1.setViewportView(prnTable);
        if (prnTable.getColumnModel().getColumnCount() > 0) {
            prnTable.getColumnModel().getColumn(0).setMinWidth(100);
            prnTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            prnTable.getColumnModel().getColumn(0).setMaxWidth(100);
            prnTable.getColumnModel().getColumn(1).setMinWidth(100);
            prnTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            prnTable.getColumnModel().getColumn(1).setMaxWidth(100);
            prnTable.getColumnModel().getColumn(2).setMinWidth(100);
            prnTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            prnTable.getColumnModel().getColumn(2).setMaxWidth(100);
            prnTable.getColumnModel().getColumn(3).setMinWidth(100);
            prnTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            prnTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

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

        searchScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search", 0, 0, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        searchScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        searchScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        prnNoLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prnNoLabel.setText("PRN no.");

        prnNoTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prnNoTextField.setText(" ");
        prnNoTextField.setBorder(null);

        poNoLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        poNoLabel.setText("PO no.");

        poNoTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        poNoTextField.setText(" ");
        poNoTextField.setBorder(null);

        employeeLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        employeeLabel.setText("Employee");

        employeeTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        employeeTextField.setText(" ");
        employeeTextField.setBorder(null);

        datePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fromLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        fromLabel.setText("From");

        toLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        toLabel.setText("To");

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLabel)
                    .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        amountPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        greaterThanLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        greaterThanLabel.setText("Greater than");

        greaterThanTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        greaterThanTextField.setText(" ");
        greaterThanTextField.setBorder(null);

        lessThanLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lessThanLabel.setText("Less than");

        lessThanTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lessThanTextField.setText(" ");
        lessThanTextField.setBorder(null);

        javax.swing.GroupLayout amountPanelLayout = new javax.swing.GroupLayout(amountPanel);
        amountPanel.setLayout(amountPanelLayout);
        amountPanelLayout.setHorizontalGroup(
            amountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(amountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(amountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greaterThanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greaterThanLabel)
                    .addComponent(lessThanLabel)
                    .addComponent(lessThanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        amountPanelLayout.setVerticalGroup(
            amountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(amountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greaterThanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greaterThanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lessThanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lessThanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeLabel)
                    .addComponent(employeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prnNoLabel)
                    .addComponent(prnNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poNoLabel)
                    .addComponent(poNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(amountPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prnNoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prnNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(poNoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(poNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(employeeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(amountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchScrollPane.setViewportView(searchPanel);
        searchScrollPane.getVerticalScrollBar().setUnitIncrement(20);

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

        javax.swing.GroupLayout prnHistoryPanelLayout = new javax.swing.GroupLayout(prnHistoryPanel);
        prnHistoryPanel.setLayout(prnHistoryPanelLayout);
        prnHistoryPanelLayout.setHorizontalGroup(
            prnHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prnHistoryPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(prnHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(prnHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prnHistoryPanelLayout.createSequentialGroup()
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        prnHistoryPanelLayout.setVerticalGroup(
            prnHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prnHistoryPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(prnHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(prnHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prnHistoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prnHistoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel amountPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel datePanel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel employeeLabel;
    javax.swing.JTextField employeeTextField;
    org.jdesktop.swingx.JXDatePicker fromDatePicker;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel greaterThanLabel;
    javax.swing.JTextField greaterThanTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lessThanLabel;
    javax.swing.JTextField lessThanTextField;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel poNoLabel;
    javax.swing.JTextField poNoTextField;
    private javax.swing.JPanel prnHistoryPanel;
    private javax.swing.JLabel prnNoLabel;
    javax.swing.JTextField prnNoTextField;
    javax.swing.JTable prnTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JScrollPane searchScrollPane;
    org.jdesktop.swingx.JXDatePicker toDatePicker;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateViewInternalFrameListener(InternalFrameListener ifl) {
        this.addInternalFrameListener(ifl);
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
    
    public void addSearchKeyListener(KeyListener kl){
        prnNoTextField.addKeyListener(kl);
        poNoTextField.addKeyListener(kl);
        employeeTextField.addKeyListener(kl);
        greaterThanTextField.addKeyListener(kl);
        lessThanTextField.addKeyListener(kl);
    }
    
    public void addSearchActionlistener(ActionListener al){
        fromDatePicker.addActionListener(al);
        toDatePicker.addActionListener(al);
    }
}
