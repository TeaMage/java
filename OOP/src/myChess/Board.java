package myChess;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame {
	public JButton[][] buttons = new JButton[8][8];

	public Board() {
		super("Schach!");

		setLayout(new GridLayout(8, 8));

		Figure bauer = new Figure(this, new ImageIcon("Images\\bauerWhite.png"));
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addMouseListener(new ButtonListener(this));
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
