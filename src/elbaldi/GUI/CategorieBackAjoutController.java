/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elbaldi.GUI;

import elbaldi.models.categorie;
import elbaldi.services.CategorieCRUD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class CategorieBackAjoutController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private Button Ajout;
    @FXML
    private TextField nom;
   
  
    @FXML
    private TextArea descriptionC;
    @FXML
    private Button annuler;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Ajout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                categorie cat = new categorie(nom.getText(), descriptionC.getText());
                
                CategorieCRUD categorieCRUD = new CategorieCRUD();
                try {
                    if (!nom.getText().equalsIgnoreCase("") && !descriptionC.getText().equalsIgnoreCase("") && !categorieCRUD.NomExiste(nom.getText())) {
                        categorieCRUD.ajouterCategorie(cat);
                        Alert alert0 = new Alert(Alert.AlertType.INFORMATION);
                        alert0.setTitle("information Dialog");
                        alert0.setHeaderText(null);
                        alert0.setContentText("Ajout avec succes ");
                        alert0.show();
                        ((Node) event.getSource()).getScene().getWindow().hide();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Echec de l'ajout");
                        alert.setHeaderText(null);
                        alert.setContentText("Attention ! Verifier les données saisie (Pas de champs vides)");
                        alert.showAndWait();
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(CategorieBackAjoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        annuler.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                nom.clear();
              descriptionC.clear();            
            }
            });
        
    }

    
    
}

