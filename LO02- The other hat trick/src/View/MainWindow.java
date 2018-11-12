package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import Control.Controller;
import Game.Match;
import Player.PhysicalPlayer;

public class MainWindow implements Observer {
	
	private Match match;
	private PhysicalPlayer physicalPlayer;
	private Controller controller;
	private JFrame frame;
	private JPanel panelNorth;
	private JPanel panelWest;
	private JPanel panelEast;
	private JPanel panelCenter;
	private JPanel panelSouth;
	private VirtualPlayerGraphic panelLeft;

	public MainWindow(Controller ctrl) {
		this.controller = ctrl;
		this.match = this.controller.getMatch();
		/*match.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.initialize();
	}

	private void initialize() {
		frame = new JFrame("HatTrick");
		frame.setBounds(0, 0, 1240, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.setBackground(new Color(0, 100, 0));
		frame.getContentPane().setLayout(new BorderLayout());

		
		panelNorth = new GameCenterGraphic(this.match, this.controller);
		TitledBorder borderTop = new TitledBorder("Center Game");
		borderTop.setTitleJustification(TitledBorder.CENTER);
		borderTop.setTitlePosition(TitledBorder.TOP);
		panelNorth.setBorder(borderTop);
		panelNorth.setPreferredSize(new Dimension(1220, 180));
		frame.add(panelNorth,BorderLayout.PAGE_START);


	/*	panelWest = new VirtualPlayerGraphic(this.match, this.controller,this.match.getVirtualPlayers().get(0));
		TitledBorder borderWest = new TitledBorder("Player 1");
		borderWest.setTitleJustification(TitledBorder.CENTER);
		borderWest.setTitlePosition(TitledBorder.TOP);
		panelWest.setBorder(borderWest);
		panelWest.setPreferredSize(new Dimension(300, 200));
		frame.add(panelWest,BorderLayout.LINE_START);
		*/
		
		panelWest = new VirtualPlayerGraphic(this.match, this.controller,this.match.getVirtualPlayers().get(0));
		TitledBorder borderWest = new TitledBorder("Player 1");
		borderWest.setTitleJustification(TitledBorder.CENTER);
		borderWest.setTitlePosition(TitledBorder.TOP);
		panelWest.setBorder(borderWest);
		panelWest.setPreferredSize(new Dimension(400, 400));
		frame.add(panelWest,BorderLayout.LINE_START);
		
		
		panelEast = new VirtualPlayerGraphic(this.match, this.controller,this.match.getVirtualPlayers().get(1));
		TitledBorder borderEast = new TitledBorder("Player 2");
		borderEast.setTitleJustification(TitledBorder.CENTER);
		borderEast.setTitlePosition(TitledBorder.TOP);
		panelEast.setBorder(borderEast);
		panelEast.setPreferredSize(new Dimension(400, 400));
		frame.add(panelEast,BorderLayout.LINE_END);
		
		
		
		panelSouth = new PhysicalPlayerGraphic(this.match,this.controller,this.match.getPhysicalPlayer());
		TitledBorder borderBottom = new TitledBorder("Center Game");
		borderBottom.setTitleJustification(TitledBorder.CENTER);
		borderBottom.setTitlePosition(TitledBorder.TOP);
		panelSouth.setBorder(borderTop);
		panelSouth.setPreferredSize(new Dimension(1220, 180));
		frame.add(panelSouth,BorderLayout.PAGE_END);
		

		panelCenter = new CollectionPropsGraphic(this.match, this.controller);
		TitledBorder borderCenter = new TitledBorder("The 7th Prop");
		borderCenter.setTitleJustification(TitledBorder.CENTER);
		borderCenter.setTitlePosition(TitledBorder.TOP);
		panelCenter.setBorder(borderCenter);
		panelCenter.setPreferredSize(new Dimension(300, 200));
		frame.add(panelCenter,BorderLayout.CENTER);
		
		this.frame.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
