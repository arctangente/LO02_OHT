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
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git


    //constructeur
=======
	//Constructeur 
>>>>>>> e89b5f6 Commentaire
	public Player(int idPlayer, String namePlayer, int agePlayer ) {
		this.namePlayer = namePlayer;
		this.idPlayer = idPlayer;
		this.agePlayer = agePlayer;
		this.pointPlayer =0;	
		this.arrPropinHand = new ArrayList<Prop>();
		this.arrTricksPerformed = new ArrayList<Trick>();
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git
    //get et set namePlayer
=======
	//get et set Nameplayer 
>>>>>>> e89b5f6 Commentaire
	public String getNamePlayer() {
		return this.namePlayer;
	}
	public void setNamePlayer(String name) {
		this.namePlayer = name;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//get et set les prop dans la main du joueur
=======
	//get et set les Props dans du joueur 
>>>>>>> e89b5f6 Commentaire
	public ArrayList<Prop> getArrPropinHand() {
		return this.arrPropinHand;
	}
	public void setArrPropinHand(int iIndex, Prop prop) {
		this.arrPropinHand.set(iIndex, prop);
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//get et add les tricks qui ont Ã©tÃ© faits dans un arraylist
	public ArrayList<Trick> getArrTricksPerformed() {
		return this.arrTricksPerformed;
	}
	public void addArrTricksPerformed(Trick tricksPerformed) {
		this.arrTricksPerformed.add(tricksPerformed) ;
	}

    //get et add les prop dans la main
=======
	
	//get Props toString 
>>>>>>> e89b5f6 Commentaire
	public String getsArrPropinHand() {
		String sResult="";
		for (int i=0; i<this.arrPropinHand.size();i++) {
			sResult += this.arrPropinHand.get(i).getsNameProp() +", ";
		}
		return sResult;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git
=======

	//get et add les Trick réalisés 
	public ArrayList<Trick> getArrTricksPerformed() {
		return this.arrTricksPerformed;
	}
	
	public void addArrTricksPerformed(Trick tricksPerformed) {
		this.arrTricksPerformed.add(tricksPerformed) ;
	}
	//Ajouter Prop 
>>>>>>> e89b5f6 Commentaire
	public void addArrPropinHand(Prop prop) {
		this.arrPropinHand.add(prop);
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git


	//get et set idPlayer
=======
	//get et set ID du joueur 
>>>>>>> e89b5f6 Commentaire
	public int getIdPlayer() {
		return this.idPlayer;
	}
	public void setIdPlayer(int id) {
		this.idPlayer = id;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//get et set age
=======
	//get et set l'âge du Joueur 
>>>>>>> e89b5f6 Commentaire
	public int getAgePlayer() {
		return this.agePlayer;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git
=======
	
>>>>>>> e89b5f6 Commentaire
	public void setAgePlayer(int age) {
		this.agePlayer = age;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//get et set current match
=======
	//get et set le Match actuel 
>>>>>>> e89b5f6 Commentaire
	public Match getcurrentMatch() {
		return this.currentMatch;
	}
	public void setcurrentMatch(Match match) {
		this.currentMatch = match;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//get et set point du player
=======
	//get et set le point du joueur 
>>>>>>> e89b5f6 Commentaire
	public int getPointPlayer() {
		return this.pointPlayer;
	}
	public void addPointPlayer(int pointPlayer) {
		this.pointPlayer += pointPlayer;
	}
	
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git
	//Methode pour montrer les parametres
    //must delete in the end
    public String showParameter() {
=======
	//Test
		public String showParameter() {
>>>>>>> e89b5f6 Commentaire
			String sResult = "";
			sResult += this.namePlayer +" " + this.agePlayer +" " + this.pointPlayer +"points " +
			  this.getsArrPropinHand();
			
			return sResult;
			
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git
	}

	//instancier nouvelle arraylist contenant les props face up du player
	public ArrayList<Prop> getPropsFaceUp(){
	    ArrayList<Prop> arrResult=  new ArrayList<Prop>();
	    for(int i=0;i<this.arrPropinHand.size();i++) {
	        if(this.arrPropinHand.get(i).getIsFaceUp()) {
	            arrResult.add(this.arrPropinHand.get(i));
=======
		}
		//get les Props retounés 
		public ArrayList<Prop> getPropsFaceUp(){
			ArrayList<Prop> arrResult=  new ArrayList<Prop>();
			for(int i=0;i<this.arrPropinHand.size();i++) {
				if(this.arrPropinHand.get(i).getIsFaceUp()) {
					arrResult.add(this.arrPropinHand.get(i));
>>>>>>> e89b5f6 Commentaire
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
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//si le trick est un succes appeller cette fonction
=======
	//Quand le joueur a réussi de faire un Trick 
>>>>>>> e89b5f6 Commentaire
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
<<<<<<< Upstream, based on branch 'master' of https://github.com/arctangente/LO02_OHT.git

	//rendre visible un prop en cas d'echec du trick
=======
	//Methode pour faceup un Prop
>>>>>>> e89b5f6 Commentaire
	public void setPropsFace(Boolean isFaceUp) {
		for(int i=0;i<2;i++) {
			this.getArrPropinHand().get(i).setIsFaceUp(isFaceUp);
		}
	}
	
	public abstract void sleightOfHand(Turn currentTurn) ;
	public abstract void forfeitMatch(Turn currentTurn) ;
		
	public abstract  void play(Turn currentTurn) ;
}
