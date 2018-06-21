package labViewer;

import java.io.File;

public class ViewerRegistry {
  private final java.util.Map<String, IViewerFactory<? extends BaseViewer>> viewer;
  
  public ViewerRegistry(java.util.Map<String, IViewerFactory<? extends BaseViewer>> viewer) {
    this.viewer = viewer;
  }
  
  public BaseViewer getViewer(File f) {
    IViewerFactory<? extends BaseViewer> v = (IViewerFactory)viewer.get(getExtensionFromFile(f));
    if (v != null) {
      try {
        return v.getViewer(f);
      } catch (Exception localException) {}
    }
    return null;
  }
  
  static String getExtensionFromFile(File f) {
    try {
      String name = f.getName();
      return name.substring(name.lastIndexOf(".") + 1);
    } catch (Exception e) {}
    return null;
  }
}