package model.items;


public enum TypUtoku 
{
	BLIZKY, DALEKY, OBRANNY;
	public static boolean isVetsi(TypUtoku prvni, TypUtoku druhy) //pokud vyhraje první, tak true
	{
		if(prvni == TypUtoku.DALEKY && druhy == TypUtoku.BLIZKY)
		{return true;}
		else
		if(prvni == TypUtoku.BLIZKY && druhy == TypUtoku.DALEKY)
		{return false;}
		else
		if(prvni == TypUtoku.DALEKY && druhy == TypUtoku.OBRANNY)
		{return false;}
		else
		if(prvni == TypUtoku.OBRANNY && druhy == TypUtoku.DALEKY)
		{return true;}
		else
		if(prvni == TypUtoku.BLIZKY && druhy == TypUtoku.OBRANNY)
		{return true;}
		else
		return false; //jedná se o obranny vs. blizky
	}
}