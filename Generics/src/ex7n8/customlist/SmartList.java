package ex7n8.customlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmartList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    public SmartList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int f, int s) {
        T temp = this.data.get(f);

        this.data.set(f, this.data.get(s));
        this.data.set(s, temp);
    }

    public int greaterThan(T element) {

        return this.data.stream()
                .filter(e -> e.compareTo(element) > 0)
                .toArray()
                .length;

    }

    public T getMaxElement() {
        return this.data.stream()
                .max(T::compareTo)
                .get();
    }

    public T getMinElement() {
        return this.data.stream()
                .min(T::compareTo)
                .get();
    }

    /**
     * public void forEach(Consumer<T> consumer) {
     * for (T datum : this.data) {
     * consumer.accept(datum);
     * }
     * }
     */

    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
