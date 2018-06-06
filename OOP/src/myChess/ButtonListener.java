package myChess;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends MouseAdapter {
	private Board board;
	private ImageIcon knight = new ImageIcon("Images\\bauerWhite.png");

	public void mousePressed(MouseEvent e) {
		
		board.buttons[0][0].setIcon(knight);
		board.buttons[4][4].setIcon(null);
		if (board.buttons[7][6].getIcon() == null) {
			System.out.println("h");
		}
	}

	public ButtonListener(Board board) {
		this.board = board;
	}
}
