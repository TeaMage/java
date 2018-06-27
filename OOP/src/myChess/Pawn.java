package myChess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pawn extends Figure {
	private boolean hasMoved = false;

	public Pawn(int row, int col) {
		super(row, col);
		setIcon(new ImageIcon("chessImages\\bauerBlack.png"));
	}
}
