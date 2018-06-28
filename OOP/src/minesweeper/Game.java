package minesweeper;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame {

	private Field[][] fields = new Field[9][9];
	private ImageIcon[] icons = new ImageIcon[12];
	long tStart = 0;

	private void setTimer() {
		tStart = System.currentTimeMillis();
	}

	private void cancelTimer() {
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		System.out.println(elapsedSeconds);
	}

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
			int row = zufall.nextInt(9);
			int col = zufall.nextInt(9);

			if (fields[row][col].hasBomb()) {
				i--;
			} else {
				fields[row][col].setBomb();
			}
		}
	}

	private void setNumbers() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int counter = 0;
				if (fields[i][j].hasBomb() == false) {

					if (i != 8) {
						if (fields[i + 1][j].hasBomb()) {
							counter++;
						}
					}
					if (i != 0) {
						if (fields[i - 1][j].hasBomb()) {
							counter++;
						}
					}
					if (j != 8) {
						if (fields[i][j + 1].hasBomb()) {
							counter++;
						}
					}
					if (j != 0) {
						if (fields[i][j - 1].hasBomb()) {
							counter++;
						}
					}
					if (i != 8 && j != 8) {
						if (fields[i + 1][j + 1].hasBomb()) {
							counter++;
						}
					}
					if (i != 0 && j != 0) {
						if (fields[i - 1][j - 1].hasBomb()) {
							counter++;
						}
					}
					if (i != 8 && j != 0) {
						if (fields[i + 1][j - 1].hasBomb()) {
							counter++;
						}
					}
					if (i != 0 && j != 8) {
						if (fields[i - 1][j + 1].hasBomb()) {
							counter++;
						}
					}

					fields[i][j].setMinesAround(counter);
				}
			}
		}
	}

	private void uncoverAroundCell(int row, int col) {
		if (row != 8) {
			if (fields[row + 1][col].isHidden()) {
				uncover(row + 1, col);
			}
		}
		if (row != 0) {
			if (fields[row - 1][col].isHidden()) {
				uncover(row - 1, col);
			}
		}
		if (col != 8) {
			if (fields[row][col + 1].isHidden()) {
				uncover(row, col + 1);
			}
		}
		if (col != 0) {
			if (fields[row][col - 1].isHidden()) {
				uncover(row, col - 1);
			}
		}
		if (row != 8 && col != 8) {
			if (fields[row + 1][col + 1].isHidden()) {
				uncover(row + 1, col + 1);
			}
		}
		if (row != 0 && col != 0) {
			if (fields[row - 1][col - 1].isHidden()) {
				uncover(row - 1, col - 1);
			}
		}
		if (row != 8 && col != 0) {
			if (fields[row + 1][col - 1].isHidden()) {
				uncover(row + 1, col - 1);
			}
		}
		if (row != 0 && col != 8) {
			if (fields[row - 1][col + 1].isHidden()) {
				uncover(row - 1, col + 1);
			}
		}
	}

	private void uncover(int row, int col) {
		Field field = fields[row][col];
		if (field.hasBomb()) {

			System.exit(0);
		} else {
			int mines = field.getMinesAround();
			field.setIcon(icons[mines]);
			field.unhide();
			if (mines == 0) {
				uncoverAroundCell(row, col);
			}
		}

	}

	private void checkWin() {
		int counter = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (fields[i][j].isFlagged() && fields[i][j].hasBomb()) {
					counter++;
				}
			}
		}
		if (counter == 10) {
			System.out.println("won");
			cancelTimer();
		}
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
		initImages();
		newGame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class ClickHandler extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			Field field = null;
			int row = 0;
			int col = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (source == fields[i][j]) {
						row = i;
						col = j;
						field = fields[row][col];
					}
				}
			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				if (field.isHidden()) {
					if (field.isFlagged()) {
						field.unflag();
						field.setIcon(icons[10]);
					} else {
						field.flag();
						field.setIcon(icons[11]);
					}
				}

			} else {
				if (tStart == 0) {
					setTimer();
				}
				if (field.isFlagged()) {
					return;
				} else {
					uncover(row, col);
				}
			}
			checkWin();
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
