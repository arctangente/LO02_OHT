package Card;

import Player.*;

public class Prop {
	123
	private int idProp;
	private String sIdProp;
	private String sNameProp;
	private Player pProperty;
	private Boolean isFaceUp;
	private String sPathFond;
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
	public Boolean getIsFaceUp() {
		return this.isFaceUp;
	}
	public void setIsFaceUp(Boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}
	public String getsIdProp() {
		return sIdProp;
	}
	public void setsIdProp(String sIdProp) {
		this.sIdProp = sIdProp;
	}
	public String getsNameProp() {
		return this.sNameProp;
	}
	public void setsNameProp(String sNameProp) {
		this.sNameProp = sNameProp;
	}
	public Player getpProperty() {
		return this.pProperty;
	}
	public void setpProperty(Player property) {
		this.pProperty = property;
	}
	public int getIdProp() {
		return idProp;
	}
	
	

}
