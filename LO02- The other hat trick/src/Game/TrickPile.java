package Game;

import java.util.ArrayList;

import Card.Trick;

public class TrickPile extends ArrayList<Trick>{ //TrickPile est une liste de Trick 
	
	private Match match;
	//Methode pour créer l'objet TrickPile
	public TrickPile (Match matchActuel) {
		
		super();
		this.match = matchActuel;
	}
}
