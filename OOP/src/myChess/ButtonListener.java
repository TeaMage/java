package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ButtonListener implements ActionListener {

	private Board board;

	public void processClick(int i, int j) {
		if (checkActive()) {
			board.destRow = i;
			board.destCol = j;

			setActive();
			if (board.buttons[board.destRow][board.destCol]
					.equals(board.buttons[board.originRow][board.originCol]) == false) {

				board.processClick();
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

	public void setActive() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.buttons[i][j].isActive) {

					board.originRow = i;
					board.originCol = j;
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
