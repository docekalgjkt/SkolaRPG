package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoadGameController implements Initializable {

	@FXML
	private Button saveGame1;

	@FXML
	private Button saveGame2;

	@FXML
	private Button saveGame3;

	@FXML
	private Button smazat;

	@FXML
	private Button nacist;

	@FXML
	private Button ulozit;

	@FXML
	private Button zpet;

	private int idSaveGame;

	public int getIdSaveGame() {
		return idSaveGame;
	}

	public void setIdSaveGame(int idSaveGame) {
		this.idSaveGame = idSaveGame;
	}

	private String SaveName = ("save_" + new Date().getTime() + ".sav");

	public void handleSaveGame(ActionEvent event) {

	}

	public void handleSmazat(ActionEvent event) {
		try {

			File file = new File(SaveName);

			if (file.delete()) {
				System.out.println("Uložená hra " + idSaveGame + " byla smazána.");
			} else {
				System.out.println(
						"Nepodaøilo se smazat uloženou hru. Nìco se asi pokazilo. Kontaktujte technickou podporu, nebo se modlete k Bohu. Oboje bude mít podobný výsledek.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void handleNacist(ActionEvent event) {
		try {
			FileInputStream saveFile = new FileInputStream(SaveName);
			ObjectInputStream save = new ObjectInputStream(saveFile);

			save.readObject();
			save.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void handleUlozit(ActionEvent event) {
		String vyberHrace;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Pojmenujte svou uloženou hru:");
		vyberHrace = scanner.nextLine();
		SaveName = vyberHrace;
		scanner.close();

		try {
			FileOutputStream saveFile = new FileOutputStream(SaveName);
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			save.writeObject(model.Hrac.class);
			save.writeObject(model.Batoh.class);
			save.writeObject(model.Pozice.class);

			save.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void handleZpet(ActionEvent event) throws Exception {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
