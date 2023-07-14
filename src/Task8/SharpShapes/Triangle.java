package Task8.SharpShapes;

public class Triangle extends SharpShapes {
    private double height;

    public Triangle(String name, String color, double sideX, double sideY, double height) {
        super(name, color, sideX, sideY);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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
        sideX = sideX * scale;
        sideY = sideY * scale;
        height = height * scale;
    }

    @Override
    public void sharpActions() {
        System.out.println("Я треугольник и могу склеиваться своими плоскими гранями");
    }

    @Override
    protected String showName() {
        return name;
    }

    @Override
    public double getSideX() {
        return sideX;
    }

    @Override
    public double getSideY() {
        return sideY;
    }
}
