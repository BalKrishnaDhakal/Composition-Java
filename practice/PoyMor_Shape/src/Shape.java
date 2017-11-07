
public  class Shape {
// INSATNCE VARIABLES=================	
private String color ="red";
private boolean filled = true;
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
public String toString()
{
	return String.format("%n%s: %s%n%s: %s%n", "Color", color, "IsFilled", filled);
}

}
