import java.util.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DialogBoxExample extends Application{
	
	public void start(Stage stage) {
		
		boolean keepGoing = true;
		while(keepGoing) {
			TextInputDialog inputDialog = new TextInputDialog();
			
			inputDialog.setHeaderText(null);
			inputDialog.setTitle("Enter Numbers");
			inputDialog.setContentText("Enter a number");
			
			Optional<String> userInput = inputDialog.showAndWait();
			
			if(userInput.isPresent()) {
				String userInputString = userInput.get();
				int userNumber1 = Integer.parseInt(userInputString);
				
				inputDialog.getEditor().clear();
				Optional<String> userInput1 = inputDialog.showAndWait();
			
				if(userInput.isPresent()) {
					String userInputString1 = userInput1 .get();
					int userNumber2 = Integer.parseInt(userInputString1);
					int product = userNumber1 * userNumber2;
					
					Alert resultAlert = new Alert(AlertType.INFORMATION);
					resultAlert.setContentText("Prduct: " + product);
					resultAlert.setHeaderText(null);
					resultAlert.setTitle("Results");
					resultAlert.showAndWait();
					
					Alert againAlert = new Alert(AlertType.CONFIRMATION);
					againAlert.setTitle("Again?");
					againAlert.setHeaderText(null);
					againAlert.setContentText("Enter another pair of values?");
					
					Optional<ButtonType> userSelection = againAlert.showAndWait();
					
					if(userSelection.isPresent() && userSelection.get() == ButtonType.OK){
						keepGoing = true;
					} else {
						keepGoing = false;
					}
				}
			}
		else {
			System.out.println("No user input");
			 }
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}