import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

interface Filter<T> {
    boolean accept(T x);
}

public class ShortWordFilter implements Filter<String> {

    @Override
    public boolean accept(String word) {
        return word.length() < 5;
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
