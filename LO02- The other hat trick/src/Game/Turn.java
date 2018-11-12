package Game;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

import Card.*;
import Player.*;

public class Turn {

	
	
	private Match match;
	private Player player;
	private Trick trickOnPerform;
	private Player playerChosen;
	private ArrayList<Prop> arrPairOfProp = new ArrayList<Prop>();
	private int iCounterLastRound;



	public Turn (Match currentMatch,Player currentPlayer) {
		this.match = currentMatch;
		this.player = currentPlayer;
		this.iCounterLastRound =0;
		this.startTurn();
		
	}
	public void startTurn() {
		this.player.play(this);
		
		
	}
	public ArrayList<Prop> getArrPairOfProp() {
		return this.arrPairOfProp;
	}

	public void setArrPairOfProp(ArrayList<Prop> arrPairOfProp) {
		this.arrPairOfProp = arrPairOfProp;
	}
	
	public Trick getTrickOnPerform() {
		return this.trickOnPerform;
	}


	public void setTrickOnPerform(Trick trickOnPerform) {
		this.trickOnPerform = trickOnPerform;
	}


	public Match getMatch() {
		return this.match;
	}


	public Player getPlayer() {
		return this.player;
	}

	public Player getPlayerChosen() {
		return this.playerChosen;
	}
	public void setPlayerChosen(Player player) {
		this.playerChosen = player;
	}
	public void lastRound(Boolean bResultTurn) {
		if(bResultTurn) {
			this.match.setIsEnd(true);
		}
		else {
			this.iCounterLastRound++;
			if(this.iCounterLastRound==3) {
				this.match.setIsEnd(true);
			}
		}
		
	}

}
