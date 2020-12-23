package tasks.figures;

public class Rect extends AbstractFigures {
    double a;
    double b;
    double perimeterRect;

    Rect(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double perimeter() {
        perimeterRect = 2 * (a + b);
        return perimeterRect;
    }
}
