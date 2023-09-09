package RoundedShapes;
import Board.Shapes;
public abstract class RoundedShapes extends Shapes implements RoundActions {
    protected double radius;

    public RoundedShapes(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    protected abstract double getRadius();
}
