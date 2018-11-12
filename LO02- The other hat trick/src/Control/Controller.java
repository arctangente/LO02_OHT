package Control;

import java.util.Observable;
import java.util.Observer;

import Game.*;
import View.MainWindow;

public class Controller{
	
	
	private Match match;

	public Controller (Match currentMatch) {
		this.match = currentMatch;
		
		
	}

	public Match getMatch() {
		return match;
	}



}
