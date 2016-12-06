package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Batoh;
import model.TlacitkoInventare;
import model.characters.Postava;
import model.items.INositelne;
import model.items.Jidlo;
import model.items.Zbran;

public class InventarController implements Initializable
{
	/*
	 * Deklarace v�ech prvk�, kter� figuruj� v okn� batohu
	 */
	
	//odd�l zbran�
	@FXML
	private TilePane zbraneTilePane;
	@FXML
	private Label nazevZbraneLabel;
	@FXML
	private Label popisZbraneLabel;
	@FXML
	private Label utokZbraneLabel;
	@FXML
	private Label obranaZbraneLabel;
	@FXML
	private Label typPoskozeniZbraneLabel;
	@FXML
	private Label vydrzZbraneLabel;
	@FXML
	private Label cenaZbraneLabel;
	@FXML
	private Button vyberZbraneButton;
	
	//odd�l j�dla
	@FXML
	private TilePane jidloTilePane;
	@FXML
	private Label nazevJidlaLabel;
	@FXML
	private Label popisJidlaLabel;
	@FXML
	private Label hodnotaObnovyJidlaLabel;
	@FXML
	private Label cenaJidlaLabel;
	@FXML
	private Button vyberJidlaButton;
	
	//odd�l ostatn�
	@FXML
	private TilePane ostatniTilePane;
	@FXML
	private Label nazevOstatniLabel;
	@FXML
	private Label popisOstatniLabel;
	@FXML
	private Label cenaOstatniLabel;
	@FXML
	private Button vyberOstatniButton;
	
	/*
	 * Deklarace parametr� a prom�nn�ch
	 */
	
	private Postava postava;
	private INositelne vybranaZbran = null;
	private INositelne vybraneJidlo = null;
	private INositelne vybraneOstatni = null;
	private INositelne vybranyItem = null;
	
	/*
	 * Metody controlleru
	 */
	
	public void inicializujInventar() //napln�n� TilePan� tla��tky
	{
		Batoh batoh = postava.getBatoh();
		for(INositelne item : batoh)
		{
			TlacitkoInventare tlacitko = new TlacitkoInventare();
			tlacitko.setItem(item);
			tlacitko.setMinHeight(120);
			tlacitko.setMinWidth(120);
			if(item instanceof Zbran)
			{
				tlacitko.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> setVybranaZbran(item));
				zbraneTilePane.getChildren().add(tlacitko);
			}
			else if(item instanceof Jidlo)
			{
				tlacitko.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> setVybraneJidlo(item));
				jidloTilePane.getChildren().add(tlacitko);
			}
			else
			{
				tlacitko.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> setVybraneOstatni(item));
				ostatniTilePane.getChildren().add(tlacitko);
			}
		}
	}
	public void setPostava(Postava postava)
	{
		this.postava = postava;
	}
	private void clear() //�ist� TilePany, kdyby v nich n�co p��padn� bylo
	{
		zbraneTilePane.getChildren().removeAll(zbraneTilePane.getChildren());
		jidloTilePane.getChildren().removeAll(jidloTilePane.getChildren());
		ostatniTilePane.getChildren().removeAll(ostatniTilePane.getChildren());
	}
	private void refreshZbranStaty() //nastav� informace o dan� zbrani
	{
		nazevZbraneLabel.setText(getVybranaZbran().getNazev());
		popisZbraneLabel.setText(getVybranaZbran().getPopis());
		utokZbraneLabel.setText(Integer.toString(getVybranaZbran().getUtok()));
		obranaZbraneLabel.setText(Integer.toString(getVybranaZbran().getObrana()));
		typPoskozeniZbraneLabel.setText(getVybranaZbran().getTypUtoku().toString());
		vydrzZbraneLabel.setText(Integer.toString(getVybranaZbran().getTrvanlivost()));
		cenaZbraneLabel.setText(Integer.toString(getVybranaZbran().getHodnota()));
	}
	private void refreshJidloStaty() //nastav� informace o dan�m j�dle
	{
		nazevJidlaLabel.setText(getVybraneJidlo().getNazev());
		popisJidlaLabel.setText(getVybraneJidlo().getPopis());
		hodnotaObnovyJidlaLabel.setText(Integer.toString(getVybraneJidlo().getHodnotaObnovy())+getVybraneJidlo().getTypObnovy());
		cenaJidlaLabel.setText(Integer.toString(getVybraneJidlo().getHodnota()));
	}
	private void refreshOstatniStaty() //nastav� informace o dan�m odpadu/kl��i
	{
		nazevOstatniLabel.setText(getVybraneOstatni().getNazev());
		popisOstatniLabel.setText(getVybraneOstatni().getPopis());
		cenaOstatniLabel.setText(Integer.toString(getVybraneOstatni().getHodnota()));
	}
	public void setVybranyItem(INositelne item)
	{
		this.vybranyItem = item;
	}
	public INositelne getVybranyItem()
	{
		return vybranyItem;
	}
	
	/*
	 * Metody controlleru - handlery
	 */
	
	private void setVybranaZbran(INositelne zbran)	//handler pro tla��tka zbran�
	{
		vybranaZbran = zbran;
		refreshZbranStaty();
	}
	public Zbran getVybranaZbran()
	{
		return (Zbran) vybranaZbran;
	}
	
	private void setVybraneJidlo(INositelne jidlo)	//handler pro j�dla
	{
		vybraneJidlo = jidlo;
		refreshJidloStaty();
	}
	public Jidlo getVybraneJidlo()
	{
		return (Jidlo) vybraneJidlo;
	}
	
	private void setVybraneOstatni(INositelne ostatni)	//handler pro tla��tka odpadu + kl���
	{
		vybraneOstatni = ostatni;
		refreshOstatniStaty();
	}
	public INositelne getVybraneOstatni()
	{
		return vybraneOstatni;
	}
	
	/*
	 * tohle zakl�d�, abys v�d�l, ze kter� z�lo�ky byl v�b�r zvolen
	 * kdyby toti� u�ivatel nejd��v na v�ech n�co naklikal a potom se vr�til k tomu prvn�mu,
	 * tak nevybral to, na co naposled klinul, mus� tedy rozeznat, kter� v�b�r plat�
	 */
	public void setVybranyItemZbran(ActionEvent event) //handler tla��tka v�b�ru u zbran�
	{
		setVybranyItem(vybranaZbran);
		closeInventory(event);
	}
	public void setVybranyItemJidlo(ActionEvent event)	//handler pro tal��tko v�b�ru u j�dla
	{
		setVybranyItem(vybraneJidlo);
		closeInventory(event);
	}
	public void setVybranyItemOstatni(ActionEvent event) //handler pro tla��tko v�b�ru odpadu+kl���
	{
		setVybranyItem(vybraneOstatni);
		closeInventory(event);
	}
	private void closeInventory(ActionEvent event) //zav�r� okno
	{
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		clear();
	}
}
