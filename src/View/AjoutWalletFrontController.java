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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.SessionManager;
import models.User;
import models.Wallet;
import services.UserService;
import services.WalletService;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class AjoutWalletFrontController implements Initializable {

    @FXML
    private Label labelnom;
    @FXML
    private TextField tfnum;
    @FXML
    private ComboBox<String> combod;
    @FXML
    private DatePicker tfdate;
    @FXML
    private Button ajou;
      private UserService sa = new UserService();
    private WalletService sw= new WalletService();
    SessionManager sessionManager = SessionManager.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combod.getItems().add("Paypal");
        combod.getItems().add("MasterCard");
        combod.getItems().add("VisaCard");
      
    User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
        labelnom.setText(f.getNom());
        // TODO
    }    

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

    private void modif(ActionEvent event) {
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("ModifUserFront.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void wall(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("WalletFront.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void ajou(ActionEvent event) {
          if(tfnum.getText().isEmpty() ||  combod.getValue().isEmpty())
        {
            Alert a = new Alert(Alert.AlertType.ERROR,"Champs vides",ButtonType.OK);
        a.showAndWait();
        }
        
        LocalDate d = tfdate.getValue(); 
        User u = new User();
            UserService ss = new UserService();
            u=SessionManager.getInstance().getCurrentUser();
        Wallet w = new Wallet(u,Integer.parseInt(tfnum.getText()),combod.getValue(),java.sql.Date.valueOf(d));
        sw.ajouter(w);
     
        
        
        
    }
    

    @FXML
    private void acc(ActionEvent event) {
            User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
            String role = "";
            String page = "";
            role = f.getRole();
            switch (role) {
            case "Client":
               
                page = "Client.fxml" ;
                break;
            case "Agent":
              
                page = "AgentFXML.fxml" ;

                break;
       
    }
             try {

            Parent page1 = FXMLLoader.load(getClass().getResource(page));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
           // scene.getStylesheets().add("https://cdn.jsdelivr.net/openjfx/8u40-b25/rt/styles/modena/modena.css");

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }
}
