package interfaces_abstract_classes;
public class Entwickler extends Mitarbeiter {
	public int year;

	public Entwickler(String name) {
		super(name);
	}

	// Die abstracte Methode _muss_ implementiert werden
	@Override
	protected double getGehalt() {
		if (year < 2)
			return 6000;
		else if (year > 5)
			return 10000;
		else
			return 8000;
	}

}
