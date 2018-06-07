package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Button extends JButton {
	// 1. generell ob der zug geht
	// 2. spezifisch: steht was im weg?
	// 3 steht der könig im schach wenn ich dort hin ziehe?

	public int[] canMoveto(int destRow, int destCol, int originRow, int originCol) {
		int[] rowsCols = new int[2];
		if (Math.abs(destRow - originRow) < 2 && Math.abs(destCol - originCol) == 0) {
			return null;
		}
		rowsCols[0] = destRow;
		rowsCols[1] = destCol;
		return rowsCols;
	}

	public boolean isActive = false;
	Board board;
	public String player;
	public String type;
	ImageIcon icon;

	public Button(Board board) {

	}
}
