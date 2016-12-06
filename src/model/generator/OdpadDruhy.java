package model.generator;

public enum OdpadDruhy 
{
	PAP�R("List pap�ru", 1, "Zma�kan� vysv�d�en� z prvn�ho ro�n�ku. Nen� divu, �e se ho adres�t zbavil."), 
	ALOBAL("Alobal", 1, "Mastn� se zbytkem sva�iny. Doty�n� nejsp� nem�la raj�ata v l�sce."), 
	L�HEV("L�hev", 5, "Byla ve �patn�m ko�i, t��d�n� se je�t� po��d moc neuchytilo."), 
	SPONKA("Sponka", 10, "Je na n� je�t� vlas. Mohl bys toho vyu��t pro Voo-Doo ritu�l."), 
	�V�KA�KA("�v�ka�ka", 2, "Vy�v�kan�, ale stejn� sis nemohl pomoct a vzal sis j�. �un�."), 
	PRACH("Prach", 0, "Alespo� ten se ti v pen�ence v�l�.");
	
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
