package de.dhbwka.theoinf.datenstukturen;

/**
 * Created by cem on 19.06.16.
 */
public class JList<T> {

    private T value;
    private JList<T> next;

    public JList(T value) {
        this.value = value;
    }

    public JList() {
    }

    public void append(T newValue) {
        if (value == null) value = newValue;
        else if (next == null) next = new JList<T>(newValue);
        else next.append(newValue);
    }

    public boolean contains(T value) {
        return this.value.equals(value) || next != null && next.contains(value);
    }

    public int length() {
        return lengthWorker(1);
    }

    private int lengthWorker(int count) {
        if (next == null) return count;
        else return next.lengthWorker(count + 1);
    }

    public T get(int number) {
        if (number == 0) return value;
        else if (next == null) return null;
        else return next.get(number - 1);
    }

    public void delete(T element) {
        if (value == element) {
            value = next.value;
            next = next.next;
        } else if (next != null) next.delete(element);
    }

}
