package model.items;

import javafx.scene.image.ImageView;

public interface INositelne 
{
	TypPredmetu getTypPredmetu();
	String getNazev();
	String getPopis();
	int getHodnota();
	ImageView getObrazek();
}
