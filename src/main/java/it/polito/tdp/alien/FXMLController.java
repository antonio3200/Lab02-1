/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienWords;
import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Dizionario model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML
    void doClear(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String riga=txtWord.getText().toLowerCase();
    	if(riga==null || riga.length()==0) {
    		txtResult.appendText("Scrivi qualcosa amigo");
    		return;}
    		
    	String [] vettore;
    	vettore= riga.split(" ");
    	if(vettore.length==1) {
    		String cercata= vettore[0];
    		if(!cercata.matches("[a-zA-Z]*")) {
    			txtResult.appendText("Scrivere solo caratteri alfabetici");
    		}

    		String result= model.traduci(cercata);
    		if(result!=null)
    		txtResult.appendText("Le traduzioni della parola "+cercata+" sono: "+result);
    		else
    			txtResult.appendText("La parola cercata non è presente nel dizionario");
    	}
    	else {
    		String ricercata=vettore[0];
    		String traduzione=vettore[1];
    		if(!ricercata.matches("[a-zA-Z]*") || !traduzione.matches("[a-zA-Z]*")) {
    			txtResult.appendText("Scrivere solo caratteri alfabetici");
    		}
    		model.addWord(ricercata, traduzione);
    		txtResult.appendText("La parola "+ricercata+" è stata aggiunta al dizionario con traduzione "+ traduzione);
    	}
    		
    	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        model= new Dizionario();
    }
}
