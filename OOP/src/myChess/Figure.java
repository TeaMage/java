package myChess;

import java.awt.*;

import javax.swing.*;

public class Figure extends JButton {
	private boolean bauer;
	Board board;
	ImageIcon icon;
	public int row = 7;
	public int col = 7;

	public void setRow(int row) {
		this.row = row;
	}

	public Figure(int row, int col, ImageIcon icon) {
		this.setIcon(icon);
		this.row = row;
		this.col = col;
	}

	public Figure(int row, int col) {
		this.setIcon(null);
		this.row = row;
		this.col = col;

	}
	public Figure() {
		
	}
}
