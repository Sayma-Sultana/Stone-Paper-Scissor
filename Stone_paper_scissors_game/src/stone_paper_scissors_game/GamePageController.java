/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package stone_paper_scissors_game;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GamePageController implements Initializable {

    private static final String PAPER = "paper";
    private static final String STONE = "stone";
    private static final String SCISSORS = "scissors";
    private Image image;
    private int round = 50;
    @FXML
    private Label playerScore;
    @FXML
    private Label botScore;
    @FXML
    private Button stoneBtn;
    @FXML
    private Button paperBtn;
    @FXML
    private Button scissorBtn;
    @FXML
    private ImageView player;
    @FXML
    private Label result;
    @FXML
    private ImageView bot;

    @FXML
    private void playerTurn(ActionEvent event) throws IOException {


        String rock = getClass().getResource("/stone_paper_scissors_game/image/Stone.jpg").toString();
        String paper = getClass().getResource("/stone_paper_scissors_game/image/Paper.jpg").toString();
        String scissor = getClass().getResource("/stone_paper_scissors_game/image/Scissor.jpg").toString();
        if (round == 0) {
                    Database db = new Database();
        Connection conn = db.getConnnection();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Your score is " + playerScore.getText());
            alert.showAndWait();
            try {
                int current_score = Integer.parseInt(playerScore.getText());
                if (current_score > GlobalValue.max) {
                    Date date = new Date(); // Current date with time
                    LocalDate onlyDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    String query = "UPDATE login SET max = ?, date = ?WHERE email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setInt(1, current_score);
                    st.setString(2, onlyDate.toString());
                    st.setString(3, GlobalValue.email);
                    st.executeUpdate();
                }
                                  //swtich scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSuccess.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        round--;
        String playerChoice = null;
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn":
                image = new Image(paper);
                playerChoice = PAPER;
                break;
            case "stoneBtn":
                image = new Image(rock);
                playerChoice = STONE;
                break;
            case "scissorBtn":
                image = new Image(scissor);
                playerChoice = SCISSORS;
                break;
        }
        player.setImage(image);

        winner(playerChoice, botTurn());
    }

    private String botTurn() {

        String rock = getClass().getResource("/stone_paper_scissors_game/image/Stone.jpg").toString();
        String paper = getClass().getResource("/stone_paper_scissors_game/image/Paper.jpg").toString();
        String scissor = getClass().getResource("/stone_paper_scissors_game/image/Scissor.jpg").toString();
        String botChoice = null;
        int index = (int) (Math.random() * 3);
        switch (index) {
            case 0:
                image = new Image(rock);
                botChoice = STONE;
                break;
            case 1:
                image = new Image(paper);
                botChoice = PAPER;
                break;
            case 2:
                image = new Image(scissor);
                botChoice = SCISSORS;
                break;

        }
        bot.setImage(image);
        return botChoice;
    }

    public void playerWin() {

        result.setText("You win!");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void botWin() {

        result.setText("You lose");
        botScore.setText(String.valueOf(Integer.parseInt(botScore.getText()) + 1));
    }

    public void draw() {

        result.setText("Draw");

    }

    private void winner(String playerChoice, String botChoice) {
        if (playerChoice.equals(botChoice)) {
            draw();
            return;
        }
        if (playerChoice.equals(STONE)) {
            if (botChoice.equals(PAPER)) {
                botWin();
            } else if (botChoice.equals(SCISSORS)) {
                playerWin();
            }
        } else if (playerChoice.equals(PAPER)) {
            if (botChoice.equals(STONE)) {
                playerWin();
            } else if (botChoice.equals(SCISSORS)) {
                botWin();
            }
        } else {
            if (botChoice.equals(STONE)) {
                botWin();
            } else if (botChoice.equals(PAPER)) {
                playerWin();
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleStop(ActionEvent event) throws IOException {
        Database db = new Database();
        Connection conn = db.getConnnection();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Stop the game?");
        alert.setHeaderText("Are you sure you want to stop the game?");
        Optional<ButtonType> r = alert.showAndWait();
        if (r.isPresent()) {
            if (r.get() == ButtonType.OK) {
                try {
                    int current_score = Integer.parseInt(playerScore.getText());
                    if (current_score > GlobalValue.max) {
                        Date date = new Date(); // Current date with time
                        LocalDate onlyDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        String query = "UPDATE login SET max = ?, date = ?WHERE email = ?";
                        PreparedStatement st = conn.prepareStatement(query);
                        st.setInt(1, current_score);
                        st.setString(2, onlyDate.toString());
                        st.setString(3, GlobalValue.email);
                        st.executeUpdate();

                        //swtich scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSuccess.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(scene);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Back");
        alert.setHeaderText("Are you sure you want to go back to menu? Your score will not be saved");
        Optional<ButtonType> r = alert.showAndWait();
        if (r.isPresent()) {
            if (r.get() == ButtonType.OK) {

                //swtich scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSuccess.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
            }
        }

    }

}
