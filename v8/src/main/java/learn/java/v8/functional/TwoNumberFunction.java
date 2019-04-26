package learn.java.v8.functional;

public interface TwoNumberFunction {

    static TwoNumberFunction subtract() {
        return (i, j) -> new Double(i - j);
    }

    public abstract Double operation(int i, int j);

    public static TwoNumberFunction add() {
        return (i, j) -> new Double(i + j);
    }
}
