import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class SmilyFaceGUI extends Application{
	
	private Button eyeColorButton;
	private Circle faceCircle;
	private Ellipse leftEye, rightEye, nose;
	private Rectangle mouth;
	@Override
	public void start(Stage primaryStage) {
		
		faceCircle = new Circle(150, 100, 50);
		faceCircle.setFill(Color.TRANSPARENT);
		faceCircle.setStroke(Color.BLACK);
		
		leftEye = new Ellipse(130, 80, 10, 5);
		leftEye.setStroke(Color.BLACK);

		rightEye = new Ellipse(170, 80, 10, 5);
		rightEye.setStroke(Color.BLACK);
		nose = new Ellipse(150, 100, 4, 8);
		
		mouth = new Rectangle(140, 120, 20, 6);
		mouth.setStroke(Color.BLACK);
		
		Group faceShapes = new Group(faceCircle, rightEye, leftEye, nose, mouth);
		Pane facePane = new Pane(faceShapes);
		
		eyeColorButton = new Button("Change Eye Color");
		eyeColorButton.setOnAction(this::handleEyeColorButton);
		
		VBox primaryBox = new VBox();
		primaryBox.getChildren().addAll(facePane, eyeColorButton);
		primaryBox.setSpacing(100);
		primaryBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(primaryBox, 300, 300, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Smiley Face");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handleEyeColorButton(ActionEvent event) {
		Color eyeColor = Color.color(Math.random(), Math.random(), Math.random());
		leftEye.setFill(eyeColor);
		rightEye.setFill(eyeColor);
	}
}
