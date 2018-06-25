package minesweeper;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame {

	private final Field[][] fields = new Field[9][9];
	private final int bombs = 10;
	private ImageIcon[] icons = new ImageIcon[12];

	private void initImages() {
		for (int i = 0; i < 9; i++) {
			icons[i] = new ImageIcon("minesweeperImages\\" + i + ".png");
		}
		icons[9] = new ImageIcon("minesweeperImages\\bomb.png");
		icons[10] = new ImageIcon("minesweeperImages\\facingDown.png");
		icons[11] = new ImageIcon("minesweeperImages\\flagged.png");
	}

	private void setBombs() {

		Random zufall = new Random();

		for (int i = 0; i < 10; i++) {
			int randomWidth = zufall.nextInt(9);
			int randomHeight = zufall.nextInt(9);

			if (fields[randomWidth][randomHeight].getBomb()) {
				i--;
			} else {
				fields[randomWidth][randomHeight].setBomb(true);
			}
		}
	}

	private void setNumbers() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int counter = 0;
				if (fields[i][j].getBomb() == false) {

					if (i != 8) {
						if (fields[i + 1][j].getBomb()) {
							counter++;
						}
					}
					if (i != 0) {
						if (fields[i - 1][j].getBomb()) {
							counter++;
						}
					}
					if (j != 8) {
						if (fields[i][j + 1].getBomb()) {
							counter++;
						}
					}
					if (j != 0) {
						if (fields[i][j - 1].getBomb()) {
							counter++;
						}
					}
					if (i != 8 && j != 8) {
						if (fields[i + 1][j + 1].getBomb()) {
							counter++;
						}
					}
					if (i != 0 && j != 0) {
						if (fields[i - 1][j - 1].getBomb()) {
							counter++;
						}
					}
					if (i != 8 && j != 0) {
						if (fields[i + 1][j - 1].getBomb()) {
							counter++;
						}
					}
					if (i != 0 && j != 8) {
						if (fields[i - 1][j + 1].getBomb()) {
							counter++;
						}
					}

					fields[i][j].setMinesAround(counter);
				}
			}
		}
	}

	private void uncover(int row, int col) {

		if (fields[row][col].getBomb()) {
			fields[row][col].setIcon(icons[9]);
			return;
		} else if (fields[row][col].getMinesAround() == 0) {

			if (row != 8) {
				if (fields[row + 1][col].getBomb() == false) {
					int mines = fields[row + 1][col].getMinesAround();
					fields[row + 1][col].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row + 1, col);
					}
				}
			}
			if (row != 0) {
				if (fields[row - 1][col].getBomb()) {
					int mines = fields[row - 1][col].getMinesAround();
					fields[row - 1][col].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row - 1, col);
					}
				}
			}
			if (col != 8) {
				if (fields[row][col + 1].getBomb()) {
					int mines = fields[row][col + 1].getMinesAround();
					fields[row][col + 1].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row, col + 1);
					}
				}
			}
			if (col != 0) {
				if (fields[row][col - 1].getBomb()) {
					int mines = fields[row][col - 1].getMinesAround();
					fields[row][col - 1].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row, col - 1);
					}
				}
			}
			if (row != 8 && col != 8) {
				if (fields[row + 1][col + 1].getBomb()) {
					int mines = fields[row + 1][col + 1].getMinesAround();
					fields[row + 1][col + 1].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row + 1, col + 1);
					}
				}
			}
			if (row != 0 && col != 0) {
				if (fields[row - 1][col - 1].getBomb()) {
					int mines = fields[row - 1][col - 1].getMinesAround();
					fields[row - 1][col - 1].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row - 1, col - 1);
					}
				}
			}
			if (row != 8 && col != 0) {
				if (fields[row + 1][col - 1].getBomb()) {
					int mines = fields[row + 1][col - 1].getMinesAround();
					fields[row + 1][col - 1].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row + 1, col - 1);
					}

				}
			}
			if (row != 0 && col != 8) {
				if (fields[row - 1][col + 1].getBomb()) {
					int mines = fields[row - 1][col + 1].getMinesAround();
					fields[row - 1][col + 1].setIcon(icons[mines]);
					if (mines == 0) {
						uncover(row - 1, col + 1);
					}

				}
			}

		}
		fields[row][col].setIcon(icons[fields[row][col].getMinesAround()]);

	}

	private void newGame() {
		ClickHandler handler = new ClickHandler();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = new Field();
				fields[i][j].addMouseListener(handler);
				add(fields[i][j]);
				fields[i][j].setIcon(icons[10]);
			}
		}
		setBombs();
		setNumbers();
	}

	public Game() {
		setTitle("minesweeper");
		setLayout(new GridLayout(9, 9));
		setSize(450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		initImages();
		newGame();

		setVisible(true);
	}

	private class ClickHandler extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (source == fields[i][j]) {
						uncover(i, j);
						return;
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
