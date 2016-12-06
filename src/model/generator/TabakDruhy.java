package model.generator;

public enum TabakDruhy 
{
	MARLBORO("Marlboro", 90, "Rakovina plic u� �ek�.", 25),
	CHESTERFIELD("Chesterfield 70s. Red", 70, "Tv�j v�rn� kamar�d.", 15),
	DAVIDOFF("Davidoff Gold slims", 94, "V�n� bys toho u� m�l nechat.", 30),
	CAMEL("Camel no filter", 72, "Nen� to sam�, co Camle Toe.", 20);
	
	private String nazev;
	private int hodnota;
	private String popis;
	private int hodnotaObnovy;
	
	TabakDruhy(String nazev, int hodnota, String popis, int hodnotaObnovy)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.popis = popis;
		this.hodnotaObnovy = hodnotaObnovy;
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
	public int getHodnotaObnovy()
	{
		return hodnotaObnovy;
	}
}
