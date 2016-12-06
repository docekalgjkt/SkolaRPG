package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.Batoh;
import model.BatohTlacitkoItemu;
import model.INositelne;
import model.Postava;
import model.Zbran;

public class BatohController implements Initializable
{
	//deklarace pol�
	@FXML
	private AnchorPane scena;
	@FXML
	private GridPane inventar;
	@FXML
	private ScrollPane scroll;
	@FXML
	private GridPane charakteristika;
	@FXML
	private Label name;
	@FXML
	private Label price;
	@FXML
	private Label popis;
	@FXML
	private Label durability;
	@FXML
	private Label attack;
	@FXML
	private Label defence;
	@FXML
	private Label typ;
	//vybran� p�edm�t
	private Zbran vybrany;
	//hr��
	private Postava postava;
	
	
	
	
	//nastaven� nov�ho vybran�ho itemu
	public void setVybrany(ActionEvent event)
	{
		BatohTlacitkoItemu vyber = (BatohTlacitkoItemu) event.getSource();
		this.vybrany = (Zbran) vyber.getZbran();
		refresh();
	}
	//nastaven� postavy
	public void setPostava(Postava postava)
	{
		this.postava = postava;
	}
	//getter postavy
	public Postava getPostava()
	{
		return postava;
	}
	//obnoven� charakteristik
	public void refresh()
	{
		name.setText(vybrany.getNazev());
		price.setText(Integer.toString(vybrany.getHodnota()));
		popis.setText(vybrany.getPopis());
		durability.setText(Integer.toString(vybrany.getTrvanlivost()));
		attack.setText(Integer.toString(vybrany.getUtok()));
		defence.setText(Integer.toString(vybrany.getObrana()));
		typ.setText(vybrany.getTypUtoku().toString());
	}
	//Napln�n� invent��e
	public void inicializaceBatohu()
	{
		inventar.getChildren().removeAll(inventar.getChildren());
		inventar.setHgap(6);
		inventar.setVgap(6);
		Batoh batoh = postava.getBatoh();
		int i = 0;
		for(INositelne zbran : batoh)
		{
			if(zbran instanceof Zbran)
			{
				BatohTlacitkoItemu zbranPole = new BatohTlacitkoItemu();
				zbranPole.setZbran(zbran);
				zbranPole.setOnAction(new EventHandler<ActionEvent>() 
				{
			            @Override 
			            public void handle(ActionEvent e) 
			            {
			                setVybrany(e);
			            }
				});
				
				//velikost, pop�. vzhled tla��tek zbran�
				zbranPole.setMinWidth(122);
				zbranPole.setMinHeight(122);
				
				
				if(i%2 == 0)
				{
					inventar.add(zbranPole, 0, i/2);	//item je vlevo
				}
				else
				{
					inventar.add(zbranPole, 1, (i-1)/2);	//item je vpravo
				}
				i++;
			}
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
	}	
}
