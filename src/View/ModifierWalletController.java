/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import models.User;
import models.Wallet;
import services.UserService;
import services.WalletService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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

/**
 * FXML Controller class
 *
 * @author dali
 */
public class ModifierWalletController implements Initializable {

    @FXML
    private ComboBox<String> Methodeeee;
    @FXML
    private Button Reatouur;
    @FXML
    private TextField numm;
    @FXML
    private DatePicker dattteee;
    
    Wallet w;
    WalletService ws= new WalletService();
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Methodeeee.getItems().add("Paypal");
        Methodeeee.getItems().add("MasterCard");
        Methodeeee.getItems().add("VisaCard");
        // TODO
    }    
void getWallet(Wallet u){
        
        numm.setText(Integer.toString(u.getNum_carte()));
        
        LocalDate d= dattteee.getValue();
        
        
    
    
        Methodeeee.setValue(u.getMethode_payment());
        
        w =  (u);
        
        
    }
    @FXML
    private void Reatouur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WalletFront.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) Reatouur.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modif(ActionEvent event) {
         try {
            w.setNum_carte(Integer.parseInt(numm.getText()));
            
            LocalDate d = dattteee.getValue(); 
            w.setDate_expiration(java.sql.Date.valueOf(d));
            w.setMethode_payment(Methodeeee.getValue());
            w.setUser(w.getUser());
             
         
            
            
            ws.modifier(w);
        FXMLLoader loader= new FXMLLoader(getClass().getResource("WalletFront.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
