package model.items;

import javafx.scene.image.ImageView;

public class Odpad implements INositelne
{
	private static final TypPredmetu TYPPREDMETU = TypPredmetu.ODPAD;
	private String nazev;
	private String popis;
	private int hodnota;
	private ImageView Image;
	
	public Odpad(String nazev, int hodnota, String popis)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.popis = popis;
	}
	@Override
	public TypPredmetu getTypPredmetu() {
		return TYPPREDMETU;
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
	@Override
	public String toString()
	{
		return getNazev()+", "+getPopis();
	}
	@Override
	public ImageView getObrazek()
	{
		return Image;
	}
	public void setObrazek(ImageView image)
	{
		Image = image;
	}
}
