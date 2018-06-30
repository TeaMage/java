package myChess;

import javax.swing.ImageIcon;

public abstract class Figure {
	public boolean hasMoved = false;
	public Integer row;
	public Integer col;
	public Boolean player;
	public boolean[][] moves = new boolean[8][8];
	public ImageIcon icon;

	public abstract void fillMoves();
	public void emptyMoves() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8 ; j++) {
				moves[i][j] = false;
			}
		}
	}
	public Figure(int row, int col, boolean player, ImageIcon icon) {
		this.row = row;
		this.col = col;
		this.player = player;
		this.icon = icon;
	}

}
