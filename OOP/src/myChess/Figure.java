package myChess;

import javax.swing.*;

public abstract class Figure {
	private int row;
	private int col;
	private boolean player;
	private ImageIcon icon;

	public void setPlayer(boolean player) {
		this.player = player;
	}

	public boolean getPlayer() {
		return player;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;

	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Figure(int row, int col) {
		this.row = row;
		this.col = col;
	}

}
