package model.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.items.INositelne;
import model.items.Jidlo;
import model.items.Klic;
import model.items.Odpad;
import model.items.TypPredmetu;
import model.items.TypUtoku;
import model.items.Zbran;

public class Generator 
{
	Random random = new Random(); //generátor náhodných èísel
	
	public Generator(){}; //konstruktor
		
	public ArrayList<INositelne> generujBatoh(int pocet) //vrátí list itemù - Zbran, Jidlo
	{
		ArrayList<INositelne> vyber = new ArrayList<>(); //sem uložím vybrané itemy
		List<TypPredmetu> predmetyBatoh = Arrays.asList(TypPredmetu.ZBRAN, TypPredmetu.JIDLO); //seznam vìcí, které chceme generovat do batohu
		
		for(int i = 0; i<pocet;i++)
		{
			TypPredmetu vybranyTyp = predmetyBatoh.get(random.nextInt(predmetyBatoh.size())); //náhodný výbìr typu pøedmìtu
			if(vybranyTyp == TypPredmetu.ZBRAN)
			{
				INositelne item = generujZbran();
				vyber.add(item); //novou zbraò pøidám do listu
			}
			else if(vybranyTyp == TypPredmetu.JIDLO)
			{
				INositelne item = generujJidlo();
				vyber.add(item); //nové jídlo pøidám do listu
			}
		}
		
		return vyber;
	}
	public ArrayList<INositelne> generujMapu(int pocet) //vrátí list itemù - Zbran, Jidlo, Odpad
	{
		/*
		 * pomocí generátoru náhodných èísel si vyberu, kolik chci mít na mapì
		 * zbraní a jídla, pro nì použiji již existující generátor pro batoh, který funguje stejnì
		 */
		int uzitecneItemy = random.nextInt(pocet);
		ArrayList<INositelne> vyber = generujBatoh(uzitecneItemy); //rovnou je uložím do seznamu, který posléze vrátím
		int zbytek = pocet - uzitecneItemy; //zjistím, kolik itemù "ODPAD" na mapì bude
		for(int i = 0; i<zbytek; i++)
		{
			INositelne odpad = generujOdpad();
			vyber.add(odpad); //nový Odpad pøidám do listu
		}
		return vyber;
	}
	public Zbran generujZbran() //vrátí jednu náhodnou zbraò
	{
		List<TypUtoku> utoky = Arrays.asList(TypUtoku.values());	//možné typy útokù
		
		TypUtoku typUtoku = utoky.get(random.nextInt(utoky.size())); //vybral jsem náhodný typ útoku
		
		ZbraneInterface zbranI; //založím Interface
		if(typUtoku == TypUtoku.BLIZKY)
		{
			List<ZbraneM> zbraneMNazvy = Arrays.asList(ZbraneM.values());	//názvy zbraní na blízko
			zbranI = zbraneMNazvy.get(random.nextInt(zbraneMNazvy.size()));  //výbìr pøedmìtu ze ZbraneM
		} 
		else if(typUtoku == TypUtoku.DALEKY)
		{
			List<ZbraneR> zbraneRNazvy = Arrays.asList(ZbraneR.values());	//názvy zbraní na dálku
			zbranI = zbraneRNazvy.get(random.nextInt(zbraneRNazvy.size())); //výbìr pøemìtu z ZbraneR
		} 
		else
		{
			List<ZbraneD> zbraneDNazvy = Arrays.asList(ZbraneD.values());	//názvy obranných zbraní
			zbranI = zbraneDNazvy.get(random.nextInt(zbraneDNazvy.size())); //výbìr pøedmìtu ze ZbraneD
		}
		
		//naplním všechny potøebné parametry pro vytvoøení Zbranì
		String nazev = zbranI.getNazev();
		int hodnota = zbranI.getHodnota();
		int utok = zbranI.getUtok();
		int obrana = zbranI.getObrana();
		int trvanlivost = zbranI.getTrvanlivost();
		String popis = zbranI.getPopis();
		
		Zbran zbran = new Zbran(nazev,hodnota,utok,obrana,trvanlivost,typUtoku, popis); //vytvoøím zbraò
		
		return zbran; //vrátím ji
	}
	public ArrayList<Zbran> generujZbran(int pocet) //generuje zadaný poèet zbraní
	{
		ArrayList<Zbran> zbrane = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			zbrane.add(generujZbran());
		}
		return zbrane;
	}
	public Jidlo generujJidlo() //vrátí jedno náhodné jídlo
	{
		List<JidloDruhy> jidloDruhy = Arrays.asList(JidloDruhy.values());	//názvy jídel

		JidloDruhy vybraneJidlo = jidloDruhy.get(random.nextInt(jidloDruhy.size())); //náhodnì vyberu jedno z jídel
		
		String nazev = vybraneJidlo.getNazev();	
		int hodnota = vybraneJidlo.getHodnota();
		int hodnotaObnovy = vybraneJidlo.getHodnotaObnovy();		
		String typObnovy = "HP";
		String popis = vybraneJidlo.getPopis();

		Jidlo jidlo = new Jidlo(nazev, hodnota, hodnotaObnovy, typObnovy, popis);
		return jidlo;
	}
	public ArrayList<Jidlo> generujJidlo(int pocet) //generuje zadaný poèet jídla
	{
		ArrayList<Jidlo> jidlo = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			jidlo.add(generujJidlo());
		}
		return jidlo;
	}
	public Jidlo generujTabak() //vygeneruje jeden náhodný tabákový výrobek
	{
		List<TabakDruhy> tabakDruhy = Arrays.asList(TabakDruhy.values()); //názvy cigaret
		
		TabakDruhy vybranyTabak = tabakDruhy.get(random.nextInt(tabakDruhy.size())); //náhodnì vyberu jeden z tabákù
		
		String nazev = vybranyTabak.getNazev();
		int hodnota = vybranyTabak.getHodnota();
		int hodnotaObnovy = vybranyTabak.getHodnotaObnovy();
		String typObnovy = "nikotin";
		String popis = vybranyTabak.getPopis();
		
		Jidlo tabak = new Jidlo(nazev, hodnota, hodnotaObnovy, typObnovy, popis);
		return tabak;
	}
	public ArrayList<Jidlo> generujTabak(int pocet) //generuje zadaný poèet tabáku
	{
		ArrayList<Jidlo> tabak = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			tabak.add(generujTabak());
		}
		return tabak;
	}
	public Odpad generujOdpad() //vrátí jeden náhodný odpad
	{
		List<OdpadDruhy> odpadDruhy = Arrays.asList(OdpadDruhy.values());	//názvy odpadu
		
		OdpadDruhy odpadEnum = odpadDruhy.get(random.nextInt(odpadDruhy.size()));
		
		String nazev = odpadEnum.getNazev();
		int hodnota = odpadEnum.getHodnota();
		String popis = odpadEnum.getPopis();
		
		Odpad odpad = new Odpad(nazev, hodnota, popis);
		
		return odpad;
	}
	public ArrayList<Odpad> generujOdpad(int pocet) //navrátí zadaný poèet odpadù
	{
		ArrayList<Odpad> odpad = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			odpad.add(generujOdpad());
		}
		return odpad;
	}
	public Klic generujKlic(int ID) //vrátí klíè se zadaným ID
	{
		try
		{
			KlicDruhy klicI = KlicDruhy.getPodleID(ID);
			Klic klic = new Klic(klicI.getNazev(),klicI.getHodnota(),klicI.getID(), klicI.getPopis());
			return klic;
		}
		catch(NullPointerException e)
		{
			System.out.println("Chybné ID pøi generování klíèe! ID: "+ID);
		}
		Klic neexistujiciKlic = new Klic("Klíè od neznámých dveøí", 0, ID, "Øíká se, že za tìmito dveømi leží svìt, ve kterém ženy vìdí, co chtìjí.");
		return neexistujiciKlic;
	}
}
