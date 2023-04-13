/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.SessionManager;
import models.User;
import services.UserService;
/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class ModifUserFrontController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tftel;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfpass;
    @FXML
    private TextField tfadresse;
    @FXML
    private DatePicker tfdate;
    @FXML
    private Label labelnom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserService sa = new  UserService();
        User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
        labelnom.setText( f.getNom());
        tfnom.setText(f.getNom());
        tfmail.setText(f.getEmail());
        tftel.setText(String.valueOf(f.getTel()));
        tfprenom.setText(f.getPrenom());
        tfpass.setText(f.getPswd());
        tfadresse.setText(f.getAdresse());
        
    }    

    @FXML
    private void modif(ActionEvent event) {
        UserService sa = new  UserService();
        User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
        f.setNom(tfnom.getText());
            f.setPrenom(tfprenom.getText());
            LocalDate d = tfdate.getValue(); 
            f.setDdn(java.sql.Date.valueOf(d));
            f.setEmail(tfmail.getText());
            f.setPswd(tfpass.getText());
            f.setTel(Integer.parseInt(tftel.getText()));
            f.setAdresse(tfadresse.getText());
            
            
            sa.modifier(f);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Profil Modifié", ButtonType.OK);
            a.showAndWait();  
            labelnom.setText( f.getNom());
    }

    @FXML
    private void acc(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("AgentFXML.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void deco(ActionEvent event) {
        SessionManager.getInstance().setCurrentUser(null);
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("SeConnecter.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }
    
}
