import java.util.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// Hi-Low Game
public class HiLow extends Application{
	
	private VBox primaryBox, innerVBox;
	private TextField userInputField;
	private Button submitButton, startOver;
	private int randomNumber, count=0;
	private Text resultText;
	HBox resultBox, startOverBox;
	HBox inputLabelBox;
	
	@Override
	public void start(Stage primaryStage) {
		
		randomNumber = (int)(Math.random() * 100 + 1);
		
		primaryBox = new VBox();
		innerVBox = new VBox();
		//primaryBox.setBackground(new BackgroundImage("celbrations.gif")));
		Text welcomeText = new Text("Welcome to Hi-Low Guessing Game!");
		welcomeText.setFill(Color.LIGHTSALMON);
		welcomeText.setFont(Font.font("Helvatica", 20));
		
		HBox welcomeBox = new HBox(welcomeText);
		welcomeBox.setAlignment(Pos.CENTER);
		welcomeBox.setPadding( new Insets(20, 0, 10, 0));
		primaryBox.getChildren().add(welcomeBox);
		
		Text inputLabel = new Text("Guess the Number");
		inputLabel.setFill(Color.BLUEVIOLET);
		inputLabel.setFont(Font.font(18));
		inputLabelBox = new HBox(inputLabel);
		inputLabelBox.setAlignment(Pos.CENTER);
		inputLabelBox.setPadding(new Insets(0, 0, 10, 0));
		innerVBox.getChildren().add(inputLabelBox);
		
		Text infoText = new Text("Enter a number between 1-100.");
		infoText.setFont(Font.font(10));
		HBox userInfoBox = new HBox(infoText);
		userInfoBox.setPadding(new Insets(0, 0, 0, 94));;
		innerVBox.getChildren().add(userInfoBox);		
		
		userInputField = new TextField("");
		userInputField.setMaxWidth(300);
		userInputField.setMinHeight(25);
		userInputField.setFont(Font.font(10));
		userInputField.setOnAction(this::processUserInput);
		
		submitButton = new Button("Submit");
		submitButton.setOnAction(this::processUserInput);
		
		HBox inputBox = new HBox(userInputField, submitButton);
		inputBox.setAlignment(Pos.CENTER);
		inputBox.setSpacing(30);
		innerVBox.getChildren().add(inputBox);
		primaryBox.getChildren().add(innerVBox);

		
		//result text
		resultText = new Text("");
		
		resultBox = new HBox(resultText);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setPadding(new Insets(20, 0, 0, 0));
		resultBox.setSpacing(20);
		primaryBox.getChildren().add(resultBox);
		
		startOver = new Button("Start Over");
		startOver.setOnAction(this::handleStartOverButton);
		startOverBox = new HBox(startOver);
		startOverBox.setPadding(new Insets(20, 0, 0, 0));
		startOverBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(primaryBox, 400, 300, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hi-Low Guessing Game");
		primaryStage.show();
	}
	
	private void processUserInput(ActionEvent event) {
		String userInputStr = userInputField.getText();
		String error = "Enter a number!";
		int userNum = -1;
		try {
			userNum = Integer.parseInt(userInputStr);
		}catch (IllegalArgumentException ex) {
			resultText.setText(error);
			resultText.setFill(Color.RED);
			resultText.setFont(Font.font(18));
			userInputField.clear();
			System.out.println("Catch-Block");
		} finally {
			System.out.println("Finally-Block: Value of userNum = " + userNum + " Random Number = " + randomNumber);
			
			if(userNum > -1) {
				count++;
				resultText.setFont(Font.font(18));
				resultText.setFill(Color.BLACK);
				
				if(userNum==randomNumber) {
					BackgroundImage backgroundimage = new BackgroundImage(new Image("celebration.gif"),  
		                  BackgroundRepeat.NO_REPEAT,  
		                  BackgroundRepeat.NO_REPEAT,  
		                  BackgroundPosition.CENTER,  
		                     BackgroundSize.DEFAULT); 
		
					// create Background 
					Background background = new Background(backgroundimage); 
		
					// set background 
					primaryBox.setBackground(background); 
					resultText.setText("Correct!! Congratulations!!!\nYou got it correct in " + count + " attempt(s)!");
					resultText.setFill(Color.ALICEBLUE);
					userInputField.clear();
					primaryBox.getChildren().remove(1);
					primaryBox.getChildren().add(startOverBox);
		
				} else if(userNum < randomNumber) {
					resultText.setText("That was LOW! Try Again!!");
					userInputField.clear();
				} else if(userNum > randomNumber){
					resultText.setText("That was HIGH! Try Again!!");
					userInputField.clear();
					}
				}
			}
	}
	
	private void handleStartOverButton(ActionEvent event) {
		int index = primaryBox.getChildren().size()-1;
		primaryBox.setBackground(null);
		resultText.setText("");
		primaryBox.getChildren().remove(index);
		primaryBox.getChildren().add(innerVBox);
		randomNumber = (int)(Math.random() * 100);
	}

	public static void main(String[] args) {
		launch(args);

	}

}
