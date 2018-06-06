package myChess;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame {
	public Figure[][] buttons = new Figure[8][8];
	ImageIcon bauer = new ImageIcon("Images\\bauerWhite.png");

	public Board() {
		super("Schach!");

		setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j] = new Figure(this, bauer,true);
				buttons[i][j].addMouseListener(new ButtonListener(this,buttons[i][j]));
				add(buttons[i][j]);
			}
		}

		buttons[7][7].setIcon(null);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Board();
	}
}
