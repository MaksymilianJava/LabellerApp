/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IPZappWindow;

import static IPZappWindow.CreateNewConfWindow.configurationsListDir;
import static IPZappWindow.EditLabelersListWindow.labellersListFile;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import org.json.*;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lenovo
 */
public class labellerApp extends javax.swing.JFrame {
    //Zmienna globalna do sprawdzenia czy okno edycji etykieciarek jest otwarte
    private boolean ifEditLabellersOpened = false;
    //Zmienna globalna do sprawdzenia czy aktywne jest połączenie z etykieciarką
    private boolean ifConnected = false;
    //Globalna lista etykieciarek zapisanych na komputerze
    private List labellersList = new ArrayList<Labeller>();
    //Model listy do obsługi wyświetlanej listy konfiguracji zapisanych na komputerze
    private DefaultListModel computerConfigListModel = new DefaultListModel();
    //Model listy do obsługi wyświetlanej listy konfiguracji zapisanych na połączonej etykieciarce
    private DefaultListModel labellerConfigListModel = new DefaultListModel();
    //Model listy do obsługi wyświetlanej listy statystyk konfiguracji zapisanych na połączonej etykieciarce
    private DefaultListModel labellerConfigStatsListModel = new DefaultListModel();
    //Globalna lista konfiguracji zapisanych na komputerze
    private List computerConfigList = new ArrayList<Configuration>();
    //Globalna lista konfiguracji zapisanych na połączonej etykieciarce
    private List labellerConfigList = new ArrayList<Configuration>();
    //Globalna lista statystyk konfiguracji zapisanych na połączonej etykieciarce
    private List labellerConfigStatsList = new ArrayList<ConfigurationStats>();
    //Globalna zmienna przechowujące adres IP etykieciarki wybranej z rozwijanej listy
    private String chosenLabellerIPAddress;
    //Globalna stała przechowująca nazwę sterownika SQL
    private static String SQLDriver = "com.mysql.cj.jdbc.Driver";
    //Globalna zmienna do przechowywania puli połączeń z bazą danych
    private ConnectionPool connectionPool;
    //Globalna stała zawierająca nazwę użytkownika do logowania do bazy danyc
    private static String DATABASE_USER = "pracownik";
    //Globalna stała zawierająca hasło do logowania do bazy danych
    private static String DATABASE_PASSWORD = "etykieciarka";
    //Globalna zmienna przechowująca panel szklany (przezroczysty) blokujący działanie przycisków przy oczekiwaniu na odpowiedź programu
    JPanel glass = new JPanel(new GridLayout(0, 1)); 
    //Etykieta dodawana do panelu szklanego do przenoszenia fokusu
    JLabel padding = new JLabel();
    //Timer do pomiaru czasu aby przechwycić kliknięcia przy oczekiwaniu na odpowiedź programu
    Timer timer;

