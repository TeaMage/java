package beispielDialog;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JPanel;

public class ImageViewPanel extends JPanel {
	
	private Image img;
	

	public ImageViewPanel(File f){
		this.img = Toolkit.getDefaultToolkit().getImage(f.getPath());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
