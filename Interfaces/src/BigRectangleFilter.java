import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BigRectangleFilter implements Filter<Rectangle> {

    @Override
    public boolean accept(Rectangle rectangle) {
        double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
        return perimeter > 10;
    }
    public static List<Rectangle> createRectangles() {
        List<Rectangle> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(2, 3));    // Perimeter: 10
        rectangles.add(new Rectangle(2, 2));    // Perimeter: 8
        rectangles.add(new Rectangle(5, 5));    // Perimeter: 20
        rectangles.add(new Rectangle(3, 7));    // Perimeter: 20
        rectangles.add(new Rectangle(1, 1));    // Perimeter: 4
        rectangles.add(new Rectangle(1, 2));    // Perimeter: 6
        rectangles.add(new Rectangle(8, 3));    // Perimeter: 22
        rectangles.add(new Rectangle(2, 9));    // Perimeter: 22
        rectangles.add(new Rectangle(4, 4));    // Perimeter: 16
        rectangles.add(new Rectangle(7, 7));    // Perimeter: 28

        return rectangles;
    }

    public static <T> List<T> collectAll(List<T> objects, Predicate<T> filter) {
        List<T> acceptedObjects = new ArrayList<>();

        for (T obj : objects) {
            if (filter.test(obj)) {
                acceptedObjects.add(obj);
            }
        }

        return acceptedObjects;
    }

}
