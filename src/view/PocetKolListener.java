package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

public class PocetKolListener implements ChangeListener<Number>{

	private Label pocetKol;
	
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {
		pocetKol.setText(newNumber.toString());
	}

	public void setPocetKolLabel(Label pocetKol){
		this.pocetKol = pocetKol;
	}
}
