package ex1n2;

public class Box<T> {

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
}
