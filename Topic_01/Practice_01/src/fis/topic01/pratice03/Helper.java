package fis.topic01.pratice03;

public class Helper {
	
	public static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return s*s == x;
	}
	public static boolean isFibonacci(int n) {
		// n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both is perfect square
		return isPerfectSquare(5*n*n+4) || isPerfectSquare(5*n*n-4);
	}
	
	public static boolean isPrime(int n) {
		if(n < 2) {
			return false;
		}
		for(int i =2; i <= (int) Math.sqrt(n);i++) {
			if (n%i == 0) {
				return false; 
			} 
		}
		return true;
	}
	public static int calculateTriangularNumber(int n) {
		return n*(n+1)/2;
	}
	
	
}
