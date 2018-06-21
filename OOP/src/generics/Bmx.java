package generics;

public class Bmx extends Auto{
	public final int series;
	
	public Bmx(double maxSpeed, int wheels, int series) {
		super(maxSpeed, wheels);
		this.series = series;
	}
}
