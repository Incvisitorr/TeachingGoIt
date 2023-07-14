package Task8.Board;

public abstract class Shapes implements Colorable, Scale {
    protected String name;
    protected String color;

    Shapes() {
    }

    public Shapes(String name, String color) {
        this.name = name;
        this.color = color;
    }

    protected abstract String showName();

    @Override
    public abstract String getColor();
}
