package model.generator;

public enum ZbraneD implements ZbraneInterface
{
	HASIÈÁK("Hasicí pøístroj", 1999, "Tak zajištìnı, e v pøípadì poáru nijak nepomùe.", 90, 20, 10),
	KNÍKA("Mein Kampf", 199, "Do roku 2015 zakázaná.", 50, 5, 3),
	ODPAÏÁK("Odpadkovı koš", 99, "Díky Kultovy velmi vzácná vìc", 35, 15, 5),
	BATOH("Baùek z 1. tøídy", 29, "Máš s ním spojenou spoustu vzpomínek, ale teï tì za nìj šikanují.", 30, 15, 10),
	BUSTALENINA("Busta Lenina", 4999, "Kadé ráno ji musíš pozdravit.", 40, 18, 1),
	IDLE("idle", 799, "Sakra nepohodlná. Uèitelská by byla lepší.", 60, 30, 8);
	
	private final String nazev;
	private final int hodnota;
	private final String popis;
	private final int obrana;
	private final int utok;
	private final int trvanlivost;
	ZbraneD(String nazev, int hodnota, String popis, int obrana, int utok, int trvanlivost)
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