    /**
     * Konstruktor klasy do tworzenia nowego okna
     */
    public labellerApp() {
        initComponents();//Inicjalizacja komponentów okna
        updateLabellersComboBox(); //Aktualizacja listy rozwijanej etykieciarek
        updateComputerConfigList(); //Aktualizacja listy konfiguracji zapisanych na komputerze
        glass.setOpaque(false); //Ustawienie przezroczystości panelu szklanego
        glass.add(padding); //Dodanie do panelu szklanego etykiety padding
        glass.addMouseListener(new MouseAdapter() {}); //Dodanie do panelu szklanego obsługi kliknięć myszki
        glass.addMouseMotionListener(new MouseMotionAdapter() {}); //Dodanie do panelu szklanego obsługi ruchów myszki
        glass.addKeyListener(new KeyAdapter() {}); //Dodanie do panelu szklanego obsługi klawiszów klawiatury
        this.setGlassPane(glass); //Ustawienie panelu szklanego dla okna aplikacji
        //Dodanie obsługi okna, rozłączenie z bazą danych przy zamknięciu okna
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e) 
            {
                disconnect();
            }
        });
    }

    /**
     * Kod wygenerowany za pomocą kreatora tworzący zawartość okna
     * oraz ustawiający odpowiednie parametry elementów okna
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editLabListButton = new javax.swing.JButton();
        newConfButton = new javax.swing.JButton();
        confStatsPane = new javax.swing.JTabbedPane();
        confPanel = new javax.swing.JPanel();
        downloadConfButton = new javax.swing.JButton();
        removeLabelConfButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        labellerConfigListWindow = new javax.swing.JList<>(labellerConfigListModel);
        jLabel6 = new javax.swing.JLabel();
        updateConfListButton = new javax.swing.JButton();
        statsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        statsConfigListWindow = new javax.swing.JList<>(labellerConfigStatsListModel);
        jLabel2 = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        stopDateTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        info1TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        info2TextField = new javax.swing.JTextField();
        info3TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        updateStatsButton = new javax.swing.JButton();
        connectPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        computerConfigListWindow = new javax.swing.JList<>(computerConfigListModel);
        sendConfButton = new javax.swing.JButton();
        removeCompConfButton = new javax.swing.JButton();
        editConfButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        connStatusPanel = new StatusPanel();
        labellersComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Labellers manager");
        setIconImage(new ImageIcon("label printer.png").getImage());
        setLocationByPlatform(true);
        setResizable(false);

        editLabListButton.setText("Edit labellers list");
        editLabListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLabListButtonActionPerformed(evt);
            }
        });

        newConfButton.setText("Create new cofiguration");
        newConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newConfButtonActionPerformed(evt);
            }
        });

        confStatsPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        downloadConfButton.setText("Download");
        downloadConfButton.setToolTipText("Download configuration from labeller");
        downloadConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadConfButtonActionPerformed(evt);
            }
        });

        removeLabelConfButton.setText("Remove");
        removeLabelConfButton.setToolTipText("Remove configuration from labeller");
        removeLabelConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLabelConfButtonActionPerformed(evt);
            }
        });

        labellerConfigListWindow.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(labellerConfigListWindow);

        jLabel6.setText("Configurations on labeller");

        updateConfListButton.setText("Update");
        updateConfListButton.setToolTipText("Download configuration from labeller");
        updateConfListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateConfListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confPanelLayout = new javax.swing.GroupLayout(confPanel);
        confPanel.setLayout(confPanelLayout);
        confPanelLayout.setHorizontalGroup(
            confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confPanelLayout.createSequentialGroup()
                        .addComponent(downloadConfButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateConfListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeLabelConfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(confPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        confPanelLayout.setVerticalGroup(
            confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(downloadConfButton)
                    .addComponent(removeLabelConfButton)
                    .addComponent(updateConfListButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        confStatsPane.addTab("Configurations", confPanel);

        statsConfigListWindow.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        statsConfigListWindow.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                statsConfigListWindowValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(statsConfigListWindow);

        jLabel2.setText("Start date:");

        jLabel3.setText("Stop date:");

        jLabel4.setText("Information 1:");

        jLabel5.setText("Information 2:");

        jLabel8.setText("Information 3:");

        updateStatsButton.setText("Update");
        updateStatsButton.setToolTipText("");
        updateStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(info3TextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(info2TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(startDateTextField)
                            .addComponent(stopDateTextField)
                            .addComponent(info1TextField))))
                .addContainerGap())
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(updateStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stopDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(info1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(info2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(info3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateStatsButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        confStatsPane.addTab("Statistics", statsPanel);

        connectPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        computerConfigListWindow.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(computerConfigListWindow);

        sendConfButton.setText("Send");
        sendConfButton.setToolTipText("Send configuration to labeller");
        sendConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendConfButtonActionPerformed(evt);
            }
        });

        removeCompConfButton.setText("Remove");
        removeCompConfButton.setToolTipText("Remove configuration from computer");
        removeCompConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompConfButtonActionPerformed(evt);
            }
        });

        editConfButton.setText("Edit");
        editConfButton.setToolTipText("Edit configuration");
        editConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editConfButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Configurations on computer");

        javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
        connectPanel.setLayout(connectPanelLayout);
        connectPanelLayout.setHorizontalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addComponent(editConfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeCompConfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendConfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        connectPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editConfButton, removeCompConfButton, sendConfButton});

        connectPanelLayout.setVerticalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editConfButton)
                    .addComponent(removeCompConfButton)
                    .addComponent(sendConfButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout connStatusPanelLayout = new javax.swing.GroupLayout(connStatusPanel);
        connStatusPanel.setLayout(connStatusPanelLayout);
        connStatusPanelLayout.setHorizontalGroup(
            connStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );
        connStatusPanelLayout.setVerticalGroup(
            connStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Choose labeller to connect:");

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labellersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(editLabListButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newConfButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confStatsPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(connStatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labellersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disconnectButton)
                .addGap(26, 26, 26)
                .addComponent(newConfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editLabListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(confStatsPane)
            .addComponent(connectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        confStatsPane.getAccessibleContext().setAccessibleName("Konfiguracje");

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Obsługa kliknięcia przycisku edycji listy etykieciarek
    private void editLabListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLabListButtonActionPerformed
        //Sprawdzenie czy okno edycji nie jest już otwarte, jeśli nie to wykonanie kolejnych linii kodu
        if(ifEditLabellersOpened == false) 
        {
            //Stworzenie nowego okna edytora listy etykieciarek i zablokowanie możliwościa otwarcie więcej niż 1 okna
            EditLabelersListWindow window = new EditLabelersListWindow();
            ifEditLabellersOpened = true;
            window.setVisible(true);
            //Dodanie obsługi okna, przy zamknięciu odblokowanie możliwości otwarcia okna i aktualizacja listy etykieciarek
            window.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) 
                {
                    ifEditLabellersOpened = false;
                    updateLabellersComboBox();
                }
            });
        }
    }//GEN-LAST:event_editLabListButtonActionPerformed
//Obsługa kliknięcia przycisku tworzenia nowej konfiguracji
    private void newConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newConfButtonActionPerformed
        //Stworzenie nowego okna kreatora konfiguracji
        CreateNewConfWindow newWindow = new CreateNewConfWindow();
        //Dodanie obsługi okna, przy zamknięciu aktualizacja listy konfiguracji zapisanych na komputerze
        newWindow.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) 
            {
                updateComputerConfigList();
            }
        });
        newWindow.setVisible(true);
    }//GEN-LAST:event_newConfButtonActionPerformed

//Obsługa kliknięcia przycisku usunięcia konfiguracji z komputera
    private void removeCompConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCompConfButtonActionPerformed
        //Pobranie indeksu oraz nazwy elementu wybranego z listy konfiguracji zapisanych na komputerze, jeśli nic nie jest wybrane to powrót
        String selectedConf = computerConfigListWindow.getSelectedValue();
        int selectedConfIndex = computerConfigListWindow.getSelectedIndex();
        if(selectedConf == null)
            return;
        //Usunięcie konfiguracji z danym indeskem z listy konfiguracji na komputerze
        computerConfigList.remove(selectedConfIndex);
        //Utworzenie zmiennej typu plik o nazwie takiej jak nazwa wybranej konfiguracji z rozszerzeniem .labconf w
        //lokalizacji, gdzie przechowywane są wszystkie konfiguracje
        File fileToRemove = new File(CreateNewConfWindow.configurationsListDir, new String(selectedConf + ".labconf"));
        //Jeśli taki plik istnieje to usunięcie
        if(fileToRemove.exists())
        {
            fileToRemove.delete();
        }
        //Aktualizacja listy konfiguracji zapisanych na komputerze
        updateComputerConfigList();
    }//GEN-LAST:event_removeCompConfButtonActionPerformed

    private void editConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editConfButtonActionPerformed
        String selectedConf = computerConfigListWindow.getSelectedValue();
        if(selectedConf == null)
        {
            JOptionPane.showMessageDialog(rootPane, "You do not choose file to edit");
        }
        else
        {    
            String[] zapisParametrow= new String[9];
            try 
            {
                //System.out.print(selectedConf);
                BufferedReader plik = new BufferedReader(new FileReader(CreateNewConfWindow.configurationsListDir + 
                        File.separator+ selectedConf + ".labconf"));
                String dane;
                String[] parametry = null;
                String[] tabPom = null;
                while((dane=plik.readLine())!= null)
                {
                    parametry= dane.split(",");
                }
                for(int i=0; i< parametry.length; i++) 
                {
                    System.out.println(parametry[i]);
                }
                System.out.println(parametry.length);
                for(int i=0; i< parametry.length; i++) 
                {
                    int pom;
                    tabPom = parametry[i].split(":");
                    if(i<parametry.length-2)
                    {  
                        pom = tabPom[1].length();
                        zapisParametrow[i]= tabPom[1].substring(1, pom);
                    }
                    else if(i == parametry.length-2)
                    {
                        pom = tabPom[1].length()-1;
                        zapisParametrow[i]= tabPom[1].substring(2, pom);
                    }
                    else
                    {
                        pom = tabPom[1].length()-3;
                        zapisParametrow[i]= tabPom[1].substring(2, pom);
                    }
                }
                plik.close();
            }
            catch (IOException e) 
            {
                System.out.println(e.getMessage());
            }
            CreateNewConfWindow newWindow = new CreateNewConfWindow(zapisParametrow[0], zapisParametrow[1], zapisParametrow[3], zapisParametrow[2],
                                                                        zapisParametrow[4], zapisParametrow[5], zapisParametrow[6],zapisParametrow[7],zapisParametrow[8]);
            newWindow.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) 
            {
                updateComputerConfigList();
            }
            });
            newWindow.setVisible(true);
        }
    }//GEN-LAST:event_editConfButtonActionPerformed
//Obsługa przycisku wysłania konfiguracji z komputera do etykieciarki
    private void sendConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendConfButtonActionPerformed
        //Pobranie indeksu elementu wybranego z listy konfiguracji na komputerze, jeśli nic nie jest wybrane, to powrót
        int selectedConfIndex = computerConfigListWindow.getSelectedIndex();
        if(selectedConfIndex == -1)
            return;
        //Sprawdzenie czy nastąpiło połączenie z etykieciarką, jeśli tak to wykonanie kodu
        if(ifConnected)
        {
            //Włączenie panelu szklanego do zbierania kliknięć
            glass.setVisible(true);
            padding.requestFocus();
            //Uruchomienie metody do wysłania konfiguracji do etykieciarki z indeksem jako parametrem
            sendConfigurationToLabeller(selectedConfIndex);
            //Aktualizacja listy konfiguracji na etykieciarce
            updateLabellerConfigList();
            //Uruchomienie timera, który odmierzy czas potrzebny na zebranie kliknięć i wyłączy panel szklany
            startGlassTimer();
        }   
    }//GEN-LAST:event_sendConfButtonActionPerformed
//Obsługa kliknięcia przycisku connect
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        //Pobranie indeksu elementu wybranego z listy konfiguracji na komputerze, jeśli nic nie jest wybrane, to powrót
        int selectedIndex = labellersComboBox.getSelectedIndex();
        if(selectedIndex == -1)
            return;
        //Zapisanie adresu IP wybranej etykieciarki do globalnej zmiennej
        chosenLabellerIPAddress = ((Labeller)labellersList.get(selectedIndex)).getIPAddress();
        //Włączenie panelu szklanego do zbierania kliknięć
        glass.setVisible(true);
        padding.requestFocus();
        //Próba połączenia z etykieciarką i zapisanie statusu połączenia do zmiennej
        int status = checkDBConnection();
        //Aktualizacja panelu przedstawiającego ikonę stanu połączenia z etykieciarką
        ((StatusPanel)connStatusPanel).updateStatus(status);
        //Jeśli połączono to aktualizacja listy konfiguracji zapisanych na etykiecarce i aktualizacja jej statystyk
        if(status == 1)
        {
            updateLabellerConfigList();
            updateLabellerStats();
        }
        //Uruchomienie timera, który odmierzy czas potrzebny na zebranie kliknięć i wyłączy panel szklany
        startGlassTimer();
    }//GEN-LAST:event_connectButtonActionPerformed
//Obsługa przycisku disconnect
    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        //Uruchom funkcję rozłączenia z etykieciarką
        disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed
//Obsługa zmiany wyboru na liście konfiguracji w zakładce statystyk
    private void statsConfigListWindowValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_statsConfigListWindowValueChanged
        //Pobranie indeksu elementu wybranego z listy
        int selectedIndex = statsConfigListWindow.getSelectedIndex();
        //Jeśli coś jest wybrane, to uruchomienie metody do wyświetlenia statystyk wybranej konfiguracji
        if(selectedIndex != -1)
            displayStats(((ConfigurationStats)labellerConfigStatsList.get(selectedIndex)));
    }//GEN-LAST:event_statsConfigListWindowValueChanged
//Obsługa przycisku aktulizacji statystyk
    private void updateStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatsButtonActionPerformed
        //Sprawdzenie czy jest aktywne połączenie z etykieciarką, jeśli tak to wykonanie kodu w klamrach if
        if(ifConnected)
        {
            //Włączenie panelu szklanego do zbierania kliknięć
            glass.setVisible(true);
            padding.requestFocus();
            //Uruchomienie metody aktualizacji statystyk
            updateLabellerStats();
            //Uruchomienie timera, który odmierzy czas potrzebny na zebranie kliknięć i wyłączy panel szklany
            startGlassTimer();
        }
        //Pobranie indeksu elementu wybranego z listy
        int selectedIndex = statsConfigListWindow.getSelectedIndex();
        //Jeśli coś jest wybrane, to uruchomienie metody do wyświetlenia statystyk wybranej konfiguracji
        if(selectedIndex != -1)
            displayStats(((ConfigurationStats)labellerConfigStatsList.get(selectedIndex)));
    }//GEN-LAST:event_updateStatsButtonActionPerformed
//Obsługa przycisku aktualizacji listy konfiguracji z etykieciarki
    private void updateConfListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateConfListButtonActionPerformed
        //Sprawdzenie czy jest aktywne połączenie z etykieciarką, jeśli tak to wykonanie kodu w klamrach if
        if(ifConnected)
        {
            //Włączenie panelu szklanego do zbierania kliknięć
            glass.setVisible(true);
            padding.requestFocus();
            //Uruchomienie metody do aktualizacji listy konfiguracji zapisanych na etykieciarce
            updateLabellerConfigList();
            //Uruchomienie timera, który odmierzy czas potrzebny na zebranie kliknięć i wyłączy panel szklany
            startGlassTimer();
        }
    }//GEN-LAST:event_updateConfListButtonActionPerformed
//Obsługa przycisku usunięcie konfiguracji z etykieciarki
    private void removeLabelConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeLabelConfButtonActionPerformed
        //Pobranie indeksu elementu wybranego na liście konfiguracji zapisanych na etykieciarce, jeśli nic nie jest wybrane to powrót
        int selectedIndex = labellerConfigListWindow.getSelectedIndex();
        if(selectedIndex == -1)
            return;
        //Przygotowanie wiadomości do ona potwierdzenia chęci usunięcia konfiguracji
        String message = "Are you sure you want to remove " + ((Configuration)labellerConfigList.get(selectedIndex)).getName() + " configuration from labeller memory?";
        //Wyświetlenie okna potwierdzenia i zapisanie odpowiedzi do zmiennej
        int answer = JOptionPane.showConfirmDialog(rootPane, message, "Warning", JOptionPane.YES_NO_OPTION);
        //Jeśli potwierdzono usunięcie i jest aktywne połączenie to wykonanie kodu
        if(answer == 0 && ifConnected)
        {
            //Włączenie panelu szklanego do zbierania kliknięć
            glass.setVisible(true);
            padding.requestFocus();
            //Uruchomienie metody usuwającej konfigurację z etykieciarki
            removeConfigurationFromLabeller(selectedIndex);
            //Aktualizacja listy konfiguracji zapisanych na etykieciarce
            updateLabellerConfigList();
            //Uruchomienie timera, który odmierzy czas potrzebny na zebranie kliknięć i wyłączy panel szklany
            startGlassTimer();
        }
    }//GEN-LAST:event_removeLabelConfButtonActionPerformed
//Obsługa przycisku pobrania konfiguracji z etykieciarki
    private void downloadConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadConfButtonActionPerformed
        //Pobranie indeksu elementu wybranego na liście konfiguracji zapisanych na etykieciarce, jeśli nic nie jest wybrane to powrót
        int selectedIndex = labellerConfigListWindow.getSelectedIndex();
        if(selectedIndex == -1)
            return;
        //Sprawdzenie czy jest aktywne połączenie z etykieciarką, jeśli tak to wykonanie kodu w klamrach if
        if(ifConnected)
        {
            //Włączenie panelu szklanego do zbierania kliknięć
            glass.setVisible(true);
            padding.requestFocus();
            //Uruchomienie metody do pobrania konfiguracji z etykieciarki z indeksem jako parametrem
            downloadConfiguration(selectedIndex);
            //Aktualizacja listy konfiguracji na komputerze
            updateComputerConfigList();
            //Uruchomienie timera, który odmierzy czas potrzebny na zebranie kliknięć i wyłączy panel szklany
            startGlassTimer();
        }
    }//GEN-LAST:event_downloadConfButtonActionPerformed

    //Główna metoda klasy wywoływana przy starcie aplikacji
    public static void main(String args[]) {
        //Ustawienie wyglądu okna aplikacji w stylu Windowsowym oraz obsługa możliwych wyjątków
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(labellerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(labellerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(labellerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(labellerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Utworzenie okna aplikacji i uwidocznienie go
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new labellerApp().setVisible(true);
            }
        });
    }
//Metoda aktualizująca listę rozwijaną etykieciarek
    void updateLabellersComboBox()
    {
        //Wyczyszczenie listy rozwijanej oraz zmiennej w postaci listy przechowującej etykieciarki w pamięci programu
        labellersComboBox.removeAllItems();
        labellersList.clear();
        try {
            //Sprawdzenie czy istnieje plik w pamięci komputera przechowujący dane o etykieciarkach
            if(EditLabelersListWindow.labellersListFile.exists())
            {
               //Utworzenie obiektu do odczytu danych z pliku
               Scanner scanner = new Scanner(new BufferedReader(new FileReader(EditLabelersListWindow.labellersListFile)));
               //Gdy plik zawiera kolejną linię to wykonaj kod w pętli while
               while(scanner.hasNextLine())
               {
                   //Utworzenie obiektu deserializującego dane zapisane w formacie JSON i deserializacja odczytanej linii
                   JSONObject labellerJson = new JSONObject(scanner.nextLine());
                   //Dodanie do listy danych dotyczących zczytanej z pliku etykieciarki
                   labellersList.add(new Labeller(labellerJson.getInt("id"), labellerJson.getString("name"), labellerJson.getString("IPAddress")));
                   //Dodanie elementu do listy rozwijanej
                   labellersComboBox.addItem(new String(labellerJson.getString("name") + " (" + labellerJson.getString("IPAddress") + ")"));
               }
               //Zamknięcie strumienia danych
               scanner.close();
            }
        } 
        catch (IOException ex) 
        {
            //Obsługa wyjątków wyrzucanych przez obiekt scanner
            System.out.println("Path problem (updateLabellersComboBox)");
        }
        catch (JSONException ex) 
        {
            //Obsługa wyjątków wyrzucanych przez obiekt JSONObject
            System.out.println("JSON problem (updateLabellersComboBox)");
        }
    }
    //Metoda sprawdzająca połączenie z wybraną etykieciarką
    private int checkDBConnection()
    {
        //Zmienna przechowująca adres bazy danych etykieciarki
        String DBUrl = new String("jdbc:mysql://" + chosenLabellerIPAddress + "/Etykieciarka");
        try
        {
            //Ustawienie sterownika SQL
            Class.forName(SQLDriver);
            //Utworzenie puli połączeń z bazą danych etykieciarki
            connectionPool = ConnectionPool.create(DBUrl, DATABASE_USER, DATABASE_PASSWORD);
        }
        catch(SQLException ex)
        {
            //Obsługa wyjątku w wypadku problemu z połączeniem
            System.out.println("SQL exception(checkDBConnection)");
            return -1;
        }  
        catch (ClassNotFoundException ex) 
        {
            //Obsługa wyjątku w przypadku problemów z ustawieniem sterownika SQL
            System.out.println("Class exception(checkDBConnection)");
            return -1;
        }
        //Ustawienie wartości true dla zmiennej informującej o stanie połączenia
        ifConnected = true;
        //Wyłączenie możliwości wyboru w liście rozwijanej etykieciarek
        labellersComboBox.setEnabled(false);
        return 1;
    }
    //Metoda aktualizująca listę konfiguracji zapisanych na komputerze
    private void updateComputerConfigList()
    {
        //Wyczyszczenie listy i okna wyświetlającego listę
        computerConfigListModel.clear();
        computerConfigList.clear();
        //Zczytanie listy wszystkich plików znajdujących się w folderze z konfiguracjami
        String[] list = CreateNewConfWindow.configurationsListDir.list();
        //Pętla przechodząca po wszystkich elementach  powyższej listy
        for(int i = 0; i < list.length; i++)
        {
            //Stworzenie zmiennej typu plik na podstawie kolejnych elementów listy
            File file = new File(CreateNewConfWindow.configurationsListDir.getPath(), list[i]);
            //Pobranie nazwy pliku
            String name = file.getName();
            //Sprawdzenie poprawności rozszerzenia pliku
            if(name.substring(name.length()-8).equals(".labconf"))
            {
                try 
                {
                    //Otwarcie strumienia do odczytu danych z pliku
                    Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
                    //Sprawdzenie czy plik zawiera kolejną linię, jeśli tak to wykonanie kodu
                    if(scanner.hasNextLine())
                    {
                        //Stworzenie deserializera formatu JSON i przekazanie linii z pliku
                        JSONObject labellerJson = new JSONObject(scanner.nextLine());
                        //Dodanie do listy konfiguracji zapisanych na komputerze konfiguracji zapisanej w danym pliku
                        computerConfigList.add(new Configuration(labellerJson.getInt("issuingVelocity"), labellerJson.getInt("ejectionDistance"), labellerJson.getInt("startRamp"), labellerJson.getInt("stopRamp"), labellerJson.getInt("startDelay"), labellerJson.getInt("stopDelay"), labellerJson.getDouble("velocityDifference"), labellerJson.getString("name"), labellerJson.getString("format")));
                        //Dodanie elementu do modelu listy aby wyświetlić konfigurację w oknie
                        computerConfigListModel.addElement(name.substring(0, name.length()-8));
                    }    
                    //Zamknięcie strumienia danych
                    scanner.close();
                } 
                catch(IOException ex)
                {
                    //Obsługa wyjątku w wypadku problemu z połączeniem
                    System.out.println("IOException (updateComputerConfigList)");
                }
                catch(JSONException ex)
                {
                    //Obsługa wyjątku z deserializera
                    System.out.println("JSONException (updateComputerConfigList)");
                }
            }
        }
    }
    //Metoda aktualizująca konfiguracje zapisane na etykieciarce
    private void updateLabellerConfigList()
    {
        //Stworzenie zmiennej przechowującej połączenie z bazą danych etykieciarki
        Connection DBConn;
        try
        {
            //Przypisanie zmiennej połączenia z puli połączeń
            DBConn = connectionPool.getConnection();
            //Stworzenie zapytania do bazy danych etykieciarki, odczyt wszystkich wartości z tabli programs
            String query = "SELECT * FROM programs";
            //Utworzenie zmiennej wykonującej zapytanie do bazy danych na podstawie połączenia
            Statement statement = DBConn.createStatement();
            //Odczytanie odpowiedzi bazy danych na przygotowane wcześniej zapytanie
            ResultSet results = statement.executeQuery(query);
            //Wyczyszczenie listy konfiguracji zapisanych na etykieciarce i okna wyświetlającego te konfiguracje
            labellerConfigList.clear();
            labellerConfigListModel.clear();
            //Wykonanie kodu pętli gdy istnieje kolejny wynik w zestawie wyników
            while(results.next())
            {
                //Odczytanie parametrów konfiguracji z zestawu wyników i przypisanie do zmiennych
                int issuingVelocity = results.getInt("velocity_of_issuing_labels");
                int ejectionDistance = results.getInt("distance_of_label_ejection");
                int startRamp = results.getInt("start_ramp");
                int stopRamp = results.getInt("stop_ramp");
                int startDelay = results.getInt("stop_delay");
                int stopDelay = results.getInt("stop_delay");
                double velocityDifference = results.getDouble("velocity_difference");
                String name = results.getString("name");
                String format = results.getString("format");
                //Jeśli nazwa nie jest przypisana to pominięcie dwóch ostatnich linii kodu w pętli
                if(name == null)
                    continue;
                //Dodanie do listy konfiguracji zapisanych na etykieciarce konfiguracji odczytanej z bazy danych etykieciarki
                labellerConfigList.add(new Configuration(issuingVelocity, ejectionDistance, startRamp, stopRamp, startDelay, stopDelay, velocityDifference, name, format));
                //Dodanie elementu do modelu listy aby wyświetlić konfigurację w oknie
                labellerConfigListModel.addElement(labellerConfigList.get(labellerConfigList.size()-1));
            }
            //Zwrócenie zajętego połączenia do bazy połączeń
            connectionPool.releaseConnection(DBConn);
        } 
        catch (SQLException ex) 
        {
            //Obsługa wyjątku w przypadku problemów z połączeniem z bazą danych
            System.out.println("SQL exception (updateLabellerConfigList)");
        } 
    }
    //Metoda do pobierania konfiguracji z etykieciarki na komputer
    private void downloadConfiguration(int selectedIndex)
    {
        //Zapisanie konfiguracji z listy z indeksem przekazanym jako parametr do zmiennej
        Configuration configuration = ((Configuration)labellerConfigList.get(selectedIndex));
        //Zapisanie nazwy konfiguracji do zmiennej
        String configurationName = configuration.getName();
        //Dodanie do nazwy konfiguracji rozszerzenia pliku i zapisanie do zmiennej
        String fileName = configurationName + ".labconf";
        //Stworzenie zmiennej typu plik z lokalizacją w folderze z konfiguracjami na komputerze
        File newConfiguration = new File(CreateNewConfWindow.configurationsListDir, fileName);
        int i = 1;
        //Jeśli plik o takiej nazwie już istnieje to dodanie do nazwy kolejnej liczby w nawiasie
        //np. plik(1), plik(2), plik(3) itd.
        while(newConfiguration.exists())
        {
            fileName = configurationName + "(" + i + ").labconf";
            i++;
            newConfiguration = new File(CreateNewConfWindow.configurationsListDir, fileName);
        }
        try {
            //Utworzenie pliku o wybranej nazwie w folderze z konfiguracjami
            newConfiguration.createNewFile();
        } 
        catch (IOException ex) 
        {
            //Obsługa wyjątku w przypadku błędu w tworzeniu pliku
            System.out.println("Creating new configuration file problem (downloadConfiguration)");
        }
        //Sprawdzenie czy utworzono plik z konfiguracją, jeśli tak to wykonanie kodu
        if(newConfiguration.exists())
        {
            try 
            {
                //Otwarcie strumienia danych zapisu do pliku
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(newConfiguration)));
                //Zapisanie do pliku danych w formacie JSON, przygotowanym przez użytą funkcję
                writer.println(prepareConfigJSONString(configuration));
                //Zamknięcie strumienia danych
                writer.close();
            } 
            catch (IOException ex) 
            {
                //Obsługa wyjątku w przypadku błędu zapisu do pliku
                System.out.println("IO Exception (downloadConfiguration)");
            }
        }
    }
    //Metoda przygotowująca tekst w formacie JSON z danymi konfiguracji
    private String prepareConfigJSONString(Configuration configuration)
    {
        //Przygotowanie zmiennej tekstowej na podstawie danych konfiguracji przekazanej jako parametr
        String result = new String("{ \"issuingVelocity\" : " + configuration.getIssuingVelocity() + ", \"ejectionDistance\" : " 
                + configuration.getEjectionDistance() + ", \"startRamp\" : " + configuration.getStartRamp() + ", \"stopRamp\" : " 
                + configuration.getStopRamp() + ", \"startDelay\" : " + configuration.getStartDelay() + ", \"stopDelay\" : " 
                + configuration.getStopDelay() + ", \"velocityDifference\" : " + configuration.getVelocityDifference() 
                + ", \"name\" : \"" + configuration.getName() + ", \"format\" : \"" + configuration.getFormat() + "\" }");
        //Zwrócenie przygotowanej zmiennej
        return result;
    }
    //Metoda usuwająca konfigurację z bazy danych etykieciarki
    private void removeConfigurationFromLabeller(int selectedIndex)
    {
        //Zapisanie konfiguracji z listy z indeksem przekazanym jako parametr do zmiennej
        Configuration configuration = ((Configuration)labellerConfigList.get(selectedIndex));
        //Zapisanie nazwy konfiguracji do zmiennej
        String name = configuration.getName();
        //Stworzenie zmiennej przechowującej połączenie z bazą danych
        Connection DBConn;
        try
        {
            //Pobranie połączenia z puli połączeń
            DBConn = connectionPool.getConnection();
            //Przygotowanie zapytania do bazy danych w formie tesktowej, usunięcie z tabeli programi rekodu o nazwe podanej jako parametr
            String query = "delete from programs where name = ?";
            //Przygotowanie zapytania do bazy danych do wykonania
            PreparedStatement preparedStmt = DBConn.prepareStatement(query);
            //Ustawienie wartości parametru dla zapytania
            preparedStmt.setString(1, name);
            //Wykonanie zapytania do bazy danych
            preparedStmt.execute();
            //Zwrócenie połączenia do puli połączeń
            connectionPool.releaseConnection(DBConn);
        } 
        catch (SQLException ex) 
        {
            //Obsługa wyjątku w przypadku błędu połączenia z bazą danych
            System.out.println("SQL exception (removeConfigurationFromLabeller)");
        }  
    }
    //Metoda do wysyłania konfiguracji do etykieciarki
    private void sendConfigurationToLabeller(int selectedIndex)
    {
        //Aktualizacja listy konfiguracji zapisanych na etykieciarce, aby posiadać jak najaktualniejsze dane przed zapisem w bazie danych
        updateLabellerConfigList();
        //Zapisanie konfiguracji z listy z indeksem przekazanym jako parametr do zmiennej
        Configuration configuration = ((Configuration)computerConfigList.get(selectedIndex));
        //Stworzenie zmiennej przechowującej połączenie z bazą danych
        Connection DBConn;
        //Zapisanie nazwy konfiguracji do zmiennej
        String name = configuration.getName();
        boolean isCorrect = false;
        int addToName = 1;
        /*pies
        pies(1)
        pies
        kot
        krowa
        */
        //Sprawdzenie czy konfiguracja o takiej nazwie istnieje już w bazie danych
        while(!isCorrect)
        {
            //Stworzenie zmiennej do sprawdzenie czy zmieniła się nazwa 
            int check = addToName;
            //Pętla przechodząca po wszystkich elementach listy konfiguracji zapisanych na etykieciarce
            for(int i = 0; i < labellerConfigList.size(); i++)
            {
                //Sprawdzenie czy nazwa konfiguracji do zapisu jest taka sama jak nazwa konfiguracji na liście z indeksem równym i
                if(name.equals(((Configuration)labellerConfigList.get(i)).getName()))
                {
                    //Dodanie do nazwy numeru zapisanego w zmiennej addToName w nawiasie
                    name = name + "(" + addToName + ")";
                    //Zwiększenie wartości zapisanej w addToName o 1
                    addToName++;
                }
            }
            //Jeśli wartość addToName się nie zmieniła, czyli nie znaleziono takiej samej nazwy na liście to wyjście z pętli while
            if(check == addToName)
                isCorrect = true;
        }
        try
        {
            //Zapisanie do zmiennej połączenia pobranego z puli połączeń
            DBConn = connectionPool.getConnection();
            //Przygotowanie zapytania do bazy danych w formie tekstowej, zapisanie do tabeli programu rekordu z podanymi parametrami
            String query = " insert into programs (velocity_of_issuing_labels, distance_of_label_ejection, start_ramp, stop_ramp, start_delay, stop_delay, velocity_difference, name, format)"
            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //Przygotowanie zapytania do wysłanie do bazy danych i przypisanie wartości kolejnych parametrów pobranych z konfiguracji pobranej z listy
            PreparedStatement preparedStmt = DBConn.prepareStatement(query);
            preparedStmt.setInt(1, configuration.getIssuingVelocity());
            preparedStmt.setInt(2, configuration.getEjectionDistance());
            preparedStmt.setInt(3, configuration.getStartRamp());
            preparedStmt.setInt(4, configuration.getStopRamp());
            preparedStmt.setInt(5, configuration.getStartDelay());
            preparedStmt.setInt(6, configuration.getStopDelay());
            preparedStmt.setDouble(7, configuration.getVelocityDifference());
            preparedStmt.setString(8, name);
            preparedStmt.setString(9, configuration.getFormat());
            //Wykonanie zapytania do bazy danych
            preparedStmt.execute();
            //Zwrócenie połączenia do puli połączeń
            connectionPool.releaseConnection(DBConn);
        } 
        catch (SQLException ex) 
        {
            //Obsługa wyjatku w przypadku błędu z połączeniem z bazą danych
            System.out.println("SQL exception (sendConfigurationToLabeller)");
        } 
    }
    //
    private void updateLabellerStats()
    {
        //Stworzenie zmiennej przechowującej połączenie z bazą danych etykieciarki
        Connection DBConn;
        try
        {
            //Zapisanie do zmiennej połączenia pobranego z puli połączeń
            DBConn = connectionPool.getConnection();
            //Przygotowanie zmiennej tekstowej z zapytaniem do bazy danych, wybranie wszystkich elementów z tabeli programs_history
            String query = "SELECT * FROM programs_history";
            //Przygotowanie zapytania do wysłania do bazy danych
            Statement statement = DBConn.createStatement();
            //Zapisanie do zmiennej odpowiedzi bazy danych na zapytanie
            ResultSet results = statement.executeQuery(query);
            //Wyczyszczenie listy przechowującej statystyki etykieciarki i okno wyświetlające listę konfiguracji w zakładce statystyk
            labellerConfigStatsList.clear();
            labellerConfigStatsListModel.clear();
            //Pętla wykonująca się gdy istnieje kolejny wynik w zestawie wyników
            while(results.next())
            {
                //Zapisanie danych z rekordu z bazy danych do zmiennych
                Timestamp startDate = Optional.ofNullable(results.getTimestamp("start_date")).orElse(new Timestamp(0));
                Timestamp stopDate = Optional.ofNullable(results.getTimestamp("stop_date")).orElse(new Timestamp(0));
                int information1 = Optional.ofNullable(results.getInt("information #1")).orElse(0);
                int information2 = Optional.ofNullable(results.getInt("information #2")).orElse(0);
                int information3 = Optional.ofNullable(results.getInt("information #3")).orElse(0);
                String name = Optional.ofNullable(results.getString("program_name")).orElse("---------");
                //Dodanie statystyk konfiguracji odczytanych z bazy danych do listy statystyk oraz konfiguracji do listy w zakładce statystyk
                labellerConfigStatsList.add(new ConfigurationStats(startDate, stopDate, information1, information2, information3, name));
                labellerConfigStatsListModel.addElement(labellerConfigStatsList.get(labellerConfigStatsList.size()-1));
            }
            //Zwrócenie połączenia do puli połączeń
            connectionPool.releaseConnection(DBConn);
        } 
        catch (SQLException ex) 
        {
            //Obsługa wyjątku w przypadku błędu połączenia z bazą danych
            System.out.println("SQL exception (updateLabellerStats)");
        }
    }
    //Metoda do wyświetlenia statystyk w zakładce statystyk przekazanych za pomocą parametru
    private void displayStats(ConfigurationStats configStats)
    {
        startDateTextField.setText(configStats.getStartDate().toString());
        stopDateTextField.setText(configStats.getStopDate().toString());
        info1TextField.setText(""+configStats.getInformation1());
        info2TextField.setText(""+configStats.getInformation2());
        info3TextField.setText(""+configStats.getInformation3());
    }
    //Metoda do wyświetlenia w zakładce statystyk tekstu przekazanego jako parametr
    private void displayStats(String text)
    {
        startDateTextField.setText(text);
        stopDateTextField.setText(text);
        info1TextField.setText(text);
        info2TextField.setText(text);
        info3TextField.setText(text);
    }
    //Metoda do rozłączenia z bazą danych etykieciarki
    private void disconnect()
    {
        //Aktualizacja status panelu wyświetlającego ikonę obrazującą stan połączenia
        ((StatusPanel)connStatusPanel).updateStatus(0);
        //Zmiana wartości zmiennej określającej aktualny stan połączenia 
        ifConnected = false;
        //Wyczyszczenie list oraz okien wyświetlających listy powiązanych z etykieciarką
        labellerConfigList.clear();
        labellerConfigListModel.clear();
        labellerConfigStatsList.clear();
        labellerConfigStatsListModel.clear();
        //Wyczyszczenie okien wyświetlających statystyki
        displayStats("");
        //Uruchomienie możliwości wyboru etykieciarki z rozwijanej listy
        labellersComboBox.setEnabled(true);
        //Sprawdzenie czy do zmiennej przechowującej pulę połączeń jest przypisana pula połączeń
        if(connectionPool != null)
        {
            try 
            {
                //Rozłączenie połączeń z puli z bazą danych
                connectionPool.shutdown();
            } 
            catch (SQLException ex) 
            {
                //Obsługa wyjątku w przypadku błędu rozłączania z bazą danych
                System.out.println("SQL exception (shutting down connection pool)");
            }
        }
    }
    //Metoda uruchamiająca Timer panelu szklanego pozwalający na zebranie niechcianych kliknięć
    private void startGlassTimer() 
    {  
        //Sprawdzenie czy do zmiennej globalnej timer jest przypisany Timer, jeśli nie to dodanie Timera
        if (timer == null) 
        {
            //Dodanie Timera do zmiennej globalnej i ustawienie działania przy wywołaniu timera
            timer = new Timer(100, new ActionListener() {
                int progress = 0;
                public void actionPerformed(ActionEvent A) 
                {
                    //Dodanie 10 do aktualnej wartości zmiennej progress
                    progress += 10;
                    //Jeśli zmienna progress osiągnie wartość większą lub równą 100 to wykonanie kodu w klamrach
                    if (progress >= 100) {
                        //Wyzerowanie zmiennej progress
                        progress = 0;
                        //Zatrzymanie timera
                        timer.stop();
                        //Wyłączenie panelu szklanego
                        glass.setVisible(false);
                    }
                }
            });
        } 
        //Sprawdzenie czy timer aktulanie działa, jeśli tak to zatrzymanie
        if (timer.isRunning()) {
            timer.stop();
        } 
        //Uruchomienie timera
        timer.start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> computerConfigListWindow;
    private javax.swing.JPanel confPanel;
    private javax.swing.JTabbedPane confStatsPane;
    private javax.swing.JPanel connStatusPanel;
    private javax.swing.JButton connectButton;
    private javax.swing.JPanel connectPanel;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JButton downloadConfButton;
    private javax.swing.JButton editConfButton;
    private javax.swing.JButton editLabListButton;
    private javax.swing.JTextField info1TextField;
    private javax.swing.JTextField info2TextField;
    private javax.swing.JTextField info3TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> labellerConfigListWindow;
    private javax.swing.JComboBox<String> labellersComboBox;
    private javax.swing.JButton newConfButton;
    private javax.swing.JButton removeCompConfButton;
    private javax.swing.JButton removeLabelConfButton;
    private javax.swing.JButton sendConfButton;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JList<String> statsConfigListWindow;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JTextField stopDateTextField;
    private javax.swing.JButton updateConfListButton;
    private javax.swing.JButton updateStatsButton;
    // End of variables declaration//GEN-END:variables

    //Metoda wygenerowana przez kreator wywoływana gdy nie jest obsłużona funkcjonalność któregoś ze stworzonych elementów okna
    private Reader FileReader(String supertxt) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//Klasa stworzona w celu obsługi panelu prezentującego stan połączenia z etykieciarką
class StatusPanel extends JPanel
{
    //Stworzenie zmiennej lokalnej przechowującej ikonę i przypisanie do niej domyślnie ikony z pliku "question mark.png"
    private Image icon = new ImageIcon("question mark.png").getImage();
    //Konstrukto publiczny klasy
    public StatusPanel()
    {
        //Wywołanie kostruktora klasy rozszerzonej
        super();
    }
    //Metoda aktualizująca status
    public void updateStatus(int status)
    {
        //Przypisanie zmiennej icon odpowiedniej ikony z pliku w zależności od wartości przekazanego parametru
        switch (status) 
        {
            case 1:
                icon = new ImageIcon("ok.png").getImage();
                break;
            case -1:
                icon = new ImageIcon("wrong.png").getImage();
                break;
            case 0:
                icon = new ImageIcon("question mark.png").getImage();
                break;
            default:
                break;
        }
        //Ponowne narysowanie panelu w oknie
        this.repaint();
    }
    //Nadpisana metoda rysująca panel w oknie
    @Override
    public void paintComponent(Graphics g)
    {
        //Wywołanie nadpisywanej metody
        super.paintComponent(g);
        //Wywołanie metody rysującej na panelu ikonę przechowywanę w zmiennej icon
        g.drawImage(icon, (this.getWidth()-icon.getWidth(this))/2, 1, null);
    }
}