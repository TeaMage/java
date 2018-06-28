package minesweeper;

import javax.swing.JButton;

public class Field extends JButton {

	private int minesAround;
	private boolean bomb = false;
	private boolean flagged = false;
	private boolean hidden = true;

	public int getMinesAround() {
		return minesAround;
	}

	public void setMinesAround(int minesAround) {
		this.minesAround = minesAround;
	}

	public void setBomb() {
		this.bomb = true;
	}

	public boolean hasBomb() {
		return this.bomb;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void flag() {
		this.flagged = true;
	}

	public void unflag() {
		this.flagged = false;
	}

	public void unhide() {
		this.hidden = false;
	}

	public boolean isHidden() {
		return hidden;
	}
}
