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
public class User {
    private int id;
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String img;
    private String pswd;
    private int tel;
    private String adresse;
    private String role;
   
   
    public User(){    
    }
   
    public User(int id,String nom,String prenom ,Date ddn,String email,String img,String pswd,int tel,String adresse,String role )
    {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.ddn=ddn;
        this.email=email;
        this.img=img;
        this.pswd=pswd;
        this.tel=tel;
        this.adresse=adresse;
        this.role=role;
       
    }
   
      public User(String nom,String prenom ,Date ddn,String email,String img,String pswd,int tel,String adresse,String role )
    {
        this.nom=nom;
        this.prenom=prenom;
        this.ddn=ddn;
        this.email=email;
        this.img=img;
        this.pswd=pswd;
        this.tel=tel;
        this.adresse=adresse;
        this.role=role;
       
    }
   
    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImg() {
        return img;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
   
    @Override
    public String toString() {
    return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", ddn=" + ddn + ", email=" + email + ",img="+ img +", pswd=" + pswd + ", tel=" + tel + ", adresse=" + adresse + ", role=" + role + "]";
}
}

 


