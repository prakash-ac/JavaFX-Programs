import java.util.ArrayList;
import java.util.Collections;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class TransformationExample extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		
		int startX=100, startY=100, length=200, width=50;
		Group group = new Group();
		
		Image myImage = new Image("prof1.jpeg", 200, 200, true, true);
		ImageView imgView = new ImageView(myImage);
		imgView.setRotate(45);
		
		group.getChildren().add(imgView);
		
		// create 10 rectangles
		for(int i=0;i<10;i++) {
			Rectangle rect = new Rectangle(startX, startY, length, width);
			rect.setTranslateX(i*10);
			rect.setTranslateY(i*10);
			rect.setFill(Color.TRANSPARENT);
			rect.setStroke(Color.BLACK);
			group.getChildren().add(rect);
		}
		
		FlowPane fPane = new FlowPane(group);
		Scene scene = new Scene(fPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Display Image");
		primaryStage.show();
	}
	
	public static void main(String[]args) {
		launch(args);
	}
}
