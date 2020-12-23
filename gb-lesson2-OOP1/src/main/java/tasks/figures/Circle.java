package tasks.figures;

class Circle extends AbstractFigures {
    public double radius;
    public double perimeterCircle;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        perimeterCircle = Math.PI * 2 * radius;
        return perimeterCircle;
    }
}
