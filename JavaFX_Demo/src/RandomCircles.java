import java.util.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class RandomCircles extends Application {
	private final static int WIDTH = 500, HEIGHT = 500;
	private Group circleGroup;
	VBox controlBox;
	private Pane circlesPane;
	private CheckBox fillCheckbox;
	private Button redrawButton; 
	private RadioButton singleColorButton, multipleColorButton;
	private Text text;
	private int numCircles;
	HBox radioButtonBox;
	
	@Override
	public void start(Stage stage) {
		BorderPane borderPane = new BorderPane();
		
		numCircles = getNumberCircles();
		
		circlesPane = new Pane();
		circlesPane.getChildren().add(createCircles());
		borderPane.setCenter(circlesPane); 
		
		redrawButton = new Button("Re-Draw Circles");
		redrawButton.setOnAction(this::handleRedrawButton);
		text = new Text("");
		
		fillCheckbox = new CheckBox("Fill Color?");
		fillCheckbox. setSelected(false);
		fillCheckbox.setOnAction(this::handleButtons);
		
		HBox controlBox1 = new HBox(redrawButton, fillCheckbox, text);
		controlBox1.setAlignment(Pos.CENTER);
		controlBox1.setSpacing(20);
		
		ToggleGroup colorGroup = new ToggleGroup();
		singleColorButton = new RadioButton("Single Color");
		singleColorButton.setToggleGroup(colorGroup);
		singleColorButton.setSelected(false);
		singleColorButton.setOnAction(this::handleButtons);
		
		multipleColorButton = new RadioButton("Multiple Color");
		multipleColorButton.setSelected(false);
		multipleColorButton.setOnAction(this::handleButtons);
		multipleColorButton.setToggleGroup(colorGroup);
		
		radioButtonBox = new HBox(singleColorButton, multipleColorButton);
		radioButtonBox.setSpacing(20);
		radioButtonBox.setAlignment(Pos.CENTER);
		
		controlBox = new VBox(controlBox1, radioButtonBox);
		controlBox.setSpacing(20);
		controlBox.setPadding(new Insets(10, 0, 20, 0));
		borderPane.setBottom(controlBox);
		Scene scene = new Scene(borderPane, WIDTH, HEIGHT, Color.TRANSPARENT);
		stage.setScene(scene);
		stage.setTitle("Circles");
		stage.show();
	}
	
	protected Group createCircles() {
		circleGroup = new Group();
		Random generator = new Random();
		for(int i=0;i<numCircles;i++) {
			double x = generator.nextInt(WIDTH );
			double y = generator.nextInt(HEIGHT-200); 
			double radius = generator.nextInt(WIDTH/4); 
			
			Circle circle = new Circle(x, y, radius);
			circle.setFill(Color.TRANSPARENT);
			
			circle.setStroke(Color.BLACK);
			circleGroup.getChildren().add(circle);
		}
		return circleGroup;
	}
	
	private void handleRedrawButton(ActionEvent event) {
		circlesPane.getChildren().remove(0);
		circlesPane.getChildren().add(createCircles());
		fillCheckbox.setSelected(false);
		singleColorButton.setSelected(false);
		multipleColorButton.setSelected(false);
	}
	
	private void handleButtons(ActionEvent event) {
		int numOfCircles = circleGroup.getChildren().size();
		if(fillCheckbox.isSelected() && !singleColorButton.isSelected() && !multipleColorButton.isSelected()){
			text.setText("Select single or multiple color");
			text.setStroke(Color.RED);
		}
		else if(fillCheckbox.isSelected() && event.getSource() == singleColorButton) {
			if(singleColorButton.isSelected()) {
				text.setText("");
				Color color = Color.color(Math.random(), Math.random(), Math.random());
				for(int i=0;i<numOfCircles;i++) {
					Circle c = (Circle) circleGroup.getChildren().get(i);
					c.setFill(color);
				}
			}
		} else if(fillCheckbox.isSelected() && event.getSource() == multipleColorButton) {
			text.setText("");
			for(int i=0;i<numOfCircles;i++) {
				Circle c = (Circle) circleGroup.getChildren().get(i);
				c.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			}
		} else if(!fillCheckbox.isSelected()) {
			singleColorButton.setSelected(false);
			multipleColorButton.setSelected(false);
			text.setText("");
			for(int i=0;i<numOfCircles;i++) {
				Circle c = (Circle) circleGroup.getChildren().get(i);
				c.setFill(Color.TRANSPARENT);
			}
		}
	}
	
	private int getNumberCircles() {
		String errorMessage = "";
		TextInputDialog inputDialog = new TextInputDialog();
		inputDialog.setHeaderText("Number of Circles");
		inputDialog.setHeaderText(null);
		inputDialog.setContentText("How many circles?");
	
		// return default number of circles
		
		Optional<String> userInput = inputDialog.showAndWait();
		if(userInput.isPresent()) {
			String userInputString = userInput.get();
			try {
				numCircles = Integer.parseInt(userInputString);
				return numCircles;
			} catch(NumberFormatException ex) {
				errorMessage = "Not a number!";
			}
		} else {
			errorMessage = "No number entered!";
		}
		
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(null);
		error.setTitle("Error!");
		error.setContentText(errorMessage + "\nDrawing 20 Circles");
		error.showAndWait();
		return 20;
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
