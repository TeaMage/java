package myChess;

// jeder figur das board übergeben, damit die einzelnen Figuren ihre möglichen Züge errechnen können? 
//getIcon und setIcon ?
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Board extends JFrame {

	public Button[][] buttons = new Button[8][8];
	private Color black = Color.gray;
	public String rights = "white";

	public void processRightClick(int pressedRow, int pressedCol) {

		if (hasIcon(buttons[pressedRow][pressedCol]) == false) {
			return;
		}

		Figure figure = (Figure) buttons[pressedRow][pressedCol].getIcon();
		String color = figure.getDescription();

		if (color.equals(rights)) {

			buttons[pressedRow][pressedCol].setActive();
			if (rights.equals("white")) {
				rights = "black";
			} else {
				rights = "white";
			}
			System.out.println("Zugrecht erteilt");
			System.out.println("next player: " + rights);
			return;
		} else {
			return;
		}
	}fff

	public void processLeftClick(int pressedRow, int pressedCol) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (buttons[i][j].isActive) {
					buttons[i][j].removeActive();
					buttons[i][j].getIcon().getImage();
					Figure dings = (Figure) buttons[i][j].getIcon();
					
					System.out.println(dings instanceof Pawn);
					return;
				}
			}
		}
	}

	public void newGame() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				buttons[i][j] = new Button(false);

				if ((i + j) % 2 != 0) {

					buttons[i][j].setBackground(black);
				}
				buttons[i][j].addMouseListener(new ButtonListener(this));
				add(buttons[i][j]);
			}
		}

		for (int i = 6; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				Pawn pawn = new Pawn("Images\\bauerWhite.png", "white", this);
				buttons[i][j].setIcon(pawn);
			}

		}
		for (int i = 1; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				Pawn pawn = new Pawn("Images\\bauerBlack.png", "black", this);
				buttons[i][j].setIcon(pawn);
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

		setTitle("chess");
		setLayout(new GridLayout(8, 8));
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		newGame();

	}

	public static void main(String[] args) {
		new Board();
	}
}
