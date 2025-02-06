/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package stone_paper_scissors_game;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ImageView img;
    @FXML
    private Button loginbtn;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button loginbtn1;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GaussianBlur gg = new GaussianBlur(10);
        img.setEffect(gg);
    }    

    @FXML
private void loginbtnmethod(ActionEvent event) throws IOException {
    Database db = new Database();
    Connection conn = db.getConnnection();

    String stmnet = "SELECT * FROM login WHERE email = ?";
    try {
        PreparedStatement ps = conn.prepareStatement(stmnet);
        ps.setString(1, email.getText());  // Set the email parameter safely

        ResultSet rs = ps.executeQuery();
        LoginUser u = new LoginUser();

        if (rs.next()) {
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setMax(rs.getInt("max"));
            u.setRank(rs.getInt("rank"));
            u.setDate(rs.getString("date"));

            // Use .equals() for string comparison
            if (u.getEmail().equals(email.getText()) && u.getPassword().equals(password.getText())) {
                // Navigate to the next scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSuccess.fxml"));
                GlobalValue.username =  u.getName();
                GlobalValue.email = u.getEmail();
                GlobalValue.rank = u.getRank();
                GlobalValue.max = u.getMax();
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
            } else {
                // Handle incorrect login attempt (optional)
                System.out.println("Invalid email or password.");
            }
        } else {
            // Handle case when no user is found with that email
            System.out.println("User not found.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);

    }

    
}
