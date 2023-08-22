import java.util.function.Supplier;

abstract class TrafficLight {
	private final String color;


	TrafficLight(String color) {
		this.color = color;
	}

	TrafficLight toggle() {
	}

	@Override
	public String toString() {
		return this.color;
	}
}