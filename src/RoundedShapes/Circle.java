package RoundedShapes;

public class Circle extends RoundedShapes {
    public Circle(String name, String color, double radius) {
        super(name, color, radius);
    }

    @Override
    protected double getRadius() {
        return radius;
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
        radius = radius * scale;
    }

    @Override
    public void roundAction() {
        System.out.println("Я круг и могу центрироваться по центру и склеивать грань по касательной");
    }

    @Override
    protected String showName() {
        return name;
    }
}
