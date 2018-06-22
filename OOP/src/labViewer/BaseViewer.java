package labViewer;

import java.io.File;

public abstract class BaseViewer extends javax.swing.JPanel {
	protected final File file;

	protected BaseViewer(File file) throws Exception {
		if (file == null) {
			throw new Exception();
		}
		this.file = file;
	}
}