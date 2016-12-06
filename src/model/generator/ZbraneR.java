package model.generator;

public enum ZbraneR implements ZbraneInterface
{
	ALOBALOVÁKULIÈKA("Alobalová kulièka", 0, "Pìknì zamaštìná od svaèiny.", 0, 5, 1),
	FOTBALOVEJMÍÈ("Fotbalovı míè", 699, "Má bıt sloenı z rovnostrannıch pìtiúhelníkù.", 13, 37, 2),
	TROJÚHELNÍK("Trojúhelník", 29, "Nech se jeho ryska zbarví krví!", 6, 26, 1),
	PANTOFLE("Pantofle", 159, "Na záchodech se nabalila nechutnou špínou.", 9, 23, 1),
	CD("CD", 299, "Pochází z uèebnice angliètiny. Stejnì jsi ho nikdy nepouil.", 1, 33, 1),
	KRUÍTKO("Kruítko", 69, "Hrot má naštìstí ostrı jako ihadlo.", 2, 19, 1);
	
	private final String nazev;
	private final int hodnota;
	private final String popis;
	private final int obrana;
	private final int utok;
	private final int trvanlivost;
	ZbraneR(String nazev, int hodnota, String popis, int obrana, int utok, int trvanlivost)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.popis = popis;
		this.obrana = obrana;
		this.utok = utok;
		this.trvanlivost = trvanlivost;
	}

	@Override
	public String getNazev() {return nazev;}

	@Override
	public int getHodnota() {return hodnota;}

	@Override
	public String getPopis() {return popis;}

	@Override
	public int getObrana() {return obrana;}

	@Override
	public int getUtok() {return utok;}

	@Override
	public int getTrvanlivost() {return trvanlivost;}
}
