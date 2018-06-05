package myChess;

import java.awt.*;

import javax.swing.*;

public class Board extends JFrame {
	private Container contents;
	public Figure[][] figures = new Figure[8][8];
	private Color colorBlack = Color.BLACK;
	ImageIcon icon = new ImageIcon("Images\\bauerWhite.png");

	public Board() {
		super("Schach!");

		contents = getContentPane();
		contents.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				figures[i][j] = new Figure();
				if ((i + j) % 2 != 0) {
					figures[i][j].setBackground(colorBlack);
				}
				contents.add(figures[i][j]);
				ButtonHandler buttonHandler = new ButtonHandler(this);
				figures[i][j].addMouseListener(buttonHandler);
				
				
			}
		}
		figures[0][0].setIcon(icon);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Board();
	}
}