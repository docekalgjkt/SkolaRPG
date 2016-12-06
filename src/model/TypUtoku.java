package model;

public enum TypUtoku {
	BLIZKY, DALEKY, OBRANNY; //  Blízky > Daleký > Obranný > Blízký
	
	public static boolean isVetsi(TypUtoku typUtoku1, TypUtoku typUtoku2){
		switch(typUtoku1){
		case BLIZKY:
			if(typUtoku2 == DALEKY){
				return true;
			} else {
				return false;
			}
		case DALEKY:
			if(typUtoku2 == OBRANNY){
				return true;
			} else {
				return false;
			}
		case OBRANNY:
			if(typUtoku2.equals(BLIZKY)){
				return true;
			} else {
				return false;
			}
		
		default:
			return false; // Toto se nikdy nestane, ale aby kompilátor mìl klid a nebuzeroval, tak to zde musí být.
		}
	}
}
