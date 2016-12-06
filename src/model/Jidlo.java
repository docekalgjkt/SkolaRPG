package model;

import javafx.scene.image.Image;

public class Jidlo implements INositelne{

	final private TypPredmetu typPredmetu = TypPredmetu.JIDLO;
	
	private String nazev;
	private String popis;
	private int hodnota;	
	private int hodnotaObnovy;
	private String typObnovy;
	private Image obrazek;
	
	public Jidlo(String nazev, String popis, int hodnota, int hodnotaObnovy, String typObnovy, Image obrazek){
		this.nazev = nazev;
		this.popis = popis;
		this.hodnota = hodnota;
		this.hodnotaObnovy = hodnotaObnovy;
		this.typObnovy = typObnovy;
		this.obrazek = obrazek;
	}

	@Override
	public TypPredmetu getTypPredmetu() {
		return typPredmetu;
	}

	@Override
	public String getNazev() {
		return nazev;
	}

	@Override
	public String getPopis() {
		return popis;
	}

	@Override
	public int getHodnota() {
		return hodnota;
	}
	
	public int getHodnotaObnovy(){
		return hodnotaObnovy;
	}
	
	public String getTypObnovy(){
		return typObnovy;
	}

	@Override
	public Image getObrazek() {
		return obrazek;
	}
}
