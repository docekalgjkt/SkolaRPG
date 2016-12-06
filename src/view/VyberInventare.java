package view;

import java.util.ArrayList;

import app.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.INositelne;

public class VyberInventare extends VBox{

	private ArrayList<INositelne> predmety;
	private int pocetRadku;
	private int pocetSloupcu;
	private int odItemu;
	private RolovaciTlacitkoNahoru tlacitkoNahoru;
	private RolovaciTlacitkoDolu tlacitkoDolu;
	private Main main;
	private Label typ;
	private Label hodnota;
	
	public VyberInventare(){
		predmety = new ArrayList<INositelne>();
		super.setAlignment(Pos.CENTER);
		tlacitkoNahoru = new RolovaciTlacitkoNahoru(this);
		tlacitkoDolu = new RolovaciTlacitkoDolu(this);
		super.setSpacing(10);
	}
	
	public void nactiPredmety(int odItemu){
		super.getChildren().clear();
		nactiRolovaciTlacitka();
		this.odItemu = odItemu;
		ArrayList<INositelne> pouzivanePredmety = new ArrayList<INositelne>();
		for(int i = odItemu; i < predmety.size(); i++){
			pouzivanePredmety.add(predmety.get(i));
		}
		for(int i = 0; i < pocetRadku; i++){
			VyberInventareRadek radek = new VyberInventareRadek(this);
			ArrayList<INositelne> tempPredmety = new ArrayList<INositelne>();
			for(int o = i * pocetSloupcu; o < (i * pocetSloupcu + pocetSloupcu); o++){
				if(o < pouzivanePredmety.size()){
				tempPredmety.add(pouzivanePredmety.get(o));
				}
			}
			radek.nactiPredmety(tempPredmety);
			super.getChildren().add(radek);
		}
	}
	
	public void nactiRolovaciTlacitka(){
		if(((AnchorPane)this.getParent()).getChildren().contains(tlacitkoNahoru)){
			
		} else {
		((AnchorPane)this.getParent()).getChildren().add(tlacitkoNahoru);
		tlacitkoNahoru.setLayoutX(this.getPrefWidth()/2 - tlacitkoNahoru.getPrefWidth());
		tlacitkoNahoru.setLayoutY(0);
		}
		if(((AnchorPane)this.getParent()).getChildren().contains(tlacitkoDolu)){
			
		} else {
		((AnchorPane)this.getParent()).getChildren().add(tlacitkoDolu);
		tlacitkoDolu.setLayoutX(this.getPrefWidth()/2 - tlacitkoNahoru.getPrefWidth());
		tlacitkoDolu.setLayoutY(this.getPrefHeight() - tlacitkoNahoru.getPrefHeight());
		}
	}
	
	public void posunoutNiz(){
		if((odItemu + pocetSloupcu) >= predmety.size()){
			
		} else {
			nactiPredmety(odItemu + pocetSloupcu);
		}
	}
	
	public void posunoutVys(){
		if((odItemu - pocetSloupcu) < 0){
			
		} else {
			nactiPredmety(odItemu - pocetSloupcu);
		}
	}
	
	public void setPredmety(ArrayList<INositelne> predmety){
		this.predmety = predmety;
	}
	
	public void setVelikost(int pocetRadku, int pocetSloupcu){
		this.pocetRadku = pocetRadku;
		this.pocetSloupcu = pocetSloupcu;
	}
	
	public int getPocetRadku(){
		return pocetRadku;
	}
	
	public int getPocetSloupcu(){
		return pocetSloupcu;
	}
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public Main getMain(){
		return this.main;
	}
	
	public void setTypLabel(Label typ){
		this.typ = typ;
	}
	
	public void setHodnotaLabel(Label hodnota){
		this.hodnota = hodnota;
	}
	
	public Label getHodnotaLabel(){
		return hodnota;
	}
	
	public Label getTypLabel(){
		return typ;
	}
}
