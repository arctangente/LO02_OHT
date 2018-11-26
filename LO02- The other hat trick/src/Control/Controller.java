package Control;

import java.util.Observable;
import java.util.Observer;

import Game.*;
import View.MainWindow;

public class Controller{
	
	
	private Match match;
	//Methode constructeur qui produit l'objet Match actuel
	public Controller (Match currentMatch) {
		this.match = currentMatch;
		
		
	}
	//Methode pour avoir le match actuel
	public Match getMatch() {
		return match;
	}



}
