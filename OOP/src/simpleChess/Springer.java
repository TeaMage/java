package simpleChess;

import javax.swing.ImageIcon;

public class Springer extends Figure {
	

	public boolean isValidMove(int i, int j) {
		int rowDelta = Math.abs(i - row);
		int colDelta = Math.abs(j - col);
		if ((rowDelta == 1 && colDelta == 2)) {
			return true;
		}
		if ((colDelta == 1 && rowDelta == 2)) {
			return true;
		}
		return false;
	}
	public Springer(ImageIcon icon, String player,  Integer row, Integer col) {
		super(icon, player,  row, col);
	}
}
