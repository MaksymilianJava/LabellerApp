
package IPZappWindow;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.regex.*;
import javax.swing.ImageIcon;
import org.json.*;


/**
 *
 * @author Maksymilian Szczypkowski, Adrian Szczygielski
 */
//Klasa okna edycji listy etykieciarek
public class EditLabellersListWindow extends javax.swing.JFrame {
    //Stała przechowująca wzór do walidacji wpisywanego adresu IP
    private static final String IPV4_PATTERN = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
    //Stała przechowująca lokalizację pliku przechowującego listę etykieciarek w pamięci komputera
    static final File LABELLERS_LIST_DIR = new File("data" + File.separator + "labellers");
    //Stała typu plik dla pliku przechowującego listę etykieciarek w pamięci komputera
    static final File LABELLERS_LIST_FILE = new File(LABELLERS_LIST_DIR.getPath(),"labellers.lab");
    //Zmienna globalna do przechowywania listy etykieciarek w pamięci programu
    private List labellersList = new ArrayList<Labeller>();
    //Model listy do obsługi listy wyświetlającej elementy listy etykieciarek
    private DefaultListModel labellersListModel = new DefaultListModel();

    /**
     * Konstruktor klasy do tworzenia nowego okna edycji listy etykieciarek
     */
    public EditLabellersListWindow() {
        //Wywołanie metody do inicjalizacji elementów okna
        initComponents();
        //Sprawdzenie czy istnieje lokalizacja do przechowywania pliku z listą etykieciarek, jeśli nie to utworzenie lokalizacji
        if(!LABELLERS_LIST_DIR.exists())
            LABELLERS_LIST_DIR.mkdirs();
        try 
        {
            //Sprawdzenie czy istnieje plik z listą etykieciarek, jeśli nie to utworzenie pliku
            if(!LABELLERS_LIST_FILE.exists())
               LABELLERS_LIST_FILE.createNewFile();
            //Otwarcie strumienia odczytu z pliku z listą etykieciarek
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(LABELLERS_LIST_FILE)));
            //Wykonanie pętli gdy plik posiada kolejną linię
            while(scanner.hasNextLine())
            {
                //Deserializacja odczytanej linii zapisanej w formacie JSON
                JSONObject labellerJson = new JSONObject(scanner.nextLine());
                //Dodanie do listy etykieciarki odczytanej z pliku z listą etykieciarek
                labellersList.add(new Labeller(labellerJson.getString("name"), labellerJson.getString("IPAddress")));
            }
            //Zamknięcie strumienia danych
            scanner.close();
            //Aktualizacja listy wyświetlanej w oknie
            updateLabellersList();
        } 
        catch (IOException ex) 
        {
            //Obsługa wyjątku w przypadku błędu z plikiem
            System.out.println("IOException (EditLabellersListWindow)");
        }
        catch (JSONException ex) 
        {
            //Obsługa wyjątku w przypadku błędu z deserializacją danych z formatu JSON
            System.out.println("JSONException (EditLabellersListWindow)");
        }
    }

    /**
     * Kod wygenerowany przez kreator aplikacji okienkowej programu
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        labellersWindowList = new javax.swing.JList<>(labellersListModel);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labellerNameTextField = new javax.swing.JTextField();
        IPAddressTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit labellers list");
        setIconImage(new ImageIcon("label printer.png").getImage());
        setLocationByPlatform(true);
        setResizable(false);

        labellersWindowList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(labellersWindowList);

        jLabel1.setText("Name:");

        jLabel2.setText("IP Address:");

        labellerNameTextField.setToolTipText("Type name you want to give");
        labellerNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                labellerNameTextFieldKeyPressed(evt);
            }
        });

        IPAddressTextField.setToolTipText("Type URL of database of labeller you want to add");
        IPAddressTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IPAddressTextFieldKeyPressed(evt);
            }
        });

        jLabel3.setText("New labeller");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IPAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labellerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labellerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(IPAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Obsługa kliknięcia przycisku dodawania etykieciarki do listy
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //Pobranie nazwy wpisanej w polu tekstowym i zapisanie do zmiennej
        String labellerName = labellerNameTextField.getText();
        //Pobranie adresu IP wpisanego w polu tesktowym i zapisanie do zmiennej
        String IPAddress = IPAddressTextField.getText();
        //Sprawdzenie czy podana nazwa jest pusta (brak znaków, lub same białe znaki), jeśli tak to wykonanie kodu w klamrach
        if(labellerName.isBlank())
        {
            //Wyświetlenie okna informującego, że należy podać nazwę i następnie wyjście z metody
            JOptionPane.showMessageDialog(rootPane, "You have to give a name to new labeller");
            return;
        }
        //Sprawdzenie czy podany adres IP jest pusty lub czy nie jest zgodny z formatem, jeśli któryś z warunków jest spełniony to wykonanie kodu w klamrach
        if(IPAddress.isBlank() || !ifValidIP(IPAddress))
        {
            //Wyświetlenie okna informującego, że adres IP jest niepoprawny i następnie wyjście z metody
            JOptionPane.showMessageDialog(rootPane, "Invalid IP Address");
            return;
        }
        try 
        {
            //Otwarcie strumienia do zapisu w pliku z listą etykieciarek
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(LABELLERS_LIST_FILE,true)));
            //Dodanie do listy etykieciarek nowej etykieciarki z nazwą i adresem IP odczytanym z pól tekstowych
            labellersList.add(new Labeller(labellerName, IPAddress));
            //Przygotowanie danych etykieciarki w formacie JSON do zapisu do pliku
            String toWrite = prepareJSONString(labellerName, IPAddress);
            //Zapisanie linii z danymi w formacie JSON do pliku
            writer.println(toWrite);
            //Zamknięcie strumienia danych
            writer.close();
            //Wyczyszczenie pól tesktowych do wprowadzania nazwy i adresu IP
            labellerNameTextField.setText("");
            IPAddressTextField.setText("");
            //Aktualizacja listy etykieciarek wyświetlanej w oknie
            updateLabellersList();
        } 
        catch (IOException ex) 
        {
            //Obsługa wyjątku występującego w przypadku błędu z plikiem
            System.out.println("IOException");
        }
    }//GEN-LAST:event_addButtonActionPerformed
//Metoda obsługująca kliknięcie przycisku do usuwania etykieciarki z listy
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        //Pobranie ineksu elementu wybranego z listy i zapisanie go do zmiennej
        int selectedIndex = labellersWindowList.getSelectedIndex();
        //Sprawdzenie czy jakikolwiek elemeny listy był wybrany, jeśli nie to powrót
        if(selectedIndex == -1)
            return;
        //Usunięcie wybranego elementu z listy 
        labellersList.remove(selectedIndex);
        //Aktualizacja listy wyświetlanej w oknie
        updateLabellersList();
        //Aktualizacja pliku przechowującego listę etykieciarek
        updateLabellersFile();
    }//GEN-LAST:event_removeButtonActionPerformed
//Metoda wywoływana gdy wciśnięty jest przycisk podczas wpisywania tesktu w pole tekstowe nazwy
    private void labellerNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labellerNameTextFieldKeyPressed
        //Sprawdzenie czy wciśnięte są jednocześnie klawisze ctrl i v, czyli czy jest wykonywana próba wklejenia, jeśli tak to wykonanie kodu
        if(evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V)
        {
            //Pobranie schowka systemowego i zapisanie go do zmiennej
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            //Zapisanie do zmiennej obiektu określającego typ danych, w tym przypadku String
            DataFlavor flavor = DataFlavor.stringFlavor;
            //Stworzenie zmiennej do przechowywania zawartości schowka
            String clipboardString = "";
            try 
            {
                //Próba pobrania zawartości schowka jako typ String i zrzutowanie go na typ String
                clipboardString = (String)clipboard.getData(flavor);
            } 
            catch (UnsupportedFlavorException ex) 
            {
                //Obsługa wyjątku wyrzucanego w przypadku gdy schowek nie zawiera typu String
                System.out.println("It is not a String");
            } 
            catch (IOException ex)
            {
                ////Obsługa wyjątku wyrzucanego w przypadku błędu IOException
                System.out.println("Input/output error");
            }
        }
    }//GEN-LAST:event_labellerNameTextFieldKeyPressed
//Metoda wywoływana gdy wciśnięty jest przycisk podczas wpisywania tesktu w pole tekstowe adresu IP
    private void IPAddressTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IPAddressTextFieldKeyPressed
        //Sprawdzenie czy wciśnięte są jednocześnie klawisze ctrl i v, czyli czy jest wykonywana próba wklejenia, jeśli tak to wykonanie kodu
        if(evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V)
        {
            //Pobranie schowka systemowego i zapisanie go do zmiennej
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            //Zapisanie do zmiennej obiektu określającego typ danych, w tym przypadku String
            DataFlavor flavor = DataFlavor.stringFlavor;
            //Stworzenie zmiennej do przechowywania zawartości schowka
            String clipboardString = "";
            try 
            {
                //Próba pobrania zawartości schowka jako typ String i zrzutowanie go na typ String
                clipboardString = (String)clipboard.getData(flavor);
            } 
            catch (UnsupportedFlavorException ex) 
            {
                //Obsługa wyjątku wyrzucanego w przypadku gdy schowek nie zawiera typu String
                System.out.println("It is not a String");
            } 
            catch (IOException ex)
            {
                ////Obsługa wyjątku wyrzucanego w przypadku błędu IOException
                System.out.println("Input/output error");
            }
        }
    }//GEN-LAST:event_IPAddressTextFieldKeyPressed

 //Główna metoda klasy
    public static void main(String args[]) {
        //Ustawienie wyglądu elementów
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
            java.util.logging.Logger.getLogger(EditLabellersListWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditLabellersListWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditLabellersListWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditLabellersListWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //Stworzenie nowego okna i uwidocznienie go
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditLabellersListWindow().setVisible(true);
            }
        });
    }
    //Metoda do przygotowania danych w formacie tekstowym JSON do zapisu do pliku
    private static String prepareJSONString(String name, String IPAddress)
    {
        //Stworzenie zmiennej typu tekstowego String i zapisanie do niej danych przekazanych jako parametry w formacie JSON
        String result = new String("{ \"name\" : \"" + name + "\", \"IPAddress\" : \"" + IPAddress + "\" }");
        //Zwrócenie przygotowanego tekstu
        return result;
    }
    //Metoda do aktualizacji listy etykieciarek wyświetlanej w oknie
    private void updateLabellersList()
    {
        //Wyczyszczenia listy wyświetlanej w oknie
        labellersListModel.clear();
        //Pętla przechodząca po wszystkich elementach listy etykieciarek zapisanej w pamięci programu
        for(int i = 0; i < labellersList.size(); i++)
            //Dodanie elementu do listy etykieciarek wyświetlanej w oknie
            labellersListModel.addElement(labellersList.get(i));
    }
    //Metoda do aktualizacji pliku przechowującego listę etykieciarek
    private void updateLabellersFile()
    {
        try 
        {
            //Otwarcie strumienia w celu wyczyszczenia pliku przechowującego listę etykieciarek
            PrintWriter deleter = new PrintWriter(new BufferedWriter(new FileWriter(LABELLERS_LIST_FILE)));
            ///Nadpisanie listy znajdującej się w pliku pustym tesktem
            deleter.write("");
            //Zamknięcie strumienia
            deleter.close();
            //Otwarcie strumienia do zapisu danych do pliku
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(LABELLERS_LIST_FILE,true)));
            //Pętla przechodząca po wszystkich elementach listy etykieciarek zapisanej w pamięci programu
            for(int i = 0; i < labellersList.size(); i++)
            {
                //Zapisanie do zmiennych nazwy i adresu IP etykieciarki zapisanej na liście w pamięci programu pod i-tym indeksem
                String labellerName = ((Labeller)labellersList.get(i)).getName();
                String IPAddress = ((Labeller)labellersList.get(i)).getIPAddress();
                //Przygotowanie danych w formacie tekstowym JSON do zapisania w pliku
                String toWrite = prepareJSONString(labellerName, IPAddress);
                //Zapisanie przygotowanych danych w formacie JSON do nowej linii w pliku
                writer.println(toWrite);
            }
            //Zamknięcie strumienia danych
            writer.close();
        } 
        catch (IOException ex) 
        {
            //Obsługa wyjątku wyrzucanego w przypadku błędu zapisu do pliku
            System.out.println("IOException");
        }
    }
    //Metoda sprawdzająca czy tekst przekazany jako parametr odpowiada formatowi adresu IP
    private boolean ifValidIP(String IPAddress)
    {
        //Skompilowanie wzoru odpowiadającego adresowi IPV4
        Pattern IPPattern = Pattern.compile(IPV4_PATTERN);
        //Stworzenie obiektu typu matcher ze zmienną tekstową IPAddress podaną jako parametrem
        Matcher matcher = IPPattern.matcher(IPAddress);
        //Sprawdzenie czy zmienna tekstowa pasuje do wzoru adresu IPV4
        return matcher.matches();
    }
    //Zmienne zdefiniowane przez kreator do tworzenia aplikacji okienkowej
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IPAddressTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField labellerNameTextField;
    private javax.swing.JList<String> labellersWindowList;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
