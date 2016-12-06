package model.generator;

public enum KlicDruhy 
{
	KLIC_ID0("Karta od vchodu", 50, 0, "Otv�r� vchod do �koly. Nefunguje v�t�inu dne."), 
	KLIC_ID1("�ip od biologie", 100, 1, "Otv�r� dve�e ke spoust� preparovan�ch zv��at."), 
	KLIC_ID2("�ip od kancel��e", 200, 2, "Otv�r� dve�e k osobn�m informac�m n�s v�ech."), 
	KLIC_ID3("�ip od po��ta�ovny", 400, 3, "Otv�r� dve�e k nejv�t�� kr�de�i, kterou �kola za�ila.");
	
	private String nazev;
	private int hodnota;
	private int ID;
	private String popis;
	KlicDruhy(String nazev, int hodnota, int ID, String popis)
	{
		this.nazev = nazev;
		this.hodnota = hodnota;
		this.ID = ID;
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
	public int getID()
	{
		return ID;
	}
	public String getPopis()
	{
		return popis;
	}
	public static KlicDruhy getPodleID(int ID) //vrac� null, kdy� ID neodpov�d� ��dn�mu kl��i
	{
		for(KlicDruhy klic: KlicDruhy.values())
		{
			if(klic.getID() == ID)
			{
				return klic;
			}
		}
		return null;
	}
}
