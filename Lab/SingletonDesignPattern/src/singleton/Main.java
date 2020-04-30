package singleton;

public class Main {

    public static void main(String[] args) {
	    for (int i = 0; i < 200; i++) {
            SingletonFibonacci singletonFibonacci = SingletonFibonacci.getFibonacci();
	        System.out.printf("%dth: Fibonacci number is:%s\n", i, singletonFibonacci.next().toString());
        }
    }
}
