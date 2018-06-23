package lab01;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(255, 0, 0));
		g.fillRect((this.getWidth() / 2) - this.getWidth() / 6,
				this.getHeight() / 2 - this.getHeight() / 6,
				this.getWidth() / 3, this.getHeight() / 3);

	}
}
