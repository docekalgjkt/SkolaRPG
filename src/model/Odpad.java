package model;

import javafx.scene.image.Image;

public class Odpad implements INositelne {

	private final TypPredmetu typPredmetu = TypPredmetu.ODPAD;
	
	private String nazev;
	private String popis;
	public int hodnota;
	public Image obrazek;
	
	public Odpad(String nazev, String popis, int hodnota, Image obrazek){
		this.nazev = nazev;
		this.popis = popis;
		this.hodnota = hodnota;
		this.obrazek = obrazek;
	}
	
	@Override
	public TypPredmetu getTypPredmetu() {
		return this.typPredmetu;
	}

	@Override
	public String getNazev() {
		return this.nazev;
	}

	@Override
	public String getPopis() {
		return popis;
	}

	@Override
	public int getHodnota() {
		return hodnota;
	}

	@Override
	public Image getObrazek() {
		return obrazek;
	}

}
