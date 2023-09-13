import java.awt.*;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {

        List<Rectangle> rectangles = BigRectangleFilter.createRectangles();

        BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();

        List<Rectangle> bigRectangles = BigRectangleFilter.collectAll(rectangles, bigRectangleFilter::accept);

        System.out.println("Big rectangles:");
        for (Rectangle rect : bigRectangles) {
            System.out.println("Width: " + rect.getWidth() + ", Height: " + rect.getHeight());
        }
    }


}
