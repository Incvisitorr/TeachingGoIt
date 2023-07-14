package Task8.SharpShapes;

public class Rhombus extends SharpShapes {
    private double corner;

    public Rhombus(String name, String color, double sideX, double sideY, double corner) {
        super(name, color, sideX, sideY);
        this.corner = corner;
    }

    public double getCorner() {
        return corner;
    }

    public void setCorner(double corner) {
        this.corner = corner;
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
    public void sharpActions() {
        System.out.println("Я ромб и могу склеиваться своими плоскими гранями");
    }

    @Override
    protected String showName() {
        return name;
    }
}
