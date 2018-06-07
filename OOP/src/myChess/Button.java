package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Button extends JButton {
	// 1. generell ob der zug geht
	// 2. spezifisch: steht was im weg?
	// 3 steht der könig im schach wenn ich dort hin ziehe?

	public boolean canMoveto(int destRow, int destCol, int originRow, int originCol) {
		boolean hit = false;
		int control;
		int control2 = 0;
		if (board.buttons[originRow][originCol].player.equals("white")) {
			if (board.buttons[originRow][originCol].hasMoved == false) {
				control = -2;
				control2 = -1;
			} else {
				control = -1;

			}

		} else {
			if (board.buttons[originRow][originCol].hasMoved == false) {
				control = 2;
				control2 = 1;
			} else {
				control = 1;
			}
		}
		if ((destRow - originRow == control || destRow - originRow == control2) && Math.abs(destCol - originCol) < 2) {
			if (Math.abs(destCol - originCol) == 1) {
				hit = true;
			}
			if (canActuallyMove(destRow, destCol, hit)) {
				return true;
			}
		}
		return false;
	}

	public boolean canActuallyMove(int destRow, int destCol, boolean hit) {
		if (hit == false) {
			if (board.buttons[destRow][destCol].getIcon() == null) {
				return true;
			}
			return false;
		} else {
			if (board.buttons[destRow][destCol].getIcon() == null) {
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean isActive = false;
	Board board;
	public String player;
	public String type;
	ImageIcon icon;
	boolean hasMoved = false;

	public Button(Board board) {
		this.board = board;

	}
}
