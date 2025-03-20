package d.recursion;

public class Fibonacci {
	//secuencia de Fibonacci (iterativo y recursivo)
	public static int fibonacci(int n) {
		if(n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static int fibonacci2(int n) {
		if(n < 2) {
			return n;
		}
		int suma = n - 1 + n - 2;
		return suma;
	}

	public static void main(String[] args) {
        int serie = 10;
        
        for (int i = 0; i < serie; i++) {
            System.out.print(fibonacci(i));
        }
        System.out.println();
        for (int i = 0; i < serie; i++) {
			System.out.print(fibonacci(i));
		}
	}
}
