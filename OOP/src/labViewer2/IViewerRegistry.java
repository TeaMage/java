package labViewer2;
import java.io.File;

import javax.swing.JPanel;

public abstract interface IViewerRegistry
{
  public abstract JPanel getViewer(File paramFile);
  
  public abstract void addViewer(String paramString, IViewerFactory<? extends JPanel> paramIViewerFactory);
}