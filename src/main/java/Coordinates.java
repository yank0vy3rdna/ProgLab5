import java.util.Objects;

public class Coordinates {
    private Double x; //Поле не может быть null
    private float y;

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Coordinates(Double x, float y) throws IllegalArgumentException, NullPointerException{
        this.x = Objects.requireNonNull(x,"invalid x");
        this.y = y;
    }
}
