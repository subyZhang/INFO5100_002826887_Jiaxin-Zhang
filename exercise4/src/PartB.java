import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PartB {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        for (int i = 0; i < 25; i++) {
            int num = i + 1;
            executorService.submit(() -> calculatePrime(num));
        }

        for (int i = 0; i < 50; i++) {
            int num = i;
            executorService.submit(() -> calculateFibonacci(num));
        }

        for (int i = 1; i <= 50; i++) {
            int num = i;
            executorService.submit(() -> calculateFactorials(num));
        }

        executorService.shutdown();
    }

    private  static void calculatePrime(int number) {
        int count = 0;
        int num = 2;
        int result = 0;

        while (count < number) {
            boolean isPrime = true;
            for(int i = 2; i < num; i++) {
                if(num % i == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                result = num;
                count++;
            }
            num++;
        }
        System.out.printf("[%s] %s: %s Result: %d%n", new Date(), Thread.currentThread().getName(), "Prime number:",  result);
        PartB.randomDelay();
    }
    private  static void calculateFibonacci(int number) {
        int a=0;
        int b=1;
        int result = 0;
        for(int i =0;i<=number;i++){
            result=a;

            int next=a+b;
            a=b;
            b=next;


        }
        System.out.printf("[%s] %s: %s Result: %d%n", new Date(), Thread.currentThread().getName(), "Fibonacci number:",  result);
        PartB.randomDelay();
    }
    private  static void calculateFactorials(int number) {
        int result=1;
        for(int i =1;i<=number;i++){
            result=result*i;
        }
        System.out.printf("[%s] %s: %s Result: %d%n", new Date(), Thread.currentThread().getName(), "factorials "+number+":",  result);

        PartB.randomDelay();
    }

    private static void randomDelay(){
        try {
            Thread.sleep(new Random().nextInt(400)+100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
