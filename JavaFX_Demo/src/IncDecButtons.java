
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class IncDecButtons extends Application {
	
	private Text counterText;
	private Button incButton, decButton;
	private int counter;
	private TextField intervalTextField;
	private Text intervalText;
	private int increment;
	
	public void start(Stage primaryStage) {
		
		counter = 0;
		increment = 1;
		// main scene node
		VBox mainVBox = new VBox();
		mainVBox.setStyle("-fx-background-color: skyblue");
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setSpacing(20);
		
		// counter text  
		counterText = new Text(Integer.toString(counter));
		counterText.setFont(Font.font("Helvetica", 20));
		counterText.setFill(Color.CHOCOLATE);
		mainVBox.getChildren().add(counterText);
		
		// two buttons
		incButton = new Button("+");
		incButton.setScaleX(1.5);
		incButton.setScaleY(1.5);
		incButton.setOnAction(this::handleButtons);
		decButton = new Button("-");
		decButton.setOnAction(this::handleButtons);
		decButton.setScaleX(1.5);
		decButton.setScaleY(1.5);
		HBox buttonBox = new HBox(incButton, decButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(20);
		mainVBox.getChildren().add(buttonBox);
		
		intervalText = new Text("Set Interval: ");
		intervalTextField = new TextField("1");
		intervalTextField.setMaxSize(50, 30);
		intervalTextField.setOnAction(this::processTextField);
		
		// HBox that contains two children intervalTextField and intervalField
		HBox intervalBox = new HBox(intervalText, intervalTextField);
		intervalBox.setAlignment(Pos.CENTER);
		intervalBox.setSpacing(10);
		mainVBox.getChildren().add(intervalBox);
		
		Scene scene = new Scene(mainVBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handleButtons(ActionEvent event) {
		increment = Integer.parseInt(intervalTextField.getText());
		if(event.getSource() == incButton) {
			counter += increment;
		} else if (event.getSource() == decButton) {
			counter -= increment;
		}
		counterText.setText(Integer.toString(counter));
	}
	
	public void processTextField(ActionEvent event) {
		increment = Integer.parseInt(intervalTextField.getText());
	}
}
