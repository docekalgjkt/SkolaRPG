package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.INositelne;

public class VyberInventareRadek extends HBox{

	private VyberInventare vyberInventare;
	
	public VyberInventareRadek(VyberInventare vyber){
		this.vyberInventare = vyber;
		super.setAlignment(Pos.CENTER);
		super.setSpacing(10);
	}
	
	public void nactiPredmety(ArrayList<INositelne> predmety){
		ArrayList<TlacitkoPredmetu> tlacitka = new ArrayList<TlacitkoPredmetu>();
		for(INositelne predmet : predmety){
			TlacitkoPredmetu tlacitko = new TlacitkoPredmetu();
			tlacitko.setPredmet(predmet);
			tlacitko.setPrefHeight(vyberInventare.getPrefHeight()/(vyberInventare.getPocetRadku() + 2));
			tlacitko.setPrefWidth(vyberInventare.getPrefWidth()/vyberInventare.getPocetSloupcu() + 2);
			tlacitko.setMaxHeight(USE_PREF_SIZE);
			tlacitko.setMinHeight(USE_PREF_SIZE);
			tlacitko.setMaxWidth(USE_PREF_SIZE);
			tlacitko.setMinWidth(USE_PREF_SIZE);
			tlacitko.getStyleClass().add("predmetButton");
			TlacitkoPredmetuHandler handler = new TlacitkoPredmetuHandler(vyberInventare.getMain().getHrac());
			handler.setHodnotaLabel(vyberInventare.getHodnotaLabel());
			handler.setTypLabel(vyberInventare.getTypLabel());
			tlacitko.setOnAction(handler);
			tlacitka.add(tlacitko);
		}
		super.getChildren().addAll(tlacitka);
		super.applyCss();
	}
}
