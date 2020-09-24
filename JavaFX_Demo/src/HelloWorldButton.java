import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloWorldButton extends Application {
	
	private Button button;
	private Text sampleText;
	@Override 
	public void start(Stage primaryStage) {
		// can serve as a root node as well
		Pane pane = new FlowPane();
		
		sampleText = new Text("Hello World!");
		pane.getChildren().add(sampleText);
		sampleText.setFont(Font.font("Helvetica", 36));
		//sampleText.setFill(Color.SALMON);
		sampleText.setFill(Color.color(0, 0, 0));
		
		button = new Button("Click Here!");
		button.setOnAction(this::handleButton);
		pane.getChildren().add(button);	
		Scene scene = new Scene(pane, 300, 300, Color.BEIGE);
		primaryStage.setTitle("Hello JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// this will handle the click on the Click Here! button 
	private void handleButton(ActionEvent event) {
		sampleText.setText("The button was clicked!");
		button.setDisable(true);
	}
	
	public static void main(String[]args) {
		launch(args);
	}
}
