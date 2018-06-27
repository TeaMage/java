package chess;

public abstract class Figure {
	private boolean color;
	private int xPosition;
	private int yPosition;
	private boolean[][] possibleMoves = new boolean[8][8];

	public abstract boolean[][] getPossibleMoves();
}
