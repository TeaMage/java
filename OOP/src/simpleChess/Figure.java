package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class Figure {
	public Figure getFigure() {
		return this;
	}
	ImageIcon icon;
	String type;
	String player;
	public int row;
	public int col;
	boolean hasMoved;

	public int[][] getMovesBauer() {
		return null;
	}

	public int[][] getMoveKönig() {
		return null;
	}
}
