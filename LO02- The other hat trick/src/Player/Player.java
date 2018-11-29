package Player;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Scanner;

import Card.*;
import Game.*;

public  abstract class Player extends Observable {
	

	private String namePlayer;
	private int idPlayer;
	private int agePlayer;
	private Match currentMatch;
	private int pointPlayer;
	private ArrayList<Prop> arrPropinHand;
	private ArrayList<Trick> arrTricksPerformed;





	//Constructeur 

	public Player(int idPlayer, String namePlayer, int agePlayer ) {
		this.namePlayer = namePlayer;
		this.idPlayer = idPlayer;
		this.agePlayer = agePlayer;
		this.pointPlayer =0;	
		this.arrPropinHand = new ArrayList<Prop>();
		this.arrTricksPerformed = new ArrayList<Trick>();
	}


	//get et set Nameplayer 

	public String getNamePlayer() {
		return this.namePlayer;
	}
	public void setNamePlayer(String name) {
		this.namePlayer = name;
	}


	//get et set les prop dans la main du joueur


	public ArrayList<Prop> getArrPropinHand() {
		return this.arrPropinHand;
	}
	public void setArrPropinHand(int iIndex, Prop prop) {
		this.arrPropinHand.set(iIndex, prop);
	}




   

	
	//get Props toString 

	public String getsArrPropinHand() {
		String sResult="";
		for (int i=0; i<this.arrPropinHand.size();i++) {
			sResult += this.arrPropinHand.get(i).getsNameProp() +", ";
		}
		return sResult;
	}

	//get et add les Trick réalisés 
	public ArrayList<Trick> getArrTricksPerformed() {
		return this.arrTricksPerformed;
	}
	
	public void addArrTricksPerformed(Trick tricksPerformed) {
		this.arrTricksPerformed.add(tricksPerformed) ;
	}
	//Ajouter Prop 

	public void addArrPropinHand(Prop prop) {
		this.arrPropinHand.add(prop);
	}





	//get et set ID du joueur 

	public int getIdPlayer() {
		return this.idPlayer;
	}
	public void setIdPlayer(int id) {
		this.idPlayer = id;
	}



	//get et set l'âge du Joueur 

	public int getAgePlayer() {
		return this.agePlayer;
	}

	

	public void setAgePlayer(int age) {
		this.agePlayer = age;
	}



	//get et set le Match actuel 

	public Match getcurrentMatch() {
		return this.currentMatch;
	}
	public void setcurrentMatch(Match match) {
		this.currentMatch = match;
	}




	//get et set le point du joueur 

	public int getPointPlayer() {
		return this.pointPlayer;
	}
	public void addPointPlayer(int pointPlayer) {
		this.pointPlayer += pointPlayer;
	}
	

	//Methode pour montrer les parametres
    //must delete in the end

	//Test
		public String showParameter() {

			String sResult = "";
			sResult += this.namePlayer +" " + this.agePlayer +" " + this.pointPlayer +"points " +
			  this.getsArrPropinHand();
			
			return sResult;
			

	}


		//get les Props retounés 
		public ArrayList<Prop> getPropsFaceUp(){
			ArrayList<Prop> arrResult=  new ArrayList<Prop>();
			for(int i=0;i<this.arrPropinHand.size();i++) {
				if(this.arrPropinHand.get(i).getIsFaceUp()) {
					arrResult.add(this.arrPropinHand.get(i));

				}
			}
			return arrResult;
	}
		
	//performer les props verifie si les props joues correspondent aux prop necessaire pour le trick (contenus dans le array PropInTrick)
	public  void performProps(Turn currentTurn)  {
		int iCounter = 0;
		for (int i=0;i<2;i++) {
			String[] listPropInTrick = currentTurn.getTrickOnPerform().getArrIdProps();
			String sIdProp = currentTurn.getArrPairOfProp().get(i).getsIdProp();
			if(Arrays.asList(listPropInTrick).contains(sIdProp)) {
				iCounter ++;
			}
		}
		Trick trickOnPerform = currentTurn.getTrickOnPerform();
		if(iCounter ==2) {
			this.successMatch(currentTurn);
			if(trickOnPerform.getsIdTrick() == "otherRabit" ) {
				currentTurn.lastRound(true);
			}
		}
		else {
			this.forfeitMatch(currentTurn);
			if(trickOnPerform.getsIdTrick() == "otherRabit" ){
				currentTurn.lastRound(false);
			    }
		}
		
		
	}


	//si le trick est un succes appeller cette fonction

	//Quand le joueur a réussi de faire un Trick 
//>>>>>>> e89b5f6 Commentaire
	public void successMatch(Turn currentTurn) {
		System.out.println("Success");
		this.addPointPlayer(currentTurn.getTrickOnPerform().getiPointTrick());
		this.addArrTricksPerformed(currentTurn.getTrickOnPerform());
		currentTurn.getMatch().getTrickPile().remove(currentTurn.getTrickOnPerform());
		for (int i=0;i < 2;i++) {
			this.getArrPropinHand().get(i).setIsFaceUp(true);
		}
		this.sleightOfHand( currentTurn);
	}


	//rendre visible un prop en cas d'echec du trick

	//Methode pour faceup un Prop

	public void setPropsFace(Boolean isFaceUp) {
		for(int i=0;i<2;i++) {
			this.getArrPropinHand().get(i).setIsFaceUp(isFaceUp);
		}
	}
	
	public abstract void sleightOfHand(Turn currentTurn) ;
	public abstract void forfeitMatch(Turn currentTurn) ;
		
	public abstract  void play(Turn currentTurn) ;
}
