package Player;


import Game.*;

public class VirtualPlayer extends Player{
	private stategy stategy;

	public VirtualPlayer(int idPlayer, String namePlayer, int agePlayer,stategy stategy) {
		super(idPlayer, namePlayer, agePlayer);
		this.stategy = stategy;
	}

	@Override
	public void sleightOfHand(Turn currentTurn) {
		this.stategy.sleightOfHand(this,currentTurn);
	}


	@Override
	public void play(Turn currentTurn) {
		this.stategy.play(this, currentTurn);
		this.performProps(currentTurn);
		
	}





	public void forfeitMatch(Turn currentTurn) {
		System.out.println("///////////////////"+this.getNamePlayer() +" Forfeit"+"///////////////////");
		
		this.stategy.forfeit(this,currentTurn);
		
	}




	
}
