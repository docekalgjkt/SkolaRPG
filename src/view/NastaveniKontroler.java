package view;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.ui.Screen;

import Util.Konfigurace;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class NastaveniKontroler implements Initializable {
	
	private Stage primaryStage;
	
	private int rozliseniVyska;
	private int rozliseniSirka;
	
	@FXML
	private MenuItem rozliseni1;
	@FXML
	private MenuItem rozliseni2;
	@FXML
	private MenuItem rozliseni3;
	@FXML
	private MenuItem rozliseni4;
	@FXML
	private Label text;
	@FXML
	private Button full;
	@FXML
	private Button win;
	
	
		
	@FXML
	public void handleRozliseni1(ActionEvent event){
		/*Stage stage = (Stage) rozliseni1.getScene().getWindow();*/
		rozliseniVyska = 1080;
		rozliseniSirka = 1920;
		updateStage();
		
	}
	@FXML
	public void handleRozliseni2(ActionEvent event){
		/*Stage stage = (Stage) rozliseni1.getScene().getWindow();*/
		
		rozliseniVyska = 900;
		rozliseniSirka = 1600;
		updateStage();
	}
	@FXML
	public void handleRozliseni3(ActionEvent event){
		/*Stage stage = (Stage) rozliseni1.getScene().getWindow();*/
		
		rozliseniVyska = 768;
		rozliseniSirka = 1366;
		updateStage();
	}
	@FXML
	public void handleRozliseni4(ActionEvent event){
		/*Stage stage = (Stage) rozliseni1.getScene().getWindow();*/
		
		rozliseniVyska = 720;
		rozliseniSirka = 1280;
		updateStage();
	}
	private void updateStage(){
		primaryStage.setHeight(rozliseniVyska);
		primaryStage.setWidth(rozliseniSirka);
	}
	
	@FXML
	public void handleFull(ActionEvent event){
		Stage stage = (Stage) full.getScene().getWindow();
		
		stage.setFullScreen(true);
		Konfigurace.getKonfigurace().getFullScreen();

	} 
	@FXML
	public void handleWin(ActionEvent event){
		Stage stage = (Stage) win.getScene().getWindow();
		stage.setFullScreen(false);
	}
	
	
	/*private EventHandler<ActionEvent> loginClienteHandler() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void setprimaryStage(Stage stage){
		this.primaryStage = stage;
	}

}
