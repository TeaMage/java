package labViewer2;
import java.io.File;
import javax.swing.JPanel;

public abstract interface IViewerFactory<T extends JPanel>
{
  public abstract T getViewer(File paramFile)
    throws Exception;
}