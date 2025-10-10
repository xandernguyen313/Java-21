package switchpkg;

public class Square implements Shape{
	private double s;
	public Square(double s) {
		this.s = s;
	}
	public double getSide() {
		return this.s;
	}
}
