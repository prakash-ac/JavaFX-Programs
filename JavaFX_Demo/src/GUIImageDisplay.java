
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

public class GUIImageDisplay extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		VBox primaryBox = new VBox();
		
		Image myImage = new Image("prof1.jpeg", 200, 200, true, true);
		ImageView imgView = new ImageView(myImage);
		primaryBox.getChildren().add(imgView);
		primaryBox.setAlignment(Pos.CENTER);
		
		Text imgDescription = new Text("Prakash Acharya");
		primaryBox.getChildren().add(imgDescription);
		
		Scene scene = new Scene(primaryBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Display Image");
		primaryStage.show();
	}
	
	public static void main(String[]args) {
		launch(args);
	}
}
