package ex5;

public class Box<T extends Comparable<T>> {

    private T store;

    public Box(T store) {
        this.store = store;
    }

    private String getStorageType() {
        return this.store.getClass().getName();
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getStorageType(), this.store);
    }

    public int compareTo(Box<T> o) {
        return this.store.compareTo(o.store);
    }
}
