package model;

public class NPC extends Postava {
	
	public NPC(String jmeno) {
		super(jmeno);
	}
	
	private double HP;
	
	public double getHP(){
		return HP;
	}
	
	//public Zbran getUtok(){
	//	return super.getBatoh();
	//}
	
	//public INo



	@Override
	public void zran(double zaKolik) {
		HP -= zaKolik;
	}
	
	

}
