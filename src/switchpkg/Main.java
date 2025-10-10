package switchpkg;

public class Main {

	public static void main(String[] args) {
		Shape shape = new Square(3);
		double area = switch (shape) {
			case Square s -> s.getSide() * s.getSide();
			case Circle c -> Math.PI * c.getRadius() * c.getRadius();
			default -> throw new IllegalArgumentException("Unexpected value: " + shape); 
		};
		System.out.println(area);
	}

}
