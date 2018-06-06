package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ButtonListener extends MouseAdapter {

	private Board board;
	private int pressedRow;
	private int pressedCol;

	public void mousePressed(MouseEvent e) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.buttons[i][j] == e.getSource()) {
					pressedRow = i;
					pressedCol = j;

				}
			}
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
		
			board.processRightClick(pressedRow, pressedCol);

		}

		else if (e.getButton() == MouseEvent.BUTTON1) {
			board.processLeftClick(pressedRow, pressedCol);
		} else {
			return;
		}

	}

	public ButtonListener(Board board) {
		this.board = board;
	}
}
