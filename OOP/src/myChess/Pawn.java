package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Pawn extends Figure {
	Board board;

	public void move() {

	}

	public Pawn(String filename, String player, Board board) {

		super(filename, player);
		this.board = board;

	}
}
