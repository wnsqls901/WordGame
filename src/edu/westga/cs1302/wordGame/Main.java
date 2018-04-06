package edu.westga.cs1302.wordGame;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


/**
 * The Class Main to run the application
 * 
 * @author Junbin Kwon
 * @version 04-04-2018
 */
public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/wordGameGui.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			primaryStage.setTitle("A Word Game by Junbin Kwon");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
