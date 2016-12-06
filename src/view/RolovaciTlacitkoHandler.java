package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RolovaciTlacitkoHandler implements EventHandler<ActionEvent>{

	private VyberInventare vyber;
	private boolean nahoru;
	
	public RolovaciTlacitkoHandler(VyberInventare vyber, boolean nahoru){
		super();
		this.vyber = vyber;
		this.nahoru = nahoru;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(nahoru){
			vyber.posunoutVys();
		} else {
			vyber.posunoutNiz();
		}
	}

}
