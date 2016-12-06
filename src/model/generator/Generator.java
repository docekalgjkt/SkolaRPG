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
	Random random = new Random(); //gener�tor n�hodn�ch ��sel
	
	public Generator(){}; //konstruktor
		
	public ArrayList<INositelne> generujBatoh(int pocet) //vr�t� list item� - Zbran, Jidlo
	{
		ArrayList<INositelne> vyber = new ArrayList<>(); //sem ulo��m vybran� itemy
		List<TypPredmetu> predmetyBatoh = Arrays.asList(TypPredmetu.ZBRAN, TypPredmetu.JIDLO); //seznam v�c�, kter� chceme generovat do batohu
		
		for(int i = 0; i<pocet;i++)
		{
			TypPredmetu vybranyTyp = predmetyBatoh.get(random.nextInt(predmetyBatoh.size())); //n�hodn� v�b�r typu p�edm�tu
			if(vybranyTyp == TypPredmetu.ZBRAN)
			{
				INositelne item = generujZbran();
				vyber.add(item); //novou zbra� p�id�m do listu
			}
			else if(vybranyTyp == TypPredmetu.JIDLO)
			{
				INositelne item = generujJidlo();
				vyber.add(item); //nov� j�dlo p�id�m do listu
			}
		}
		
		return vyber;
	}
	public ArrayList<INositelne> generujMapu(int pocet) //vr�t� list item� - Zbran, Jidlo, Odpad
	{
		/*
		 * pomoc� gener�toru n�hodn�ch ��sel si vyberu, kolik chci m�t na map�
		 * zbran� a j�dla, pro n� pou�iji ji� existuj�c� gener�tor pro batoh, kter� funguje stejn�
		 */
		int uzitecneItemy = random.nextInt(pocet);
		ArrayList<INositelne> vyber = generujBatoh(uzitecneItemy); //rovnou je ulo��m do seznamu, kter� posl�ze vr�t�m
		int zbytek = pocet - uzitecneItemy; //zjist�m, kolik item� "ODPAD" na map� bude
		for(int i = 0; i<zbytek; i++)
		{
			INositelne odpad = generujOdpad();
			vyber.add(odpad); //nov� Odpad p�id�m do listu
		}
		return vyber;
	}
	public Zbran generujZbran() //vr�t� jednu n�hodnou zbra�
	{
		List<TypUtoku> utoky = Arrays.asList(TypUtoku.values());	//mo�n� typy �tok�
		
		TypUtoku typUtoku = utoky.get(random.nextInt(utoky.size())); //vybral jsem n�hodn� typ �toku
		
		ZbraneInterface zbranI; //zalo��m Interface
		if(typUtoku == TypUtoku.BLIZKY)
		{
			List<ZbraneM> zbraneMNazvy = Arrays.asList(ZbraneM.values());	//n�zvy zbran� na bl�zko
			zbranI = zbraneMNazvy.get(random.nextInt(zbraneMNazvy.size()));  //v�b�r p�edm�tu ze ZbraneM
		} 
		else if(typUtoku == TypUtoku.DALEKY)
		{
			List<ZbraneR> zbraneRNazvy = Arrays.asList(ZbraneR.values());	//n�zvy zbran� na d�lku
			zbranI = zbraneRNazvy.get(random.nextInt(zbraneRNazvy.size())); //v�b�r p�em�tu z ZbraneR
		} 
		else
		{
			List<ZbraneD> zbraneDNazvy = Arrays.asList(ZbraneD.values());	//n�zvy obrann�ch zbran�
			zbranI = zbraneDNazvy.get(random.nextInt(zbraneDNazvy.size())); //v�b�r p�edm�tu ze ZbraneD
		}
		
		//napln�m v�echny pot�ebn� parametry pro vytvo�en� Zbran�
		String nazev = zbranI.getNazev();
		int hodnota = zbranI.getHodnota();
		int utok = zbranI.getUtok();
		int obrana = zbranI.getObrana();
		int trvanlivost = zbranI.getTrvanlivost();
		String popis = zbranI.getPopis();
		
		Zbran zbran = new Zbran(nazev,hodnota,utok,obrana,trvanlivost,typUtoku, popis); //vytvo��m zbra�
		
		return zbran; //vr�t�m ji
	}
	public ArrayList<Zbran> generujZbran(int pocet) //generuje zadan� po�et zbran�
	{
		ArrayList<Zbran> zbrane = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			zbrane.add(generujZbran());
		}
		return zbrane;
	}
	public Jidlo generujJidlo() //vr�t� jedno n�hodn� j�dlo
	{
		List<JidloDruhy> jidloDruhy = Arrays.asList(JidloDruhy.values());	//n�zvy j�del

		JidloDruhy vybraneJidlo = jidloDruhy.get(random.nextInt(jidloDruhy.size())); //n�hodn� vyberu jedno z j�del
		
		String nazev = vybraneJidlo.getNazev();	
		int hodnota = vybraneJidlo.getHodnota();
		int hodnotaObnovy = vybraneJidlo.getHodnotaObnovy();		
		String typObnovy = "HP";
		String popis = vybraneJidlo.getPopis();

		Jidlo jidlo = new Jidlo(nazev, hodnota, hodnotaObnovy, typObnovy, popis);
		return jidlo;
	}
	public ArrayList<Jidlo> generujJidlo(int pocet) //generuje zadan� po�et j�dla
	{
		ArrayList<Jidlo> jidlo = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			jidlo.add(generujJidlo());
		}
		return jidlo;
	}
	public Jidlo generujTabak() //vygeneruje jeden n�hodn� tab�kov� v�robek
	{
		List<TabakDruhy> tabakDruhy = Arrays.asList(TabakDruhy.values()); //n�zvy cigaret
		
		TabakDruhy vybranyTabak = tabakDruhy.get(random.nextInt(tabakDruhy.size())); //n�hodn� vyberu jeden z tab�k�
		
		String nazev = vybranyTabak.getNazev();
		int hodnota = vybranyTabak.getHodnota();
		int hodnotaObnovy = vybranyTabak.getHodnotaObnovy();
		String typObnovy = "nikotin";
		String popis = vybranyTabak.getPopis();
		
		Jidlo tabak = new Jidlo(nazev, hodnota, hodnotaObnovy, typObnovy, popis);
		return tabak;
	}
	public ArrayList<Jidlo> generujTabak(int pocet) //generuje zadan� po�et tab�ku
	{
		ArrayList<Jidlo> tabak = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			tabak.add(generujTabak());
		}
		return tabak;
	}
	public Odpad generujOdpad() //vr�t� jeden n�hodn� odpad
	{
		List<OdpadDruhy> odpadDruhy = Arrays.asList(OdpadDruhy.values());	//n�zvy odpadu
		
		OdpadDruhy odpadEnum = odpadDruhy.get(random.nextInt(odpadDruhy.size()));
		
		String nazev = odpadEnum.getNazev();
		int hodnota = odpadEnum.getHodnota();
		String popis = odpadEnum.getPopis();
		
		Odpad odpad = new Odpad(nazev, hodnota, popis);
		
		return odpad;
	}
	public ArrayList<Odpad> generujOdpad(int pocet) //navr�t� zadan� po�et odpad�
	{
		ArrayList<Odpad> odpad = new ArrayList<>();
		for(int i = 0; i<pocet; i++)
		{
			odpad.add(generujOdpad());
		}
		return odpad;
	}
	public Klic generujKlic(int ID) //vr�t� kl�� se zadan�m ID
	{
		try
		{
			KlicDruhy klicI = KlicDruhy.getPodleID(ID);
			Klic klic = new Klic(klicI.getNazev(),klicI.getHodnota(),klicI.getID(), klicI.getPopis());
			return klic;
		}
		catch(NullPointerException e)
		{
			System.out.println("Chybn� ID p�i generov�n� kl��e! ID: "+ID);
		}
		Klic neexistujiciKlic = new Klic("Kl�� od nezn�m�ch dve��", 0, ID, "��k� se, �e za t�mito dve�mi le�� sv�t, ve kter�m �eny v�d�, co cht�j�.");
		return neexistujiciKlic;
	}
}
