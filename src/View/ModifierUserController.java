/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author dali
 */
public class ModifierUserController implements Initializable {

    @FXML
    private TextField nom2;
    @FXML
    private TextField prenom2;
    @FXML
    private DatePicker date2;
    @FXML
    private TextField email2;
    @FXML
    private TextField password2;
    @FXML
    private TextField tel2;
    @FXML
    private TextField adresse2;
    @FXML
    private ComboBox<String> rolle2;
    @FXML
    private Button modifier;
    @FXML
    private Button RetourAuAccueil2;
    User U;
    UserService Us=new UserService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rolle2.getItems().add("Admin");
        rolle2.getItems().add("Client");
        rolle2.getItems().add("Agent");
        // TODO
    }    
    
    void getUser(User u){
        
        nom2.setText(u.getNom());
        prenom2.setText(u.getPrenom());
        LocalDate d= date2.getValue();
        email2.setText(u.getEmail());
        password2.setText(u.getPswd());
        tel2.setText(Integer.toString(u.getTel()));
        adresse2.setText(u.getAdresse());
        U =  (u);
        
        
    }

    @FXML
    private void modif(ActionEvent event) {
        try {
            U.setNom(nom2.getText());
            U.setPrenom(prenom2.getText());
            LocalDate d = date2.getValue(); 
            U.setDdn(java.sql.Date.valueOf(d));
            U.setEmail(email2.getText());
            U.setPswd(password2.getText());
            U.setTel(Integer.parseInt(tel2.getText()));
            U.setAdresse(adresse2.getText());
            
            
            Us.modifier(U);
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Accueil.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void RetourAuAccueil2(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetourAuAccueil2.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
