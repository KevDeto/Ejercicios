package d.recursion;

public class Potencia {
	//Potencia de un número usando recursión (a^b)
	
	public static int potencia(int baseNum, int exponente) {
		if(exponente == 0) {
			return 1;
		}
		if(exponente == 1) {
			return baseNum;
		}
		return baseNum * potencia(baseNum, exponente - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(potencia(2, 10));
	}
}
