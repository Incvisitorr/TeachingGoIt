package Task8.SharpShapes;

import Task8.Board.Shapes;

abstract class SharpShapes extends Shapes implements SharpActions {
    protected double sideX;
    protected double sideY;

    public SharpShapes(String name, String color, double sideX, double sideY) {
        super(name, color);
        this.sideX = sideX;
        this.sideY = sideY;
    }

    public abstract double getSideX();

    public abstract double getSideY();
}
