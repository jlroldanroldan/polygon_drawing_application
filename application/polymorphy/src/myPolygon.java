import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class myPolygon extends myShape {
    private double radius;
    private double[] xPoints;
    private double[] yPoints;
    private int nPoints;

    // constructor
    public myPolygon(double x, double y, Color strokeColor,
                   double radius, double[] xPoints, double[] yPoints,
                   int nPoints){
        super(x,y,strokeColor);

        this.radius = radius;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
    }

    // getAngle() method
    public double getAngle(){
        return 180.0*(nPoints-2)/nPoints;
    }

    // getSide() method
    public double getSide(){
        double side = 0;
        side = Math.sqrt(Math.pow(xPoints[1]-xPoints[0],2) + Math.pow(yPoints[1]-yPoints[0],2));
        return side;
    }

    // getPerimeter() method
    public double getPerimeter(){
        double side = getSide();
        return nPoints*side;
    }

    // getArea() method
    public double getArea(){
        return (1.0/2)*nPoints*Math.pow(radius,2)*Math.sin(2*Math.PI/nPoints);
    }

    //toString() method
    @Override
    public String toString(){
        return String.format("%n%s %n%s%.1f%n%s%.1f%n%s%.1f%n%s%.1f", "Polygon",
                "side length:", getSide(),
                "interior angle: ",getAngle(),"perimeter: ",getPerimeter(),
                "area: ", getArea());
    }

    // draw method
    @Override
    public void draw(GraphicsContext gc,double canvasWidth, double canvasHeight) {
        double angleInDegrees = 360/nPoints;
        double angleInRadians = Math.toRadians(angleInDegrees);

        for(int counter = 0; counter < nPoints ; counter++ ){
            xPoints[counter] = super.getX() + radius*Math.sin(counter*angleInRadians);
            yPoints[counter] = super.getX() - radius*Math.cos(counter*angleInRadians);
        }

        System.out.println("x     y");
        for(int counter = 0; counter < nPoints ; counter++ ){
            System.out.printf("%.1f %.1f%n",xPoints[counter],yPoints[counter]);
        }

        // set the color for the current arc
        gc.setFill(super.getColor());

        // Draw Polygon
        gc.strokePolygon(xPoints,yPoints,nPoints);
        gc.fillPolygon(xPoints,yPoints,nPoints);
    }

    // getPoint method
    public Point getPoint(){
        Point point1 = new Point(getX(),getY());

        return point1;
    }
    // getBoundingBox method
    public myRectangle getBoundingBox(double canvasWidth, double canvasHeight,Color color1){
        double y1 = yPoints[0];
        double halfHeight = Math.sqrt(Math.pow(super.getX() - xPoints[0],2)
                            + Math.pow(super.getY()-yPoints[0],2));
        myRectangle rectangle1 = new myRectangle(super.getX(),super.getY(),color1,
                            2*halfHeight,2*halfHeight);

        return rectangle1;
    }
}
