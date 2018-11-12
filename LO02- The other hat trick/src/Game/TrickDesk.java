package Game;

import java.util.ArrayList;

import Card.Trick;

public class TrickDesk extends ArrayList<Trick> {
	
	private Match match;

	public TrickDesk (Match matchActuel, ArrayList<Trick> tricks) {		
		super();
		this.match = matchActuel;
		this.addAll(tricks);
		this.flipTrick();
	}
	public void flipTrick() {
		Trick trickTop = this.get(0);
		trickTop.setIsFaceUp(true);
		this.match.getTrickPile().add(trickTop);
		this.remove(trickTop);
	}
}
