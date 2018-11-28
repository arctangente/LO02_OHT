package Game;

import java.util.*;

import Card.Prop;
import Player.Player;

public class CollectionProps extends ArrayList<Prop> {

	private Match match;
	//Methode pour creer une liste de Prop au debut du jeu
	public CollectionProps (Match matchActuel, ArrayList<Prop> arrProps) {
		
		super();
		this.match = matchActuel;
		this.addAll(arrProps);
	}
	//Methode pour distribuer les Props aux joueurs au d�but du jeu 
	public void distributeProp (ArrayList<Player> arrPlayers) {
		
		while (this.match.getCollectionProps().size()>arrPlayers.size()) {
			for(int i=0; i<arrPlayers.size();i++) {
				Player p = arrPlayers.get(i);
				int iSizeCollection = this.match.getCollectionProps().size();
				Prop prop = this.match.getCollectionProps().get(iSizeCollection-1);
				prop.setpProperty(p);
				p.addArrPropinHand(prop);
				this.match.removeProp(iSizeCollection-1);				
			}
		}
		
	}
}
