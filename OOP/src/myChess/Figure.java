package myChess;

import javax.swing.ImageIcon;

public class Figure extends JButton {
	public Board board;
	private ImageIcon icon;

	public Figure(Board board, ImageIcon icon) {
		this.board = board;
		this.icon = icon;
	}//seticon etc  üverschreiben
}
