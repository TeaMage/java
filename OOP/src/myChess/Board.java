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
	public int destRow;
	public int destCol;
	public int originCol;
	public int originRow;
	public String activeType;

	public void processClick() {

		activeType = buttons[originRow][originCol].type;
		if (buttons[originRow][originCol].canMoveto(destRow, destCol, originRow, originCol)) {

			move(destRow, destCol, originRow, originCol);

		} else {
			buttons[originRow][originCol].isActive = false;
		}
	}

	public void move(int destRow, int destCol, int originRow, int originCol) {
		if (buttons[originRow][originCol].player.equals("white")) {
			rights = "black";
		} else {
			rights = "white";
		}

		buttons[destRow][destCol].setIcon(buttons[originRow][originCol].icon);
		buttons[destRow][destCol].icon = buttons[originRow][originCol].icon;
		buttons[destRow][destCol].isActive = false;
		buttons[originRow][originCol].isActive = false;
		buttons[originRow][originCol].setIcon(null);
		buttons[originRow][originCol].icon = null;
		buttons[destRow][destCol].player = buttons[originRow][originCol].player;
		buttons[destRow][destCol].type = buttons[originRow][originCol].type;
		buttons[destRow][destCol].hasMoved = true;
		return;
	}

	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				buttons[i][j] = new Button(this);

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
