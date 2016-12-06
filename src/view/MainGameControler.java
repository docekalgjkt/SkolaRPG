package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
public class MainGameControler implements Initializable
{
	@FXML
	private MenuButton Menu;
	
	@FXML
	private MenuItem LoadGame;
	
	@FXML
	private MenuItem Options;
	
	@FXML
	private MenuItem MainMenu;
	
	@FXML
	private Button Inventory;
	

	public void OpenInventory(ActionEvent event) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/BatohView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
