package simpleChess;

import javax.swing.ImageIcon;

public class Dame extends Figure {
	public boolean isValidMove(int i, int j) {
		int rowDelta = Math.abs(i - row);
		int colDelta = Math.abs(j - col);

		if ((rowDelta > 0 && colDelta > 0)) {
			return true;
		}
		if ((colDelta > 0 && rowDelta > 0)) {
			return true;
		}
		if ((rowDelta > 0 && colDelta == 0)) {
			return true;
		}
		if ((colDelta > 0 && rowDelta == 0)) {
			return true;
		}
		return false;

	}

	public Dame(ImageIcon icon, String player,  Integer row, Integer col) {
		super(icon, player,  row, col);
	}
}
