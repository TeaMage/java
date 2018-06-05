package v5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// generische klasse <> funktioniert vfür objekte von typ t
public class SerializationHelper<T> {
	private String path;
/*
	public void SerializationHelper(String path) {
		this.path = path;
	}

	public void Save(Rechnung o) {
		FileOutputStream fos = new FileOutputStream("E:\\moin.test");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);
		oos.close(); // beinhaltet flush()
		fos.close();
	}

	public Rechnung Load() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(this.path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		T result = (T) ois.readObject();
		ois.close();
		fis.close();
		return result;
	}*/
}
