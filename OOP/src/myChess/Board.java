package myChess;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board extends JFrame {
	private boolean player = true;
	private JButton[][] fields = new JButton[8][8];
	private static Figure[] figures = new Figure[32];
	private Figure selectedFigure;

	private void newGame() {
		ClickHandler handler = new ClickHandler();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				fields[i][j] = new JButton();
				if ((i + j) % 2 != 0) {
					fields[i][j].setBackground(Color.GRAY);
				}
				add(fields[i][j]);
				fields[i][j].addMouseListener(handler);
			}
		}
		setFigures();
		paint();
	}

	private void paint() {
		for (int i = 0; i < 32; i++) {
			if (figures[i] != null) {
				fields[figures[i].getRow()][figures[i].getCol()].setIcon(figures[i].getIcon());
			}
		}
	}

	private void setFigures() {
		int counter = 0;
		for (int i = 1; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				figures[counter] = new Pawn(i, j, false, new ImageIcon("chessImages\\pB.png"));
				counter++;
			}
		}
		for (int i = 6; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				figures[counter] = new Pawn(i, j, true, new ImageIcon("chessImages\\pW.png"));
				counter++;
			}
		}
		figures[counter] = new Rook(0, 0, false, new ImageIcon("chessImages\\rB.png"));
		counter++;
		figures[counter] = new Rook(0, 7, false, new ImageIcon("chessImages\\rB.png"));
		counter++;
		figures[counter] = new Rook(7, 0, true, new ImageIcon("chessImages\\rW.png"));
		counter++;
		figures[counter] = new Rook(7, 7, true, new ImageIcon("chessImages\\rW.png"));
		counter++;

		figures[counter] = new Bishop(0, 2, false, new ImageIcon("chessImages\\bB.png"));
		counter++;
		figures[counter] = new Bishop(0, 5, false, new ImageIcon("chessImages\\bB.png"));
		counter++;
		figures[counter] = new Bishop(7, 2, true, new ImageIcon("chessImages\\bW.png"));
		counter++;
		figures[counter] = new Bishop(7, 5, true, new ImageIcon("chessImages\\bW.png"));
		counter++;

		figures[counter] = new Knight(0, 1, false, new ImageIcon("chessImages\\knB.png"));
		counter++;
		figures[counter] = new Knight(0, 6, false, new ImageIcon("chessImages\\knB.png"));
		counter++;
		figures[counter] = new Knight(7, 1, true, new ImageIcon("chessImages\\knW.png"));
		counter++;
		figures[counter] = new Knight(7, 6, true, new ImageIcon("chessImages\\knW.png"));
		counter++;

		figures[counter] = new Queen(0, 3, false, new ImageIcon("chessImages\\qB.png"));
		counter++;
		figures[counter] = new Queen(7, 3, true, new ImageIcon("chessImages\\qW.png"));
		counter++;

		figures[counter] = new King(0, 4, false, new ImageIcon("chessImages\\kB.png"));
		counter++;
		figures[counter] = new King(7, 4, true, new ImageIcon("chessImages\\kW.png"));
		counter++;
	}

	private void processLeftClick(int row, int col) {
		if (selectedFigure != null) {
			if (selectedFigure.moves[row][col] == true) {
				moveTo(row, col);
			}
		}
		return;

	}

	private void processRightClick(int row, int col) {

		if (getFigureByPosition(row, col) != null) {
			if (player == getFigureByPosition(row, col).player) {
				getFigureByPosition(row, col).fillMoves();
				selectedFigure = getFigureByPosition(row, col);
			}
		}
		return;
	}

	private Integer getFigureIndex(int row, int col) {
		for (int i = 0; i < 32; i++) {
			if (figures[i].row == row && figures[i].col == col) {
				return i;
			}
		}
		return null;
	}

	private void moveTo(int row, int col) {
		if (getFigureByPosition(row, col) != null) {
			figures[getFigureIndex(row, col)] = null;
		}
		selectedFigure.setRow(row);
		selectedFigure.setCol(col);
		if (player) {
			player = false;
		} else {
			player = true;
		}
		fields[selectedFigure.row][selectedFigure.col].setIcon(null);
		selectedFigure = null;
		paint();
	}

	public static Figure getFigureByPosition(int row, int col) {
		for (int i = 0; i < 32; i++) {
			if (figures[i].getRow() == row && figures[i].getCol() == col) {
				return figures[i];
			}
		}
		return null;
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
			Object source = e.getSource();
			int row = 0;
			int col = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (fields[i][j] == source) {
						row = i;
						col = j;
					}
				}
			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				processRightClick(row, col);

			}

			else {
				processLeftClick(row, col);

			}
		}

	}

	public static void main(String[] args) {
		new Board();
	}
}
