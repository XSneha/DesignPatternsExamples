package pattern.factory;

public class ShapeFactory {
	public IShape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new Square();
	         
	      }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	         
	      } 
//	      else if(shapeType.equalsIgnoreCase("Circle")){
//	         return new Circle();
//	      }
	      return null;
	   }
}
