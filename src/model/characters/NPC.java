package model.characters;

import model.Batoh;
import model.items.INositelne;
import model.items.Jidlo;

public class NPC extends Postava
{
	private static String JMENO = "Neznámé NPC";
	private static double defHP = 100;
	private static Batoh defBatoh;
	
	private double HP;
	
	public NPC()
	{
		this(JMENO);
	}
	public NPC(String jmeno)
	{
		this(jmeno, defBatoh);
	}
	public NPC(String jmeno, Batoh batoh)
	{
		this(jmeno, batoh, defHP);
	}
	public NPC(String jmeno, Batoh batoh, double HP)
	{
		super(jmeno,batoh);
		this.HP = HP;
	}
	@Override
	public double getHP(){return HP;}
	public void setHP(double HP){this.HP = HP;}
	@Override
	public void injured(double dmg){setHP(getHP()-dmg);}
	@Override
	public void eat(INositelne item) 
	{
		Jidlo jidlo = (Jidlo) item;
		setHP(getHP()+jidlo.getHodnotaObnovy());
	}
	@Override
	public void addToBatoh(INositelne item) 
	{
		Batoh batoh = getBatoh();
		batoh.add(item);
		setBatoh(batoh);
	}
}