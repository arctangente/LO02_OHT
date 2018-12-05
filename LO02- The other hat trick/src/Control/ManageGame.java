package Control;

import java.util.Scanner;

import Game.Match;

import Player.*;

public class ManageGame {
	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		
		//Game in console
		//Saisir des donn�es du joueur
		System.out.println("Veuillez saisir votre nom :");
		String sNom1 = sc.nextLine();
		System.out.println("Veuillez saisir votre age" );
		String sAge1 = sc.nextLine();
		int iAge1 = Integer.parseInt(sAge1);
		//Creer l'objet "Joueur Reel"
		PhysicalPlayer player1 = new PhysicalPlayer(0, sNom1, iAge1);
		
		//Definir le strategy du jeu
		stategy stategy = new EasyStategy();
		//Creer deux autres Joueurs Virtuels qui s'appellent VP1 et VP2
		//leurs age sont choisis aleatoirement entre 1 et 50
		String sName2 = "VP1";
		int iAge2 = (int) (Math.random()*50 +1);
		VirtualPlayer player2 = new VirtualPlayer(1, sName2, iAge2,stategy);
		
		String sName3 = "VP2";
		int iAge3 = (int) (Math.random()*50 +1);
		VirtualPlayer player3 = new VirtualPlayer(2, sName3, iAge3,stategy);
		
		Match match = new Match(player1, player2, player3);
		
		//System.out.println("the players are ready :" + match.getPlayer() );
		//Finir la creation des joueurs
		
		//Game in graphic
		
		/*	BeginWindow BeginWind = new BeginWindow();
		
		BeginWind.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				PhysicalPlayer player1 = BeginWind.getPhysicalPlayer();
				//Stategy
				stategy stategy = new EasyStategy();
				
				String sName2 = "John";
				int iAge2 = (int) (Math.random()*50 +1);
				VirtualPlayer player2 = new VirtualPlayer(1, sName2, iAge2,stategy);
				
				String sName3 = "David";
				int iAge3 = (int) (Math.random()*50 +1);
				VirtualPlayer player3 = new VirtualPlayer(2, sName3, iAge3,stategy);
				
				Match match = Match.getSingleton(player1, player2, player3);
				
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Controller controllerMatch = new Controller(match);
				MainWindow viewGraphic = new MainWindow(controllerMatch);
				match.addObserver(viewGraphic);
				BeginWind.closeWindow();
			}
		});

	}  */

}
	}
