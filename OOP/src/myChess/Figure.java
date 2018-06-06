package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

abstract class Figure extends ImageIcon {
	abstract void move();
	public Figure(String filename, String player) {

		super(filename, player);

	}
}
