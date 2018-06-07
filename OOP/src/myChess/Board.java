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

	public int[][] getPawnMoves() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].canMoveto(i,j);
			}
		}

	}

	public boolean hasIcon(Button button) {
		if (button.getIcon() == null) {

			return false;

		} else {

			return true;
		}
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
		buttons[0][0].icon = bauerBlack;
		buttons[7][0].icon = bauerWhite;
		buttons[0][0].player = "black";
		buttons[0][0].type = "bauer";
		buttons[7][0].player = "white";
		buttons[7][0].type = "bauer";
		buttons[0][0].setIcon(bauerBlack);
		buttons[7][0].setIcon(bauerWhite);

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
