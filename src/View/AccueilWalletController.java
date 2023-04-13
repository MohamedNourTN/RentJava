/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import interfaces.Interface_IService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.User;
import models.Wallet;
import services.WalletService;

/**
 * FXML Controller class
 *
 * @author dali
 */
public class AccueilWalletController implements Initializable {

    @FXML
    private ListView<Wallet> afficherwallet2;
    @FXML
    private Button RetourAuMenuWallet;
    @FXML
    private Button AjouuterWallet;
    @FXML
    private Button ModifierWaalet;
    Interface_IService sw= new WalletService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }    

    @FXML
    private void RetourAuMenuWallet(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetourAuMenuWallet.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AjouuterWallet(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterWallet.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) AjouuterWallet.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ModifierWaalet(ActionEvent event) throws IOException {
         Wallet selectedW=afficherwallet2.getSelectionModel().getSelectedItem();
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierWallet.fxml"));
             Parent view_2=loader.load();
            ModifierWalletController ModifierWalletController=loader.getController();
           
            ModifierWalletController.getWallet(selectedW);
             ModifierWalletController.w =selectedW;
           
            
           Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void afficherWallet(ActionEvent event) {
        ObservableList<Wallet> Wallets =FXCollections.observableArrayList(sw.afficher());
       afficherwallet2.setItems(Wallets);

    }

    @FXML
    private void supprimerWallet(ActionEvent event) {
           // Récupérer le pack sélectionné
    Wallet WalletSelectionne = afficherwallet2.getSelectionModel().getSelectedItem();

    if (WalletSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sw.supprimer(WalletSelectionne.getId_wallet());

        // Retirer le pack de la ListView
        afficherwallet2.getItems().remove(WalletSelectionne);
    }
    }
    
}
