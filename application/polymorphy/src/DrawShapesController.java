import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawShapesController {
    @FXML private Canvas canvas;
    @FXML
    void drawShapesButtonPressed(ActionEvent event) {

        // canvas dimensions and declaration
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double centerX = canvas.getWidth()/2;
        double centerY = canvas.getHeight()/2;
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        // create Color array
        Color colorList[] = {Color.BEIGE, Color.LIGHTGREEN,Color.BROWN,
                Color.LIGHTBLUE,Color.YELLOW,Color.VIOLET};

        // SHAPES DIMENSION 1
        double radiusX1 = canvasWidth/2.7;
        double radiusY1 = canvasHeight/3.0;
        myOval oval1 = new myOval(centerX+canvasWidth/2 - radiusX1,
                centerY + canvasHeight/2 - radiusY1 ,colorList[1],radiusX1,radiusY1);
        myRectangle rectangleForOval1 = oval1.getBoundingBox(canvasWidth,canvasHeight,colorList[0]);

        // SHAPES DIMENSION 2
        double radiusX2 = (rectangleForOval1.getWidth()/Math.sqrt(2))/2;
        double radiusY2 = (rectangleForOval1.getHeight()/Math.sqrt(2))/2;
        myOval oval2 = new myOval(centerX+canvasWidth/2 - radiusX2,
                centerY + canvasHeight/2 - radiusY2 ,colorList[3],radiusX2,radiusY2);
        myRectangle rectangleForOval2 = oval2.getBoundingBox(canvasWidth,canvasHeight,colorList[2]);

        // SHAPES DIMENSION 3
        double radiusX3 = (rectangleForOval2.getWidth()/Math.sqrt(2))/2;
        double radiusY3 = (rectangleForOval2.getHeight()/Math.sqrt(2))/2;
        myOval oval3 = new myOval(centerX+canvasWidth/2 - radiusX3,
                centerY + canvasHeight/2 - radiusY3 ,colorList[5],radiusX3,radiusY3);
        myRectangle rectangleForOval3 = oval3.getBoundingBox(canvasWidth,canvasHeight,colorList[4]);


//        rectangleForOval3.draw(gc,canvasWidth,canvasHeight);
//        oval3.draw(gc,canvasWidth,canvasHeight);

        // Initialize array with myShapes objects
        myShape[] myShapeList = new myShape[6];
        myShapeList[0] = rectangleForOval1;
        myShapeList[1] = oval1;
        myShapeList[2] = rectangleForOval2;
        myShapeList[3] = oval2;
        myShapeList[4] = rectangleForOval3;
        myShapeList[5] = oval3;

        System.out.println("================================================");
        System.out.printf("myShapes objects processed polymorphically:%n");
        System.out.print("================================================");

        double rectangleNumber = 0;
        double ovalNumber = 0;

        for (myShape myshapeTest : myShapeList){

            if (myshapeTest instanceof myRectangle) {
                rectangleNumber++;
                System.out.printf("%n%n%s %.0f", "Rectangle Shape: ", rectangleNumber);

            }
            if (myshapeTest instanceof myOval) {
                ovalNumber++;
                System.out.printf("%n%n%s %.0f", "Oval Shape " , ovalNumber);
            }

            System.out.printf("%n%s %n%s%.2f %n%s%.2f ",
                    myshapeTest.getPoint(),"Area: ", myshapeTest.getArea(),
                    "Circumference: ", myshapeTest.getPerimeter());

            myshapeTest.draw(gc,canvasWidth,canvasHeight);
        }
    }
}
