import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;


public class DisplayQuotes extends Application{
	
	private VBox root;
	private Text quoteCategory;
	private Text quote;
	private Button insQuoteButton, myFavQuoteButton, funnyQuoteButton;
	private ArrayList<String> inspirationalQuotes = new ArrayList<String>(Arrays.asList(
			"There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle.\n- Albert Einstein",
			"I have not failed. I've just found 10,000 ways that won't work.\n- Thomas A. Edition", 
			"It is never too late to be what you might have been.\n- George Eliot",
			"Everything you can imagine is real.\n- Pablo Picasso",
			"Life isn't about finding yourself. Life is about creating yourself.\n- G. B. Shaw"
			));
	
	private ArrayList<String> myFavs = new ArrayList<String>(Arrays.asList(
			"Be the change that you wish to see in the world.\n-Mahatma Gandhi",
			"And, when you want something, all the universe conspires in helping you to achieve it.\n- Paulo Coelho",
			"What you're supposed to do when you don't like a thing is change it.If you can't change it, change the way you think about it. Don't complain\n- Maya Angelou",
			"It's the possibility of having a dream come true that makes life interesting.\n- Paulo Coelho",
			"When you have eliminated all which is impossible, then whatever remains, however improbable, must be the truth.\n- Arthur Conan Doyle",
			"Our lives begin to end the day we become silent about things that matter.\n- Martin Luther King Jr."
			));
	
	private ArrayList<String> funnyQuotes = new ArrayList<String>(Arrays.asList(
			"Before you judge a man, walk a mile in his shoes. After that who cares?... He’s a mile away and you’ve got his shoes!\n — Billy Connolly",
			"The best thing about the future is that it comes one day at a time.\n- Abraham Lincoln",
			"Nobody realizes that some people expend tremendous energy merely to be normal.\n - Albert Camus",
			"The difference between stupidity and genius is that genius has its limits.\n- Albert Einstein",
			"I refuse to answer that question on the grounds that I don’t know the answer.\n- Douglas Adams"
			));
	
	@Override
	public void start(Stage stage) {
		root = new VBox();
		//GridPane root = new GridPane();
		
		// category pane
		quoteCategory = new Text("Select Type of Quote");
		quoteCategory.setFont(Font.font("Helvatica", 20));
		TilePane catagoryPane = new TilePane(quoteCategory);
		catagoryPane.setAlignment(Pos.CENTER);
		catagoryPane.setPadding(new Insets(10, 0, 10, 0));
		root.getChildren().add(catagoryPane);
		
		// quote pane
		quote = new Text("No Quotes Selected");
		quote.setFontSmoothingType(FontSmoothingType.LCD);
		quote.setFont(Font.font("Apple Chancery", 16));
		FlowPane quotePane = new FlowPane(quote);
		quote.setLineSpacing(10);
		quotePane.setAlignment(Pos.CENTER);
		quotePane.setPadding(new Insets(10, 0, 30, 0));
		root.getChildren().add(quotePane);
		
		// Buttons
		insQuoteButton = new Button("Inspirational Quotes");
		insQuoteButton.setOnAction(this::handleButtons);
		
		myFavQuoteButton = new Button("My Favorite Quotes");
		myFavQuoteButton.setOnAction(this::handleButtons);
		
		funnyQuoteButton = new Button("Funny Quotes");
		funnyQuoteButton.setOnAction(this::handleButtons);
		
		HBox buttonBox = new HBox(insQuoteButton, myFavQuoteButton,funnyQuoteButton);
		buttonBox.setSpacing(10);
		buttonBox.setPadding(new Insets(50, 0, 0, 20));
		buttonBox.setAlignment(Pos.CENTER);
		root.getChildren().add(buttonBox);
		
		Scene scene = new Scene(root, 500, 300);
		stage.setScene(scene);
		stage.setTitle("Diplay Quote");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handleButtons(ActionEvent event) {
		quote.setWrappingWidth(400);
		String quoteString;
		if(event.getSource() == insQuoteButton) {
			quoteString = inspirationalQuotes.get((int)(Math.random()*5));
			root.setStyle("-fx-background-color:skyblue");
			quote.setText(quoteString);
			quote.setStroke(Color.CHOCOLATE);
			quoteCategory.setText("Inspirational Quote");
		} else if(event.getSource() == myFavQuoteButton) {
			quoteString = myFavs.get((int)(Math.random()*5));
			root.setStyle("-fx-background-color:skyblue");
			quote.setText(quoteString);
			quote.setStroke(Color.GRAY);
			quoteCategory.setText("My Favorite Quote");
		} else if(event.getSource() == funnyQuoteButton) {
			quoteString = funnyQuotes.get((int)(Math.random()*5));
			root.setStyle("-fx-background-color:yellow");
			quote.setText(quoteString);
			quote.setStroke(Color.GRAY);
			quoteCategory.setText("Funny Quote");
		}
	}
}
