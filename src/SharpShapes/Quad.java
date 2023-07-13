package SharpShapes;

import Board.Shapes;





public class Quad extends SharpShapes {

    public Quad(String name, String color, double sideX, double sideY) {
        super(name, color, sideX, sideY);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void scale(int scale) {
        sideY = sideY * scale;
        sideX = sideX * scale;
    }

    @Override
    public void sharpActions() {
        System.out.println("Я квадрат и могу склеиваться своими плоскими гранями");
    }

    @Override
    public double getSideX() {
        return sideX;
    }

    @Override
    public double getSideY() {
        return sideY;
    }

    @Override
    protected String showName() {
        return name;
    }
}

