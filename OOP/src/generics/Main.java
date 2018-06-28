package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {		
		List<Auto> cars = new ArrayList<Auto>();
		cars.add(new Bmx(220. , 4, 3));
		cars.add(new Bmx(250. , 5, 5));
		cars.add(new Bmx(270. , 6, 7));
		
		System.out.println(getFastest(cars).wheels);
	}

	static <T extends IFaster<? super T>> T getFastest(List<? extends T> cars){
		T car = cars.get(0);
		for(T c : cars){
			if (c.isFaster(car)){
				car = c;
			}
		}
		return car;
	}
	
}
