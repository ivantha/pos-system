/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package main;

import javax.swing.event.InternalFrameListener;
import controller.View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
class Dashboard extends javax.swing.JFrame implements View{
    ImageIcon homeIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/home_tab_dark.png"));
    ImageIcon homeIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/home_tab_light.png"));
    ImageIcon purchaseIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/purchase_tab_dark.png"));
    ImageIcon purchaseIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/purchase_tab_light.png"));
    ImageIcon salesIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/sales_tab_dark.png"));
    ImageIcon salesIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/sales_tab_light.png"));
    ImageIcon inventoryIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/inventory_tab_dark.png"));
    ImageIcon inventoryIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/inventory_tab_light.png"));
    ImageIcon reviewIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/review_tab_dark.png"));
    ImageIcon reviewIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/review_tab_light.png"));
    ImageIcon userIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/user_tab_dark.png"));
    ImageIcon userIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/user_tab_light.png"));
    ImageIcon helpIconDark = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/help_tab_dark.png"));
    ImageIcon helpIconLight = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/help_tab_light.png"));
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
              
        //Icon
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemClassLoader().getResource("icon/tech_lobby_logo.png")));
        
        //Background
        ImageIcon backgroundPanelWallpaper = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/background_label_wallpaper.jpg"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.backgroundLabel.setIcon(new ImageIcon(backgroundPanelWallpaper.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        
        //Ribbon pane
        this.ribbonTabbedPane.setBackground(ColourPalatte.OTHER_BLUE);
        this.ribbonTabbedPane.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //Tabs
        ribbonTabbedPane.addTab("<html><body><table>HOME</table></body></html>", homeIconDark, this.homePanel);
        ribbonTabbedPane.addTab("<html><body><table>PURCHASE</table></body></html>", purchaseIconDark, this.purchasePanel);
        ribbonTabbedPane.addTab("<html><body><table>SALES</table></body></html>", salesIconDark, this.salesPanel);
        ribbonTabbedPane.addTab("<html><body><table>INVENTORY</table></body></html>", inventoryIconDark, this.inventoryPanel);
        ribbonTabbedPane.addTab("<html><body><table>REVIEW</table></body></html>", reviewIconDark, this.reviewPanel);
        ribbonTabbedPane.addTab("<html><body><table>USER</table></body></html>", userIconDark, this.userPanel);
        ribbonTabbedPane.addTab("<html><body><table>HELP</table></body></html>", helpIconDark, this.helpPanel);
        
        //Home tab
        this.itemsButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.itemListsButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.suppliersButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.employeesButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.customersButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //Purchase tab
        this.poButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.grnButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.prnButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.poHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.grnHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.prnHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //Sales tab
        this.soButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.invoiceButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.srnButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.soHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.invoiceHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.srnHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //Inventory tab
        this.inventoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //User tab
        this.accountButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.settingsButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.logOutButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //Help tab
        this.userManualButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.versionHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.aboutButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        
        //Logo panel
        this.logoPanel.setBackground(ColourPalatte.LIGHT_BLUE);
        
        //Info panel
        this.infoPanel.setBackground(ColourPalatte.DARK_BLUE);
        this.infoTitleLabel.setForeground(ColourPalatte.FONT_ORANGE);
        this.infoDetailsLabel.setForeground(ColourPalatte.FONT_ORANGE);
        this.infoTitleLabel.setText("<html></html>");
        this.infoDetailsLabel.setText("<html></html>");
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLayeredPane = new javax.swing.JLayeredPane();
        mainJDPPanel = new javax.swing.JPanel();
        mainJDP = new javax.swing.JDesktopPane();
        backgroundPanel = new javax.swing.JPanel();
        backgroundLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        infoTitleLabel = new javax.swing.JLabel();
        infoDetailsLabel = new javax.swing.JLabel();
        userSubPanel = new javax.swing.JPanel();
        userIDLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        userIDValueLabel = new javax.swing.JLabel();
        userNameValueLabel = new javax.swing.JLabel();
        roleValueLabel = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ribbonTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        itemsButton = new javax.swing.JButton();
        itemListsButton = new javax.swing.JButton();
        employeesButton = new javax.swing.JButton();
        suppliersButton = new javax.swing.JButton();
        customersButton = new javax.swing.JButton();
        purchasePanel = new javax.swing.JPanel();
        poButton = new javax.swing.JButton();
        grnButton = new javax.swing.JButton();
        prnButton = new javax.swing.JButton();
        poHistoryButton = new javax.swing.JButton();
        grnHistoryButton = new javax.swing.JButton();
        prnHistoryButton = new javax.swing.JButton();
        salesPanel = new javax.swing.JPanel();
        invoiceButton = new javax.swing.JButton();
        srnButton = new javax.swing.JButton();
        invoiceHistoryButton = new javax.swing.JButton();
        srnHistoryButton = new javax.swing.JButton();
        soButton = new javax.swing.JButton();
        soHistoryButton = new javax.swing.JButton();
        inventoryPanel = new javax.swing.JPanel();
        inventoryButton = new javax.swing.JButton();
        reviewPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        accountButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        helpPanel = new javax.swing.JPanel();
        userManualButton = new javax.swing.JButton();
        versionHistoryButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POS System");

        mainJDPPanel.setOpaque(false);

        mainJDP.setBackground(new java.awt.Color(153, 153, 153));
        mainJDP.setOpaque(false);
        mainJDP.setPreferredSize(new java.awt.Dimension(900, 500));

        javax.swing.GroupLayout mainJDPLayout = new javax.swing.GroupLayout(mainJDP);
        mainJDP.setLayout(mainJDPLayout);
        mainJDPLayout.setHorizontalGroup(
            mainJDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1511, Short.MAX_VALUE)
        );
        mainJDPLayout.setVerticalGroup(
            mainJDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainJDPPanelLayout = new javax.swing.GroupLayout(mainJDPPanel);
        mainJDPPanel.setLayout(mainJDPPanelLayout);
        mainJDPPanelLayout.setHorizontalGroup(
            mainJDPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJDP, javax.swing.GroupLayout.DEFAULT_SIZE, 1511, Short.MAX_VALUE)
        );
        mainJDPPanelLayout.setVerticalGroup(
            mainJDPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJDP, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );

        backgroundLabel.setText(" ");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1511, Short.MAX_VALUE)
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );

        mainPanel.setOpaque(false);

        rightPanel.setOpaque(false);

        infoPanel.setBackground(new java.awt.Color(153, 153, 153));
        infoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 250, 250)));

        infoTitleLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        infoTitleLabel.setText("<info_title>");

        infoDetailsLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        infoDetailsLabel.setText("<info_details>");
        infoDetailsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoDetailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(infoTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(infoTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoDetailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        userSubPanel.setBackground(new java.awt.Color(153, 153, 153));
        userSubPanel.setOpaque(false);

        userIDLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        userIDLabel.setText("User ID");

        userNameLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        userNameLabel.setText("User name");

        roleLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        roleLabel.setText("Role");

        userIDValueLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        userIDValueLabel.setText("<user_id>");

        userNameValueLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        userNameValueLabel.setText("<user_name>");

        roleValueLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        roleValueLabel.setText("<role>");

        javax.swing.GroupLayout userSubPanelLayout = new javax.swing.GroupLayout(userSubPanel);
        userSubPanel.setLayout(userSubPanelLayout);
        userSubPanelLayout.setHorizontalGroup(
            userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIDLabel)
                    .addComponent(userNameLabel)
                    .addComponent(roleLabel))
                .addGroup(userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSubPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(roleValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(userSubPanelLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(userNameValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(userSubPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                            .addComponent(userIDValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        userSubPanelLayout.setVerticalGroup(
            userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIDLabel)
                    .addComponent(userIDValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleLabel)
                    .addComponent(roleValueLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoPanel.setBackground(new java.awt.Color(153, 153, 153));
        logoPanel.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/tech_lobby_banner_small.png"))); // NOI18N

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userSubPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userSubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        ribbonTabbedPane.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        homePanel.setOpaque(false);
        homePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                homePanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                homePanelComponentShown(evt);
            }
        });

        itemsButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        itemsButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/items_button_dark.png"))); // NOI18N
        itemsButton.setText("Items");
        itemsButton.setBorder(null);
        itemsButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        itemsButton.setOpaque(false);
        itemsButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/items_button_light.png"))); // NOI18N
        itemsButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/items_button_light.png"))); // NOI18N

        itemListsButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        itemListsButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/item_lists_button_dark.png"))); // NOI18N
        itemListsButton.setText("Item lists");
        itemListsButton.setBorder(null);
        itemListsButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        itemListsButton.setOpaque(false);
        itemListsButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/item_lists_button_light.png"))); // NOI18N
        itemListsButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/item_lists_button_light.png"))); // NOI18N

        employeesButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        employeesButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/employees_button_dark.png"))); // NOI18N
        employeesButton.setText("Employees");
        employeesButton.setBorder(null);
        employeesButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        employeesButton.setOpaque(false);
        employeesButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/employees_button_light.png"))); // NOI18N
        employeesButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/employees_button_light.png"))); // NOI18N

        suppliersButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        suppliersButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/suppliers_button_dark.png"))); // NOI18N
        suppliersButton.setText("Suppliers");
        suppliersButton.setBorder(null);
        suppliersButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        suppliersButton.setOpaque(false);
        suppliersButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/suppliers_button_light.png"))); // NOI18N
        suppliersButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/suppliers_button_light.png"))); // NOI18N

        customersButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        customersButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/customers_button_dark.png"))); // NOI18N
        customersButton.setText("Customers");
        customersButton.setBorder(null);
        customersButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        customersButton.setOpaque(false);
        customersButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/customers_button_light.png"))); // NOI18N
        customersButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/customers_button_light.png"))); // NOI18N

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(itemsButton)
                .addGap(18, 18, 18)
                .addComponent(itemListsButton)
                .addGap(18, 18, 18)
                .addComponent(suppliersButton)
                .addGap(18, 18, 18)
                .addComponent(employeesButton)
                .addGap(18, 18, 18)
                .addComponent(customersButton)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemsButton)
                    .addComponent(itemListsButton)
                    .addComponent(employeesButton)
                    .addComponent(customersButton)
                    .addComponent(suppliersButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ribbonTabbedPane.addTab("HOME", homePanel);

        purchasePanel.setOpaque(false);
        purchasePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                purchasePanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                purchasePanelComponentShown(evt);
            }
        });

        poButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        poButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/po_button_dark.png"))); // NOI18N
        poButton.setText("Purchase order");
        poButton.setBorder(null);
        poButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        poButton.setOpaque(false);
        poButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/po_button_light.png"))); // NOI18N
        poButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/po_button_light.png"))); // NOI18N

        grnButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        grnButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/grn_button_dark.png"))); // NOI18N
        grnButton.setText("Good receive note");
        grnButton.setBorder(null);
        grnButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        grnButton.setOpaque(false);
        grnButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/grn_button_light.png"))); // NOI18N
        grnButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/grn_button_light.png"))); // NOI18N

        prnButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prnButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/prn_button_dark.png"))); // NOI18N
        prnButton.setText("Purchase return note");
        prnButton.setBorder(null);
        prnButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        prnButton.setOpaque(false);
        prnButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/prn_button_light.png"))); // NOI18N
        prnButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/prn_button_light.png"))); // NOI18N

        poHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        poHistoryButton.setText("PO history");
        poHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        poHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        poHistoryButton.setOpaque(false);
        poHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                poHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                poHistoryButtonMouseExited(evt);
            }
        });

        grnHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        grnHistoryButton.setText("GRN history");
        grnHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        grnHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        grnHistoryButton.setOpaque(false);
        grnHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grnHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                grnHistoryButtonMouseExited(evt);
            }
        });

        prnHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prnHistoryButton.setText("PRN history");
        prnHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        prnHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        prnHistoryButton.setOpaque(false);
        prnHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prnHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prnHistoryButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout purchasePanelLayout = new javax.swing.GroupLayout(purchasePanel);
        purchasePanel.setLayout(purchasePanelLayout);
        purchasePanelLayout.setHorizontalGroup(
            purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchasePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(poButton)
                .addGap(18, 18, 18)
                .addComponent(grnButton)
                .addGap(18, 18, 18)
                .addComponent(prnButton)
                .addGap(18, 18, 18)
                .addComponent(poHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(grnHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prnHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        purchasePanelLayout.setVerticalGroup(
            purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchasePanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prnButton)
                    .addComponent(grnButton)
                    .addComponent(poButton)
                    .addComponent(poHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prnHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ribbonTabbedPane.addTab("PURCHASE", purchasePanel);

        salesPanel.setOpaque(false);
        salesPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                salesPanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                salesPanelComponentShown(evt);
            }
        });

        invoiceButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        invoiceButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/invoice_button_dark.png"))); // NOI18N
        invoiceButton.setText("Invoice");
        invoiceButton.setBorder(null);
        invoiceButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        invoiceButton.setOpaque(false);
        invoiceButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/so_button_light.png"))); // NOI18N
        invoiceButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/invoice_button_light.png"))); // NOI18N

        srnButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        srnButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/srn_button_dark.png"))); // NOI18N
        srnButton.setText("Sales return note");
        srnButton.setBorder(null);
        srnButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        srnButton.setOpaque(false);
        srnButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/srn_button_light.png"))); // NOI18N
        srnButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/srn_button_light.png"))); // NOI18N

        invoiceHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        invoiceHistoryButton.setText("Invoice history");
        invoiceHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        invoiceHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        invoiceHistoryButton.setOpaque(false);
        invoiceHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceHistoryButtonMouseExited(evt);
            }
        });

        srnHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        srnHistoryButton.setText("SRN history");
        srnHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        srnHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        srnHistoryButton.setOpaque(false);
        srnHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                srnHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                srnHistoryButtonMouseExited(evt);
            }
        });

        soButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        soButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/so_button_dark.png"))); // NOI18N
        soButton.setText("Sales order");
        soButton.setBorder(null);
        soButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        soButton.setOpaque(false);
        soButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/so_button_light.png"))); // NOI18N
        soButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/so_button_light.png"))); // NOI18N

        soHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        soHistoryButton.setText("SO history");
        soHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        soHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        soHistoryButton.setOpaque(false);
        soHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soHistoryButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(soButton)
                .addGap(18, 18, 18)
                .addComponent(invoiceButton)
                .addGap(18, 18, 18)
                .addComponent(srnButton)
                .addGap(18, 18, 18)
                .addComponent(soHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(invoiceHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(srnHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceButton)
                    .addComponent(srnButton)
                    .addComponent(invoiceHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srnHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soButton)
                    .addComponent(soHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ribbonTabbedPane.addTab("SALES", salesPanel);

        inventoryPanel.setOpaque(false);
        inventoryPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                inventoryPanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                inventoryPanelComponentShown(evt);
            }
        });

        inventoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        inventoryButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/inventory_button_dark.png"))); // NOI18N
        inventoryButton.setText("Inventory");
        inventoryButton.setBorder(null);
        inventoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        inventoryButton.setOpaque(false);
        inventoryButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/inventory_button_light.png"))); // NOI18N
        inventoryButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/inventory_button_light.png"))); // NOI18N

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(inventoryButton)
                .addContainerGap(1067, Short.MAX_VALUE))
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(inventoryButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ribbonTabbedPane.addTab("INVENTORY", inventoryPanel);

        reviewPanel.setOpaque(false);
        reviewPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                reviewPanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                reviewPanelComponentShown(evt);
            }
        });

        javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
        reviewPanel.setLayout(reviewPanelLayout);
        reviewPanelLayout.setHorizontalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1188, Short.MAX_VALUE)
        );
        reviewPanelLayout.setVerticalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        ribbonTabbedPane.addTab("REVIEW", reviewPanel);

        userPanel.setOpaque(false);
        userPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                userPanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                userPanelComponentShown(evt);
            }
        });

        accountButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        accountButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/account_button_dark.png"))); // NOI18N
        accountButton.setText("Account");
        accountButton.setBorder(null);
        accountButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        accountButton.setOpaque(false);
        accountButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/account_button_light.png"))); // NOI18N
        accountButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/account_button_light.png"))); // NOI18N

        settingsButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        settingsButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/settings_button_dark.png"))); // NOI18N
        settingsButton.setText("Settings");
        settingsButton.setBorder(null);
        settingsButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        settingsButton.setOpaque(false);
        settingsButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/settings_button_light.png"))); // NOI18N
        settingsButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/settings_button_light.png"))); // NOI18N

        logOutButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        logOutButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/log_out_button_dark.png"))); // NOI18N
        logOutButton.setText("Log out");
        logOutButton.setBorder(null);
        logOutButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        logOutButton.setOpaque(false);
        logOutButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/log_out_button_light.png"))); // NOI18N
        logOutButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/log_out_button_light.png"))); // NOI18N

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(accountButton)
                .addGap(18, 18, 18)
                .addComponent(settingsButton)
                .addGap(18, 18, 18)
                .addComponent(logOutButton)
                .addContainerGap(863, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logOutButton)
                    .addComponent(accountButton)
                    .addComponent(settingsButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        ribbonTabbedPane.addTab("USER", userPanel);

        helpPanel.setOpaque(false);
        helpPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                helpPanelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                helpPanelComponentShown(evt);
            }
        });

        userManualButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        userManualButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/user_manual_button_dark.png"))); // NOI18N
        userManualButton.setText("User manual");
        userManualButton.setBorder(null);
        userManualButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        userManualButton.setOpaque(false);
        userManualButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/user_manual_button_light.png"))); // NOI18N
        userManualButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/user_manual_button_light.png"))); // NOI18N

        versionHistoryButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        versionHistoryButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/version_history_button_dark.png"))); // NOI18N
        versionHistoryButton.setText("Version history");
        versionHistoryButton.setBorder(null);
        versionHistoryButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        versionHistoryButton.setOpaque(false);
        versionHistoryButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/version_history_button_light.png"))); // NOI18N
        versionHistoryButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/version_history_button_light.png"))); // NOI18N

        aboutButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        aboutButton.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/about_button_dark.png"))); // NOI18N
        aboutButton.setText("About");
        aboutButton.setBorder(null);
        aboutButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        aboutButton.setOpaque(false);
        aboutButton.setPressedIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/about_button_light.png"))); // NOI18N
        aboutButton.setRolloverIcon(new javax.swing.ImageIcon(ClassLoader.getSystemClassLoader().getResource("icon/about_button_light.png"))); // NOI18N

        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(userManualButton)
                .addGap(18, 18, 18)
                .addComponent(versionHistoryButton)
                .addGap(18, 18, 18)
                .addComponent(aboutButton)
                .addContainerGap(809, Short.MAX_VALUE))
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutButton)
                    .addComponent(versionHistoryButton)
                    .addComponent(userManualButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ribbonTabbedPane.addTab("HELP", helpPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(ribbonTabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(ribbonTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(674, Short.MAX_VALUE))
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainLayeredPane.setLayer(mainJDPPanel, 3);
        mainLayeredPane.setLayer(backgroundPanel, 1);
        mainLayeredPane.setLayer(mainPanel, 2);

        javax.swing.GroupLayout mainLayeredPaneLayout = new javax.swing.GroupLayout(mainLayeredPane);
        mainLayeredPane.setLayout(mainLayeredPaneLayout);
        mainLayeredPaneLayout.setHorizontalGroup(
            mainLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJDPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainLayeredPaneLayout.setVerticalGroup(
            mainLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJDPPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLayeredPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLayeredPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homePanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_homePanelComponentShown
        ribbonTabbedPane.setIconAt(0, homeIconLight);
    }//GEN-LAST:event_homePanelComponentShown

    private void purchasePanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_purchasePanelComponentShown
        ribbonTabbedPane.setIconAt(1, purchaseIconLight);
    }//GEN-LAST:event_purchasePanelComponentShown

    private void purchasePanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_purchasePanelComponentHidden
        ribbonTabbedPane.setIconAt(1, purchaseIconDark);
    }//GEN-LAST:event_purchasePanelComponentHidden

    private void salesPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_salesPanelComponentShown
        ribbonTabbedPane.setIconAt(2, salesIconLight);
    }//GEN-LAST:event_salesPanelComponentShown

    private void salesPanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_salesPanelComponentHidden
        ribbonTabbedPane.setIconAt(2, salesIconDark);
    }//GEN-LAST:event_salesPanelComponentHidden

    private void inventoryPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_inventoryPanelComponentShown
        ribbonTabbedPane.setIconAt(3, inventoryIconLight);
    }//GEN-LAST:event_inventoryPanelComponentShown

    private void inventoryPanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_inventoryPanelComponentHidden
        ribbonTabbedPane.setIconAt(3, inventoryIconDark);
    }//GEN-LAST:event_inventoryPanelComponentHidden

    private void reviewPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_reviewPanelComponentShown
        ribbonTabbedPane.setIconAt(4, reviewIconLight);
    }//GEN-LAST:event_reviewPanelComponentShown

    private void reviewPanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_reviewPanelComponentHidden
        ribbonTabbedPane.setIconAt(4, reviewIconDark);
    }//GEN-LAST:event_reviewPanelComponentHidden

    private void userPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_userPanelComponentShown
        ribbonTabbedPane.setIconAt(5, userIconLight);
    }//GEN-LAST:event_userPanelComponentShown

    private void userPanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_userPanelComponentHidden
        ribbonTabbedPane.setIconAt(5, userIconDark);
    }//GEN-LAST:event_userPanelComponentHidden

    private void homePanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_homePanelComponentHidden
        ribbonTabbedPane.setIconAt(0, homeIconDark);
    }//GEN-LAST:event_homePanelComponentHidden

    private void helpPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_helpPanelComponentShown
        ribbonTabbedPane.setIconAt(6, helpIconLight);
    }//GEN-LAST:event_helpPanelComponentShown

    private void helpPanelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_helpPanelComponentHidden
        ribbonTabbedPane.setIconAt(6, helpIconDark);
    }//GEN-LAST:event_helpPanelComponentHidden

    private void poHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poHistoryButtonMouseEntered
        this.poHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.poHistoryButton.setForeground(Color.BLACK);
        this.poHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }//GEN-LAST:event_poHistoryButtonMouseEntered

    private void poHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poHistoryButtonMouseExited
        this.poHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.poHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.poHistoryButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_poHistoryButtonMouseExited

    private void grnHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnHistoryButtonMouseEntered
        this.grnHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.grnHistoryButton.setForeground(Color.BLACK);
        this.grnHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }//GEN-LAST:event_grnHistoryButtonMouseEntered

    private void grnHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnHistoryButtonMouseExited
        this.grnHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.grnHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.grnHistoryButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_grnHistoryButtonMouseExited

    private void prnHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prnHistoryButtonMouseEntered
        this.prnHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.prnHistoryButton.setForeground(Color.BLACK);
        this.prnHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }//GEN-LAST:event_prnHistoryButtonMouseEntered

    private void prnHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prnHistoryButtonMouseExited
        this.prnHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.prnHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.prnHistoryButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_prnHistoryButtonMouseExited

    private void soHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soHistoryButtonMouseEntered
        this.soHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.soHistoryButton.setForeground(Color.BLACK);
        this.soHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }//GEN-LAST:event_soHistoryButtonMouseEntered

    private void soHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soHistoryButtonMouseExited
        this.soHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.soHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.soHistoryButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_soHistoryButtonMouseExited

    private void invoiceHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceHistoryButtonMouseEntered
        this.invoiceHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.invoiceHistoryButton.setForeground(Color.BLACK);
        this.invoiceHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }//GEN-LAST:event_invoiceHistoryButtonMouseEntered

    private void invoiceHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceHistoryButtonMouseExited
        this.invoiceHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.invoiceHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.invoiceHistoryButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_invoiceHistoryButtonMouseExited

    private void srnHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srnHistoryButtonMouseEntered
        this.srnHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.srnHistoryButton.setForeground(Color.BLACK);
        this.srnHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }//GEN-LAST:event_srnHistoryButtonMouseEntered

    private void srnHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srnHistoryButtonMouseExited
        this.srnHistoryButton.setBackground(ColourPalatte.DARK_BLUE);
        this.srnHistoryButton.setForeground(ColourPalatte.BRIGHT_WHITE);
        this.srnHistoryButton.setBorder(BorderFactory.createLineBorder(ColourPalatte.BRIGHT_WHITE, 1));
    }//GEN-LAST:event_srnHistoryButtonMouseExited

    //Home tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void addItemsButtonActionlistener(ActionListener al){
        this.itemsButton.addActionListener(al);
    }
    
    public void addItemListsButtonActionlistener(ActionListener al){
        this.itemListsButton.addActionListener(al);
    }
    
    public void addSuppliersButtonActionlistener(ActionListener al){
        this.suppliersButton.addActionListener(al);
    }
    
    public void addEmployeesButtonActionlistener(ActionListener al){
        this.employeesButton.addActionListener(al);
    }
    
    public void addCustomersButtonActionlistener(ActionListener al){
        this.customersButton.addActionListener(al);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Purchase tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void addPOButtonActionlistener(ActionListener al){
        this.poButton.addActionListener(al);
    }
    
    public void addGRNButtonActionlistener(ActionListener al){
        this.grnButton.addActionListener(al);
    }
    
    public void addPRNButtonActionlistener(ActionListener al){
        this.prnButton.addActionListener(al);
    }
    
    public void addPOHistoryButtonActionlistener(ActionListener al){
        this.poHistoryButton.addActionListener(al);
    }
    
    public void addGRNHistoryButtonActionlistener(ActionListener al){
        this.grnHistoryButton.addActionListener(al);
    }
    
    public void addPRNHistoryButtonActionlistener(ActionListener al){
        this.prnHistoryButton.addActionListener(al);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Sales tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void addSOButtonActionlistener(ActionListener al){
        this.soButton.addActionListener(al);
    }
    
    public void addInvoiceButtonActionlistener(ActionListener al){
        this.invoiceButton.addActionListener(al);
    }
    
    public void addSRNButtonActionlistener(ActionListener al){
        this.srnButton.addActionListener(al);
    }
    
    public void addSOHistoryButtonActionlistener(ActionListener al){
        this.soHistoryButton.addActionListener(al);
    }
    
    public void addInvoiceHistoryButtonActionlistener(ActionListener al){
        this.invoiceHistoryButton.addActionListener(al);
    }
    
    public void addSRNHistoryButtonActionlistener(ActionListener al){
        this.srnHistoryButton.addActionListener(al);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Inventory tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void addInventoryButtonActionListener(ActionListener al){
        this.inventoryButton.addActionListener(al);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Review tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //User tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void addAccountButtonActionlistener(ActionListener al){
        this.accountButton.addActionListener(al);
    }
    
    public void addSettingsButtonActionlistener(ActionListener al){
        this.settingsButton.addActionListener(al);
    }
    
    public void addLogOutButtonActionlistener(ActionListener al){
        this.logOutButton.addActionListener(al);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Help tab>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void  addUserManualButtonActionListener(ActionListener al){
        this.userManualButton.addActionListener(al);
    }
    
    public void addVersionHistoryButtonActionListener(ActionListener al){
        this.versionHistoryButton.addActionListener(al);
    }
    
    public void addAboutButtonActionListener(ActionListener al){
        this.aboutButton.addActionListener(al);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    @Override
    public void updateViewInternalFrameListener(InternalFrameListener ifl) {}
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton accountButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton customersButton;
    private javax.swing.JButton employeesButton;
    private javax.swing.JButton grnButton;
    private javax.swing.JButton grnHistoryButton;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JPanel homePanel;
    javax.swing.JLabel infoDetailsLabel;
    private javax.swing.JPanel infoPanel;
    javax.swing.JLabel infoTitleLabel;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JButton invoiceButton;
    private javax.swing.JButton invoiceHistoryButton;
    private javax.swing.JButton itemListsButton;
    private javax.swing.JButton itemsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel logoPanel;
    javax.swing.JDesktopPane mainJDP;
    private javax.swing.JPanel mainJDPPanel;
    private javax.swing.JLayeredPane mainLayeredPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton poButton;
    private javax.swing.JButton poHistoryButton;
    private javax.swing.JButton prnButton;
    private javax.swing.JButton prnHistoryButton;
    private javax.swing.JPanel purchasePanel;
    private javax.swing.JPanel reviewPanel;
    private javax.swing.JTabbedPane ribbonTabbedPane;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel roleLabel;
    javax.swing.JLabel roleValueLabel;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton soButton;
    private javax.swing.JButton soHistoryButton;
    private javax.swing.JButton srnButton;
    private javax.swing.JButton srnHistoryButton;
    private javax.swing.JButton suppliersButton;
    private javax.swing.JLabel userIDLabel;
    javax.swing.JLabel userIDValueLabel;
    private javax.swing.JButton userManualButton;
    private javax.swing.JLabel userNameLabel;
    javax.swing.JLabel userNameValueLabel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel userSubPanel;
    private javax.swing.JButton versionHistoryButton;
    // End of variables declaration//GEN-END:variables
}
