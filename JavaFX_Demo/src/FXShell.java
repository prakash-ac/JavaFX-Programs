import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class FXShell extends Application {
	
	@Override 
	public void start(Stage primaryStage) {
		// can serve as a root node as well
		Pane pane = new FlowPane();
		Text sampleText = new Text("Hello World!");
		pane.getChildren().add(sampleText);
		sampleText.setFont(Font.font("Helvetica", 36));
		//sampleText.setFill(Color.SALMON);
		sampleText.setFill(Color.color(0, 0, 0));
		
		Scene scene = new Scene(pane, 300, 300, Color.BEIGE);
		primaryStage.setTitle("Hello JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[]args) {
		launch(args);
	}
}
