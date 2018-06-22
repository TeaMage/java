package labViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public final class FileChooserWindow extends JFrame {
	private JFileChooser fileDialog;

	public FileChooserWindow(final ViewerRegistry reg) throws Exception {
		if (reg == null) {
			throw new Exception();
		}
		fileDialog = new JFileChooser();
		fileDialog.setFileSelectionMode(0);
		setDefaultCloseOperation(3);
		setSize(250, 150);
		JButton b = new JButton();
		b.setText("Choose File ...");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (fileDialog.showDialog(FileChooserWindow.this, "choose file") == 0) {
					BaseViewer p = reg.getViewer(fileDialog.getSelectedFile());
					if (p != null) {
						try {
							new ViewerFrame(p);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
			}
		});
		add(b);
		setVisible(true);
	}
}