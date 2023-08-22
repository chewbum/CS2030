/*import java.util.stream.Stream;

class Test {
    public void executeStream(Stream<Integer> stream) {};
    public void executeStream(Stream<String> stream) {};
}

*/

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

class ImList<T> {
    private final Supplier<List<T>> list;

    private ImList(Supplier<List<T>> list) {
        this.list = list;
    }

    ImList() {
        this.list = () -> new ArrayList<T>();
    }

    private ImList(List<? extends T> list) {
        this.list = () -> new ArrayList<T>(list);
    }

    ImList<T> add(T t) {

        Supplier<List<T>> innerList = () -> {
            System.out.println("Adding: " + t);
            List<T> l = this.list.get();
            l.add(t);
            return l;
        };

        ImList<T> result = new ImList<T>(innerList);
        return result;
    }

    ImList<T> set(int index, T t) {
        Supplier<List<T>> innerList = () -> {
            System.out.println("Setting: " + index + ", " + t);
            List<T> l = this.list.get();
            l.set(index, t);
            return l;
        };
        ImList<T> result = new ImList<T>(innerList);
        return result;
    }

    T get(int index) {
    return this.list.get().get(index);
    }

    @Override
    public String toString() {
    return "ImList";
    }
}

