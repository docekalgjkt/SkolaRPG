package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Hrac;

public class MainMenuController implements Initializable {

	@FXML
	private Button novaHra;
	@FXML
	private Button nacistHru;
	@FXML
	private Button nastaveni;
	@FXML
	private Button konec;

	public void handleNovaHra(ActionEvent event) {
		Hrac hrac = new Hrac();
		hrac.setSytost(100);
		hrac.setKofein(40);
		hrac.zran(60);
		System.out.println("Sytost: " + hrac.getSytost() + ", Kofein: " + hrac.getKofein());
	}

	public void handleNacistHru(ActionEvent event) throws Exception {
		Stage podium = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoadGame.fxml"));
		Parent koren = loader.load();

		loader.getController();

		Scene scena = new Scene(koren);
		podium.setScene(scena);
		podium.show();
		podium.setTitle("Škola RPG");

		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	public void handleNastaveni(ActionEvent event) throws Exception {
		Stage podium = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Nastaveni.fxml"));
		Parent koren = loader.load();

		loader.getController();

		Scene scena = new Scene(koren);
		podium.setScene(scena);
		podium.show();
		podium.setTitle("Škola RPG");

		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	public void handleKonec(ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
