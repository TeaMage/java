package myChess;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Button extends JButton {
	public boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive() {
		this.isActive = true;
	}
	public void removeActive() {
		this.isActive= false;
	}

	public Button(boolean isActive) {
		this.isActive = isActive;
	}
}
