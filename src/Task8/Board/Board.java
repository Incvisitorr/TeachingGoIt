package Task8.Board;

import Task8.RoundedShapes.*;
import Task8.SharpShapes.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    public static void main(String[] args) {
        Shapes oval = new Oval("Oval", "Red", 15, 10);
        Shapes circle = new Circle("Circle", "Blue", 20);
        Shapes cylinder = new Cylinder("Cylindr", "Orange", 7, 12);
        Shapes quade = new Quad("Quad", "Neon", 4, 7);
        Shapes rhombus = new Rhombus("Rhombus", "Black", 7, 8, 15);
        Shapes triangle = new Triangle("Triangle", "Dark", 15, 15, 10);

        ArrayList<Shapes> shapesList = new ArrayList<>(Arrays.asList(oval, circle, cylinder, quade, rhombus, triangle));
        for (Shapes shape : shapesList) {
            if (shape instanceof RoundedShapes) {
                System.out.println("Я круглый обьект - " + shape.name+" мой цвет "+shape.getColor());
            } else System.out.println("Я обьект с острыми краями - " + shape.name+" мой цвет "+shape.getColor());
        }
    }
}





