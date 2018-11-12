package View;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Control.Controller;
import Game.Match;
import Player.PhysicalPlayer;

public class PhysicalPlayerGraphic extends JPanel {

	private Match match;
	private Controller controller;
	private PhysicalPlayer player;

	public PhysicalPlayerGraphic(Match match, Controller controller, PhysicalPlayer physicalPlayer) {
		super();
		this.match = match;
		this.controller = controller;
		this.player= physicalPlayer;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}

	private void displayComponent() {
				
	}


}
