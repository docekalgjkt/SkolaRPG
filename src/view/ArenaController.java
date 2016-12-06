package view;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Arena;
import model.Hrac;
import model.INositelne;
import model.NPC;

public class ArenaController implements Initializable{
	
	private VyberInventare vyberInventare;
	private Main main;
	private Arena arena;
	
	NumberFormat formatter = new DecimalFormat("#0.0");
	
	private double hracovaSytostNaZacatku;
	private double hracuvNikotinNaZacatku;
	private double hracuvKofeinNaZacatku;
	private double nepritelovyHPNaZacatku;
	
	@FXML
	private Label typ;
	@FXML
	private Label hodnota;
	@FXML
	private AnchorPane spodniCast;
	@FXML
	private AnchorPane horniCast;
	@FXML
	private AnchorPane koncovaCast;
	@FXML
	private Button boj;
	@FXML
	private Label bojovnik1Label;
	@FXML
	private Label bojovnik2Label;
	@FXML
	private Label pocetKol;
	@FXML
	private ImageView hracImageView;
	@FXML
	private ImageView nepritelImageView;
	@FXML
	private ProgressBar hracSytostProgressBar;
	@FXML
	private ProgressBar hracNikotinProgressBar;
	@FXML
	private ProgressBar hracKofeinProgressBar;
	@FXML
	private Label hracSytostLabel;
	@FXML
	private Label hracNikotinLabel;
	@FXML
	private Label hracKofeinLabel;
	@FXML
	private ProgressBar nepritelHPPorgressBar;
	@FXML
	private Label nepritelHPLabel;
	@FXML
	private ImageView vyhraProhraImageView;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.vyberInventare = new VyberInventare();
		koncovaCast.setVisible(false);
	}

	public void priprav(Arena arena, Main main){
		this.setArena(arena);
		vyberInventare.setMain(main);
		vyberInventare.setTypLabel(typ);
		vyberInventare.setHodnotaLabel(hodnota);
		this.setMain(main);
		this.setPredmety(arena.getBojovnik1().getBatoh());
		bojovnik1Label.setText(arena.getBojovnik1().getJmeno());
		bojovnik2Label.setText(arena.getBojovnik2().getJmeno());
		PocetKolListener listener = new PocetKolListener();
		listener.setPocetKolLabel(pocetKol);
		arena.getKoloProperty().addListener(listener);
		Hrac hrac = (Hrac)arena.getBojovnik1();
		
		hracSytostProgressBar.setProgress(1);
		hracovaSytostNaZacatku = hrac.getSytost();
		hracSytostLabel.setText(formatter.format(hrac.getSytost()) + "/" + formatter.format(hracovaSytostNaZacatku));
		hrac.getSytostProperty().addListener((ov, oldVal, newVal)->{
			hracSytostProgressBar.setProgress(newVal.doubleValue()/hracovaSytostNaZacatku);
			hracSytostLabel.setText(formatter.format(hrac.getSytost()) + "/" + formatter.format(hracovaSytostNaZacatku));
		});
		
		hracKofeinProgressBar.setProgress(1);
		hracuvKofeinNaZacatku = hrac.getKofein();
		hracKofeinLabel.setText(formatter.format(hrac.getKofein()) + "/" + formatter.format(hracuvKofeinNaZacatku));
		hrac.getKofeinProperty().addListener((ov, oldVal, newVal)->{
			hracKofeinProgressBar.setProgress(newVal.doubleValue()/hracuvKofeinNaZacatku);
			hracKofeinLabel.setText(formatter.format(hrac.getKofein()) + "/" + formatter.format(hracuvKofeinNaZacatku));
		});
		
		hracNikotinProgressBar.setProgress(1);
		hracuvNikotinNaZacatku = hrac.getNikotin();
		hracNikotinLabel.setText(formatter.format(hrac.getNikotin()) + "/" + formatter.format(hracuvNikotinNaZacatku));
		hrac.getNikotinProperty().addListener((ov, oldVal, newVal)->{
			hracNikotinProgressBar.setProgress(newVal.doubleValue()/hracuvNikotinNaZacatku);
			hracNikotinLabel.setText(formatter.format(hrac.getNikotin()) + "/" + formatter.format(hracuvNikotinNaZacatku));
		});
		
		NPC nepritel = (NPC) arena.getBojovnik2();
		nepritelHPPorgressBar.setProgress(1);
		nepritelovyHPNaZacatku = nepritel.getHP();
		nepritelHPLabel.setText(formatter.format(nepritel.getHP()) + "/" + formatter.format(nepritelovyHPNaZacatku));
		nepritel.getHPProperty().addListener((ov,oldVal,newVal)->{
			nepritelHPPorgressBar.setProgress(newVal.doubleValue()/nepritelovyHPNaZacatku);
			nepritelHPLabel.setText(formatter.format(nepritel.getHP()) + "/" + formatter.format(nepritelovyHPNaZacatku));
		});
	}
	
	public void setPredmety(ArrayList<INositelne> predmety){
		vyberInventare.setPredmety(predmety);
		vyberInventare.setVelikost(2, 5);
		vyberInventare.nactiPredmety(0);
	}
	
	public void setMain(Main main){
		this.main = main;
		spodniCast.setPrefHeight(main.getStage().getHeight()/3);
		horniCast.setPrefHeight(main.getStage().getHeight()*8/15);
		vyberInventare.setPrefHeight(spodniCast.getHeight());
		vyberInventare.setPrefWidth(spodniCast.getWidth()*7/12);
		spodniCast.getChildren().add(vyberInventare);
	}
	
	public VyberInventare getVyberInventare(){
		return vyberInventare;
	}
	
	private void setArena(Arena arena){
		this.arena = arena;
	}
	
	public void ukonciAVyhodnot(int vyherce){
		if(vyherce == 1){
			vyhraProhraImageView.setImage(new Image(Main.class.getResourceAsStream("/source/vyhra.png")));
		} else if (vyherce == 2){
			vyhraProhraImageView.setImage(new Image(Main.class.getResourceAsStream("/source/prohra.png")));
		} else {
			//koncovyText.setText("Remiza.");
		}
		horniCast.setVisible(false);
		spodniCast.setVisible(false);
		koncovaCast.setVisible(true);
		vyhraProhraImageView.setVisible(true);
	}
	
	@FXML
	private void bojHandler(){
		arena.spustSouboj();
	}
}
