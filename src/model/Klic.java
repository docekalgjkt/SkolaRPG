package model;

import javafx.scene.image.Image;

public class Klic  implements INositelne{

	private final TypPredmetu typPredmetu = TypPredmetu.KLIC;
	
	private String nazev;
	private String popis;
	private int hodnota;
	private int idDveriKtereOtevira;
	private Image obrazek;
	
	public Klic(String nazev, String popis, int hodnota, int idDveriKtereOtevira, Image obrazek){
		this.nazev = nazev;
		this.popis = popis;
		this.hodnota = hodnota;
		this.idDveriKtereOtevira = idDveriKtereOtevira;
		this.obrazek = obrazek;
	}
	
	public int getIdDveriKtereOtevira(){
		return this.idDveriKtereOtevira;
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
		return this.popis;
	}

	@Override
	public int getHodnota() {
		return this.hodnota;
	}

	@Override
	public Image getObrazek() {
		return obrazek;
	}

}
