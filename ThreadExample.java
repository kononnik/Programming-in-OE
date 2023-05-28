//Лабораторна робота 5

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class ThreadExample {
    private static volatile int counter = 0;
    private static final int MAX_COUNTER_VALUE = 240;
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (counter <= MAX_COUNTER_VALUE) {
                writeToFile("Thread 1", counter);
                counter++;
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            while (counter <= MAX_COUNTER_VALUE) {
                writeToFile("Thread 2", counter);
                counter++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread thread3 = new Thread(() -> {
            while (counter <= MAX_COUNTER_VALUE) {
                writeToFile("Thread 3", counter);
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    private static synchronized void writeToFile(String threadName, int counter) {
        try (FileWriter fileWriter = new FileWriter("output.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            LocalTime currentTime = LocalTime.now();
            String output = String.format("%s - %s: Counter = %d", currentTime, threadName, counter);
            printWriter.println(output);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
