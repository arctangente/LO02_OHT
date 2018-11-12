package Control;

import java.util.Scanner;

import Game.Match;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Player.*;
import Game.*;
import View.BeginWindow;
import View.*;

public class ManageGame {
	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		
		//Game in console
		System.out.println("Veuillez saisir votre nom :");
		String sNom1 = sc.nextLine();
		System.out.println("Veuillez saisir votre age" );
		String sAge1 = sc.nextLine();
		int iAge1 = Integer.parseInt(sAge1);
		PhysicalPlayer player1 = new PhysicalPlayer(0, sNom1, iAge1);
		
		//
		stategy stategy = new EasyStategy();
		
		String sName2 = "John";
		int iAge2 = (int) (Math.random()*50 +1);
		VirtualPlayer player2 = new VirtualPlayer(1, sName2, iAge2,stategy);
		
		String sName3 = "David";
		int iAge3 = (int) (Math.random()*50 +1);
		VirtualPlayer player3 = new VirtualPlayer(2, sName3, iAge3,stategy);
		
		Match match = new Match(player1, player2, player3);
	
		System.out.println("the players are ready :" + match.getsPlayers() );
		
		/*
		//Game in graphic
		
		BeginWindow BeginWind = new BeginWindow();
		
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
		});*/

	}

}
