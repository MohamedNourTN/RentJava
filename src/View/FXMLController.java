/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.User;
import services.EmailSender;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author dali
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ComboBox<String> rolle;
    @FXML
    private DatePicker date;
    @FXML
    private TextField tel;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private TextField password;
    @FXML
    private Button inscription;
     private String ImagePath;
    
    UserService us=new UserService();
    @FXML
    private Button RetourAuAccueil;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImagePath = "";
        rolle.getItems().add("Admin");
        rolle.getItems().add("Client");
        rolle.getItems().add("Agent");
    }    
    
    private boolean validateTel(String num) {
        String pattern = "^[0-9]{8}$";
        return num.matches(pattern);
    }

    @FXML
    private void inscrip(ActionEvent event) throws IOException {
        if (nom.getText().isEmpty()|| prenom.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || tel.getText().isEmpty() || adresse.getText().isEmpty() )
        {
            Alert a = new Alert(Alert.AlertType.ERROR,"Champs vides",ButtonType.OK);
        a.showAndWait();
        }
        else if (!validateTel(tel.getText())){
            Alert a = new Alert(Alert.AlertType.ERROR,"Num Tel invalide (8 chiffres )",ButtonType.OK);
        a.showAndWait();
        }
        
        else {
        User r = new User();
       
        r.setNom(nom.getText());
        r.setPrenom(prenom.getText());
        LocalDate d = date.getValue(); 
        r.setDdn(java.sql.Date.valueOf(d));
        r.setEmail(email.getText());
        r.setImg(ImagePath.toString());
        r.setPswd(password.getText());
        r.setTel(Integer.parseInt(tel.getText()));
        r.setAdresse(adresse.getText());
        r.setRole(rolle.getValue()); 
           
           us.ajouter(r);
            EmailSender.sendEmail("firas.eljary@esprit.tn", "espritmain47",email.getText(), "Inscription avec succes", "Bonjour " +nom.getText()+" ,Bienvenue sur notre pltaforme ONTEJ \n Voici votre mail d'inscription  : "+email.getText()  );
           Alert a = new Alert(Alert.AlertType.INFORMATION,"User ajouté",ButtonType.OK);
        a.showAndWait();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeConnecter.fxml"));
            Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) inscription.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }
    @FXML
    private void RetourAuAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeConnecter.fxml"));
            Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetourAuAccueil.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btn_img(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null) {
            ImagePath = "src/resources/"+SelectedFile.getName();
            
            
            
            imageview.setImage(new Image(new File(ImagePath).toURI().toString()));
        } else {

            ImagePath = "C:/Users/Ghass/Desktop/profile.jpg";
            
            imageview.setImage(new Image(new File(ImagePath).toString()));

        }
    }
    
}
