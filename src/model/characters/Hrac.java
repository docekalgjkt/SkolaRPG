package model.characters;

import model.Batoh;
import model.Pozice;
import model.items.INositelne;
import model.items.Jidlo;

public class Hrac extends Postava{

	private static final Pozice POZICE = new Pozice(0,0);
	private static final String JMENO = "Frajer";
	private static final double SYTOST = 100.0;
	private static final double KOFEIN = 0.0;
	private static final double NIKOTIN = 0.0;
	
	private double sytost;
	private double kofein;
	private double nikotin;
	private Pozice pozice;
	
	public Hrac()
	{
		this(JMENO);
	}
	public Hrac(String jmeno)
	{
		this(jmeno,NIKOTIN);
	}
	public Hrac(String jmeno, double nikotin)
	{
		this(jmeno, nikotin, SYTOST);
	}
	public Hrac(String jmeno, double nikotin, double sytost)
	{
		this(jmeno, nikotin, sytost, KOFEIN);
	}
	public Hrac(String jmeno, double nikotin, double sytost, double kofein)
	{
		this(jmeno, nikotin, sytost, kofein, POZICE);
	}
	public Hrac(String jmeno, double nikotin, double sytost, double kofein, Pozice pozice)
	{
		super(jmeno);
		this.pozice = pozice;
		this.sytost = sytost;
		this.kofein = kofein;
		this.nikotin = nikotin;
	}
	public double getNikotin(){return nikotin;}
	public void setNikotin(double newNikotin){this.nikotin = newNikotin;}
	public double getKofein(){return kofein;}
	public void setKofein(double newKofein){this.kofein = newKofein;}
	public double getSytost(){return sytost;}
	public void setSytost(double newSytost){this.sytost = newSytost;}
	public Pozice getPozice(){return pozice;}
	public void setPozice(Pozice pozice){this.pozice = pozice;}
	@Override
	public double getHP(){return getNikotin()+getKofein();}
	@Override
	public void injured(double dmg) //vstupuje po�kozen�, spo��t� novou hodnotu Kofeinu a Nikotinu
	{
		/*
		 * Pokud by p�i d�len� dmg p�l na p�l mezi nikotin a sytost jedna z hodnot spadla pod nulu
		 * mus�m rozpo��tat dmg tak, aby se pokud mo�no ob� hodnoty vyrovnaly. Pokud to mo�n� nen�,
		 * ode�tu dmg jenom od jedn�.
		 */
		if(getNikotin()<(dmg/2) && getSytost()<(dmg/2)) //v tomto p��pad� hr�� �tok nep�e�il
		{
			setNikotin(0);
			setSytost(0);
		}
		else if(getNikotin()<(dmg/2)) //pokud by nikotin spadl pod nulu
		{
			if(dmg<(getSytost()-getNikotin())) //pokud je dmg men�� ne� rozd�l obou hodnot
			{
				setKofein(getSytost()-dmg);
			}
			else //dmg se rozd�l� tak, aby se ob� hodnoty vyrovnaly
			{
				double newHodnoty = getSytost();
				newHodnoty = newHodnoty - (getSytost()-getNikotin()); //vyrovn�m ob� hodnoty
				newHodnoty = newHodnoty - (dmg-newHodnoty)/2;	//a rozd�l�m zb�vaj�c� dmg na poloviny
				setNikotin(newHodnoty);
				setSytost(newHodnoty);
			}
		}
		else if(getSytost()<(dmg/2)) //pokud by sytost spadl pod nulu, zachov�m se stejn�, jako v p�ede�l�m p��pad�
		{
			if(dmg<(getNikotin()-getSytost()))
			{
				setNikotin(getNikotin()-dmg);
			}
			else
			{
				double newHodnoty = getNikotin();
				newHodnoty = newHodnoty - (getNikotin()-getSytost());
				newHodnoty = newHodnoty - (dmg-newHodnoty)/2;
				setNikotin(newHodnoty);
				setSytost(newHodnoty);
			}
		}
		else //v tomto p��pad� rozpo��t�m dmg p�l na p�l
		{
			setNikotin(getNikotin()-dmg/2);
			setSytost(getKofein()-dmg/2);
		}
	}
	@Override
	public void eat(INositelne item) //vstupuje INositelne, vystupuje nov� Kofein nebo Nikotin
	{
		Jidlo jidlo = (Jidlo) item;
		if(jidlo.getTypObnovy().equals("HP"))
		{
			setSytost(getSytost()+jidlo.getHodnotaObnovy());
		}
		else
		{
			setNikotin(getNikotin()+jidlo.getHodnotaObnovy());
		}
	}
	@Override
	public void addToBatoh(INositelne predmet) //p�id�v� INositelne do batohu hr��e
	{
		Batoh batoh = getBatoh();
		batoh.add(predmet);
		setBatoh(batoh);
	}
}
