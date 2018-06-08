package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class Figure {

	ImageIcon icon;
	String type;
	String player;
	public Integer row;
	public Integer col;
	boolean hasMoved;

	public int[][] moves = new int[14][2];

	public int[][] getMoves() {
		int x = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (isValidMove(i, j)) {

					moves[x][0] = i;
					moves[x][1] = j;
					x++;
					if (x == 14) {
						return moves;
					}

				}
			}
		}
		return moves;
	}

	private boolean isValidMove(int i, int j) {

		int rowDelta = Math.abs(i - row);
		int colDelta = Math.abs(j - col);

		if ((rowDelta == 0 && colDelta > 0)) {
			return true;
		}
		if ((colDelta == 0 && rowDelta > 0)) {
			return true;
		}
		return false;

	}

	public int[][] getMoveKönig() {
		return null;
	}

	public Figure(ImageIcon icon, String player, String type, Integer row, Integer col) {
		this.icon = icon;
		this.player = player;
		this.type = type;
		this.row = row;
		this.col = col;
	}
	public Figure(Integer row, Integer col) {
		this.row = row;
		this.col = col;
	}
}
