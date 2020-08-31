import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public abstract class  myShape implements ShapePositionInterface{

    // instance variable
    private double x;
    private double y;
    private Color strokeColor;

    //constructor
    public myShape(double x, double y, Color strokeColor){
        this.x = x;
        this.y = y;
        this.strokeColor = strokeColor;
    }

    // get methods
    public double getX(){ return this.x; }

    public double getY(){
        return this.y;
    }

    public Color getColor(){
        return this.strokeColor;
    }

    // set methods
    public void setX(double x){ this.x  = x; }

    public void setY(double y){ this.y  = y; }

    public void setColor(Color strokeColor){ this.strokeColor  = strokeColor; }


    // shift methods
    public void shiftX(double deltaX){
        this.x = this.x + deltaX;
    }

    public void shiftY(double deltaY){
        this.y = this.y + deltaY;
    }

    // toString method
    @Override
    public String toString(){
        return String.format("%s: %n%s %.1f%n%s %.1f%n%s%s",
                "shape","x:",getX(),"y:",getY(),"color: ",getColor());
    }

    // draw method
    public void draw(GraphicsContext gc, double canvasWidth, double canvasHeight){
        // set the color for the current arc
        gc.setFill(strokeColor);

        gc.fillRect(x - canvasWidth/2,y - canvasHeight/2,canvasWidth,canvasHeight);
    }


    // moveTo method
    public void moveTo(double newX, double newY){
        setX(getX() + newX);
        setY(getY() + newY);
    }

    // distanceTo method
    public double distanceTo(double targetX,double  targetY){
        return  Math.sqrt(Math.pow(getX()-targetX,2) + Math.pow(getY()-targetY,2));
    }

}
