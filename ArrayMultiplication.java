//Лабораторна робота 4

import java.util.Arrays;

public class ArrayMultiplication {
    public static void main(String[] args) {
        int n = 10000;
        int sleep = 0; // Значення затримки

        int[] input1 = new int[n];
        int[] input2 = new int[n];
        int[] result = new int[n];

        // Заповнення масивів випадковими числами від 0 до 100
        for (int i = 0; i < n; i++) {
            input1[i] = (int) (Math.random() * 101);
            input2[i] = (int) (Math.random() * 101);
        }

        // Традиційний синхронний підхід з затримкою
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            result[i] = input1[i] * input2[i];
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long syncTime = System.currentTimeMillis() - time1;
        System.out.printf("Sync: %d ms\n", syncTime);

        // Parallel stream підхід з затримкою
        long time2 = System.currentTimeMillis();
        Arrays.parallelSetAll(result, i -> {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return input1[i] * input2[i];
        });
        long parallelTime = System.currentTimeMillis() - time2;
        System.out.printf("Parallel: %d ms\n", parallelTime);
    }
}
