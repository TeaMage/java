package myChess;

import javax.swing.ImageIcon;

public class Pawn extends Figure {
	private boolean hasMoved = false;

	public void fillMoves(boolean player) {
		if (player) {

		}
	}

	public Pawn(int row, int col, boolean player, ImageIcon icon,Figure[] figures) {
		super(row, col, player, icon,figures);
	}
}
