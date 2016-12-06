package model;

import java.util.ArrayList;

/**
 * 
 * @author vesely
 *
 */

public abstract class Postava {
	
	private String jmeno;
	private Batoh batoh;
	
	public Postava(String jmeno, ArrayList<INositelne> batoh){
		this.jmeno = jmeno;
		this.batoh = (Batoh) batoh;
	}
	
	public Postava(String jmeno){
		this.jmeno = jmeno;
		batoh = new Batoh();
	}
	
	public String getJmeno(){
		return jmeno;
	}
	
	public void vzitPredmet(INositelne predmet){
		batoh.add(predmet);
	}
	
	public Batoh getBatoh(){
		return batoh;
	}
	
	public ArrayList<Zbran> getZbraneZBatohu(){
		ArrayList<Zbran> zbrane = new ArrayList<Zbran>();
		for(int i = 0; i<batoh.size(); i++){
			if(batoh.get(i).getTypPredmetu() == TypPredmetu.ZBRAN){
				zbrane.add((Zbran)batoh.get(i));
			} else {
				continue;
			}
		}
		return zbrane;
	}
	
	public ArrayList<Jidlo> getJidloZBatohu(){
		ArrayList<Jidlo> jidlo = new ArrayList<Jidlo>();
		for(int i = 0; i<batoh.size(); i++){
			if(batoh.get(i).getTypPredmetu() == TypPredmetu.JIDLO){
				jidlo.add((Jidlo)batoh.get(i));
			} else {
				continue;
			}
		}
		return jidlo;
	}
	
	abstract void dejSi(Jidlo jidlo);
	
	abstract INositelne getVyberPredmetu();
	
	abstract double getHP();
	
	abstract void zran(double zaKolik);
}
