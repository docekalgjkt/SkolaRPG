package model.characters;

import model.Batoh;
import model.items.INositelne;

public abstract class Postava 
{
	private String jmeno;
	private Batoh batoh;
	private static final String JMENO = "Bojovník beze jména";
	public Postava()
	{
		this.jmeno = JMENO;
	}
	public Postava(String jmeno)
	{
		this.jmeno = jmeno;
		this.batoh = new Batoh();
	}
	public Postava(String jmeno, Batoh batoh) 
	{
		this.jmeno = jmeno;
		this.batoh = batoh;
	}
	
	
	public void setBatoh(Batoh batoh)
	{
		this.batoh = batoh;
	}
	public String getJmeno()
	{
		return jmeno;
	}
	public Batoh getBatoh()
	{
		return batoh;
	}
	public abstract double getHP();
	public abstract void injured(double dmg);
	public abstract void eat(INositelne jidlo);
	public abstract void addToBatoh(INositelne predmet);
}
