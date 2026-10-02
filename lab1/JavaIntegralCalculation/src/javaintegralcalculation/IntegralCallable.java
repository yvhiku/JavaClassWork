package javaintegralcalculation;

import java.util.concurrent.Callable;

public class IntegralCallable implements Callable<Double> {

    private final double low;
    private final double high;
    private final double step;

    public IntegralCallable(double low, double high, double step) {
        this.low = low;
        this.high = high;
        this.step = step;
    }

    @Override
    public Double call() {

        double start = low;
        double result = 0.0;

        while (start < high) {

            double h = Math.min(step, high - start);

            result += h
                    * (Math.sin(start)
                    + Math.sin(start + h)) / 2;

            start += h;
        }

        System.out.println(
                Thread.currentThread().getName()
                + " calculated: " + result);

        return result;
    }
}