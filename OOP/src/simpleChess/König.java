package simpleChess;

import javax.swing.ImageIcon;

public class König extends Figure {
	public boolean isValidMove(int i, int j) {
		int rowDelta = Math.abs(i - row);
		int colDelta = Math.abs(j - col);

		if ((rowDelta > 0 && colDelta == 0)) {
			if (rowDelta > 1) {
				return false;
			} else {
				return true;
			}
		}
		if ((colDelta > 0 && rowDelta == 0)) {
			if (colDelta > 1) {
				return false;
			} else {
				return true;
			}
		}
		if ((rowDelta > 0 && colDelta > 0)) {
			if (colDelta > 1 && rowDelta > 1) {
				return false;
			} else {
				return true;
			}
		}
		if ((colDelta > 0 && rowDelta > 0)) {
			if (colDelta > 1 && rowDelta > 1) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public König(ImageIcon icon, String player,  Integer row, Integer col) {
		super(icon, player, row, col);
	}
}
