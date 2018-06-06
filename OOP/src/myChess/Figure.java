package myChess;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Figure extends JButton {
	public Board board;
	private ImageIcon icon;
	public boolean canMove;

	public Figure(Board board, ImageIcon icon, boolean canMove) {
		this.board = board;
		this.icon = icon;
		this.canMove = canMove;
	}
}
