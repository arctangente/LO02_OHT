package Card;

import java.util.ArrayList;

public class Trick {
	// Attributs Principaux
	private int idTrick;
	private String[] arrIdProps1;//La liste de composants pour faire le trick
	private String[] arrIdProps2;
	private int iPointTrick;//Le point gagnant si trick reussi
	private String sIdTrick;//Le 's' est pour le type 'String'
	private String sNameTrick;
	private Boolean isFaceUp;
	private String sPathFond;
	
	//Methode constructeur 
	public Trick(int idTrick, String sIdTrick,String sNameTrick, String [] arrIdProps1, String [] arrIdProps2, int iPointTrick, String sPathFond) {
		this.idTrick = idTrick;
		this.arrIdProps1 = arrIdProps1;
		this.arrIdProps2 = arrIdProps2;
		this.iPointTrick = iPointTrick;
		this.sIdTrick = sIdTrick;
		this.sNameTrick = sNameTrick;
		this.isFaceUp = false;
		this.sPathFond = sPathFond;
		
	}
	//Methode pour get,set les Attributes 
	public String getsPathFond() {
		return sPathFond;
	}
	public Boolean getIsFaceUp() {
		return this.isFaceUp;
	}
	public void setIsFaceUp(Boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}
	public int getIdTrick() {
		return this.idTrick;
	}
	public String getsIdTrick() {
		return this.sIdTrick;
	}
	public void setsIdTrick(String sIdTrick) {
		this.sIdTrick = sIdTrick;
	}
	public String getsNameTrick() {
		return this.sNameTrick;
	}
	public void setsNameTrick(String sNameTrick) {
		this.sNameTrick = sNameTrick;
	}
	public String[] getArrIdProps1() {
		return this.arrIdProps1;
	}
	public String[] getArrIdProps2() {
		return this.arrIdProps2;
	}
	public int getiPointTrick() {
		return this.iPointTrick;
	}

}
