package myChess;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class ButtonHandler extends MouseAdapter {

	private Board board;
	private Figure figure;

	private void processClick(int i, int j) {

		board.figures[figure.row][figure.col].setIcon(null);
		board.figures[i][j].setIcon(figure.icon);
		figure.row = i;
		figure.col = j;
	}

	public void mousePressed(ActionEvent e) {

		Object source = e.getSource();
		System.out.println(source);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (source == board.figures[i][j]) {
					processClick(i, j);
					return;
				}
			}

		}

	}

	public ButtonHandler(Board board) {
		this.board = board;
		
	}
}
