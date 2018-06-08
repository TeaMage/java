package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Board extends JFrame {

	private Color colorBlack = Color.BLACK;
	public JButton[][] buttons = new JButton[8][8];
	public Figure[] figures = new Figure[32];
	public ButtonListener buttonListener = new ButtonListener(this);
	public String rights;
	public int[][] pawnMoves;
	public int originRow;
	public int originCol;
	public int destRow;
	public int destCol;

	public void processRightClick(int row, int col) {
		originRow = row;
		originCol = col;
		int index = getFigureIndex(row, col);
		Figure figure = getFig(index);
		pawnMoves = figure.getMoves();

	}

	public Figure getFig(int index) {
		return figures[index];
	}

	public void processLeftClick(int row, int col) { 
		destRow = row;
		destCol = col;
		System.out.println(canMove());
		if (canMove()) {
			move();
		}
	}

	public Integer getFigureIndex(int row, int col) {

		for (int g = 0; g < figures.length; g++) {
			if (figures[g] != null) {
				if (figures[g].row == row && figures[g].col == col) {
					return g;
				}
			}
		}
		return null;
	}

	public boolean canMove() {
		for (int i = 0; i <= destRow; i++) {

			int row = pawnMoves[i][0];
			int col = pawnMoves[i][1];
			System.out.println(row + " " + col);
			int figureIndex = getFigureIndex(row, col);
			Figure fig = figures[figureIndex];
			if (fig.icon != null) {
				return false;
			}

		}
		return true;
	}

	public void move() {
		int index = getFigureIndex(originRow, originCol);
		figures[index].row = destRow;
		figures[index].col = destCol;

		int destIndex = getFigureIndex(destRow, destCol);

		if (figures[destIndex] != null) {
			figures[destIndex].row = null;
			figures[destIndex].col = null;
		}

	}

	public void repaint() {

		for (int i = 0; i < 32; i++) {
			if (figures[i] != null) {
				int row = figures[i].row;
				int col = figures[i].col;
				buttons[row][col].setIcon(figures[i].icon);
			}
		}
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
		Figure figure = new Figure(new ImageIcon("Images\\turmBlack.png"), "white", "bauer", 0, 4);
		Figure figure2 = new Figure(new ImageIcon("Images\\turmWhite.png"), "white", "bauer", 0, 0);
		figures[0] = figure;
		figures[1] = figure2;

		repaint();

		System.out.println(Arrays.deepToString(figures[0].getMoves()));
		System.out.println(Arrays.deepToString(figures[1].getMoves()));

	}

	public static void main(String[] args) {
		new Board();
	}
}