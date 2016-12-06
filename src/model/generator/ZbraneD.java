package model.generator;

public enum ZbraneD implements ZbraneInterface
{
	HASI��K("Hasic� p��stroj", 1999, "Tak zaji�t�n�, �e v p��pad� po��ru nijak nepom��e.", 90, 20, 10),
	KN͎KA("Mein Kampf", 199, "Do roku 2015 zak�zan�.", 50, 5, 3),
	ODPA��K("Odpadkov� ko�", 99, "D�ky Kultovy velmi vz�cn� v�c", 35, 15, 5),
	BATOH("Ba���ek z 1. t��dy", 29, "M� s n�m spojenou spoustu vzpom�nek, ale te� t� za n�j �ikanuj�.", 30, 15, 10),
	BUSTALENINA("Busta Lenina", 4999, "Ka�d� r�no ji mus� pozdravit.", 40, 18, 1),
	�IDLE("�idle", 799, "Sakra nepohodln�. U�itelsk� by byla lep��.", 60, 30, 8);
	
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
