
public class Rectangle extends Shape {
	private double width=1.0;
	private double length=1.0;
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		if(width<0.0) {
			throw new IllegalArgumentException("Width can't be negative");
		}
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		if(length<0.0) {
			throw new IllegalArgumentException("Length can't be nagative");
		}
		this.length = length;
	}
	public Rectangle() {}
	public Rectangle(double width, double length) {
		if(width<0.0) {
			throw new IllegalArgumentException("Width can't be negative");
		}
		this.width = width;
		if(length<0.0) {
			throw new IllegalArgumentException("Length can't be nagative");
		}
		this.length = length;
		
	}
	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		if(width<0.0) {
			throw new IllegalArgumentException("Width can't be negative");
		}
		this.width = width;
		if(length<0.0) {
			throw new IllegalArgumentException("Length can't be nagative");
		}
		this.length = length;
		
	}

	public double getArea() {
		return this.length*this.width;
		
	}
	public double getPerimeter() {
		return 2*(this.length+this.width);
	}
public String toString() {
	return String.format("%n%s%n%s: %.2f%n%s: %.2f" , super.toString(),"Length: ",this.length, "Width", this.width);
}
}
