package View;

import java.awt.BorderLayout;

import javax.print.DocFlavor.STRING;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.Controller;
import Game.Match;
import Player.VirtualPlayer;

public class VirtualPlayerGraphic extends JPanel {

	private Match match;
	private Controller controller;
	private VirtualPlayer player;

	public VirtualPlayerGraphic(Match match, Controller controller, VirtualPlayer virtualPlayer) {
		super();
		this.match = match;
		this.controller = controller;
		this.player= virtualPlayer;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.displayComponent();
	}

	private void displayComponent() {
		JPanel infoPlayer = new JPanel();
		infoPlayer.setLayout(new BoxLayout(infoPlayer, BoxLayout.X_AXIS));
		JLabel nameBox = new JLabel("Name: " + this.player.getNamePlayer());
		nameBox.setSize(100, 25);
		infoPlayer.add(nameBox);
			
		JLabel ageBox = new JLabel("Age: " + this.player.getAgePlayer());
		ageBox.setSize(100, 25);
		infoPlayer.add(ageBox);
		
		JLabel pointBox = new JLabel("Point: " + this.player.getPointPlayer());
		pointBox.setSize(100, 25);
		infoPlayer.add(pointBox);
		this.add(infoPlayer);
		
		JPanel listProp = new JPanel();
		infoPlayer.setLayout(new BoxLayout(infoPlayer, BoxLayout.X_AXIS));
		for (int i=0;i<2;i++) {
			PropGraphic cardProp = new PropGraphic(this.player.getArrPropinHand().get(i), this.controller);
			listProp.add(cardProp);
		}
		this.add(listProp);
		
	}

}
