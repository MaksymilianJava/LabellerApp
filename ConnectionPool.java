/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IPZappWindow;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

//Klasa do obsługi puli połączeń z bazą danych
public class ConnectionPool {
    //Zmienna przechowująca adres URL bazy danch
    private String url;
    //Zmienna przechowująca login do bazy danch
    private String user;
    //Zmienna przechowująca hasło do bazy danch
    private String password;
    //Lista przechowująca połączenia służąca jako pula połączeń
    private List<Connection> connectionPool;
    //Lista przechowująca połączenia wykorzystywane w danym momencie
    private List<Connection> usedConnections = new ArrayList<>();
    //Stała określająca rozmiar puli połączeń
    private static int INITIAL_POOL_SIZE = 5;
    
    //Metoda tworząca pulę połączeń przyjmująca jako parametry adres, login i hasło, wyrzucająca wyjątek SQLException
    public static ConnectionPool create(String url, String user, String password) throws SQLException 
    {
        //Inicjalizacja listy połączeń o zadanym rozmiarze
        List<Connection> pool = new ArrayList<Connection>(INITIAL_POOL_SIZE);
        //Pętla dodająca do listy połączeń kolejne stworzone połączenia z bazą danych, tyle połączeń ile wynosi ustalony rozmiar puli
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) 
        {
            pool.add(createConnection(url, user, password));
        }
        //Zwrócenie nowo stworzonego obiektu ConnectionPool ze stworzoną listą połączeń jako parametrem
        return new ConnectionPool(url, user, password, pool);
    }
    //Konstruktor klasy przyjmujący jako parametry adres, login, hasło oraz listę połączeń
    private ConnectionPool(String url, String user, String password, List<Connection> pool)
    {
        //Ustawienie wartości zmiennych prywatnych
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }
    //Metoda zwracająca jedno połączenie z puli
    public Connection getConnection() 
    {
        //Przypisanie do zmiennej połączenia z ostatnim indeksem w puli i usunięcie go z puli
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        //Dodanie usuniętego połączenia do listy używanych połączeń
        usedConnections.add(connection);
        //Zwrócenie połączenia
        return connection;
    }
    //Metoda do tworzenia połączenia z bazą danych wyrzucająca wyjątek SQLException
    private static Connection createConnection(String url, String user, String password) throws SQLException 
    {
        //Zwrócenie połączenia stworzonego z wykorzystaniem Driver Managera
        return DriverManager.getConnection(url, user, password);
    }
    //Metoda zwalniająca połączenie przekazane jako parametr
    public boolean releaseConnection(Connection connection) 
    {
        //Sprawdzenie czy lista używanych połączeń zawiera zwracane połączenie
        if(usedConnections.contains(connection))
            //Dodanie połączenia do puli połączeń
            connectionPool.add(connection);
        //Zwrócenie zmiennej logicznej okrślającej czy połączenie zostało usunięte z listy używanych połączeń
        return usedConnections.remove(connection);
    }
    //Metoda zwracająca rozmiar puli połączeń - zarówno połączenia aktualnie nieużywane jak i używane
    public int getSize() 
    {
        return connectionPool.size() + usedConnections.size();
    }
    //Metoda zamykająca pulę połączeń wyrzucająca wyjątek SQLException
    public void shutdown() throws SQLException 
    {
        //Zwolnienie wszystkich połączeń będących na liście używanych połączeń
        usedConnections.forEach(this::releaseConnection);
        //Pętla przechodząca po wszystkich elementach listy zawierającej pulę połączeń
        for (Connection c : connectionPool) 
        {
            //Zamknięcie połączenia z bazą danych
            c.close();
        }
        //Wyczyszczenie listy przechowującej pulę połączeń
        connectionPool.clear();
    }
}
