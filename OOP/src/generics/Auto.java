package generics;

public class Auto extends Fahrzeug implements IFaster<Fahrzeug>{
	public final int wheels;
	
	public Auto(double maxSpeed, int wheels) {
		super(maxSpeed);
		this.wheels = wheels;
	}

	@Override
	public boolean isFaster(Fahrzeug item) {
		return this.maxSpeed > item.maxSpeed;
	}
}
