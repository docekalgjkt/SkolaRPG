package model.items;

import javafx.scene.image.ImageView;

public class Jidlo implements INositelne
{
	private static final TypPredmetu TYPPREDMETU = TypPredmetu.JIDLO;
	private String nazev;
	private String popis;
	private int hodnota;
	private int hodnotaObnovy;
	private String typObnovy;
	private ImageView Image;
	
	public Jidlo(String nazev, int hodnota, int hodnotaObnovy, String typObnovy, String popis)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.hodnotaObnovy = hodnotaObnovy;
		this.typObnovy = typObnovy;
		this.popis = popis;
	}
	@Override
	public String getNazev()
	{
		return nazev;
	}
	@Override
	public TypPredmetu getTypPredmetu()
	{
		return TYPPREDMETU;
	}
	@Override
	public String getPopis()
	{
		return popis;
	}
	@Override
	public int getHodnota()
	{
		return hodnota;
	}
	public int getHodnotaObnovy()
	{
		return hodnotaObnovy;
	}
	public String getTypObnovy()
	{
		return typObnovy;
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
