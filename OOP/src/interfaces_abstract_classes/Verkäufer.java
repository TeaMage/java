package interfaces_abstract_classes;
public class Verk�ufer extends Mitarbeiter {

	public Verk�ufer(String name) {
		super(name);
	}

	//Die abstracte Methode _muss_ implementiert werden
	@Override
	protected double getGehalt(){
		return 6000;
	}
}
