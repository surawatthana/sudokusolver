import java.util.Objects;

public class Range {
    private final Byte MIN;
    private final Byte MAX;

    public Range(Byte MIN, Byte MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
    }

    public Byte getMIN() {
        return MIN;
    }

    public Byte getMAX() {
        return MAX;
    }

    public boolean isBetweenRange(byte number) {
        return number >= MIN && number <= MAX ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return MIN.equals(range.MIN) && MAX.equals(range.MAX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN, MAX);
    }
}
