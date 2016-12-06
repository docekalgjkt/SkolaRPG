package Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import javafx.stage.Stage;

public class Konfigurace {
	private Stage primaryStage;
	
	private static final int VOLUME_DEFAULT = 100;
	private static final boolean FULLSCREEN_DEFAULT = false;
	private static final int ROZLISENI_VYSKA = 720;
	private static final int ROZLISENI_SIRKA = 1280;
	
	private static final String CESTA = "C:/Users/nguyen/Konfigurace.xml";

	private static Konfigurace konfigurace;
	private int Volume;
	private boolean FullScreen;
	private int rozliseniVyska;
	private int rozliseniSirka;
	
	public static Konfigurace getKonfigurace(){
		if(konfigurace != null){
			return konfigurace;
		}else{
			Konfigurace konf = new Konfigurace();
			konf.cteni();
			return konf;
		}
	}
	
	private Konfigurace(){
		
	}
	
	private Konfigurace(int Volume, boolean FullScreen, int rozliseniSirka, int rozliseniVyska){
		this.Volume = Volume;
		this.FullScreen = FullScreen;
		this.rozliseniSirka = rozliseniSirka;
		this.rozliseniVyska = rozliseniVyska;		
	}
	
	public void setprimaryStage(Stage stage){
		this.primaryStage = stage;
	}
	
	public int getrozliseniSirka(){
		return rozliseniSirka;
	}
	
	public int getrozliseniVyska(){
		return rozliseniVyska;
	}
	
	public void setrozliseniSirka(int cisloS){
		this.rozliseniSirka = cisloS;
	}
	
	public void setrozliseniVyska(int cisloV){
		this.rozliseniVyska = cisloV;
	}
	public boolean getFullScreen(){
		return FullScreen;
	}
	
	public int getVolume(){
		return Volume;
	}
	
	public void setVolume(int Hlasitost){
		
	}
	private static void setKonfigurace (Konfigurace konfig){
		
		Konfigurace.konfigurace = konfig;
	}
	
	
	public void zapis(){

		
		
		
		XMLOutputFactory xof = XMLOutputFactory.newInstance();
		XMLStreamWriter xsw = null;
		
		try
		{
	        xsw = xof.createXMLStreamWriter(new FileWriter(CESTA));
	        xsw.writeStartDocument();
	        xsw.writeStartElement("konfigurace");
	        
	        xsw.writeAttribute("volume", Double.toString(getVolume()));
	        xsw.writeAttribute("fullscreen", Boolean.toString(getFullScreen()));
	        xsw.writeAttribute("rozliseniVyska", Double.toString(getrozliseniVyska()));
	        xsw.writeAttribute("rozliseniSirka", Double.toString(getrozliseniSirka()));	
	        
	        xsw.writeEndElement();
	        xsw.writeEndDocument();
	        xsw.flush();
	        xsw.close();
	}
	catch (Exception e)
	{
	                System.err.println("Chyba pøi zápisu: " + e.getMessage());
	}
	finally
	{
	        try
	        {
	                if (xsw != null)
	                {
	                                xsw.close();
	                }
	        }
	        catch (Exception e)
	        {
	                        System.err.println("Chyba pøi uzavírání souboru: " + e.getMessage());
	        }
	}
		
	}
	
	public void cteni(){
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader xsr = null;
		
		try
		{
		         xsr = factory.createXMLStreamReader(new FileReader(CESTA));
		         
		         xsr.next();
		         this.Volume = Integer.parseInt(xsr.getAttributeValue(0));
		         this.FullScreen = Boolean.parseBoolean(xsr.getAttributeValue(1));
		         this.rozliseniVyska = Integer.parseInt(xsr.getAttributeValue(2));
		         this.rozliseniSirka = Integer.parseInt(xsr.getAttributeValue(3));
		       xsr.close();
		}
		catch (FileNotFoundException e)
		{
			Volume = VOLUME_DEFAULT;
			FullScreen = FULLSCREEN_DEFAULT;
			rozliseniVyska = ROZLISENI_VYSKA;
			rozliseniSirka = ROZLISENI_SIRKA;
			zapis();
		}
		catch (Exception e)
		{		
			//TODO
		}
		finally
		{
		        try
		        {
		                xsr.close();
		        }
		        catch (Exception e)
		        {
		                System.err.println("Chyba pøi uzavírání souboru: " + e.getMessage());
		        }
		}
	}
	
	

	
	
}
