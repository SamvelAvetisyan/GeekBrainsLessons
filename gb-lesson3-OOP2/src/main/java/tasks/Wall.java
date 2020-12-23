package tasks;

public class Wall implements Obstacle {
    private final int height;

    public int getHeight() {
        return height;
    }

    public Wall(int height) {

        this.height = height;
    }
}
