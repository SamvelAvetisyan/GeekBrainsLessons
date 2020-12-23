package tasks;

public class TemperatureConverter {
    public double c;
    public double converter(double c) {
        if (c > (-273.15)) {
            return c - 36;
        } else {
            throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля");
        }
    }
}
