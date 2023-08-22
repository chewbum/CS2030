import java.util.function.Supplier;

abstract class TrafficLight {
	private final String color;

	TrafficLight(String color) {
		this.color = color;
	}

	abstract TrafficLight toggle();

	@Override
	public String toString() {
		return this.color;
	}

}

class RedLight extends TrafficLight {

	RedLight() {
		super("red");
	}

	@Override
	GreenLight toggle() {
		return new GreenLight();
	}
}

class GreenLight extends TrafficLight {

	GreenLight() {
		super("green");
	}

	@Override
	public RedLight toggle() {
		return new RedLight();
	}
}

//c

abstract class RedLight extends TrafficLight {

	RedLight() {
		super("red");
	}

	abstract toggle();
	
}

abstract class GreenLight extends TrafficLight {

	GreenLight() {
		super("green");
	}

	abstract toggle();
}

abstract class AmberLight extends TrafficLight {

	AmberLight() {
		super("amber");
	}

	abstract toggle();
}

//d
RedLight redLight = new RedLight() {
	RedLight red = this;

	@Override 
	GreenLight toggle() {
		return new GreenLight() {
			@Override
			AmberLight toggle() {
				return new AmberLight() {
					@Override 
					RedLight toggle() {
						return red;
					}
				}
			}
		}
	}
}


