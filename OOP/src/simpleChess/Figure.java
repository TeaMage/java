package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public abstract class Figure {
	private Board board;
	private boolean possibleMoves[][];
	public ImageIcon icon;
	public Integer row;
	public Integer col;
	public boolean hasMoved = false;
	public boolean player;

	public abstract Integer[][] getPossibleMoves();

	public abstract boolean isValidMove(int i, int j);

	public Figure(ImageIcon icon, boolean player, Integer row, Integer col, Board board) {
		this.icon = icon;
		this.player = player;
		this.row = row;
		this.col = col;
		this.board = board;
	}
}
