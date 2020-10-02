
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class InteractiveImageDisplay extends Application{
	
	private CheckBox descriptionCheckBox;
	private Text imgDescription;
	private RadioButton pRadioButton, rRadioButton;
	private ImageView imgView;
	private Image myImage, herImage;
	private String prakash, ranjana;
	@Override
	public void start(Stage primaryStage) {
		VBox primaryBox = new VBox();
		
		prakash = "Er. Prakash Acharya";
		ranjana = "Dr. Ranjana Bhattarai";
		
		myImage = new Image("prof1.jpeg", 200, 200, true, true);
		herImage = new Image("ranju.jpeg", 200, 200, true, true);
		imgView = new ImageView(myImage);
		primaryBox.getChildren().add(imgView);
		primaryBox.setAlignment(Pos.CENTER);
		
		imgDescription = new Text(prakash);
		primaryBox.getChildren().add(imgDescription);
		
		// check-box
		descriptionCheckBox = new CheckBox("Display Description");
		descriptionCheckBox.setSelected(true);
		descriptionCheckBox.setOnAction(this::handleDescriptionCheckBox);
		primaryBox.getChildren().add(descriptionCheckBox);
		
		// radio buttons
		ToggleGroup photoGroup = new ToggleGroup();
		pRadioButton = new RadioButton("Prakash's Photo");
		pRadioButton.setToggleGroup(photoGroup);
		pRadioButton.setOnAction(this::handleRadioButtons);
		pRadioButton.setSelected(true);
		
		rRadioButton = new RadioButton("Ranjana's Photo");
		rRadioButton.setToggleGroup(photoGroup);
		rRadioButton.setOnAction(this::handleRadioButtons);
		HBox radioButtonBox = new HBox(pRadioButton, rRadioButton);
		radioButtonBox.setAlignment(Pos.CENTER);
		primaryBox.getChildren().add(radioButtonBox);
		
		
		Scene scene = new Scene(primaryBox, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Display Image");
		primaryStage.show();
	}
	
	public static void main(String[]args) {
		launch(args);
	}
	
	private void handleDescriptionCheckBox(ActionEvent event) {
		
		if(descriptionCheckBox.isSelected()) {
			imgDescription.setVisible(true);
			
		}else if(!descriptionCheckBox.isSelected()) {
			imgDescription.setVisible(false);
			
		}
		
	}
	
	private void handleRadioButtons(ActionEvent event) {
		if(pRadioButton.isSelected()) {
			imgView.setImage(myImage);
			imgDescription.setText(prakash);
		} else if(rRadioButton.isSelected()) {
			imgView.setImage(herImage);
			imgDescription.setText(ranjana);
		}
	}
}
