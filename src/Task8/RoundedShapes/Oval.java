package RoundedShapes;

public class Oval extends RoundedShapes {
    private double radiusSide;

    public Oval(String name, String color, double radius, double radiusSide) {
        super(name, color, radius);
        this.radiusSide = radiusSide;
    }

    public double getRadiusSide() {
        return radiusSide;
    }

    public void setRadiusSide(double radiusSide) {
        this.radiusSide = radiusSide;
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
        radiusSide = radiusSide * scale;
    }

    @Override
    public void roundAction() {
        System.out.println("Я овал и могу центрироваться по центру и склеивать грань по касательной");
    }

    @Override
    protected double getRadius() {
        return radius;
    }

    @Override
    protected String showName() {
        return name;
    }
}
