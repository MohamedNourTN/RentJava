/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Interface_IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.User;
import models.Wallet;
import utilities.MyConnection;

/**
 *
 * @author dali
 */
public class WalletService implements Interface_IService <Wallet>{
        Connection cnx=MyConnection.getInstance().getCnx();
        
        @Override
    public void ajouter(Wallet w) {
    try {
        String req = "INSERT INTO wallet (id, num_carte, methode_payment,date_expiration) VALUES ('" + w.getUser().getId()+ "', '" + w.getNum_carte()+ "', '"+ w.getMethode_payment() + "','" + w.getDate_expiration() + "')" ;
       Statement ps = cnx.createStatement();
       ps.executeUpdate(req);
        
       System.out.println("Wallet Added Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
    public void supprimer(int ID) {
    try {
        String req = "DELETE FROM wallet WHERE id_wallet = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, ID);
        ps.executeUpdate();
        System.out.println("Wallet Deleted Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }   
    
    }
 @Override
    public List afficher() {
     List<Wallet> wallets = new ArrayList<>();
     UserService us=new UserService();
    try {
        String req = "SELECT * FROM wallet  ";
        PreparedStatement ps = cnx.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Wallet w = new Wallet();
            User u = new User();
            UserService ss = new UserService();
            u=ss.readById(rs.getInt(2));
            w.setId_wallet(rs.getInt("id_wallet"));
            w.setUser(u);
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
           
           wallets.add(w);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return wallets;    
    
    }
    public List afficherParid(int id) {
     List<Wallet> wallets = new ArrayList<>();
     UserService us=new UserService();
    try {
        String req = "SELECT * FROM wallet WHERE wallet.id ='"+id+"'  ";
        PreparedStatement ps = cnx.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Wallet w = new Wallet();
            User u = new User();
            UserService ss = new UserService();
            u=ss.readById(id);
            w.setId_wallet(rs.getInt("id_wallet"));
            w.setUser(u);
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
           
           wallets.add(w);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return wallets;    
    
    }
    @Override
    public List afficherrr() {
        List<Wallet> wallets = new ArrayList<>();
     UserService us=new UserService();
    try {
        String req = "SELECT * FROM wallet  ";
        PreparedStatement ps = cnx.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           
            User u = new User();
            UserService ss = new UserService();
            u=ss.readById(rs.getInt(2));
             Wallet w = new Wallet(rs.getInt(3),rs.getString(4),rs.getDate(5),u.getNom(),u.getPrenom());
            
             
           
          
           
           wallets.add(w);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return wallets; 
       
    
    }
  @Override
    public List afficherjointure() {
     List<Wallet> wallets = new ArrayList<>();
     UserService us=new UserService();
    try {
        String req = "SELECT num_carte,methode_payment,date_expiration,nom,prenom FROM wallet w JOIN user u ON w.id=u.id ";
        Statement ps = cnx.createStatement();
        //ps.executeUpdate(req);
        ResultSet rs = ps.executeQuery(req);
        while (rs.next()) {
           Wallet w = new Wallet();
           
           w(Integer.parseInt(rs.getString(1)),rs.getString(2).toString(),rs.getDate("date_expiration").toLocalDate(),rs.getString("nom").toString(),rs.getString("prenom").toString());
           wallets.add(w);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return wallets;    
    
    }

    @Override
    public Wallet readById(int id) {
      Wallet  w =new Wallet();
        try {
        String req="SELECT * FROM wallet WHERE `id_wallet`='"+id+"'";
        Statement ste = cnx.createStatement();
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            User u = new User();
            UserService ss = new UserService();
            u=ss.readById(rs.getInt(2));
            w.setId_wallet(rs.getInt("id_wallet"));
             w.setUser(u);
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
        }
           } catch (SQLException ex) {
        ex.printStackTrace();    }
       return w;  
    }

    @Override
    public ArrayList sortBy(String nom_column, String Asc_Dsc) {
    ArrayList<Wallet>wallets=new ArrayList();
       try {
            String req="SELECT * FROM wallet ORDER BY "+nom_column+" "+Asc_Dsc+"";
            Statement ste = cnx.createStatement();
            ResultSet rs=ste.executeQuery(req);
         while(rs.next()){
           Wallet w = new Wallet();
           User u = new User();
            UserService ss = new UserService();
            u=ss.readById(rs.getInt(2));
            w.setId_wallet(rs.getInt("id"));
             w.setUser(u);
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
            
            wallets.add(w);
            
        }   } catch (SQLException ex) {
        ex.printStackTrace(); ;
    }
     return wallets;
    }

   


    @Override
    public void modifier(Wallet w) {
       try {
        String req = "UPDATE wallet SET id = ?, num_carte = ?, methode_payment = ?, date_expiration = ? WHERE id_wallet = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, w.getUser().getId());
        ps.setInt(2, w.getNum_carte());
        ps.setString(3, w.getMethode_payment());
        ps.setDate(4,(Date) w.getDate_expiration());
        ps.setInt(5, w.getId_wallet());
        ps.executeUpdate();
        System.out.println("Wallet Updated Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }   }

    private void w(int num, String meth, LocalDate d, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Wallet getOneByUserId(int id) {
        Wallet w = null;
        try {
            String req = "Select * from wallet WHERE wallet.id = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                User u;
                UserService ss = new UserService();
                u = ss.readById(id);
                 w = new Wallet(rs.getInt(1),u,rs.getInt("num_carte"), rs.getString("methode_payment"),rs.getDate("date_expiration"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return w;
    }
    
}
