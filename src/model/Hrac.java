package model;

import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Hrac extends Postava{

	private static final Pozice POZICE = new Pozice(0,0);
	private static final String JMENO = "Frajer";
	private static final double SYTOST = 100.0;
	private static final double KOFEIN = 0.0;
	private static final double NIKOTIN = 0.0;
	
	private DoubleProperty sytost = new SimpleDoubleProperty(0);
	private DoubleProperty kofein = new SimpleDoubleProperty(0);
	private DoubleProperty nikotin = new SimpleDoubleProperty(0);
	private Pozice pozice;
	private INositelne vybranyPredmet;
	
	public Hrac(String jmeno, Pozice pozice, double sytost, double kofein, double nikotin, ArrayList<INositelne> batoh){
		super(jmeno, batoh);
		this.setSytost(sytost);
		this.setKofein(kofein);
		this.setNikotin(nikotin);
		this.setPozice(pozice);
	}
	
	public Hrac(String jmeno, Pozice pozice, double sytost, double kofein, double nikotin){
		super(jmeno);
		this.setSytost(sytost);
		this.setKofein(kofein);
		this.setNikotin(nikotin);
		this.setPozice(pozice);
	}
	
	public Hrac(String jmeno, Pozice pozice){
		this(jmeno, pozice, SYTOST, KOFEIN, NIKOTIN);
	}
	
	public Hrac(String jmeno){
		this(jmeno, POZICE);
	}
	
	public Hrac(){
		this(JMENO);
	}
	
	public double getSytost(){
		return this.sytost.get();
	}
	
	public double getKofein(){
		return this.kofein.get();
	}
	
	public double getNikotin(){
		return this.nikotin.get();
	}
	
	public Pozice getPozice(){
		return pozice;
	}
	
	public double getHP(){
		return (this.sytost.get() + this.kofein.get());
	}
	
	public void setSytost(double sytost){
		this.sytost.set(sytost);
	}
	
	public void setKofein(double kofein){
		this.kofein.set(kofein);
	}
	
	public void setNikotin(double nikotin){
		this.nikotin.set(nikotin);
	}
	
	public void setPozice(Pozice pozice){
		this.pozice = pozice;
	}

	public int getXPozice(){
		return pozice.getXPoz();
	}
	
	public int getYPozice(){
		return pozice.getYPoz();
	}
	
	public DoubleProperty getSytostProperty(){
		return this.sytost;
	}
	
	public DoubleProperty getKofeinProperty(){
		return this.kofein;
	}
	
	public DoubleProperty getNikotinProperty(){
		return this.nikotin;
	}
	
	@Override
	public void zran(double zaKolik) {
		if(zaKolik > 0){
			double HP = getHP();
			sytost.set(sytost.get() - zaKolik*(sytost.get()/HP));
			kofein.set(kofein.get() - zaKolik*(kofein.get()/HP));
		}
	}

	@Override
	public INositelne getVyberPredmetu() {
		System.out.println("Hrac vybral " + vybranyPredmet.getNazev() + " \ttyp: " + ((Zbran)vybranyPredmet).getTypUtoku().toString());
		return this.vybranyPredmet;
	}
	
	public void setVyberPredmetu(INositelne vybranyPredmet){
		this.vybranyPredmet = vybranyPredmet;
	}
	
	public void dejSi(Jidlo jidlo){
		if(jidlo.getTypObnovy().toLowerCase() == "sytost"){
			this.setSytost(this.getSytost() + jidlo.getHodnotaObnovy());
		} else if(jidlo.getTypObnovy().toLowerCase() == "kofein"){
			this.setKofein(this.getKofein() + jidlo.getHodnotaObnovy());
		} else {
			this.setNikotin(this.getNikotin() + jidlo.getHodnotaObnovy());
		}
	}
}
