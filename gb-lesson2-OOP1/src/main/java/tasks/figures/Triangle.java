package tasks.figures;

public class Triangle extends AbstractFigures {
    public double a;
    public double b;
    public double c;
    public double perimeterTriangle;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double perimeter() {
        perimeterTriangle = a + b + c;
        return perimeterTriangle;
    }
}