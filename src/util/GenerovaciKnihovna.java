package util;

import java.util.Random;

import javafx.scene.image.Image;
import model.INositelne;
import model.Jidlo;
import model.Klic;
import model.Odpad;
import model.TypPredmetu;
import model.TypUtoku;
import model.Zbran;

public class GenerovaciKnihovna {

	private static final String[] PRVNIJMENA = {"Super ","Naprd ","Exkluzivni ","Ultramegasuperhyperturbo "};
	private static final String[] DRUHEJMENOZBRANI = {"kladivo", "cep", "kudla", "hasicak"};
	private static final String[] POPISY = {"Test123", "KappaPride FTW", "Get Rekt By ur MUM", "kamobracho SUPER!!!"};
	private static final int MAXIMALNIHODNOTA = 1000;
	private static final int MAXIMALNIUTOK = 100;
	private static final int MAXIMALNIOBRANA = 100;
	private static final int MAXIMALNITRVANLIVOST = 30;
	private static final int MAXIMALNIHODNOTAOBNOVY = 100;
	private static final int MAXIMALNIIDDVERIKTEREOTVIRA = 128;
	private static int number = 0;
	
	public static INositelne[] vygenerujPredmet(TypPredmetu typ, int pocet, int tier){
		Random ranGen = new Random();
		Image img = new Image("/source/sword.jpg", 48, 48, true, true);
		INositelne[] predmety = new INositelne[pocet];
		for(int i = 0; i<pocet; i++, number++){
			INositelne predmet = null;
			switch(typ){
				case ZBRAN: predmet = new Zbran(PRVNIJMENA[ranGen.nextInt(PRVNIJMENA.length)] + 
						DRUHEJMENOZBRANI[ranGen.nextInt(DRUHEJMENOZBRANI.length)] + number,
						POPISY[ranGen.nextInt(POPISY.length)],
						ranGen.nextInt(MAXIMALNIHODNOTA),
						ranGen.nextInt(MAXIMALNIUTOK),
						ranGen.nextInt(MAXIMALNIOBRANA),
						ranGen.nextInt(MAXIMALNITRVANLIVOST),
						getRandomTypUtoku(),
						img);
				break;
				case JIDLO: predmet = new Jidlo(PRVNIJMENA[ranGen.nextInt(PRVNIJMENA.length)] + number,
						POPISY[ranGen.nextInt(POPISY.length)],
						ranGen.nextInt(MAXIMALNIHODNOTA),
						ranGen.nextInt(MAXIMALNIHODNOTAOBNOVY),
						getRandomTypObnovy(),
						img);
				break;
				case KLIC: predmet = new Klic(PRVNIJMENA[ranGen.nextInt(PRVNIJMENA.length)] + number,
						POPISY[ranGen.nextInt(POPISY.length)],
						ranGen.nextInt(MAXIMALNIHODNOTA),
						ranGen.nextInt(MAXIMALNIIDDVERIKTEREOTVIRA),
						img);
				break;
				case ODPAD: predmet = new Odpad(PRVNIJMENA[ranGen.nextInt(PRVNIJMENA.length)] + number,
						POPISY[ranGen.nextInt(POPISY.length)],
						ranGen.nextInt(MAXIMALNIHODNOTA),
						img);
				break;
			}
			predmety[i] = predmet;
		}
		return predmety;
	}
	
	private static TypUtoku getRandomTypUtoku(){
		Random ranGen = new Random();
		switch(ranGen.nextInt(3)){
		case 0: return TypUtoku.BLIZKY;
		case 1: return TypUtoku.DALEKY;
		case 2: return TypUtoku.OBRANNY;
		default: return getRandomTypUtoku();
		}
	}
	
	private static String getRandomTypObnovy(){
		Random ranGen = new Random();
		switch(ranGen.nextInt(3)){
		case 0: return "kofein";
		case 1: return "sytost";
		case 2: return "nikotin";
		default: return getRandomTypObnovy();
		}
	}
}
