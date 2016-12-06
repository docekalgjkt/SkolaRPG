package model.generator;

public enum ZbraneM implements ZbraneInterface
{
	PRAV�TKO("Zlomen� prav�tko", 19, "Alespo� tentokr�t ti k n��emu bude.", 3, 16, 2),
	FLOORBALLKA("Floorballov� hokejka", 349, "Sice na opa�nou stranu, ale bolet to bude i tak!", 15, 40, 11),
	PROPISKA("Propiska", 9, "Do oka padne jako ulit�.", 1, 21, 1),
	UKAZOV�TKO("Ukazov�tko", 79, "�koda jen, �e s n�m neum� �ermovat tak dob�e, jako u�itel�.", 12, 35, 3),
	NَKY("Tup� n��ky", 39, "Kdysi d�vno byly ostr�.", 5, 30, 10),
	KV�TINOVOME�("Kv�tin�v me�", 14499, "Pat�il jednomu z d�vn�ch kr�l� ze severov�chodu. Vybojoval s n�m mnoho bitev.", 60, 99, 35);
	
	private final String nazev;
	private final int hodnota;
	private final String popis;
	private final int obrana;
	private final int utok;
	private final int trvanlivost;
	ZbraneM(String nazev, int hodnota, String popis, int obrana, int utok, int trvanlivost)
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
