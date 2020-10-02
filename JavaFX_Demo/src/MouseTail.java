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

public class MouseTail extends Application{
	
	private final static int TAIL_SIZE = 10;
	private Pane pane;
	public void start(Stage stage) {
		
		
		pane = new Pane();
		
		pane.setOnMouseMoved(this::handleMouseMotion);
		
		
		Scene scene = new Scene(pane, 500, 500, Color.KHAKI);
		stage.setScene(scene);
		stage.setTitle("Mouse Tail Example");
		stage.show();
	}

	private void handleMouseMotion(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		
		Circle circle = new Circle(x, y, 5);
		if(pane.getChildren().size() > TAIL_SIZE   ) {
			 pane.getChildren().remove(0); 
			 pane.getChildren().add(circle);
		}else {
			pane.getChildren().add(circle);
		}

	}
	public static void main(String[] args) {
		launch(args);

	}

}