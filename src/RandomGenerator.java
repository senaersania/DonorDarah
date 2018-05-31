import java.util.Random;

public class RandomGenerator {
    private double min;
    private double max;
    private Random _r;

    public RandomGenerator(double min, double max) {
        _r = new Random();
        this.min = min;
        this.max = max;
    }

    public double getValue() {
       double value = min + (max - min) * _r.nextDouble();
       return value;
    }
}
