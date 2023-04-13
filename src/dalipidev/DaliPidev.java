/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dalipidev;

import interfaces.Interface_IService;
import java.sql.Date;
import models.User;
import models.Wallet;
import services.UserService;
import services.WalletService;

/**
 *
 * @author dali
 */
public class DaliPidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Interface_IService ui= new UserService() ;
          
          //Wallet w2 = new Wallet (9,27,"par cheque",new Date (2222));
        //  Wallet w3 = new Wallet (9,27,"par aaaaaaa",new Date (2222));
          
          Interface_IService uii= new WalletService() ;
           
          
          
         //uii.ajouter(w3);
         // uii.afficher();
          //i.setDate_expiration(java.sql.Date.valueOf("2019-01-07-"));
          //ui.supprimer(id);
          //u.setId(9);
          // ui.ajouter(u5);
          //u.setNom("azouz");
          //System.out.println(u);
          
          //uii.modifier(w3);
          //System.out.println(uii.afficher());;
                  
          //ui.afficher("1");
          
          // read by id
          
          //System.out.println(ui.readById(10));
          
          //System.out.println(ui.sortBy("tel", "asc"));
      }
    }