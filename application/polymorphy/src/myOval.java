import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class myOval extends myShape{
    private double axisA;
    private double axisB;

    // constructor
    public myOval(double x, double y, Color strokeColor, double axisA, double axisB){
        super(x,y,strokeColor);
        this.axisA = axisA;
        this.axisB = axisB;
    }

    // return axisA method
    public double getAxisA(){ return this.axisA; }

    // return axisB method
    public double getAxisB(){ return this.axisB; }
    
    @Override
    public void draw(GraphicsContext gc,double width, double height) {
        // set the color for the current arc
        gc.setFill(super.getColor());

        // Draw circle
        gc.strokeOval(super.getX() - width/2,super.getY()- height/2,
                2*getAxisA(),2*getAxisB());
        gc.fillOval(super.getX() - width/2,super.getY()- height/2,
                2*getAxisA(),2*getAxisB());
    }

    // toString method
    @Override
    public String toString(){
        return String.format("%s%n%s%.1f%n%s%.1f%s%.1f%n", "Oval: "
               ,"RadiusX: ",getAxisA(),"RadiusY: ",getAxisB(),"area: ", getArea());
    }
    // ======================================
    // IMPLEMENTING METHODS FROM INTERFACES
    // ======================================
    // getPoint method
    public Point getPoint(){
        Point point1 = new Point((getX() + getAxisA())/2,(getY()+getAxisB())/2);

        return point1;
    }

    // getBoundingBox method
    public myRectangle getBoundingBox(double canvasWidth, double canvasHeight,Color color1){
        myRectangle rectangle1 = new myRectangle(getX() ,getY() ,color1,
                                2*getAxisA(),2*getAxisB());

        return rectangle1;
    }

    // perimeter method
    public double getPerimeter(){
        return 2*Math.PI*Math.sqrt((Math.pow(getAxisA(),2)+
                                        Math.pow(getAxisA(),2))/2);
    }

    // area method
    public double getArea(){ return Math.PI*axisA*axisB; }

}
