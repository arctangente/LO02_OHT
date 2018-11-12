package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;

import Player.EasyStategy;
import Player.PhysicalPlayer;
import Player.VirtualPlayer;
import Player.stategy;

import javax.swing.JTextField;

import Game.Match;

public class BeginWindow {

	
	
	private JFrame pricipalFrame;
	private JPanel container;
	private JSpinner spAgePlayer;
	private NumberEditor iAgePlayer;
	private ButtonGroup buttonGroup;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JTextField nomField;
	public JButton button;
	public JFrame frame1;

	public BeginWindow() {
		
		pricipalFrame = new JFrame("Parametrage");
		container = new JPanel(new GridLayout(0, 2, 5, 5));
		
		
		
		
		spAgePlayer = new JSpinner();
		iAgePlayer = new JSpinner.NumberEditor(spAgePlayer);
		spAgePlayer.setEditor(iAgePlayer);
			// Définition des limites du spinner
		iAgePlayer.getModel().setMinimum(5);
		iAgePlayer.getModel().setMaximum(80);
		iAgePlayer.getModel().setStepSize(1);
		iAgePlayer.getModel().setValue(5);
		iAgePlayer.getTextField().setEditable(true);


			buttonGroup = new ButtonGroup();
			radioButton1 = new JRadioButton("Easy");
			radioButton2 = new JRadioButton("Difficult");
			JPanel tempPanel = new JPanel();
			tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
			tempPanel.add(radioButton1);
			tempPanel.add(radioButton2);

			// ajout des boutons radio dans le groupe
			buttonGroup.add(radioButton1);
			buttonGroup.add(radioButton2);
			buttonGroup.setSelected(radioButton1.getModel(), true);

			nomField = new JTextField("Player");

			this.button = new JButton("Start Game!");
			
			container.add(new JLabel("Please enter your name"));
			container.add(nomField);
			container.add(new JLabel("Veuillez enter your age"));
			container.add(spAgePlayer);
			container.add(new JLabel("Please choice the niveau"));
			container.add(tempPanel);
			
			container.add(new JLabel());
			container.add(button);

			pricipalFrame.setContentPane(container);
			pricipalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pricipalFrame.pack();
			// frame.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);
			this.frame1=pricipalFrame;
			this.frame1.setVisible(true);
		}

		public static void main(String[] args) {
			BeginWindow view = new BeginWindow();
		}
		
		public PhysicalPlayer getPhysicalPlayer() {
			PhysicalPlayer player1 = null;
			int iAge = 5, idStrategie = 0;

			
			if (spAgePlayer.getValue() instanceof Integer) {
				iAge = (Integer) spAgePlayer.getValue();
			}
			
			 player1 = new PhysicalPlayer(0, nomField.getText(), iAge);
			
			
			return player1;
			
		}
		public void closeWindow() {
			this.frame1.dispose();
		}
		
	}
	
	

