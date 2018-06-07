package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ButtonListener implements ActionListener {

	private Board board;

	public void processClick(int i, int j) {
		if (board.oR != null) {
			

			board.dR = i;
			board.dC = j;

			if (board.hasRights()) {

				board.processClick();
			}

		} else {
			if (board.buttons[i][j].getIcon() != null) {
				if (board.buttons[i][j].player.equals(board.rights)) {
					board.oR = i;
					board.oC = j;

				}
			}
		}

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
