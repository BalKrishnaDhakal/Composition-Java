
public abstract class Shape {
// INSATNCE VARIABLES=================	
protected String color;
protected boolean filled;
 public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public boolean isFilled() {
	return filled;
}
public void setFilled(boolean filled) {
	this.filled = filled;
}
// CONSTRUCTORS=======================
public Shape() {}
public Shape(String color, boolean filled) {
	this.color=color;
	this.filled=filled;
}
@Override
public String toString()
{
	return String.format("%n%s: %s%n%s: %s%n", "Color", color, "IsFilled", filled);
}
		public abstract double getArea();
		public abstract double getPerimeter();
		
}
