package tasks;

public class Treadmill implements Obstacle {

    private final int length;

    public int getLength() {
        return length;
    }

    public Treadmill(int length) {

        this.length = length;
    }
}
