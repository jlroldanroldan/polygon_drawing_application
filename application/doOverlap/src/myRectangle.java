import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class myRectangle extends myShape {
    private double width;
    private double height;

    // constructor
    public myRectangle(double x, double y, Color strokeColor, double width,double  height){
        super(x,y,strokeColor);

        this.width = width;
        this.height = height;
    }

    // get width method
    public double getWidth(){ return width;}

    // get height method
    public double getHeight(){ return height;}

    // ======================================
    // IMPLEMENTING METHODS FROM INTERFACES
    // ======================================
    // getPoint method
    public Point getPoint(){
        Point point1 = new Point((getX() + getWidth()/2)/2,(getY()+ getHeight()/2)/2);
        return point1;
    }

    // getBoundingBox method
    public myRectangle getBoundingBox(double canvasWidth, double canvasHeight, Color color1){
        myRectangle rectangle1 = new myRectangle(super.getX() + width,super.getY(),color1,getWidth(),getHeight());

        return rectangle1;
    }


    // area method
    public double getArea(){ return getWidth()*getHeight();}

    // getPerimeter() method
    public double getPerimeter(){return 2*(getHeight() + getWidth());}

    // draw method
    @Override
    public void draw(GraphicsContext gc,double canvasWidth, double canvasHeight) {
        // set the color for the current arc
        gc.setFill(super.getColor());

        // Draw Rectangle
        gc.strokeRect(super.getX() - canvasWidth/2,super.getY()- canvasHeight/2,width,height);
        gc.fillRect(super.getX() - canvasWidth/2,super.getY()- canvasHeight/2,width,height);

    }
}
