
public class Circle extends Shape {
	private double radius=1.0;
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		if(radius<0.0)
		{
			throw new IllegalArgumentException("Radius can't be negative");
		}
		this.radius = radius;
	}
	// CONSTRUCTORS========================
	public Circle() {}
	public Circle(double radius) {
		if(radius<0.0)
		{
			throw new IllegalArgumentException("Radius can't be negative");
		}
		this.radius = radius;
	}
	public Circle( String color, boolean filled, double radius) {
		super(color, filled);
		if(radius<0.0)
		{
			throw new IllegalArgumentException("Radius can't be negative");
		}
		this.radius = radius;
		
	}
	public double getArea() {
		return Math.PI*(this.radius*this.radius);
	}
	public double getPerimeter() {
		return Math.PI*(2*this.radius);
	}
	public String toString() {
		return String.format("%n%s%s: &.2f",super.toString(),"Radius", this.radius);
	}
	
}


