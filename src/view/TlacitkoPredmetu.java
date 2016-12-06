package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.INositelne;

public class TlacitkoPredmetu extends Button {

	private INositelne predmet;
	
	public void setPredmet(INositelne predmet){
		this.predmet = predmet;
		super.setText(predmet.getNazev());
		super.setGraphic(new ImageView(predmet.getObrazek()));
	}
	
	public INositelne getPredmet(){
		return this.predmet;
	}
	
}
