//Лабораторна робота 3

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FibonacciAsync {
    public static void main(String[] args) {
        int n = 10; // Задане n

        CompletableFuture<Integer> fibonacciFuture = CompletableFuture.supplyAsync(() -> fibonacci(n));

        System.out.println("Очікування завершення обчислень...");

        try {
            int result = fibonacciFuture.get(); // Очікування результату
            System.out.println("Результат: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
