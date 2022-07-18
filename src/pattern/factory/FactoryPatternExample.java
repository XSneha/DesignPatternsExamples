package pattern.factory;

public class FactoryPatternExample {

	public static void main(String args[]) {
		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Rectangle and call its draw method.
		IShape shape2 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Rectangle
		shape2.draw();

		IShape shape3 = shapeFactory.getShape("Square");

		// call draw method of Circle
		shape3.draw();

		// get an object of Circle and call its draw method.
		IShape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Circle
		shape1.draw();
	}
}
