package View;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Card.*;
import Control.*;

public class TrickGraphic extends JPanel {
	private Controller controller;
	private Trick card;
	private String pathFond;

	public TrickGraphic (Trick t,Controller ctrl) {
		this.controller =ctrl;
		this.card = t;
		
		pathFond = this.card.getsPathFond();
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(pathFond));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Image background = img.getScaledInstance(120, 200, Image.SCALE_SMOOTH);
		
		Dimension cardDimension = new Dimension(120, 200);
		this.setMinimumSize(cardDimension);
		this.setMaximumSize(cardDimension);
		this.setPreferredSize(cardDimension);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
	}
}
