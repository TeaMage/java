package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

	private Color colorBlack = Color.BLACK;
	public JButton[][] buttons = new JButton[8][8];
	public Figure[] figures = new Figure[32];?
	public ButtonListener buttonListener = new ButtonListener(this);
	public String rights;
	public int[][] pawnMoves;
	// public Figure figure = figures[0].getFigure();
	// public boolean canMoveToBauer(dRow, dCol) {
	// mögliche felder von origin bis destination aufdecken, für jedes feld
	// entscheiden
	// }button figur übergeben?
	//button setzt dann sich selbst icon von der figur die es hat
	// schach: könig suchen, felder rumherum aufdecken bis figur, vojn figuren typ
	// prüfen ob schach

	public void processRightClick(int row, int col) {

	}

	public void processLeftClick(int row, int col) {
		System.out.println(row + " " + col);
	}

	public Board() {
		super("Schach!");
		setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j] = new JButton();
				if ((i + j) % 2 != 0) {
					buttons[i][j].setBackground(colorBlack);
				}
				add(buttons[i][j]);
				buttons[i][j].addMouseListener(buttonListener);
			}

		}
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Board();
	}
}
