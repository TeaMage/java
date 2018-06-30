package myChess;

import javax.swing.ImageIcon;

public class Rook extends Figure {

	public void fillMoves() {
		int i = 1;
		while (row - i >= 0) {

			if (Board.getFigureByPosition(row - i, col) == null) {

				moves[row - i][col] = true;
				i++;
			} else {
				if (Board.getFigureByPosition(row - i, col).player != player) {
					moves[row - i][col] = true;
				}
				break;
			}
		}

		for (int i = 1; i < 6; i++) {

			if (Board.getFigureByPosition(row + i, col) == null) {

				moves[row + i][col] = true;

			} else {
				if (Board.getFigureByPosition(row + i, col).player != player) {
					moves[row + i][col] = true;
				}
				break;
			}
		}
		for (int i = 1; i < 6; i++) {

			if (Board.getFigureByPosition(row, col - i) == null) {
				moves[row][col - i] = true;
			} else {
				if (Board.getFigureByPosition(row, col - i).player != player) {
					moves[row][col - i] = true;
				}
				break;
			}
		}
		for (int i = 1; i < 6; i++) {

			if (Board.getFigureByPosition(row, col + i) == null) {
				moves[row][col + i] = true;
			} else {
				if (Board.getFigureByPosition(row, col + i).player != player) {
					moves[row][col + i] = true;
				}
				break;
			}
		}
	}

	public Rook(int row, int col, boolean player, ImageIcon icon) {
		super(row, col, player, icon);
	}
}
