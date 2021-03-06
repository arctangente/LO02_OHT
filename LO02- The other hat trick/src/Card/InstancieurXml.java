package Card;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//Cette class a pour but de generer les cartes par un fichier Cards.xml
public class InstancieurXml {

	private DocumentBuilderFactory dbf ;
	private DocumentBuilder builder;
	private Document document;
	private Element root;
	private HashSet<Prop> setProps;
	private HashSet<Trick> setTricks;
	private ArrayList<Prop> arrProps;
	private ArrayList<Trick> arrTricks;
	
	public InstancieurXml() {
		this.dbf =  DocumentBuilderFactory.newInstance();
	
		try {
			builder = dbf.newDocumentBuilder();
			document = builder.parse(new File("Cards.xml"));
			// System.out.println(document.getXmlVersion());

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.root = document.getDocumentElement();
		this.generateCard(0);
	}
	
	//
	private void generateCard(int iDebugLevel) {
		setProps = new HashSet<Prop>();
		setTricks = new HashSet<Trick>();
		NodeList list = this.root.getChildNodes();
		// NodeList n'as pas d'iterateur donc on y va a l'ancienne...
		int counterProp = 0;
		int counterTrick = 0;
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeName().equals("prop")) {
				Element elementList = (Element) list.item(i);
				String sIdProp = elementList.getAttribute("template");
				String sNameProp = elementList.getTextContent();
				String sPathFond = elementList.getAttribute("pathImage");
				setProps.add(new Prop(counterProp+1,sIdProp , sNameProp,sPathFond));
				counterProp++;
			}
			else if(list.item(i).getNodeName().equals("trick")) {
				Element elementList = (Element) list.item(i);
				String sIdTrick = elementList.getAttribute("template");
				String sNameTrick = elementList.getTextContent();
				String[] arrSidProps1 = elementList.getAttribute("props1").split(",");
				String[] arrSidProps2 = elementList.getAttribute("props2").split(",");
				String sPointTrick = elementList.getAttribute("point");
				int iPointTrick = Integer.parseInt(sPointTrick);
				String sPathFond = elementList.getAttribute("pathImage");
				setTricks.add(new Trick(counterTrick, sIdTrick, sNameTrick, arrSidProps1, arrSidProps2, iPointTrick,sPathFond));
				counterTrick++;
			}
		}
		
		this.arrProps = new ArrayList<Prop>(this.setProps);
		Collections.shuffle(this.arrProps);
		this.arrTricks = new ArrayList<Trick>(this.setTricks);
		Collections.shuffle(this.arrTricks);
		String[] arrSidProps1 = {"hat"};
		String[] arrSidProps2 = {"otherRabbit"};
		Trick TheotherhatTrick = new Trick(counterTrick,"otherHat","The other Hat Trick",arrSidProps1,arrSidProps2,6,"image/OtherHat.png");
		this.arrTricks.add(this.arrTricks.size(),TheotherhatTrick);
	}
	
	public ArrayList<Prop> getListProps() {
		
			if (this.arrProps == null) {
				this.generateCard(0);
			}
			return this.arrProps;
		
	}
	
	public ArrayList<Trick> getListTricks() {
		
		if (this.arrTricks == null) {
			this.generateCard(0);
		}
		return this.arrTricks;
	
}



	public String toString() {
		String sResult=" Props :";
		for( int i=0; i < this.arrProps.size();i++) {
			sResult += this.arrProps.get(i).getsIdProp() +", ";
		}
		sResult += "\n Tricks:";
		for( int i=0; i <this.arrTricks.size();i++) {
			sResult += this.arrTricks.get(i).getsIdTrick() +", ";
		}
		return sResult;
	}
	
	
}
