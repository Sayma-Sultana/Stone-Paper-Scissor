/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package stone_paper_scissors_game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.sql.*;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SignupController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button loginbtn;
    @FXML
    private Button loginbtn1;
    @FXML
    private TextField cpassword;
    @FXML
    private Label emsg;
    ButtonType r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSignUp(ActionEvent event) {
        Database db = new Database();
        Connection conn = db.getConnnection();
        if(password.getText() == null ? cpassword.getText() == null : !password.getText().equals(cpassword.getText())){
               emsg.setText("Incorrect password");
        }
        else{
            String query = "INSERT INTO login (name,email,password,max,rank,date) VALUES(?,?,?,?,?,?)";
            try{
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1,name.getText());
                st.setString(2,email.getText());
                st.setString(3,password.getText());
                st.setInt(4,0);
                st.setInt(5,-1);
                st.setString(6,"");
                st.executeUpdate();
                           Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("SignUp Successful");
            alert.setHeaderText("Signup Succesful");
            alert.setContentText("Your account has been successfully created!");
            
            // Show the alert and wait for user response
                 alert.showAndWait();
                 GlobalValue.email = email.getText();
                 GlobalValue.username = name.getText();
                 GlobalValue.max = 0;
                 GlobalValue.rank = -1;
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSuccess.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
    }
    
}
