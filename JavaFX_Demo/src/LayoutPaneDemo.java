import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class LayoutPaneDemo extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		
		/* FlowPane layout 
		Button b1 = new Button("Button 1");
		b1.setBorder(null);
		Button b2 = new Button("Button 2");
		Button b3 = new Button("Button 3");	
		Button b4 = new Button("Button 4");
		Button b5 = new Button("Button 5");
		
		// add all buttons to the flow pane at once
		FlowPane flowPane = new FlowPane(b1, b2, b3, b4, b5);
		flowPane.setStyle("-fx-background-color: green"); // css styling
		
		// set alignment
		flowPane.setAlignment(Pos.CENTER);
		flowPane.setHgap(20);
		flowPane.setVgap(20);
		
		Scene scene = new Scene(flowPane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
		
		/* TilePane Layout */
		/*
		Button b1 = new Button("Button 1");
		b1.setBorder(null);
		Button b2 = new Button("Longer Button");
		Button b3 = new Button("Longest Button in tile pane");	
		Button b4 = new Button("Button 4");
		Button b5 = new Button("Button 5");
		
		// add all buttons to the flow pane at once
		TilePane tilePane = new TilePane(b1, b2, b3, b4, b5);
		tilePane.setStyle("-fx-background-color: green"); // css styling
		
		// set alignment
		tilePane.setAlignment(Pos.CENTER);
		tilePane.setHgap(20);
		tilePane.setVgap(20);
		
		Scene scene = new Scene(tilePane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
		/* StackPane Layout  */
		//ImageView imageView = new ImageView(new Image("prof.jpeg"));
		
		Circle circle = new Circle(40, Color.AQUA);
		Text txt = new Text("Prakash");
		Rectangle border = new Rectangle(120, 150, Color.TRANSPARENT);
		border.setStroke(Color.ANTIQUEWHITE);
		border.setStrokeWidth(5);
		
		StackPane stackPane = new StackPane();
		//stackPane.getChildren().add(imageView);
		stackPane.getChildren().add(circle);
		stackPane.getChildren().add(txt);
		stackPane.getChildren().add(border);
		
		/* HBox and VBox Layout */
		
		Button b1 = new Button("Button 1");
		b1.setBorder(null);
		Button b2 = new Button("Longer Button");
		Button b3 = new Button("Longest Button in tile pane");	
		Button b4 = new Button("Button 4");
		Button b5 = new Button("Button 5");
		HBox hBox = new HBox();
		hBox.getChildren().add(b1);
		hBox.getChildren().add(b2);
		hBox.getChildren().add(b3);
		hBox.getChildren().add(b4);
		hBox.getChildren().add(b5);
		hBox.setPadding(new Insets(10, 20, 10, 20));
		hBox.setSpacing(10);
		
		//VBox nestedPanes  = new VBox(stackPane, hBox);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(hBox);
		borderPane.setCenter(stackPane);
		borderPane.setLeft(hBox);
		borderPane.setRight(stackPane);
		Scene scene = new Scene(borderPane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
