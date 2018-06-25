package minesweeper;

import java.awt.*;
import javax.swing.*;

public class Field extends JPanel {
	private int width = 50;
	private int height = 50;
	private int image;
	private ImageIcon icon;
	public void paint(Graphics g) {
		super.paint(g); 
		g.fillRect(0, 0, 50, 50);
		g.setColor(new Color(255, 0, 0));
		g.fillRect(5, 5, 40, 40);
	}
}
