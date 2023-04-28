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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.User;
import services.UserService;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



/**
 * FXML Controller class
 *
 * @author dali
 */
public class DetailsUserController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField adresse;
    @FXML
    private Button retouuurrr;
 private Stage primaryStage;
  User uu;
    @FXML
    private ImageView detimage;
    @FXML
    private TextField datt;
    @FXML
    private Button banUser;
    /**
     * Initializes the controller class.
     */
  public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void getUser(User p)
{
nom.setText(p.getNom());
prenom.setText(p.getPrenom());
datt.setText(p.getDdn().toString());
email.setText(p.getEmail());
tel.setText(String.valueOf(p.getTel()));
adresse.setText(p.getAdresse());
if (p.getImg() != null)
        {
        File imagef = new File(p.getImg());
        Image imagee = new Image(imagef.toURI().toString());
        detimage.setImage(imagee);
        }
 uu =  (p);

}
    @FXML
    private void retouuurrr(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
        Parent view_2 = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }
@FXML
private void banUser(ActionEvent event) {
    UserService su = new UserService();
    User selectedUser = su.getUserById(uu.getId()); // Get the selected user by id
    su.banUser(selectedUser); // Ban the user
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("User Banned");
    alert.setHeaderText(null);
    alert.setContentText("The selected user has been banned.");
    alert.showAndWait();
    // Navigate back to the previous screen, if needed
}


    @FXML
    private void supp(ActionEvent event) {
        try {
            UserService su = new UserService();
            su.supprimer(uu.getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
            Parent view_2 = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
