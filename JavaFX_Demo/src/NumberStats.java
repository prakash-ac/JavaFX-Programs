import java.util.ArrayList;
import java.util.Collections;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class NumberStats extends Application{
	
	private Button clearButton, calculateButton;
	private Text resultText;
	private TextField numberField;
	private Text numberFieldLabel;
	private ArrayList<Integer>  numberList = new ArrayList<Integer>();
	@Override
	public void start(Stage primaryStage){
		
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: beige");
		
		numberFieldLabel = new Text("Enter a number");
		numberField = new TextField();
		numberField.setMaxSize(50, 40);
		numberField.setOnAction(this::processNumberField);
		TilePane numberPane = new TilePane(numberFieldLabel, numberField);
		numberPane.setAlignment(Pos.CENTER);
		
		//gridPane.getChildren().add(numberPane); 

		gridPane.add(numberPane, 0, 0);
		
		calculateButton = new Button("Calculate");
		calculateButton.setOnAction(this::handleCalculateButton);
		clearButton = new Button("Clear");
		clearButton.setOnAction(this::handleClearButton);
		TilePane buttonPane = new TilePane(calculateButton, clearButton);
		buttonPane.setPadding( new Insets(25, 5, 10, 5));
		buttonPane.setAlignment(Pos.CENTER);
		gridPane.add(buttonPane, 0,  1);
		
		resultText = new Text("");
		TilePane resultPane = new TilePane(resultText);
		resultPane.setAlignment(Pos.CENTER);
		gridPane.add(resultPane, 0, 2);
		gridPane.setPadding( new Insets(20, 15, 10, 15));
		gridPane.setVgap(20);
		
		Scene scene = new Scene(gridPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Number Stats");
		primaryStage.show();
	}
	
	public static void main(String[]args) {
		launch(args);
	}
	
	private void processNumberField(ActionEvent event) {
		try {
			int inputNumber = Integer.parseInt(numberField.getText());
			numberList.add(inputNumber);
			numberField.clear();
		} catch(NumberFormatException ex) {
			resultText.setText("Error: \'" + numberField.getText() + "\' is not a number.");
			resultText.setFill(Color.RED);
		} finally {
			numberField.clear();
		}
		
	}
	
	private void handleClearButton(ActionEvent event) {
		resultText.setText("");
		numberList = new ArrayList<Integer>();
	}
	private void handleCalculateButton(ActionEvent event) {
		int total=0, min, max;
		double average;
		
		for(int i: numberList) {
			total += i;
		}
		
		if(!numberList.isEmpty()) {
			min = Collections.min(numberList);
			max = Collections.max(numberList);
			average = (double) total/numberList.size();
			String resultString = "Statistics: ";
			resultString += "\nMin: " + min +
				"\nMax: " + max +
				"\nTotal: " + total +
				"\nAverage: " + average;
		resultText.setText(resultString);
		resultText.setFill(Color.BLACK);
		}
	}
}
