package Vorlesung2;

public class FlensGreeter extends Greeter {
	public FlensGreeter(String name) {
		super(name);
	}

	@Override
	public String getMessage() {
		return "moin und " + super.getMessage();
	}

	public String fooBar() {
		return "test";
	}
}
