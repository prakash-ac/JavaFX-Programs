import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class ButtonCount extends Application{
	private Button button;
	private Text buttonCountText;
	private Text text;
	private int clickCount;
	private Scene scene;
	
	public void start(Stage stage) {
		clickCount = 0;
		
		Pane pane = new FlowPane();
		pane.setStyle("-fx-background-color: null");
		
		text = new Text("Count your clicks!");
		pane.getChildren().add(text);
		
		button = new Button("Click Here");
		button.setOnAction(this::processButton);
		
		pane.getChildren().add(button);
		
		buttonCountText = new Text("Count: 0");
		pane.getChildren().add(buttonCountText);
		scene = new Scene(pane, 300, 300);
		scene.setFill(Color.CORAL);
		
		
		stage.setTitle("Button Click Count");
		stage.setScene(scene);
		stage.show();
	}
	
	private void processButton(ActionEvent event) {
		
		clickCount++;
		if(clickCount % 5 == 0) {
			scene.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		}
		buttonCountText.setText("Total Clicks: " + clickCount);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
