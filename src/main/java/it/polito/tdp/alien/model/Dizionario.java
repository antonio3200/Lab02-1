package it.polito.tdp.alien.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dizionario {
	private Map<String,AlienWords> dictionary;

	public Dizionario() {
		super();
		this.dictionary = new LinkedHashMap<String,AlienWords>();
	}
	
	public void addWord(String parola,String traduzione) {
		if(!this.dictionary.containsKey(parola))
			this.dictionary.put(parola,new AlienWords(parola));
		this.dictionary.get(parola).aggiungiTraduzione(traduzione);
	}
	
	public String traduci(String parola) {
		if(this.dictionary.containsKey(parola))
			return this.dictionary.get(parola).getTraduzioni();
		else
			return null;
	}
	
	

}
