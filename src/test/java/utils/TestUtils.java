package utils;

public class TestUtils {
    private static final int defaultDelay = 3000;

    public static void addDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addDelay() {
        try {
            Thread.sleep(defaultDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}