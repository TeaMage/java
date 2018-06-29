package myChess;

import javax.swing.ImageIcon;

public class Pawn extends Figure {
	private boolean hasMoved = false;

	public void fillMoves() {
		if (player) {

			if (Board.getFigureByPosition(row - 1, col) == null) {
				moves[row - 1][col] = true;
				if (!hasMoved) {
					if (Board.getFigureByPosition(row - 2, col) == null) {
						moves[row - 2][col] = true;
					}
				}
			}
			if (Board.getFigureByPosition(row - 1, col + 1) != null) {
				if (Board.getFigureByPosition(row - 1, col + 1).player == false) {
					moves[row - 1][col + 1] = true;
				}
			}
			if (Board.getFigureByPosition(row - 1, col - 1) != null) {
				if (Board.getFigureByPosition(row - 1, col - 1).player == false) {
					moves[row - 1][col - 1] = true;
				}
			}
		} else {
			if (Board.getFigureByPosition(row + 1, col) == null) {
				moves[row + 1][col] = true;
				if (!hasMoved) {
					if (Board.getFigureByPosition(row + 2, col) == null) {
						moves[row + 2][col] = true;
					}
				}
			}
			if (Board.getFigureByPosition(row + 1, col + 1) != null) {
				if (Board.getFigureByPosition(row - 1, col + 1).player) {
					moves[row - 1][col + 1] = true;
				}
			}
			if (Board.getFigureByPosition(row + 1, col - 1) != null) {
				if (Board.getFigureByPosition(row - 1, col - 1).player) {
					moves[row - 1][col - 1] = true;
				}
			}
		}
	}

	public Pawn(int row, int col, boolean player, ImageIcon icon) {
		super(row, col, player, icon);
	}
}
