package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RolovaciTlacitkoDolu extends Button{

	public RolovaciTlacitkoDolu(VyberInventare vyberInventare){
		super();
		super.setOnAction(new RolovaciTlacitkoHandler(vyberInventare, false));
		ImageView img = new ImageView(new Image("source/arrow.png", 24, 24, true, true));
		img.setRotate(90);
		super.setGraphic(img);
	}
	
}
