package tasks.figures;

public class Square extends AbstractFigures{
    double a;
    double perimeterSquare;
    @Override
    public double perimeter() {
        perimeterSquare = 4 * a;
        return perimeterSquare;
    }
}