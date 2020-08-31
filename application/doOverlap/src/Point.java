public class Point {
    public double xPoint;
    public double yPoint;

    Point(double xPoint, double yPoint){
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    //toString() method
    @Override
    public String toString(){
        return String.format("Point (x,y): (%.2f,%.2f)",xPoint,yPoint);
    }

}
