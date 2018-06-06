package chess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridLayoutManager extends JFrame {
	private Container contents;
	
	private JButton[][] squares = new JButton[8][8];
	private Color colorBlack = Color.BLACK;
	private int row = 7;
	private int col = 1;
	private ImageIcon knight = new ImageIcon("Images\\bauerWhite.png");

	public GridLayoutManager() {
		super("Schach!");
		contents = getContentPane();
		contents.setLayout(new GridLayout(8, 8));
		ButtonHandler buttonHandler = new ButtonHandler();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new JButton();
				if ((i + j) % 2 != 0) {
					squares[i][j].setBackground(colorBlack);

				}
				contents.add(squares[i][j]);
				squares[i][j].addActionListener(buttonHandler);
			}
		}
		squares[row][col].setIcon(knight);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private boolean isValidMove(int i, int j) {
		int rowDelta = Math.abs(i - row);
		int colDelta = Math.abs(j - col);

		if ((rowDelta == 1 && colDelta == 2)) {
			return true;
		}
		if ((colDelta == 1 && rowDelta == 2)) {
			return true;
		}
		return false;

	}

	private void processClick(int i, int j) {
		if (isValidMove(i, j) == false) {
			return;
		}
		squares[row][col].setIcon(null);
		squares[i][j].setIcon(knight);
		row = i;
		col = j;
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			System.out.println("m");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (source == squares[i][j]) {
						processClick(i, j);
						return;
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		new GridLayoutManager();
	}
}