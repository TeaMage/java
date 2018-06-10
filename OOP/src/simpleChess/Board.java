package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Board extends JFrame {

	private Color colorBlack = Color.GRAY;
	public JButton[][] buttons = new JButton[8][8];
	public Figure[] figures = new Figure[32];
	public ButtonListener buttonListener = new ButtonListener(this);
	public String rights = "white";
	public int originRow;
	public int originCol;
	public int destRow;
	public int destCol;
	public int[][] moves = new int[14][2];
	public Figure selectedFigure;

	public void processRightClick(int row, int col) {
		originRow = row;
		originCol = col;
		int index = getFigureIndex(row, col);
		selectedFigure = getFig(index);
		buttons[row][col].setBackground(Color.GREEN);
		canMoveTo();

		System.out.println(Arrays.deepToString(moves));
	}

	public void uncover() {

	}

	public Figure getFig(int index) {
		return figures[index];
	}

	public int[][] verticalMoves = new int[8][2];

	public boolean isInMoveSet(int row, int col) {

		for (int i = 0; i < moves.length; i++) {
			if (moves[i][0] == row && moves[i][1] == col) {
				return true;
			}
		}
		return false;
	}

	public String getOtherColor() {
		if (rights.equals("black")) {
			return "white";
		} else {
			return "black";
		}
	}

	public void canMoveTo() {

		int x = 0;
		for (int i = originRow - 1; i >= 0; i--) {

			if (selectedFigure.isValidMove(i, originCol)) {

				if (buttons[i][originCol].getIcon() == null) {
					moves[x][0] = i;
					moves[x][1] = originCol;
					x++;
					buttons[i][originCol].setBackground(Color.GREEN);
				} else {
					if (figures[getFigureIndex(i, originCol)].player.equals(getOtherColor())) {
						moves[x][0] = i;
						moves[x][1] = originCol;
						buttons[i][originCol].setBackground(Color.GREEN);
					}
					break;

				}
			}

		}
	}

	public int[][] getMoves() {

		int x = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				if (selectedFigure.isValidMove(i, j)) {

					moves[x][0] = i;
					moves[x][1] = j;
					buttons[i][j].setBackground(Color.GREEN);
					x++;
					if (x == 14) {
						return moves;
					}

				}
			}
		}
		return moves;
	}

	public void processLeftClick(int row, int col) {
		destRow = row;
		destCol = col;
		if (isInMoveSet(destRow, destCol)) {
			move();
			repaint();
		}
		rights = getOtherColor();

	}

	public Integer getFigureIndex(int row, int col) {

		for (int g = 0; g < figures.length; g++) {
			if (figures[g].row != null) {
				if (figures[g].row == row && figures[g].col == col) {
					return g;
				}

			}
		}
		return null;
	}

	public int[][] possibleMoves() {
		int x = 0;
		int[][] moves = new int[20][2];
		for (int i = 0; i < moves.length; i++) {
			int row = moves[i][0];
			int col = moves[i][1];

			int index = getFigureIndex(row, col);

			Figure fig = figures[index];
			if (fig.icon != null) {
				moves[x][0] = row;
				moves[x][1] = col;
				x++;
			}

		}
		return moves;
	}

	public void move() {
		if (getFigureIndex(destRow, destCol) != null) {
			int x = getFigureIndex(destRow, destCol);
			figures[x].icon = null;
			figures[x].row = null;
			figures[x].col = null;
			figures[x].type = null;
			figures[x].player = null;
		}

		int index = getFigureIndex(originRow, originCol);
		figures[index].row = destRow;
		figures[index].col = destCol;

	}

	public void newGame() {
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
	}

	public void repaint() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Integer figindex = getFigureIndex(i, j);
				if (figindex != null) {
					buttons[i][j].setIcon(figures[figindex].icon);
				} else {
					buttons[i][j].setIcon(null);
				}
				if (buttons[i][j].getBackground().equals(Color.GREEN)) {

					if (i < 1) {

						if (buttons[i + 1][j].getBackground().equals(Color.GRAY)) {
							buttons[i][j].setBackground(Color.WHITE);
						} else {
							buttons[i][j].setBackground(Color.GRAY);
						}
					} else if (i <= 7) {
						if (buttons[i - 1][j].getBackground().equals(Color.GRAY)) {
							buttons[i][j].setBackground(Color.WHITE);
						} else {
							buttons[i][j].setBackground(Color.GRAY);
						}
					}
				}
			}
		}
	}

	private void fillFigures() {
		int x = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				Figure fig = new Figure(new ImageIcon("Images\\turmBlack.png"), "black", "bauer", i, j);
				figures[x] = fig;
				x++;
			}
		}
		int y = 16;
		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Figure fig = new Figure(new ImageIcon("Images\\turmWhite.png"), "white", "bauer", i, j);
				figures[y] = fig;
				y++;
			}
		}

	}

	public Board() {
		super("Schach!");
		setLayout(new GridLayout(8, 8));
		newGame();
		fillFigures();

		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		repaint();
	}

	public static void main(String[] args) {
		new Board();
	}
}