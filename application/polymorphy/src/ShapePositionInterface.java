import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public interface ShapePositionInterface
        extends ShapeInterface, PositionInterface {

    // getBoundingBox method
    myRectangle getBoundingBox(double canvasWidth, double canvasHeight,Color color1);

    // determine appropiate subclass of myShape
    private Shape determineSubclass(myShape myShape1){
        Shape shapeTest1;

        if( myShape1 instanceof myCircle){
            myCircle myCircle1 = (myCircle) myShape1;
            shapeTest1 = new Circle(myCircle1.getX(),myCircle1.getY(),myCircle1.getRadius());
        }
        else if(myShape1 instanceof myOval){
            myOval myOval1 = (myOval) myShape1;
            shapeTest1 = new Ellipse(myOval1.getX(),myOval1.getY(),myOval1.getAxisA(),
                                    myOval1.getAxisB());
        }
        else if(myShape1 instanceof myRectangle){
            myRectangle myRectangle1 = (myRectangle) myShape1;
            shapeTest1 = new  Rectangle(myRectangle1.getWidth(),myRectangle1.getHeight(),
                    myRectangle1.getWidth(),myRectangle1.getHeight());
        }
        else {
            myPolygon myPolygon1 = (myPolygon) myShape1;
            shapeTest1 = new Polygon(myPolygon1.getX(),myPolygon1.getX());
        }

        return shapeTest1;
    }

    // doOverlap method
    default boolean doOverlap(myShape myShape1, myShape myShape2){

        Shape shapeTest1;
        shapeTest1 =  determineSubclass(myShape1);

        Shape shapeTest2;
        shapeTest2 =  determineSubclass(myShape2);

        Shape interceptedShapes = Shape.intersect(shapeTest1,shapeTest2);

        return (interceptedShapes.getBoundsInLocal().getWidth() != -1);
    }
}
