package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

	private int mines = 10;

	public Game() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(9, 9));
		for (int i = 0; i < 81; i++) {
			add(new JButton());
		}
	}

	private class click extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			if(source == )
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
