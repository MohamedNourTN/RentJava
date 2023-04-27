/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author baha
 */
public class MyDB {
    String url ="jdbc:mysql://localhost:3306/myapp";
    String username="root";
    String pwd="";
    
    Connection cnx;

    private static MyDB instance ;
    public MyDB() {
        try {
            cnx =  DriverManager.getConnection(url, username,pwd);
            System.out.println("cnx établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
    
        public static MyDB getInstance(){
            if(instance == null){
                instance = new MyDB();
            }
            return instance;
        }
       public Connection getCnx(){
           return cnx;
       } 
}