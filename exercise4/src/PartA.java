import java.util.Date;
import java.util.Random;

public class PartA {
    public static void main(String[] args) {
        Thread primeThread = new Thread(() -> {
            int counter = 0;
            int number=2;
            while (counter < 25) {
                boolean isPrime = true;
                for(int i = 2; i < number; i++) {
                    if(number % i == 0) {
                        isPrime = false;
                    }
                }
                if(isPrime) {
                   counter++;
                    System.out.printf("[%s] %s: %s Result: %d%n", new Date(), Thread.currentThread().getName(), "Prime number:",  number);
                }
                number++;
                PartA.randomDelay();
            }

        },"primeThread");
        Thread fibonacciThread = new Thread(() -> {
            int a=0;
            int b=1;
            for(int i =1;i<=50;i++){
                System.out.printf("[%s] %s: %s Result: %d%n", new Date(), Thread.currentThread().getName(), "Fibonacci number:",  a);
                int next=a+b;
                a=b;
                b=next;
                PartA.randomDelay();

            }
        },"FibonacciThread");
        Thread factorialsThread = new Thread(() -> {
            for(int j =1;j<=50;j++){
                int result=1;
                for(int i =1;i<=j;i++){
                    result=result*i;
                }
                System.out.printf("[%s] %s: %s Result: %d%n", new Date(), Thread.currentThread().getName(), "factorials "+j+":",  result);

                PartA.randomDelay();
            }

        },"FactorialsThread");
        primeThread.start();
        fibonacciThread.start();
        factorialsThread.start();
    }
    private static void randomDelay(){
        try {
            Thread.sleep(new Random().nextInt(400)+100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
