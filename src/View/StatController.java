/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.io.IOException;
import models.User;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import models.User;
import services.UserService;
import View.*; 
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dali
 */
public class StatController implements Initializable {

    @FXML
    private BorderPane border;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
    UserService userService = new UserService();
    List<User> userList = userService.afficher();

    Map<String, Integer> rolesCount = new HashMap<>();

    for (User user : userList) {
        String role = user.getRole();
        rolesCount.merge(role, 1, Integer::sum);
    }

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    for (Map.Entry<String, Integer> entry : rolesCount.entrySet()) {
        String role = entry.getKey();
        int count = entry.getValue();
        pieChartData.add(new PieChart.Data(role, count));
    }

    PieChart pieChart = new PieChart(pieChartData);
    pieChart.setTitle("Liste des utilisateurs par rôle");
    pieChart.setClockwise(true);
    pieChart.setLabelLineLength(50);
    pieChart.setLabelsVisible(true);
    pieChart.setLegendVisible(true);
    pieChart.setStartAngle(180);

    border.setCenter(pieChart);
}

    @FXML
    private void home(ActionEvent event) throws IOException {
      
 try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) acceuil.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        // Handle any errors that might occur during the loading or displaying of the scene
        e.printStackTrace();
    }      
}


}