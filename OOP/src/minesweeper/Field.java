package minesweeper;

import java.awt.*;
import javax.swing.*;

public class Field extends JButton {

	private int minesAround;
	private boolean bomb = false;
	private boolean flagged = false;

	public boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = true;
	}

	public int getMinesAround() {
		return minesAround;
	}

	public void setMinesAround(int minesAround) {
		this.minesAround = minesAround;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean getBomb() {
		return this.bomb;
	}

}
