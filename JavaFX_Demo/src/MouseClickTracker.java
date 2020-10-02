import java.util.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
 
public class MouseClickTracker extends Application {
	
	private Pane pane;
	private Text text, countText;
	private BorderPane borderPane;
	private int clickCount;
	public void start(Stage primaryStage) {
		
		borderPane = new BorderPane();
		
		pane = new Pane();
		pane.setOnMouseClicked(this::handleMouseClicks );
		borderPane.setCenter(pane);
		
		clickCount = 0;
		countText = new Text("Total Clicks: " + clickCount);
		borderPane.setBottom(countText);
		borderPane.setPadding( new Insets(20, 0, 20, 20));
		Scene scene = new Scene(borderPane, 500, 500, Color.TOMATO);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mouse Click Tracker");
		primaryStage.show();
	}
	
	private void handleMouseClicks(MouseEvent event) {
		clickCount++;
		
		double x = event.getX();
		double y = event.getY();
		
		Circle circle = new Circle(x, y, 5);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);
		
		pane.getChildren().add(circle);
		
		String coordinates = "(" + x + ", " + y + ")";
		text = new Text(x-10, y-10, coordinates);
		pane.getChildren().add(text);
		
		countText.setText("Total Clicks: " + clickCount);
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}
