package Task8.RoundedShapes;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(String name, String color, double radius, double height) {
        super(name, color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHight(double height) {
        this.height = height;
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
        System.out.println("Я цилиндр и могу центрироваться по центру и склеивать грань по касательной");
    }

    @Override
    protected String showName() {
        return name;
    }

}
