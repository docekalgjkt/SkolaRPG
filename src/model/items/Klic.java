package model.items;

import javafx.scene.image.ImageView;

public class Klic implements INositelne
{
	private static final TypPredmetu TYPPREDMETU = TypPredmetu.KLIC;
	private String nazev;
	private String popis;
	private int hodnota;
	private int IDDveri;
	private ImageView Image;
	
	public Klic(String nazev, int hodnota, int IDDveri, String popis)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.IDDveri = IDDveri;
		this.popis = popis;
	}
	public int getIDDveri()
	{
		return IDDveri;
	}
	public void setPopis(String popis)
	{
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
