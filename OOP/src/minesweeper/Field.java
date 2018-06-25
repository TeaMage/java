package minesweeper;

import java.awt.*;
import javax.swing.*;

public class Field extends JButton {

	private int minesAround;
	private boolean bomb;
	private boolean flagged;

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlag(boolean flagged) {
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
