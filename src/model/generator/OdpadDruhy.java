package model.generator;

public enum OdpadDruhy 
{
	PAPÍR("List papíru", 1, "Zmaèkané vysvìdèení z prvního roèníku. Není divu, že se ho adresát zbavil."), 
	ALOBAL("Alobal", 1, "Mastný se zbytkem svaèiny. Dotyèná nejspíš nemìla rajèata v lásce."), 
	LÁHEV("Láhev", 5, "Byla ve špatném koši, tøídìní se ještì poøád moc neuchytilo."), 
	SPONKA("Sponka", 10, "Je na ní ještì vlas. Mohl bys toho využít pro Voo-Doo rituál."), 
	ŽVÝKAÈKA("Žvýkaèka", 2, "Vyžvýkaná, ale stejnì sis nemohl pomoct a vzal sis jí. Èunì."), 
	PRACH("Prach", 0, "Alespoò ten se ti v penìžence válí.");
	
	private String nazev;
	private int hodnota;
	private String popis;
	OdpadDruhy(String nazev, int hodnota, String popis)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.popis = popis;
	}
	
	public String getNazev()
	{
		return nazev;
	}
	public int getHodnota()
	{
		return hodnota;
	}
	public String getPopis()
	{
		return popis;
	}
}
