package simpleChess;

import javax.swing.ImageIcon;

public class L�ufer extends Figure {
	public boolean isValidMove(int i, int j) {
		int rowDelta = Math.abs(i - row);
		int colDelta = Math.abs(j - col);

		if ((rowDelta>0 && colDelta>0)) {
			return true;
		}
		if ((colDelta >0 && rowDelta >0)) {
			return true;
		}
		return false;

	}

	public L�ufer(ImageIcon icon, String player,  Integer row, Integer col) {
		super(icon, player, row, col);
	}
}