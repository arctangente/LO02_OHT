package Game;

import java.util.ArrayList;

import Card.Trick;

public class TrickDesk extends ArrayList<Trick> { //TrickDesk est une liste de Trick
	
	private Match match;
	//Methode pour créer le TrickDesk au début d'un Match 
	public TrickDesk (Match matchActuel, ArrayList<Trick> tricks) {		
		super();
		this.match = matchActuel;
		this.addAll(tricks);
		this.flipTrick();
	}
	//Methode pour retourner la carte en top de TrickDesk et puis l'envoyer vers Trick Pile
	public void flipTrick() {
		Trick trickTop = this.get(0);
		trickTop.setIsFaceUp(true);
		this.match.getTrickPile().add(trickTop);
		this.remove(trickTop);
	}
}
