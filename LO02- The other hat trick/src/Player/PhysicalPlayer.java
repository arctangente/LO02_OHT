package Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Card.*;
import Game.*;

public class PhysicalPlayer extends Player{

	public PhysicalPlayer(int idPlayer, String namePlayer, int agePlayer) {
		super(idPlayer, namePlayer, agePlayer);
		// TODO Auto-generated constructor stub
	}


	//Methode pour choisir un Trick (print le trick et propose de le choisir ou le trick d'apres), print le trick choisi
	public void chooseTrick(Turn currentTurn) {
		TrickPile trickPile = currentTurn.getMatch().getTrickPile(); //Get le TrickPile actuel 
		TrickDeck trickDesk = currentTurn.getMatch().getTrickDesk();// Get le TrickDesk actuel 
		System.out.println("Current Trick is :" + trickPile.get(trickPile.size()-1).getsNameTrick());//Prendre le Trick on Top de TrickPile
		Scanner sc = new Scanner(System.in);
		Trick trickOnPerform;
		if (trickDesk.size()!=0){ 
			System.out.println("Please choose the trick : this(0) or next(1)?");
			String sReponse = sc.nextLine();
		
			if(sReponse.equals("0")) {
				trickOnPerform = trickPile.get(trickPile.size()-1);
			}else {
				currentTurn.getMatch().getTrickDesk().flipTrick();
				trickOnPerform = trickPile.get(trickPile.size()-1);
			}
			currentTurn.setTrickOnPerform(trickOnPerform);
			
			System.out.println("You have chosen this trick to perform : " + trickOnPerform.getsNameTrick());
			}
		else {
			trickOnPerform = trickPile.get(trickPile.size()-1);
			System.out.println("Trick to perform : " + trickOnPerform.getsNameTrick());
			//currentTurn.getMatch().setIsEnd(true);
		}
		
	}



	// choisir un prop a echanger, echanger avec un prop dans la main d'un autre joueur
	public void prepareProps(Turn currentTurn) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose the prop to exchange: the first(0) or the second(1)? : ");
		System.out.println(currentTurn.getPlayer().getsArrPropinHand());
		int iIndexPropChosen = Integer.parseInt(sc.nextLine());
		Prop pPropChosen = currentTurn.getPlayer().getArrPropinHand().get(iIndexPropChosen);
		
		System.out.println("Please choose the player you want to exchange the props : VP1(1) or VP2(2)?");
		String sReponse = sc.nextLine();
		if(sReponse.equals("1")) {
			Player p = (VirtualPlayer) currentTurn.getMatch().findPlayerById(1);
			currentTurn.setPlayerChosen(p);
		}else {
			Player p = (VirtualPlayer) currentTurn.getMatch().findPlayerById(2);
			currentTurn.setPlayerChosen(p);
		}


		System.out.println("Player Chosen : " + currentTurn.getPlayerChosen().getNamePlayer());

		//print les cartes faceup
		if(currentTurn.getPlayerChosen().getPropsFaceUp().size()>0) {
			System.out.println("The two props of the player chosen are : 0 or 1");
			Player p = currentTurn.getPlayerChosen();
			for (int i =0; i<2;i++ ) {
					System.out.print(i+"-");
				if(p.getArrPropinHand().get(i).getIsFaceUp()) {					
					System.out.println(p.getArrPropinHand().get(i).getsNameProp());
				}else {
					
					System.out.println("Unknown");
				}
			}
		} else {
			
			System.out.println("The two props of the player chosen are face down. So you want the first (0) or the second(1)?");
		}
		 sReponse = sc.nextLine();
		 int iIndexAnotherProp = Integer.parseInt(sReponse);
		 Prop pAnotherPropChosen = currentTurn.getPlayerChosen().getArrPropinHand().get(iIndexAnotherProp);
		 currentTurn.getPlayer().setArrPropinHand(iIndexPropChosen, pAnotherPropChosen);
		 currentTurn.getPlayerChosen().setArrPropinHand(iIndexAnotherProp, pPropChosen);
		 currentTurn.setArrPairOfProp(currentTurn.getPlayer().getArrPropinHand());
		 System.out.println("Your current props are: ");
		 System.out.println(currentTurn.getPlayer().getsArrPropinHand());
		 
		 
		 
	}

	/*public void performProps(Turn currentTurn) {
		int iCounter = 0;
		for (int i=0;i<2;i++) {
			String[] listPropInTrick = currentTurn.getTrickOnPerform().getArrIdProps();
			String sIdProp = currentTurn.getArrPairOfProp().get(i).getsIdProp();
			if(Arrays.asList(listPropInTrick).contains(sIdProp)) {
				iCounter ++;
			}
		}
		if(iCounter ==2) {
			this.successMatch(currentTurn);
		}else {
			this.forfeitMatch(currentTurn);
		}
		
	}
	*/


	//methode pour flip un prop en cas de forfeit, verifie si la prop nest pas deja faceup
	public void forfeitMatch(Turn currentTurn) {
		System.out.println("/////////////Forfeit//////////////");
		if(this.getPropsFaceUp().size()==0) {
			System.out.println("Please choose one of yours props to flip on : 0 or 1?");
			Scanner sc = new Scanner(System.in);
			if(sc.nextLine().equals("0")) {
				this.getArrPropinHand().get(0).setIsFaceUp(true);
				System.out.println("Yours prop is face-up: " + this.getArrPropinHand().get(0).getsNameProp());
			}else {
				this.getArrPropinHand().get(1).setIsFaceUp(true);
				System.out.println("Yours prop is face-up: " + this.getArrPropinHand().get(1).getsNameProp());
			}
		}else if(this.getPropsFaceUp().size()==1) {
			this.getArrPropinHand().get(0).setIsFaceUp(true);
			this.getArrPropinHand().get(1).setIsFaceUp(true);
			System.out.println("All of your cards are face-up");
		}else {
			System.out.println("There's no penalty for you");
		}
	}


	//sleight of hand prend la carte non distribuee dans le tableau collectionProp (la 7eme) et echange avec une des cartes
	public void sleightOfHand(Turn currentTurn) {
		
		Scanner sc = new Scanner(System.in);
		this.setPropsFace(false);
		//System.out.println(currentTurn.getMatch().getCollectionProps().size());
		System.out.println("The 7th prop is : " + currentTurn.getMatch().getCollectionProps().get(0).getsNameProp());
		
		
			System.out.println("Do you want to change the first(0)or the second(1)? : " + currentTurn.getPlayer().getsArrPropinHand());
			int iIndexProp = Integer.parseInt(sc.nextLine());
				Prop p7thProp = currentTurn.getMatch().getCollectionProps().get(0);
				Prop pPropChange = currentTurn.getPlayer().getArrPropinHand().get(iIndexProp);
				
				currentTurn.getMatch().getCollectionProps().clear();
				currentTurn.getMatch().getCollectionProps().add(pPropChange);
				
				this.getArrPropinHand().remove(iIndexProp);
				this.addArrPropinHand(p7thProp);
							

		System.out.println("The props in yours now are : " + this.getsArrPropinHand());
		System.out.println("The sleight of hand is finished.");
	
	}


	//methode pour jouer appelle choosetrick(), prepareprop(), performprop()
	public void play(Turn currentTurn) {
		this.chooseTrick(currentTurn);
		this.prepareProps(currentTurn);
		this.performProps(currentTurn);
		
	}

	

	
}
