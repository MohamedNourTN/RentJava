/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.User;

/**
 * FXML Controller class
 *
 * @author dali
 */
public class UsercellController implements Initializable {

    @FXML
    private Label nomlabel;
    @FXML
    private Label prenomlabel;
    @FXML
    private Label numerolabel;
    @FXML
    private Button details;
    private User u;
    private myListener1 myListener1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         }
    public void setData(User u, myListener1 myListener1) {
        this.u = u;
        this.myListener1 = myListener1;
        nomlabel.setText(u.getNom());
        prenomlabel.setText(u.getPrenom());
        numerolabel.setText(Integer.toString(u.getTel()));

    }

    @FXML
    private void details(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
  DetailsUserController modif=loader.getController();
           
            modif.getUser(u);
             modif.uu =u;       
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) details.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void click(MouseEvent event) {
         myListener1.onClickListener(u);
    }
    }    

 
    

