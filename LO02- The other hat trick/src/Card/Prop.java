package Card;

import Player.*;

public class Prop {
	//Attributs principaux
	private int idProp;
	private String sIdProp;//la lettre 's' represente le type 'String' de la variable
	private String sNameProp;
	private Player pProperty;//'p' pour type 'Player'
	private Boolean isFaceUp;
	private String sPathFond;
	/*Methode constructeur de la classe*/ 
	public Prop(int idProp, String sIdProp, String sNameProp, String sPathFond) {
		this.idProp = idProp;
		this.sIdProp = sIdProp;
		this.sNameProp = sNameProp;
		this.isFaceUp = false;
		this.sPathFond = sPathFond;
				
	}

	public String getsPathFond() {
		return sPathFond;
	}

	//get et set Prop est retourne ou pas
	public Boolean getIsFaceUp() {
		return this.isFaceUp;
	}
	public void setIsFaceUp(Boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}

	//get et set pour avoir l'ID du Prop en String
	public String getsIdProp() {
		return sIdProp;
	}
	public void setsIdProp(String sIdProp) {
		this.sIdProp = sIdProp;
	}


	//get et set pour le nom du Prop
	public String getsNameProp() {
		return this.sNameProp;
	}
	public void setsNameProp(String sNameProp) {
		this.sNameProp = sNameProp;
	}

	//Methode pour avoir le joueur qui tiens le Prop
	public Player getpProperty() {
		return this.pProperty;
	}
	public void setpProperty(Player property) {
		this.pProperty = property;
	}

	//Methode pour avoir l'ID du Prop en entier
	public int getIdProp() {
		return idProp;
	}
	
	

}
