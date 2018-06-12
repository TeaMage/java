package simpleChess;

import javax.swing.ImageIcon;

public class Bauer extends Figure {
	public boolean isValidMove(int i, int j) {
		if (player.equals("black")) {
			int colDelta = Math.abs(j - col);
			if ((i > row && (colDelta == 0 || colDelta == 1))) {
				return true;
			} else {
				return true;
			}
		} else {
			int colDelta = Math.abs(col - j);
			if ((i < row && (colDelta == 0 || colDelta == 1))) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Bauer(ImageIcon icon, String player, Integer row, Integer col) {
		super(icon, player, row, col);
	}
}