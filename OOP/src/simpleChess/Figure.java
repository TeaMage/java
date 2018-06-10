package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public abstract class Figure {

	ImageIcon icon;
	String player;
	Integer row;
	Integer col;
	boolean hasMoved = false;

	public abstract boolean isValidMove(int i, int j);

	public Figure(ImageIcon icon, String player, Integer row, Integer col) {
		this.icon = icon;
		this.player = player;
		this.row = row;
		this.col = col;
	}

}
