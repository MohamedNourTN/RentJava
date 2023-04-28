/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elbaldi.GUI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import elbaldi.models.produit;
import elbaldi.services.ProduitCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static oracle.jrockit.jfr.events.Bits.longValue;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class ProddetailsbackController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label reffx;
    @FXML
    private Label libellefx;
    @FXML
    private Label descfx;
    @FXML
    private Label prixfx;
    @FXML
    private Button modifierfx;
    @FXML
    private Button retourfx;
    private produit produitt;
    @FXML
    private ListView<?> listefx;
    @FXML
    private TextField ccnum;
    @FXML
    private TextField ccexp;
    @FXML
    private TextField cccvv;
    @FXML
    private Label descfx1;
    /**
     * Initializes the controller class.
     */
    @FXML
    private Label paymentStatusLabel;
    public void setProduit(produit produit) {
        this.produitt = produit;
        libellefx.setText(produit.getLibelle());
         descfx.setText(produit.getDescription());
          reffx.setText(produit.getRef_produit());
        prixfx.setText(produit.getPrix_vente() +" "+" DT ");
        File f = new File("C:\\xampp\\htdocs\\images\\" + produitt.getImage());

          img.setImage(new Image(f.toURI().toString()));          

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initialize Stripe
                Stripe.apiKey = "sk_test_51N0nVDDXXNlJHCatFF4DTWc739qNPcC0m2tMDQWq6cSHerf9PTUM0DThWXA484ZABTxe7YwLIk0ExnpdArE2Wvr000Mg65WKM1";


 }
    @FXML
    private void modifier(ActionEvent event) throws IOException, SQLException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifierProduitBack.fxml"));
        Parent root = loader.load();
        

        ModifierProduitBackController cb = loader.getController();
        cb.setProduit(produitt);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        ProduitCRUD sc=new ProduitCRUD();
        setProduit(sc.getByRefProduit(produitt.getRef_produit()));
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("prodbacklist.fxml"));
        Parent root = loader.load();
        retourfx.getScene().setRoot(root);
    }

    @FXML
    private void pay(ActionEvent event) {
        try {
          
          
            
            Stripe.apiKey = "sk_test_51N0nVDDXXNlJHCatFF4DTWc739qNPcC0m2tMDQWq6cSHerf9PTUM0DThWXA484ZABTxe7YwLIk0ExnpdArE2Wvr000Mg65WKM1";

            System.out.println(prixfx);
             
                Gson gson = new GsonBuilder()
    .setPrettyPrinting()
    .create();

long sss = longValue(produitt.getPrix_vente());
            ChargeCreateParams chargeCreateParams1 = ChargeCreateParams.builder()
                    //.setAmount(Integer.parseInt(amount) * 100)
                 .setAmount(sss+55 *10L)
                    .setCurrency("USD")
                    .setSource("tok_visa") 
                    .setDescription("Test Payment")
                    .build();
                      Charge charge1 = Charge.create(chargeCreateParams1);

//produit p  = new produit();
             System.out.println("Success! Thank you for renting with us: " + charge1.getId());
            // update payment status label
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Reservation Ajoutée !");
                alert.setContentText("Payment Successful. Charge ID: " + charge1.getId());
                alert.setContentText("Vous avez gagné : " + charge1.getAmount() +"Points" );
                alert.show();
           paymentStatusLabel.setText("Reservation Ajoutée: " + charge1.getId());
             System.out.println("Success! Here is your starter subscription price id: " + charge1.getId());

        } catch (StripeException e) {
             System.out.println(e.getMessage()); 
            // update payment status label
           paymentStatusLabel.setText("Payment Failed. Error: " + e.getMessage());
        }
    }
    
}
