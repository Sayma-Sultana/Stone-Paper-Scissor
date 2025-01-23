/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package stone_paper_scissors_game;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private void playerTurn(ActionEvent event){
        
        
        String rock = new File("").getAbsolutePath() + "\\src\\stone_paper_scissors_game\\image\\Stone.jpg";
String paper =new File("").getAbsolutePath() + "\\src\\stone_paper_scissors_game\\image\\Paper.jpg";
String scissor = new File("").getAbsolutePath() + "\\src\\stone_paper_scissors_game\\image\\Scissor.jpg";
        
        String playerChoice = null;
        switch(((Button)event.getSource()).getId()) {
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
            
    
    private String botTurn(){
        
        String rock = new File("").getAbsolutePath() + "\\src\\stone_paper_scissors_game\\image\\Stone.jpg";
String paper =new File("").getAbsolutePath() + "\\src\\stone_paper_scissors_game\\image\\Paper.jpg";
String scissor = new File("").getAbsolutePath() + "\\src\\stone_paper_scissors_game\\image\\Scissor.jpg";
        String botChoice = null;
        int index = (int)(Math.random()*3);
        switch(index){
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
    
    public void playerWin(){
        
        result.setText("You win!");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) +1));
    }
    
    public void botWin(){
        
        result.setText("You lose");
        botScore.setText(String.valueOf(Integer.parseInt(botScore.getText()) +1));
    }
    
    public void draw(){
        
        result.setText("Draw");
     
    }
    
    private void winner(String playerChoice, String botChoice){
        if(playerChoice.equals(botChoice)){
            draw();
            return;
        }
        if(playerChoice.equals(STONE)){
            if(botChoice.equals(PAPER)){
                botWin();
            } else if(botChoice.equals(SCISSORS)){
                playerWin();
            }
        } else if(playerChoice.equals(PAPER)){
            if(botChoice.equals(STONE)){
                playerWin();
            } else if(botChoice.equals(SCISSORS)){
                botWin();
            }
        } else{
            if(botChoice.equals(STONE)){
                botWin();
            }else if(botChoice.equals(PAPER)){
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
    
}
