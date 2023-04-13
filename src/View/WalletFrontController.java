/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
public class WalletFrontController implements Initializable {

    @FXML
    private ScrollPane scrollpane;
    private UserService sa = new UserService();
    private WalletService sw= new WalletService();
    @FXML
    private Label noml;

    /**
     * Initializes the controller class.
     */
    public void table(){
         List<Wallet>  offres = sw.afficherParid(SessionManager.getInstance().getCurrentUser().getId());
        VBox vBox = new VBox();
        
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(30);
        

        HBox hBox = new HBox();
         
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);//
        
        
        
        
        int count = 0;
        for (Wallet offre : offres) {
            VBox box = createOffreBox(offre);
            
            hBox.getChildren().add(box);
            count++;

            if (count == 1) {
                vBox.getChildren().add(hBox);
                hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(100);
                count = 0;
            }
        }

        if (count > 0) {
            vBox.getChildren().add(hBox);
        }
        

        
            
        

        scrollpane.setContent(vBox);
        scrollpane.setFitToWidth(true);
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
        noml.setText(f.getNom());
        table();
        // TODO
    }    
    
    private VBox createOffreBox(Wallet offre)  {
        VBox box = new VBox();
        
        box.setAlignment(Pos.CENTER);
        box.setSpacing(30);
         box.setUserData(offre.getId_wallet()); // set the ID as the user data for the VBox


        Label titre = new Label(String.valueOf(offre.getNum_carte()));
        
        Label methode = new Label(offre.getMethode_payment());
        Label mail = new Label(offre.getUser().getEmail());
        
        Button bb = new Button();
         bb.setText("Supprimer");
         
          Button bbb = new Button();
         bbb.setText("Modifier");
       
        
        
       
       
       
        Label sep = new Label("_________________________________________________________________________________________________");
        
        
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
      mail.setStyle("-fx-text-fill : Blue;");
      
        
         
        mail.setFont(Font.font("Arial", FontWeight.BOLD, 19));
        
        mail.setWrapText(true);
       
        
        box.getChildren().addAll( mail,titre,methode,bb,bbb,sep);
        
        bb.setOnMouseClicked(event -> {
            
            sw.supprimer(offre.getId_wallet());
            table();
            
        });
           bbb.setOnMouseClicked(event -> {
            
            try {
                Wallet selectedW=offre;
                
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierWallet.fxml"));
                Parent view_2=loader.load();
                ModifierWalletController ModifierWalletController=loader.getController();
                
                ModifierWalletController.getWallet(selectedW);
                ModifierWalletController.w =selectedW;
                
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(WalletFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        return box;
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

    @FXML
    private void modif(ActionEvent event) {
      
    }

    @FXML
    private void ajj(ActionEvent event) {
            try {

            Parent page1 = FXMLLoader.load(getClass().getResource("AjoutWalletFront.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }
}

