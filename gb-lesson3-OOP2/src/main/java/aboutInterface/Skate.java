package aboutInterface;

public class Skate implements Transport {
    @Override
    public void start() {
        System.out.println("skate start");
    }

    @Override
    public void stop() {
        System.out.println("skate stop");
    }
}
