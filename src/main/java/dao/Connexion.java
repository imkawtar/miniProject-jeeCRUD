package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    private static Connection connection;
    static {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/produits","root","a@B!c$333");
    }catch (Exception e){
        e.printStackTrace();
        }
}

public  static  Connection getConnection(){
        return connection;
    }
}
