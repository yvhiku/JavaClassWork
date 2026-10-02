package javaintegralcalculation;

public class IntegralRunnable implements Runnable {

    private final double low;
    private final double high;
    private final double step;

    private double result;

    public IntegralRunnable(double low, double high, double step) {
        this.low = low;
        this.high = high;
        this.step = step;
        this.result = 0.0;
    }

    @Override
    public void run() {

        double start = low;

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
    }

    public double getResult() {
        return result;
    }
}