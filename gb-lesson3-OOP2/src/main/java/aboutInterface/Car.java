package aboutInterface;

public class Car implements Transport {
    @Override
    public void start() {
        System.out.println("car start");
    }

    @Override
    public void stop() {
        System.out.println("car stop");
    }
}
