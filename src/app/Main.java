package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Hrac;
import view.MainMenuController;

public class Main extends Application{
	
	private Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
//		otevriHlavniOkno(stage);
		otevriOkno(stage, "/view/MainMenu.fxml");
		inicializuj();
	}
	
	/**
	 * Nastavení a inicializace hry.
	 * 
	 * */
	private void inicializuj(){
		
	}
	
	/**
	 * Otevøení hlavního okna.
	 * @throws IOException 
	 */
	private void otevriHlavniOkno(Stage stage) throws IOException{
		primaryStage = stage;
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainMenu.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Otevøení libovolného okna ze zadaného názvu fxml souboru
	 * @param stage
	 * @param resource
	 * @throws IOException
	 */
	private void otevriOkno(Stage stage, String resource) throws IOException{
		primaryStage = stage;
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(resource));
		AnchorPane pane = (AnchorPane) loader.load();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		
	}

}
