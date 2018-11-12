package Player;

import Game.Turn;

public interface stategy {
	public void play(VirtualPlayer player, Turn currentTurn);

	public void forfeit(VirtualPlayer player, Turn currentTurn);

	public void sleightOfHand(VirtualPlayer virtualPlayer, Turn currentTurn);
}
