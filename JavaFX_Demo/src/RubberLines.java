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

public class RubberLines extends Application{
	
	private Line line;
	private boolean lineBeingDrawn;
	
	public void start(Stage stage) {
		
		lineBeingDrawn = false;
		
		Pane pane = new Pane();
		pane.setOnMouseClicked(this::handleMouseClicks);
		pane.setOnMouseMoved(this::handleMouseMotion);
		
		line = new Line(-10, -10, -10, -10);
		line.setStroke(Color.BLACK);
		line.setStrokeWidth(4);
		pane.getChildren().add(line);
		
		
		Scene scene = new Scene(pane, 500, 500, Color.ALICEBLUE);
		stage.setScene(scene);
		stage.setTitle("Rubber Lines Example");
		stage.show();
	}
	
	private void handleMouseClicks(MouseEvent event) {
		if(!lineBeingDrawn) {
			lineBeingDrawn = true;
			
			double x = event.getX();
			double y = event.getY();
			
			line.setStartX(x);
			line.setStartY(y);
			line.setEndX(x);
			line.setEndY(y);
			
		} else {
			lineBeingDrawn = false;
		}
	}
	private void handleMouseMotion(MouseEvent event) {
		
		if(lineBeingDrawn) {
			double x = event.getX();
			double y = event.getY();
			
			line.setEndX(x);
			line.setEndY(y);
		}
	}
	public static void main(String[] args) {
		launch(args);

	}

}
 