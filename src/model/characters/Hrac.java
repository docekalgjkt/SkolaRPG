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
	public void injured(double dmg) //vstupuje poškození, spoèítá novou hodnotu Kofeinu a Nikotinu
	{
		/*
		 * Pokud by pøi dìlení dmg pùl na pùl mezi nikotin a sytost jedna z hodnot spadla pod nulu
		 * musím rozpoèítat dmg tak, aby se pokud možno obì hodnoty vyrovnaly. Pokud to možné není,
		 * odeètu dmg jenom od jedné.
		 */
		if(getNikotin()<(dmg/2) && getSytost()<(dmg/2)) //v tomto pøípadì hráè útok nepøežil
		{
			setNikotin(0);
			setSytost(0);
		}
		else if(getNikotin()<(dmg/2)) //pokud by nikotin spadl pod nulu
		{
			if(dmg<(getSytost()-getNikotin())) //pokud je dmg menší než rozdíl obou hodnot
			{
				setKofein(getSytost()-dmg);
			}
			else //dmg se rozdìlí tak, aby se obì hodnoty vyrovnaly
			{
				double newHodnoty = getSytost();
				newHodnoty = newHodnoty - (getSytost()-getNikotin()); //vyrovnám obì hodnoty
				newHodnoty = newHodnoty - (dmg-newHodnoty)/2;	//a rozdìlím zbývající dmg na poloviny
				setNikotin(newHodnoty);
				setSytost(newHodnoty);
			}
		}
		else if(getSytost()<(dmg/2)) //pokud by sytost spadl pod nulu, zachovám se stejnì, jako v pøedešlém pøípadì
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
		else //v tomto pøípadì rozpoèítám dmg pùl na pùl
		{
			setNikotin(getNikotin()-dmg/2);
			setSytost(getKofein()-dmg/2);
		}
	}
	@Override
	public void eat(INositelne item) //vstupuje INositelne, vystupuje nový Kofein nebo Nikotin
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
	public void addToBatoh(INositelne predmet) //pøidává INositelne do batohu hráèe
	{
		Batoh batoh = getBatoh();
		batoh.add(predmet);
		setBatoh(batoh);
	}
}
