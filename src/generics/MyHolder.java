package generics;

public class MyHolder<T> {

    public MyHolder() {
    }

    public MyHolder(T element) {
        this.element = element;
    }

    private T element;

    public T getElement() {
        return element;
    }

    public MyHolder setElement(T element) {
        this.element = element;
        return this;
    }
}
