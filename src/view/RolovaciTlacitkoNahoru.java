package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RolovaciTlacitkoNahoru extends Button{

	public RolovaciTlacitkoNahoru(VyberInventare vyberInventare){
		super();
		super.setOnAction(new RolovaciTlacitkoHandler(vyberInventare, true));
		ImageView img = new ImageView(new Image("source/arrow.png", 24, 24, true, true));
		img.setRotate(-90);
		super.setGraphic(img);
	}
	
}
