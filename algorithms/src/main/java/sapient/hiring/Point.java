package sapient.hiring;

import java.util.Objects;

public class Point {
    private int xcordinate;
    private int ycordinate;

    public Point(int xcordinate, int ycordinate) {
        this.xcordinate = xcordinate;
        this.ycordinate = ycordinate;
    }

    public int getXcordinate() {
        return xcordinate;
    }

    public int getYcordinate() {
        return ycordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return xcordinate == point.xcordinate &&
                ycordinate == point.ycordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xcordinate, ycordinate);
    }

    @Override
    public String toString() {
        return "Point{" +
                "xcordinate=" + xcordinate +
                ", ycordinate=" + ycordinate +
                '}';
    }
}
