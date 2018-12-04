package Game;

import java.util.*;

import Card.InstancieurXml;
import Card.*;
import Player.*;

public class Match extends Observable implements Runnable {

	private static Match match;
	private ArrayList<Player> listPlayer;
	private TrickDeck trickDesk;
	private CollectionProps collectionProps;
	private TrickPile trickPile;
	private Boolean isEnd;

	


	public Match (PhysicalPlayer player1, VirtualPlayer player2, VirtualPlayer player3) {
		this.listPlayer = new ArrayList<Player>();
		this.listPlayer.add(player1);
		this.listPlayer.add(player2);
		this.listPlayer.add(player3);
		Collections.sort(this.listPlayer,new Comparator<Player>() {

			@Override
			public int compare(Player p1, Player p2) {
				int age1 = p1.getAgePlayer();
				int age2 = p2.getAgePlayer();
				return age1-age2;
			}
			
			
			
		});
		System.out.println("match begin");
		this.start();
	//	MainWindow viewGraphic = new MainWindow(this, player1, new Controller(this));
		
	}


	public ArrayList<Player> getListPlayer() {
		return this.listPlayer;
	}
	
	public PhysicalPlayer getPhysicalPlayer() {
		Player p = null;
		for (int i=0; i<3;i++) {
			if (this.listPlayer.get(i) instanceof PhysicalPlayer)
				p = listPlayer.get(i);
		}
		return (PhysicalPlayer) p;
	}
	
	public ArrayList<VirtualPlayer> getVirtualPlayers() {
		ArrayList<VirtualPlayer> arrVirPl = new ArrayList<VirtualPlayer>();
		for (int i=0; i<3;i++) {
			if (this.listPlayer.get(i) instanceof VirtualPlayer)
				arrVirPl.add((VirtualPlayer)listPlayer.get(i)) ;
		}
		return arrVirPl;
	}

	public TrickDeck getTrickDesk() {
		return trickDesk;
	}

	public void setTrickDesk(TrickDeck trickDesk) {
		this.trickDesk = trickDesk;
	}

	public TrickPile getTrickPile() {
		return trickPile;
	}

	public void setTrickPile(TrickPile trickPile) {
		this.trickPile = trickPile;
	}

	public CollectionProps getCollectionProps() {
		return collectionProps;
	}

	public String getPlayer() {
		String sPlayers ="";
		for (int i=0; i<this.listPlayer.size();i++) {
			sPlayers += this.listPlayer.get(i).getNamePlayer() + " " + this.listPlayer.get(i).getAgePlayer() +"\n";
		}
		return sPlayers;
	}
	 
	public void removeProp(int idProp) {
		this.collectionProps.remove(idProp);
	}
	
	public Player findPlayerById (int id) {
		int iResult = -1;
		for(int i=0;i<this.listPlayer.size();i++) {
			if (id == this.listPlayer.get(i).getIdPlayer()) {
				iResult=i;
			}
		}
		
		return this.listPlayer.get(iResult);
		
	}
	public void start() {
		Thread myThreat = new Thread(this);
		myThreat.start();
	}

	public void run() {

		InstancieurXml readCard = new InstancieurXml();
		ArrayList<Prop> arrProps = readCard.getListProps();
		ArrayList<Trick> arrTricks = readCard.getListTricks();
		this.isEnd = false;
		
		
		this.collectionProps = new CollectionProps(this, arrProps);
		this.trickPile = new TrickPile(this);
		this.trickDesk = new TrickDeck(this,arrTricks);
		this.collectionProps.distributeProp(this.listPlayer);
	//	System.out.println(" Tricks and Props have been created");
	//	System.out.println(readCard.toString());
		
		for (int i=0; i<this.listPlayer.size();i++) {
			System.out.println(this.listPlayer.get(i).showParameter());
		}
		System.out.println("Trick on Trickpile : "+ this.trickPile.get(this.trickPile.size()-1).getsNameTrick());
		
		int iIndexPlayer =0;
		while(!this.isEnd) {
			Turn t = new Turn(this, this.listPlayer.get(iIndexPlayer));
			iIndexPlayer++;
			if(iIndexPlayer==3){
				iIndexPlayer =0;
				for (int k=0; k<this.listPlayer.size();k++) {
					System.out.println(this.listPlayer.get(k).showParameter());
				}
			}
			
		}
		if (this.isEnd) {
			for (int j=0; j<this.listPlayer.size();j++) {
				System.out.println(this.listPlayer.get(j).showParameter());
			}
		}
		
	}
	public Boolean getIsEnd() {
		return this.isEnd;
	}


	public void setIsEnd(Boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	public void EndMatch(){
		
	}
	
	public static Match getSingleton(PhysicalPlayer player1, VirtualPlayer player2, VirtualPlayer player3) {
		if (match == null) {
			match = new Match(player1,player2,player3);
		}
		return match;
	}

}
