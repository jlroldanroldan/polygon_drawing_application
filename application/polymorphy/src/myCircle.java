import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class myCircle extends myOval{

    // constructor
    public myCircle(double x, double y, Color strokeColor, double axisA,double  axisB){
        super(x,y,strokeColor,axisA,axisB);
    }

    // perimeter method
    public double getPerimeter(){
        return 2*Math.PI*getRadius();
    }
    // return radius method
    public double getRadius(){ return getAxisA(); }
    // toString method
    @Override
    public String toString(){
       return String.format("%s %s%n%s%.1f%n%s%.1f", "circle",
               super.toString(),"radius: ",getRadius(),"area: ", getArea());
    }
    // draw method
    @Override
    public void draw(GraphicsContext gc,double width, double height) {
        // set the color for the current arc
        gc.setFill(super.getColor());

        // Draw circle
        gc.strokeOval(super.getX() - width/2,super.getY()- height/2,
                2*getRadius(),2*getRadius());
        gc.fillOval(super.getX()- width/2,super.getY()- height/2,
                2*getRadius(),2*getRadius());
    }
    // getPoint method
    public Point getPoint(){
        Point point1 = new Point(getX(),getY());
        return point1;
    }

}
