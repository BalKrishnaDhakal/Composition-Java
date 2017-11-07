
public class ShapeTest {

	public static void main(String[] args)
	{
		Shape shape = new Shape("Red", true);
		System.out.println(shape);
		//Rectangle(double width, double length, String color, boolean filled)
		System.out.println("++++++++++Rectagle+++++++++++++");
		Rectangle rectangle = new Rectangle(5.0,6.0, "Red",true);
		System.out.println(rectangle);
		rectangle.getArea();
		System.out.printf("The area of Rectagle is: %.2f%n", rectangle.getArea());
		System.out.printf("The Perimeter of Rectagle is: %.2f", rectangle.getPerimeter());
	
	}

}
