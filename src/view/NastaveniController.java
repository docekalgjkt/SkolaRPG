package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class NastaveniController implements Initializable {

	public boolean fullscreen = false;
	@FXML
	private Button donate;
	@FXML
	private Label text;
	@FXML
	private Button full;
	@FXML
	private MenuButton resolution;
	@FXML
	private MenuButton quality;
	@FXML
	private Slider volume;
	@FXML
	private MenuButton language;
	@FXML
	private Button win;
	@FXML
	private Button back;

	public void handleDonate(ActionEvent event) {

		text.setText("Více u žida Patrika.");
	}

	public void handleFull(ActionEvent event) {
		
		full.setDisable(fullscreen);
		fullscreen = true;

		Stage stage = (Stage) full.getScene().getWindow();
		stage.close();
		stage.setFullScreen(true);
		stage.show();



	}

	public void handleResolution(ActionEvent event) {

	}

	public void handleQuality(ActionEvent event) {

	}

	public void handleVolume(ActionEvent event) {

	}

	public void handleLanguage(ActionEvent event) {

	}

	public void handleWin(ActionEvent event) {
		
		win.setDisable(!fullscreen);
		fullscreen = false;

		Stage stage = (Stage) full.getScene().getWindow();
		stage.close();
		stage.setFullScreen(false);
		stage.show();

	}

	public void handleBack(ActionEvent event) throws Exception {
		Stage podium = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainMenu.fxml"));
		Parent koren = loader.load();

		loader.getController();

		Scene scena = new Scene(koren);
		podium.setScene(scena);
		podium.show();
		podium.setTitle("Škola RPG");

		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	private EventHandler<ActionEvent> loginClienteHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
