package Game;

import java.util.ArrayList;

import Card.Trick;

public class TrickPile extends ArrayList<Trick>{
	
	private Match match;

	public TrickPile (Match matchActuel) {
		
		super();
		this.match = matchActuel;
	}
}
