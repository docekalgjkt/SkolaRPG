package model;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import model.characters.Postava;

public class Arena 
{
	@FXML
	private Label mojeJmeno;
	@FXML
	private Label nepritelovoJmeno;
	@FXML
	private ProgressBar tvojeHPBar;
	@FXML
	private ProgressBar nepritelovoHpBar;
	@FXML
	private Button vyberZbran;
	@FXML
	private ImageView nepritelovaZbranView;
	
	private Postava tvojePostava;
	private Postava nepritel;
	
	public Arena(){}
	public void setTvojePostava(Postava ty)
	{
		this.tvojePostava = ty;
	}
	public void setNepritel(Postava nepritel)
	{
		this.nepritel = nepritel;
	}
	public void fight()
	{
		loadArenaWindow();
	}
	private void loadArenaWindow() //zobrazí okno Arény
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Arena.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Main.getStage().setScene(scene);
			loadInfo();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void loadInfo()
	{
		mojeJmeno.setText(tvojePostava.getJmeno());
		nepritelovoJmeno.setText(nepritel.getJmeno());
		tvojeHPBar.setProgress(tvojePostava.getHP()/100); //tady nastavuješ maximální poèet HP
		nepritelovoHpBar.setProgress(nepritel.getHP()/100);
	}
}
