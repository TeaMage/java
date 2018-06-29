package myChess;

import javax.swing.ImageIcon;

public class Pawn extends Figure {
	private boolean hasMoved = false;

	public void fillMoves(boolean player) {
		if (player) {
			if (!hasMoved) {
				
				if(row-1)
				
				for(int i = 0; i < 32; i++) {
					figures[i].getRow();
					figures[i].getCol();
				}
			}
		} else {

		}
	}

	public Pawn(int row, int col, boolean player, ImageIcon icon, Figure[] figures) {
		super(row, col, player, icon, figures);
	}
}
