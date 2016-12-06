package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import model.Hrac;
import model.INositelne;
import model.Jidlo;
import model.TypPredmetu;
import model.Zbran;

public class TlacitkoPredmetuHandler implements EventHandler<ActionEvent> {

	private Hrac hrac;
	private Label typLabel;
	private Label hodnotaLabel;
	
	public TlacitkoPredmetuHandler(Hrac hrac){
		this.hrac = hrac;
	}
	
	@Override
	public void handle(ActionEvent event) {
		TlacitkoPredmetu tlacitko = (TlacitkoPredmetu) event.getSource();
		INositelne predmet = tlacitko.getPredmet();
		hrac.setVyberPredmetu(predmet);
		if(typLabel != null){
			if(predmet.getTypPredmetu() == TypPredmetu.JIDLO){
				String typ = ((Jidlo) predmet).getTypObnovy();
				this.typLabel.setText(typ);
				this.hodnotaLabel.setText(Integer.toString(((Jidlo) predmet).getHodnotaObnovy()));
			}  else if(predmet.getTypPredmetu() == TypPredmetu.ZBRAN){
				String typ = ((Zbran) predmet).getTypUtoku().toString();
				this.typLabel.setText(typ);
				this.hodnotaLabel.setText(Integer.toString(((Zbran) predmet).getUtok()) + " utoku\n" + Integer.toString(((Zbran) predmet).getObrana()) + " obrany");
			}
		}
	}
	
	public void setTypLabel(Label typ){
		this.typLabel = typ;
	}
	
	public void setHodnotaLabel(Label hodnota){
		this.hodnotaLabel = hodnota;
	}
}
