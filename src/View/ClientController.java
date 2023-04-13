/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.SessionManager;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class ClientController implements Initializable {

    @FXML
    private Label labelnom;
    @FXML
    private ImageView image;
    @FXML
    private Label mail;
     SessionManager sessionManager = SessionManager.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserService sa = new  UserService();
        User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
        labelnom.setText( "     "+f.getNom());
        mail.setText(f.getEmail());
        
        
        
        
        if (f.getImg() != null)
        {
        File imagef = new File(f.getImg());
        Image imagee = new Image(imagef.toURI().toString());
        image.setImage(imagee);
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

    @FXML
    private void modif(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("ModifUserFront.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

         
        
    }

    @FXML
    private void wall(ActionEvent event) throws IOException {
          Parent page1 = FXMLLoader.load(getClass().getResource("WalletFront.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();
    }

    
}
