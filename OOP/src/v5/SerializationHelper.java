package v5;

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
