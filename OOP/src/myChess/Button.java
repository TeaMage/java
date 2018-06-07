package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Button extends JButton {


	public boolean canMoveto(int destRow, int destCol, int originRow, int originCol) {
		
		if (Math.abs(destRow - originRow) < 2 && Math.abs(destCol - originCol) == 0) {
			return true;
		}
		return false;
	}

	public boolean isActive = false;
	Board board;
	public String player;
	public String type;
	ImageIcon icon;

	public Button(Board board) {

	}
}
