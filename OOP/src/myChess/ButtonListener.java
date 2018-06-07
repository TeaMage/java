package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ButtonListener implements ActionListener {

	private Board board;
	private int destRow;
	private int destCol;
	private int originRow;
	private int originCol;

	public void processClick(int i, int j) {
		if (checkActive()) {
			destRow = i;
			destCol = j;
			
			setActive();
			if (board.buttons[destRow][destCol].equals(board.buttons[originRow][originCol]) == false) {
				if (board.buttons[originRow][originCol].canMoveto(destRow,destCol,originRow,originCol)) {
					move(destRow, destCol, originRow, originCol);
				}
				
			}
			return;

		} else {
			if (board.buttons[i][j].getIcon() != null) {
				if (board.buttons[i][j].player.equals(board.rights)) {
					board.buttons[i][j].isActive = true;
					return;
				}
			}
		}

	}

	public void move(int destRow, int destCol, int originRow, int originCol) {
		if (board.buttons[originRow][originCol].player.equals("white")) {
			board.rights = "black";
		} else {
			board.rights = "white";
		}
		board.buttons[destRow][destCol].setIcon(board.buttons[originRow][originCol].icon);
		board.buttons[destRow][destCol].icon = board.buttons[originRow][originCol].icon;
		board.buttons[destRow][destCol].isActive = false;
		board.buttons[originRow][originCol].isActive = false;
		board.buttons[originRow][originCol].setIcon(null);
		board.buttons[originRow][originCol].icon = null;
		board.buttons[destRow][destCol].player = board.buttons[originRow][originCol].player;
		board.buttons[destRow][destCol].type = board.buttons[originRow][originCol].type;
		return;
	}

	public void setActive() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.buttons[i][j].isActive) {

					originRow = i;
					originCol = j;
				}
			}
		}

	}

	public boolean checkActive() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.buttons[i][j].isActive) {

					return true;
				}
			}
		}
		return false;
	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.buttons[i][j] == e.getSource()) {
					processClick(i, j);
				}
			}
		}
	}

	public ButtonListener(Board board) {
		this.board = board;
	}
}
