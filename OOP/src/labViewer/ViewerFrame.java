package labViewer;

import javax.swing.JFrame;

public class ViewerFrame extends JFrame {
	public ViewerFrame(BaseViewer viewer) throws Exception {
		if (viewer == null) {
			throw new Exception();
		}
		setSize(500, 500);
		add(viewer);
		setVisible(true);
	}
}