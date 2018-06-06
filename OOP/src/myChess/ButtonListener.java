package myChess;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ButtonListener extends MouseAdapter {
	private Board board;
	private ImageIcon knight = new ImageIcon("Images\\bauerWhite.png");
	public Figure figure;
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(board.buttons[i][j] == source) {
					if(board.buttons[i][j].canMove)
					board.buttons[i][j].setIcon(knight);
					System.out.println(i);
					System.out.println(j);
				}
			}

		}
	}

	public ButtonListener(Board board, Figure figure) {
		this.board = board;
		this.figure = figure;
	}
}
