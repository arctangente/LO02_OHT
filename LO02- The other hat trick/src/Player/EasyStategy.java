package Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Card.*;
import Game.TrickPile;
import Game.Turn;


public class EasyStategy implements stategy{

	@Override
	public void play(VirtualPlayer player, Turn currentTurn) {
		chooseTrick(player, currentTurn);
		prepareProp(player, currentTurn);
	}


	//boucle for pour choisir le trick au hasard
	public void chooseTrick(VirtualPlayer player, Turn currentTurn) {
		TrickPile trickPile  = currentTurn.getMatch().getTrickPile();
		Trick trickOnPerform = trickPile.get(trickPile.size()-1);//A Changer s'il n'y a pas de Trick dans TrickPile 
		String[] listPropInTrick1 = trickOnPerform.getArrIdProps1();
		String[] listPropInTrick2 = trickOnPerform.getArrIdProps2();
		int indexMatched =0;
		for(int i=0;i<2;i++) {
			Prop pr = player.getArrPropinHand().get(i);
			if(Arrays.asList(listPropInTrick1).contains(pr.getsIdProp()) && (Arrays.asList(listPropInTrick2).contains(pr.getsIdProp()))) {
				indexMatched ++;
			}
		}
		if(indexMatched!=1) {
			currentTurn.getMatch().getTrickDesk().flipTrick();
			trickOnPerform = trickPile.get(trickPile.size()-1);
		}
		
		currentTurn.setTrickOnPerform(trickOnPerform);	
		System.out.println( player.getNamePlayer() + " chose this trick to perform : " + trickOnPerform.getsNameTrick());
		
	}


	//random entre 0 et 1 pour choisir le prop, le joueur entre 0 et 3, et le prop a prendre
	public void prepareProp(VirtualPlayer player, Turn currentTurn) {
		Random rd = new Random();
		int iIndexPropChosen =  rd.nextInt(1);
		Prop pPropChosen = currentTurn.getPlayer().getArrPropinHand().get(iIndexPropChosen);
		
		
		int iIdPlayerChosen  =0 ;
		while ((iIdPlayerChosen == 0)|(iIdPlayerChosen == player.getIdPlayer()) ) {
			iIdPlayerChosen = rd.nextInt(3);
			//System.out.println(iIdPlayerChosen);
			
		} 
		Player p = currentTurn.getMatch().findPlayerById(iIdPlayerChosen);
		currentTurn.setPlayerChosen(p);
		int iIndexAnotherProp =  rd.nextInt(1);
		 Prop pAnotherPropChosen = currentTurn.getPlayerChosen().getArrPropinHand().get(iIndexAnotherProp);
		 
		 currentTurn.getPlayer().setArrPropinHand(iIndexPropChosen, pAnotherPropChosen);
		 currentTurn.getPlayerChosen().setArrPropinHand(iIndexAnotherProp, pPropChosen);
		 currentTurn.setArrPairOfProp(currentTurn.getPlayer().getArrPropinHand());
		System.out.println(player.getNamePlayer() + " has exchanged the props of " + p.getNamePlayer());
		System.out.println();
	}

	//retourne carte au hasard entre 0 et 1
	public void forfeit(VirtualPlayer player, Turn currentTurn) {
		if(player.getPropsFaceUp().size()==0) {
			Random rd = new Random();
			int iIndexProp = rd.nextInt(1);
			player.getArrPropinHand().get(iIndexProp).setIsFaceUp(true);
			System.out.println(player.getNamePlayer() +" prop is face-up: " + player.getArrPropinHand().get(iIndexProp).getsNameProp());
			
		}else if(player.getPropsFaceUp().size()==1) {
			player.getArrPropinHand().get(0).setIsFaceUp(true);
			player.getArrPropinHand().get(1).setIsFaceUp(true);
			System.out.println(player.getNamePlayer() +" All of props  are face-up:"+player.getArrPropinHand().get(0).getsNameProp()+" ,"+player.getArrPropinHand().get(1).getsNameProp());
		}else {
			System.out.println("There's no penalty for " + player.getNamePlayer());
		}
		System.out.println();
	}

	//au hasard
	public void sleightOfHand(VirtualPlayer player, Turn currentTurn) {
		player.setPropsFace(false);
		Random rd = new Random();
		int iChangeOrNot = rd.nextInt(1);
		if(iChangeOrNot==1) {
			int iIndexProp = rd.nextInt(1);	
			Prop p7thProp = currentTurn.getMatch().getCollectionProps().get(0);
			Prop pPropChange = currentTurn.getPlayer().getArrPropinHand().get(iIndexProp);
				
			currentTurn.getMatch().getCollectionProps().clear();
			currentTurn.getMatch().getCollectionProps().add(pPropChange);
				
			player.getArrPropinHand().remove(iIndexProp);
			player.addArrPropinHand(p7thProp);
							
		}
		System.out.println("The props of " + player.getNamePlayer() +" are face down" );
		System.out.println("The sleight of hand is finished.");
		System.out.println();
		
	};

}
