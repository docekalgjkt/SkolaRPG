package model;

public class Zbran implements INositelne {
	
	private final TypPredmetu typPredmetu = TypPredmetu.ZBRAN	;
	private String nazev;
	private String popis;
	private int hodnota;
	private int utok;
	private int obrana;
	private int trvanlivost;
	private TypUtoku typUtoku;
	
	public Zbran(String nazev, String popis, int hodnota, int utok, int obrana){
		this.nazev = nazev;
		this.popis = popis;
		this.hodnota = hodnota;
		this.utok = utok;
		this.obrana = obrana;
		
	}
		public Zbran(String string, String string2, int nextInt, int nextInt2, int nextInt3, int nextInt4,
			TypUtoku randomTypUtoku) {
		// TODO Auto-generated constructor stub
	}
		public TypUtoku getTypUtoku(){
			return typUtoku;
		}
				
		public int getTrvanlivost(){
			return trvanlivost;
		}
		
		public int getUtok(){
			return utok;
		}
		
		public int getObrana(){
			return obrana;
		}
		
		public void poskodPredmet(int oKolik){
			this.trvanlivost -= oKolik;
		}
		
		@Override
		public TypPredmetu getTypPredmetu() {
			
			return typPredmetu;
		}
		@Override
		public String getNazev() {
			
			return nazev;
		}
		@Override
		public String getPopis() {
			
			return popis;
		}
		@Override
		public int getHodnota() {
			
			return hodnota;
		}
		
		
	
}