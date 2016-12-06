package model.items;

import javafx.scene.image.ImageView;

public class Zbran implements INositelne
{
	private static final TypPredmetu TYPPRDMETU = TypPredmetu.ZBRAN;
	private String nazev;
	private String popis;
	private int hodnota;
	private int utok;
	private int obrana;
	private int trvanlivost;
	private TypUtoku TYPUTOKU;
	private ImageView Image;
	
	public Zbran(String nazev, int hodnota, int utok, int obrana, int trvanlivost, TypUtoku TYPUTOKU, String popis)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.utok = utok;
		this.obrana = obrana;
		this.trvanlivost = trvanlivost;
		this.TYPUTOKU = TYPUTOKU;
		this.popis = popis;
	}
	public int getUtok()
	{
		return utok;
	}
	public int getObrana()
	{
		return obrana;
	}
	public int getTrvanlivost()
	{
		return trvanlivost;
	}
	public TypUtoku getTypUtoku()
	{
		return TYPUTOKU;
	}
	public void poskodPredmet(int oKolik)
	{
		trvanlivost = trvanlivost - oKolik;
	}
	@Override
	public TypPredmetu getTypPredmetu() {
		return TYPPRDMETU;
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
		return getNazev() +", "+ getPopis();
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
