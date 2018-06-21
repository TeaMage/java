package labViewer2;

import javax.swing.JPanel;

public abstract class BaseFileChooserWindow extends javax.swing.JFrame
{
  public BaseFileChooserWindow() {}
  
  protected abstract IViewerRegistry getRegistry();
  
  public void addViewer(String fileExtension, IViewerFactory<? extends JPanel> fac) {
    getRegistry().addViewer(fileExtension, fac);
  }
}