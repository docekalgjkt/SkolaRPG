package model.generator;

public enum ZbraneM implements ZbraneInterface
{
	PRAVÍTKO("Zlomené pravítko", 19, "Alespoò tentokrát ti k nìèemu bude.", 3, 16, 2),
	FLOORBALLKA("Floorballová hokejka", 349, "Sice na opaènou stranu, ale bolet to bude i tak!", 15, 40, 11),
	PROPISKA("Propiska", 9, "Do oka padne jako ulitá.", 1, 21, 1),
	UKAZOVÁTKO("Ukazovátko", 79, "Škoda jen, že s ním neumíš šermovat tak dobøe, jako uèitelé.", 12, 35, 3),
	NÙŽKY("Tupé nùžky", 39, "Kdysi dávno byly ostré.", 5, 30, 10),
	KVÌTINOVOMEÈ("Kvìtinùv meè", 14499, "Patøil jednomu z dávných králù ze severovýchodu. Vybojoval s ním mnoho bitev.", 60, 99, 35);
	
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
