/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author dali
 */
public class Wallet {
    private int id_wallet;
    private User user;
    private int num_carte;
    private String methode_payment;
    private Date date_expiration;
    private String nom;
    private String prenom;

    public Wallet() {
    }

   
    public Wallet(int id_wallet, User user, int num_carte, String methode_payment, Date date_expiration) {
        this.id_wallet = id_wallet;
        this.user = user;
        this.num_carte = num_carte;
        this.methode_payment = methode_payment;
        this.date_expiration = date_expiration;
    }

    public Wallet(User user, int num_carte, String methode_payment, Date date_expiration) {
        this.user = user;
        this.num_carte = num_carte;
        this.methode_payment = methode_payment;
        this.date_expiration = date_expiration;
    }

    public Wallet(int num_carte, String methode_payment, Date date_expiration, String nom, String prenom) {
        this.num_carte = num_carte;
        this.methode_payment = methode_payment;
        this.date_expiration = date_expiration;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    //getters 

    public int getId_wallet() {
        return id_wallet;
    }

    public User getUser() {
        return user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    

    public int getNum_carte() {
        return num_carte;
    }

    public String getMethode_payment() {
        return methode_payment;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }
    
    //setters

    public void setId_wallet(int id_wallet) {
        this.id_wallet = id_wallet;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNum_carte(int num_carte) {
        this.num_carte = num_carte;
    }

    public void setMethode_payment(String methode_payment) {
        this.methode_payment = methode_payment;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    @Override
    public String toString() {
        return "Wallet{" + "id_wallet=" + id_wallet + ", id_user=" + user + ", num_carte=" + num_carte + ", methode_payment=" + methode_payment + ", date_expiration=" + date_expiration + '}';
    }

    public void setId(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNumCarte(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDdn(java.sql.Date valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRole(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ajouter(Wallet w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
