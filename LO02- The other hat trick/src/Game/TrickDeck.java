package Game;

import java.util.ArrayList;

import Card.Trick;

public class TrickDeck extends ArrayList<Trick> { //TrickDeck est une liste de Trick
	
	private Match match;
	//Methode pour creer le TrickDeck au debut d'un Match
	public TrickDeck(Match matchActuel, ArrayList<Trick> tricks) {
		super();
		this.match = matchActuel;
		this.addAll(tricks);
		this.flipTrick();
	}
	//Methode pour retourner la carte en top de TrickDeck et puis l'envoyer vers Trick Pile
	public void flipTrick() {
		Trick trickTop = this.get(0);
		trickTop.setIsFaceUp(true);
		this.match.getTrickPile().add(trickTop);
		this.remove(trickTop);
	}
}
