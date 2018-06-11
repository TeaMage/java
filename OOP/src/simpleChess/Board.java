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
	public Integer originRow;
	public Integer originCol;
	public Integer destRow;
	public Integer destCol;
	public Integer[][] moves = new Integer[100][2];
	public Integer[][] variable = new Integer[100][2];
	public Integer[][] possibleMoves = new Integer[100][2];
	public Figure selectedFigure;
	public Figure[] figuresByColor = new Figure[16];
	public Integer kingRow;
	public Integer kingCol;
	public Integer[][] threatenedFields = new Integer[100][2];
	public boolean check = false;

	public void getMoves(String color) {
		int x = 0;
		for (int i = 0; i < 32; i++) {
			if (figures[i] != null) {
				if (figures[i].player.equals(color)) {
					selectedFigure = figures[i];
					originRow = figures[i].row;
					originCol = figures[i].col;

					canMoveTo(x);
					x++;
				}
			}
		}
		for (int j = 0; j < possibleMoves.length; j++) {
			possibleMoves[j][0] = moves[j][0];
			possibleMoves[j][1] = moves[j][1];
			if (moves[j][1] != null) {
				buttons[moves[j][0]][moves[j][1]].setBackground(Color.GREEN);
			}
		}
	}

	public void checkCheckMate() {

		for (int i = 0; i < threatenedFields.length; i++) {
			if (threatenedFields[i][0] != null) {
				int threatenedRow = threatenedFields[i][0];
				int threatenedCol = threatenedFields[i][1];
				for (int g = 0; g < moves.length; g++) {
					if (moves[g][0] != null) {
						int moveRow = moves[g][0];
						int moveCol = moves[g][1];
						if (threatenedRow == moveRow && threatenedCol == moveCol) {
							moves[g][0] = null;
							moves[g][1] = null;
						}
					}
				}
			}
		}
	}

	public void emptyPossibleMoves() {
		for (int i = 0; i < 100; i++) {
			possibleMoves[i][0] = null;
			possibleMoves[i][1] = null;
		}
	}

	public boolean hasMoves() {
		for (int i = 0; i < moves.length; i++) {
			if (moves[i][0] != null) {
				return true;
			}
		}
		return false;
	}

	public void getAllMoves() {
		/*
		 * for (int k = 0; k < moves.length; k++) { moves[k][0] = null; moves[k][1] =
		 * null; } int x = 0; for (int i = 0; i < figuresByColor.length; i++) {
		 * 
		 * if (figuresByColor[i] != null) { originRow = figuresByColor[i].row; originCol
		 * = figuresByColor[i].col; selectedFigure = figuresByColor[i]; canMoveTo(); for
		 * (int j = 0; j < moves.length && moves[j][0] != null; j++) {
		 * 
		 * threatenedFields[x][0] = moves[j][0]; threatenedFields[x][1] = moves[j][1];
		 * x++;
		 * 
		 * } for (int k = 0; k < moves.length; k++) { moves[k][0] = null; moves[k][1] =
		 * null; }
		 * 
		 * } }
		 */
	}

	public void getFiguresByPlayer() {
		int x = 0;
		for (int g = 0; g < figures.length; g++) {
			if (figures[g] != null) {
				if (figures[g].player.equals(rights)) {
					figuresByColor[x] = figures[g];
					x++;
				}
			}
		}
	}

	public void getKing(String color) {
		for (int i = 0; i < figures.length; i++) {
			if (figures[i] != null) {
				if (figures[i] instanceof König && figures[i].player.equals(color)) {
					kingRow = figures[i].row;
					kingCol = figures[i].col;
				}
			}
		}
	}

	public void processRightClick(int row, int col) {

		if (check) {
			getKing(rights);
			if (row == kingRow && col == kingCol) {
				originRow = row;
				originCol = col;
				if (figures[getFigureIndex(row, col)].player.equals(rights)) {
					int index = getFigureIndex(row, col);
					selectedFigure = getFig(index);
					originRow = row;
					originCol = col;
				}
			} else {
				originRow = null;
			}
		} else {
			if (figures[getFigureIndex(row, col)].player.equals(rights)) {
				int index = getFigureIndex(row, col);
				selectedFigure = getFig(index);
				originRow = row;
				originCol = col;

				emptyPossibleMoves();
				getMoves(rights);
				selectedFigure = getFig(index);
				originRow = row;
				originCol = col;

				buttons[row][col].setBackground(Color.GREEN);
				System.out.println(Arrays.deepToString(possibleMoves));
			}
		}

	}

	/*
	 * if (row == kingRow && col == kingCol) {
	 * 
	 * selectedFigure = figures[getFigureIndex(row, col)]; originRow = row;
	 * originCol = col; canMoveTo(); checkCheckMate(); if (hasMoves()) { check =
	 * false; emptyThreats(); } else { System.out.println("lost"); }
	 * 
	 * } } }else{selectedFigure=null;}}
	 */

	public Figure getFig(int index) {
		return figures[index];
	}

	public boolean isInMoveSet(int row, int col) {
		for (int i = 0; i < moves.length; i++) {
			if (possibleMoves[i][0] != null) {
				if (possibleMoves[i][0] == row && possibleMoves[i][1] == col) {
					return true;
				}
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

	public void canMoveTo(int x) {

		if ((selectedFigure instanceof Springer) == false && selectedFigure instanceof Bauer == false) {

			for (int i = originRow; i < 8; i++) {

				if (selectedFigure.isValidMove(i, originCol)) {

					if (getFigureIndex(i, originCol) == null) {
						moves[x][0] = i;
						moves[x][1] = originCol;
						x++;
					} else {
						if (selectedFigure.player.equals(figures[getFigureIndex(i, originCol)].player)) {
							break;
						} else {
							moves[x][0] = i;
							moves[x][1] = originCol;
							x++;
							break;
						}

					}
				} else if (i != originRow) {
					break;
				}

			}
			for (int i = originRow; i >= 0; i--) {

				if (selectedFigure.isValidMove(i, originCol)) {

					if (getFigureIndex(i, originCol) == null) {
						moves[x][0] = i;
						moves[x][1] = originCol;
						x++;
					} else {
						if (selectedFigure.player.equals(figures[getFigureIndex(i, originCol)].player)) {
							break;
						} else {
							moves[x][0] = i;
							moves[x][1] = originCol;
							x++;
							break;
						}

					}
				} else if (i != originRow) {
					break;
				}
			}

			for (int i = originCol; i < 8; i++) {

				if (selectedFigure.isValidMove(originRow, i)) {

					if (getFigureIndex(originRow, i) == null) {
						moves[x][0] = originRow;
						moves[x][1] = i;
						x++;
					} else {
						if (rights.equals(figures[getFigureIndex(originRow, i)].player) == false) {
							moves[x][0] = originRow;
							moves[x][1] = i;
							x++;
							break;
						}
						break;

					}
				} else if (i != originCol) {
					break;
				}

			}
			for (int i = originCol; i >= 0; i--) {

				if (selectedFigure.isValidMove(originRow, i)) {

					if (getFigureIndex(originRow, i) == null) {
						moves[x][0] = originRow;
						moves[x][1] = i;
						x++;
					} else {
						if (rights.equals(figures[getFigureIndex(originRow, i)].player) == false) {
							moves[x][0] = originRow;
							moves[x][1] = i;
							x++;
							break;
						}
						break;

					}
				} else if (i != originCol) {
					break;
				}
			}
			int j = originCol;
			for (int i = originRow; i < 8 && j < 8; i++) {

				if (selectedFigure.isValidMove(i, j)) {

					if (getFigureIndex(i, j) == null) {
						moves[x][0] = i;
						moves[x][1] = j;
						x++;
					} else {
						if (selectedFigure.player.equals(figures[getFigureIndex(i, j)].player)) {
							break;
						} else {
							moves[x][0] = i;
							moves[x][1] = j;
							x++;
							break;
						}

					}
				} else if (i != originRow && j != originCol) {
					break;
				}
				j++;
			}
			int k = originCol;
			for (int i = originRow; i >= 0 && k >= 0; i--) {

				if (selectedFigure.isValidMove(i, k)) {

					if (getFigureIndex(i, k) == null) {
						moves[x][0] = i;
						moves[x][1] = k;
						x++;
					} else {
						if (selectedFigure.player.equals(figures[getFigureIndex(i, k)].player)) {
							break;
						} else {
							moves[x][0] = i;
							moves[x][1] = k;
							x++;
							break;
						}

					}
				} else if (i != originRow && k != originCol) {
					break;
				}
				k--;
			}
			int f = originCol;
			for (int i = originRow; i < 8 && f >= 0; i++) {

				if (selectedFigure.isValidMove(i, f)) {

					if (getFigureIndex(i, f) == null) {
						moves[x][0] = i;
						moves[x][1] = f;
						x++;
					} else {
						if (selectedFigure.player.equals(figures[getFigureIndex(i, f)].player)) {
							break;
						} else {
							moves[x][0] = i;
							moves[x][1] = f;
							x++;
							break;
						}

					}
				} else if (i != originRow && f != originCol) {
					break;
				}
				f--;
			}
			int m = originCol;
			for (int i = originRow; i >= 0 && m < 8; i--) {

				if (selectedFigure.isValidMove(i, m)) {

					if (getFigureIndex(i, m) == null) {
						moves[x][0] = i;
						moves[x][1] = m;
						x++;
					} else {
						if (selectedFigure.player.equals(figures[getFigureIndex(i, m)].player)) {
							break;
						} else {
							moves[x][0] = i;
							moves[x][1] = f;
							x++;
							break;
						}

					}
				} else if (i != originRow && m != originCol) {
					break;
				}
				m++;
			}
		} else if (selectedFigure instanceof Springer) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (selectedFigure.isValidMove(i, j)) {
						if (getFigureIndex(i, j) == null) {
							moves[x][0] = i;
							moves[x][1] = j;
							x++;
						} else {
							if (selectedFigure.player.equals(figures[getFigureIndex(i, j)].player)) {

							} else {
								moves[x][0] = i;
								moves[x][1] = j;
								x++;

							}
						}
					}

				}

			}
		} else {
			if (selectedFigure.player.equals("black")) {
				if (selectedFigure.isValidMove(originRow + 1, originCol)) {
					if (getFigureIndex(originRow + 1, originCol) == null) {
						moves[x][0] = originRow + 1;
						moves[x][1] = originCol;
						x++;
					}
				}
				if (selectedFigure.isValidMove(originRow + 1, originCol + 1)) {
					if (getFigureIndex(originRow + 1, originCol + 1) == null) {

					} else {
						if (selectedFigure.player
								.equals(figures[getFigureIndex(originRow + 1, originCol + 1)].player)) {

						} else {
							moves[x][0] = originRow + 1;
							moves[x][1] = originCol + 1;
							x++;
						}
					}

				}
				if (selectedFigure.isValidMove(originRow + 1, originCol - 1)) {
					if (getFigureIndex(originRow + 1, originCol - 1) == null) {

					} else {
						if (selectedFigure.player
								.equals(figures[getFigureIndex(originRow + 1, originCol - 1)].player)) {

						} else {
							moves[x][0] = originRow + 1;
							moves[x][1] = originCol - 1;
							x++;
						}
					}

				}
			} else {
				if (selectedFigure.isValidMove(originRow - 1, originCol)) {
					if (getFigureIndex(originRow - 1, originCol) == null) {
						moves[x][0] = originRow - 1;
						moves[x][1] = originCol;
						x++;
					}
				}
				if (selectedFigure.isValidMove(originRow - 1, originCol + 1)) {
					if (getFigureIndex(originRow - 1, originCol + 1) == null) {

					} else {
						if (selectedFigure.player
								.equals(figures[getFigureIndex(originRow - 1, originCol + 1)].player)) {

						} else {
							moves[x][0] = originRow - 1;
							moves[x][1] = originCol + 1;
							x++;
						}
					}

				}
				if (selectedFigure.isValidMove(originRow - 1, originCol - 1)) {
					if (getFigureIndex(originRow - 1, originCol - 1) == null) {

					} else {
						if (selectedFigure.player
								.equals(figures[getFigureIndex(originRow - 1, originCol - 1)].player)) {

						} else {
							moves[x][0] = originRow - 1;
							moves[x][1] = originCol - 1;
							x++;
						}
					}
				}
			}
		}

	}

	public void fillVariable() {
		for (int j = 0; j < possibleMoves.length; j++) {
			variable[j][0] = possibleMoves[j][0];
			variable[j][1] = possibleMoves[j][1];

		}
	}

	public boolean isThreatened() {
		for (int i = 0; i < possibleMoves.length; i++) {
			if (kingRow == possibleMoves[i][0] && kingCol == possibleMoves[i][1]) {
				return true;
			}
		}
		return false;
	}

	public void processLeftClick(int row, int col) {

		if (originRow != null) {
			destRow = row;
			destCol = col;
			if (isInMoveSet(destRow, destCol)) {
				move();
				repaint();
				emptyPossibleMoves();
				getMoves(rights);
				rights = getOtherColor();

				getKing(rights);

				if (isThreatened()) {
					check = true;
					// fillVariable();
				}
			} else {
				check = false;
				originRow = null;
				originCol = null;
				selectedFigure = null;
				emptyPossibleMoves();
			}

		}

	}

	public Integer getFigureIndex(int row, int col) {

		for (int g = 0; g < figures.length; g++) {
			if (figures[g] != null) {
				if (figures[g].row != null) {
					if (figures[g].row == row && figures[g].col == col) {
						return g;
					}
				}
			}
		}
		return null;
	}

	public void move() {
		if (getFigureIndex(destRow, destCol) != null) {
			int x = getFigureIndex(destRow, destCol);
			figures[x] = null;
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
		fillFigures();
		repaint();
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
		// bauern
		int x = 0;
		for (int i = 1; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				Figure fig = new Bauer(new ImageIcon("Images\\bauerBlack.png"), "black", i, j);
				figures[x] = fig;
				x++;
			}
		}

		for (int i = 6; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				Figure fig = new Bauer(new ImageIcon("Images\\bauerWhite.png"), "white", i, j);
				figures[x] = fig;
				x++;
			}
		}
		// türme
		Figure turmblack1 = new Turm(new ImageIcon("Images\\turmBlack.png"), "black", 0, 0);
		figures[x] = turmblack1;
		x++;
		Figure turmblack2 = new Turm(new ImageIcon("Images\\turmBlack.png"), "black", 0, 7);
		figures[x] = turmblack2;
		x++;
		Figure turmwhite1 = new Turm(new ImageIcon("Images\\turmWhite.png"), "white", 7, 0);
		figures[x] = turmwhite1;
		x++;
		Figure turmwhite2 = new Turm(new ImageIcon("Images\\turmWhite.png"), "white", 7, 7);
		figures[x] = turmwhite2;
		x++;

		// läufer
		Figure läuferblack1 = new Läufer(new ImageIcon("Images\\läuferBlack.png"), "black", 0, 1);
		figures[x] = läuferblack1;
		x++;
		Figure läuferblack2 = new Läufer(new ImageIcon("Images\\läuferBlack.png"), "black", 0, 6);
		figures[x] = läuferblack2;
		x++;
		Figure läuferwhite1 = new Läufer(new ImageIcon("Images\\läuferWhite.png"), "white", 7, 1);
		figures[x] = läuferwhite1;
		x++;
		Figure läuferwhite2 = new Läufer(new ImageIcon("Images\\läuferWhite.png"), "white", 7, 6);
		figures[x] = läuferwhite2;
		x++;

		// Springer
		Figure springerblack1 = new Springer(new ImageIcon("Images\\springerBlack.png"), "black", 0, 2);
		figures[x] = springerblack1;
		x++;
		Figure springerblack2 = new Springer(new ImageIcon("Images\\springerBlack.png"), "black", 0, 5);
		figures[x] = springerblack2;
		x++;
		Figure springerwhite1 = new Springer(new ImageIcon("Images\\springerWhite.png"), "white", 7, 2);
		figures[x] = springerwhite1;
		x++;
		Figure springerwhite2 = new Springer(new ImageIcon("Images\\springerWhite.png"), "white", 7, 5);
		figures[x] = springerwhite2;
		x++;

		// damen
		Figure dameblack = new Dame(new ImageIcon("Images\\dameBlack.png"), "black", 0, 3);
		figures[x] = dameblack;
		x++;
		Figure damewhite = new Dame(new ImageIcon("Images\\dameWhite.png"), "white", 7, 3);
		figures[x] = damewhite;
		x++;

		// könige
		Figure königblack = new König(new ImageIcon("Images\\königBlack.png"), "black", 0, 4);
		figures[x] = königblack;
		x++;
		Figure königwhite = new König(new ImageIcon("Images\\königWhite.png"), "white", 7, 4);
		figures[x] = königwhite;
		x++;
	}

	public Board() {
		super("Chess");
		setLayout(new GridLayout(8, 8));
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame();
	}

	public static void main(String[] args) {
		new Board();
	}
}