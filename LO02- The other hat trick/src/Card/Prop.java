package Card;

import Player.*;

public class Prop {
	//Attributes principales 
	private int idProp;
	private String sIdProp;//la lettre 's' repr�sente le type 'String' du variable 
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
	//Methode pour savoir si le Prop est retourn� ou pas
	public Boolean getIsFaceUp() {
		return this.isFaceUp;
	}
	//Methode pour d�finir la visibilit� d'un Prop 
	public void setIsFaceUp(Boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}
	//Methode pour avoir l'ID du Prop en String 
	public String getsIdProp() {
		return sIdProp;
	}
	//Methode pour d�finir l'ID du Prop en String
	
	public void setsIdProp(String sIdProp) {
		this.sIdProp = sIdProp;
	}
	//Methode pour avoir le nom du Prop 
	public String getsNameProp() {
		return this.sNameProp;
	}
	//Methode pour definir le nom du Prop 
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
