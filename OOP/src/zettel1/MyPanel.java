package zettel1;

import java.awt.Color;

import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(255, 0, 0));
		g.fillRect((this.getWidth() / 2) - this.getWidth() / 6,
				this.getHeight() / 2 - this.getHeight() / 6,
				this.getWidth() / 3, this.getHeight() / 3);

	}
}
