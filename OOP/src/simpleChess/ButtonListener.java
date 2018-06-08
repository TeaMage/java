package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class ButtonListener extends MouseAdapter {
	public Board board;
	int row;
	int col;

	public void mousePressed(MouseEvent e) {

		Object source = e.getSource();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.buttons[i][j] == source) {
					row = i;
					col = j;
					;
				}
			}
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
			board.processRightClick(row, col);
			return;
		}

		if (e.getButton() == MouseEvent.BUTTON1) {
			board.processLeftClick(row, col);
			return;
		}
	}

	public ButtonListener(Board board) {
		this.board = board;
	}
}