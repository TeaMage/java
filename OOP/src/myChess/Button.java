package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Button extends JButton {

	public String player;
	public String type;
	ImageIcon icon;
	boolean hasMoved = false;

	public Button() {

	}
}
