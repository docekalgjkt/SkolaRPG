package model;
public class Pozice 
{
	private int xPoz = 0;
	private int yPoz = 0;
	
	public Pozice(int xPoz, int yPoz)
	{
		setPozice(xPoz,yPoz);
	}
	public Pozice(Pozice pozice)
	{
		this(pozice.getXPoz(),pozice.getYPoz());
	}
	public Pozice()
	{
		this(0,0);
	}
	public void setPozice(int xPoz, int yPoz)
	{
		this.xPoz = xPoz;
		this.yPoz = yPoz;
	}
	public Pozice getPozice()
	{
		return this;
	}
	public int getXPoz()
	{
		return this.xPoz;
	}
	public int getYPoz()
	{
		return this.yPoz;
	}
	public Pozice getCopy()
	{
		return new Pozice(this);
	}
}
