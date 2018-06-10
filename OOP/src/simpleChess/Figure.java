package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class Figure {

	ImageIcon icon;
	String type;
	String player;
	Integer row;
	Integer col;
	boolean hasMoved = false;
	
	public boolean isValidMove(int i, int j) {

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

	public Figure(ImageIcon icon, String player, String type, Integer row, Integer col) {
		this.icon = icon;
		this.player = player;
		this.type = type;
		this.row = row;
		this.col = col;
	}

}
