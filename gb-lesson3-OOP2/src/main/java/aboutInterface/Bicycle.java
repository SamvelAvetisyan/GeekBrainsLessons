package aboutInterface;

public class Bicycle implements Transport {
    @Override
    public void start() {
        System.out.println("bicycle start");
    }

    @Override
    public void stop() {
        System.out.println("bicycle stop");
    }
}
