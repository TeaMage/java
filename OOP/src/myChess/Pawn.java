package myChess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pawn extends Figure {
	private boolean hasMoved = false;

	public void fillMoves() {

	}

	public Pawn(int row, int col, boolean player, ImageIcon icon) {
		super(row, col, player, icon);
	}
}
