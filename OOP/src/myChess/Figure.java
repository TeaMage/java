package myChess;

import javax.swing.ImageIcon;

public abstract class Figure {
	private int row;
	private int col;
	private boolean player;
	private boolean[][] moves = new boolean[8][8];
	private ImageIcon icon;
	public Figure[] figures; 
	public void setRow(int row) {
		this.row = row;
	}

	public int getRow() {
		return row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getCol() {
		return col;
	}

	public boolean getPlayer() {
		return player;
	}

	public boolean[][] getMoves() {
		return moves;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	abstract void fillMoves(boolean player);

	public Figure(int row, int col, boolean player, ImageIcon icon, Figure[] figures) {
		this.row = row;
		this.col = col;
		this.player = player;
		this.icon = icon;
		this.figures = figures;
	}

}
