package myChess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Board extends JFrame {
	private boolean player = true;
	private Field[][] fields = new Field[8][8];
	private Figure[] figures = new Figure[32];

	private void newGame() {
		ClickHandler handler = new ClickHandler();
		int k = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				fields[i][j] = new Field(i, j);
				if ((i + j) % 2 != 0) {
					fields[i][j].setBackground(Color.GRAY);
				}

				if (i < 2) {
					figures[k] = new Pawn(i, j);
					
					fields[i][j].setIcon(figures[k].getIcon());
					k++;
				}

				add(fields[i][j]);
				fields[i][j].addMouseListener(handler);

			}
		}
	}

	public Board() {

		setLayout(new GridLayout(8, 8));
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame();
		setVisible(true);
	}

	private class ClickHandler extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			Field source = (Field) e.getSource();
			// rechtsklick
			if (e.getButton() == MouseEvent.BUTTON3) {
				System.out.println("moin");
			}
			// linksclick
			else {

				System.out.println(source.getRow());
				System.out.println(source.getCol());

			}
		}

	}

	public static void main(String[] args) {
		new Board();
	}
}
