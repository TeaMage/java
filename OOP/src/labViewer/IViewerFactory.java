package labViewer;

import java.io.File;

public abstract interface IViewerFactory<T extends BaseViewer> {
	public abstract T getViewer(File paramFile) throws Exception;
}