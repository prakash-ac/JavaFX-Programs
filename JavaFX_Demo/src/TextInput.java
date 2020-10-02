import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class TextInput extends Application {
	
	private Text txt, inputFieldLabel;
	private TextField tF;
	private Button submitButton;
	
	@Override 
	public void start(Stage primaryStage) {
		
		// Serves as a root node as well
		Pane pane = new FlowPane();
		pane.setStyle("-fx-background-color: null");
		
		tF = new TextField();
		tF.setOnAction(this::processInput);
		
		inputFieldLabel = new Text("Enter anything");
		pane.getChildren().add(inputFieldLabel);
		
		pane.getChildren().add(tF);
		
		submitButton = new Button("Submit");
		// one event handlers can handle many events
		submitButton.setOnAction(this::processInput);
		pane.getChildren().add(submitButton);
		
		txt = new Text();
		txt.setFont(Font.font("Helvetica", 16));
		txt.setFill(Color.color(0, 0, 0));
		pane.getChildren().add(txt);
		
		Scene scene = new Scene(pane, 300, 300, Color.SKYBLUE);
		primaryStage.setTitle("Input Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void processInput(ActionEvent event) {
		String str = tF.getText();
		txt.setText("Your input : " + str);
		tF.clear();
	}
	
	public static void main(String[]args) {
		launch(args);
	}
}
