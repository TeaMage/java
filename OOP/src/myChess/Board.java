package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Board extends JFrame {

	public Button[][] buttons = new Button[8][8];
	private Color black = Color.gray;
	public String rights = "white";
	ImageIcon bauerBlack = new ImageIcon("Images\\bauerBlack.png");
	ImageIcon bauerWhite = new ImageIcon("Images\\bauerWhite.png");
	ImageIcon königBlack = new ImageIcon("Images\\königBlack.png");
	ImageIcon königWhite = new ImageIcon("Images\\königWhite.png");
	public Integer dR;
	public Integer dC;
	public Integer oR;
	public Integer oC;
	public String activeType;

	public boolean hasRights() {
		if (buttons[oR][oC].player.equals(rights)) {
			return true;
		}
		return false;
	}

	public boolean canMoveto() {

		int rowDelta = Math.abs(dR - oR);
		int colDelta = Math.abs(dC - oC);
		String player = buttons[oR][oC].player;

		if (player.equals("white")) {

			if (rowDelta == 1 && colDelta == 1 && buttons[oR - 1][oC - 1].getIcon() != null
					&& buttons[oR - 1][oC - 1].player.equals(rights) == false) {
				if (dR < oR) {
					return true;
				}
			}

			if (buttons[oR][oC].hasMoved) {
				if (rowDelta == 1 && colDelta == 0) {
					if (dR < oR) {
						return true;
					}
				}
			} else if ((rowDelta == 2 || rowDelta == 1) && colDelta == 0) {
				if (dR < oR) {
					return true;
				}
			}

		} else {
			if (rowDelta == 1 && colDelta == 1 && buttons[oR + 1][oC + 1].getIcon() != null
					&& buttons[oR + 1][oC + 1].player.equals(rights) == false) {
				if (dR > oR) {
					return true;
				}
			}

			if (buttons[oR][oC].hasMoved) {
				if (rowDelta == 1 && colDelta == 0) {
					if (dR > oR) {
						return true;
					}
				}
			} else if ((rowDelta == 2 || rowDelta == 1) && colDelta == 0) {
				if (dR > oR) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isFree() {
		if (rights.equals("white")) {
			if (buttons[oR - 1][oC].getIcon() == null) {
				return true;
			}
		} else {
			if (buttons[oR + 1][oC].getIcon() == null) {
				return true;
			}
		}
		return false;

	}

	public void processClick() {

		if (canMoveto()) {
			if (isFree()) {
				move();
			}

		} else {

			oR = null;
			oC = null;
		}
	}

	public void move() {
		if (buttons[oR][oC].player.equals("white")) {
			rights = "black";
		} else {
			rights = "white";
		}

		buttons[dR][dC].setIcon(buttons[oR][oC].icon);
		buttons[dR][dC].icon = buttons[oR][oC].icon;
		buttons[oR][oC].setIcon(null);
		buttons[oR][oC].icon = null;
		buttons[dR][dC].player = buttons[oR][oC].player;
		buttons[dR][dC].type = buttons[oR][oC].type;
		buttons[dR][dC].hasMoved = true;
		oR = null;
		oC = null;
		return;
	}

	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				buttons[i][j] = new Button();

				if ((i + j) % 2 != 0) {
					buttons[i][j].setBackground(black);
				}

				buttons[i][j].addActionListener(new ButtonListener(this));
				add(buttons[i][j]);

			}
		}
		for (int i = 1; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].icon = bauerBlack;
				buttons[i][j].setIcon(bauerBlack);
				buttons[i][j].player = "black";
				buttons[i][j].type = "bauer";
			}
		}
		for (int i = 6; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].icon = bauerWhite;
				buttons[i][j].setIcon(bauerWhite);
				buttons[i][j].player = "white";
				buttons[i][j].type = "bauer";
			}
		}
		buttons[0][4].icon = königBlack;
		buttons[0][4].setIcon(königBlack);
		buttons[0][4].player = "black";
		buttons[0][4].type = "könig";

		buttons[7][4].icon = königWhite;
		buttons[7][4].setIcon(königWhite);
		buttons[7][4].player = "white";
		buttons[7][4].type = "könig";

		setTitle("chess");
		setLayout(new GridLayout(8, 8));
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Board();
	}
}
