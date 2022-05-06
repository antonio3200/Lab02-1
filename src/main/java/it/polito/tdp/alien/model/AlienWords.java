package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Set;

public class AlienWords {
	String parola;
	Set<String> traduzioni;
	public AlienWords(String parola) {
		super();
		this.parola = parola;
		this.traduzioni = new HashSet<String>();
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public void aggiungiTraduzione(String traduzione) {
		this.traduzioni.add(traduzione);
	}
	public String getParola() {
		return parola;
	}
	public String getTraduzioni() {
		String result="";
		for(String s: this.traduzioni)
			result+=s+"\n";
		return result;
	}
	

}
