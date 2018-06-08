package simpleChess;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

	private final int row;
	private final int col;

	public Button(int i, int j) {
		this.row = i;
		this.col = j;
	}
}
