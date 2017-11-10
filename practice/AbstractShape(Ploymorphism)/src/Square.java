
public class Square  extends Rectangle{
	
public Square() {}
public Square(double side) {
	super(side,side);
	if(getWidth()==getLength()) 
	{
	  width=side;
	}
}
public Square(double side, String color, boolean filled) {
	super(side,side, color, filled);
	if(getWidth()==getLength())
	{
		 width=side;
	}
}
public double getSide()
{
	return getWidth();
}
public void setSide(double side)
{
	side=getWidth();
}
@Override
public void setWidth(double side)
{
	side=width;
}
@Override
public void setLength(double side)
{
	side=length;
}
public String toString() {
	return String.format("%n%s: %s%n%s: %s%n%s: %.2f","Color",color,"IS Filled", false,"Side",width);
}
@Override
public double getArea()
{
	return width*width;
}
@Override
public double getPerimeter()
{
	return 4*width;
}
}

