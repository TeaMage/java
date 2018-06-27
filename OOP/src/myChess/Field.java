package myChess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Field extends JButton {
	private Figure figure;
	private int row;
	private int col;

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;

	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public Figure getFigure() {
		return figure;
	}

	public Field(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public Field(int row, int col, Figure figure) {
		this.row = row;
		this.col = col;
		this.figure = figure;
	}

}
