// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(9,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = 0;
		//I did it in an inefficient way but the instructions told me it's fine:)
		for(int i = 0; i < abs(x1); i++) {
		    if(x1 > 0)
				sum++;
			else if (x1 < 0)
				sum--;
		}
		for(int j = 0; j < abs(x2); j++)
			 if(x2 > 0)
				sum++;
			 else if (x2 < 0)
				sum--;
		
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int differnce = x1;
		for (int i = 0; i < abs(x2); i++) {
		 	if(x2 > 0)
				differnce--;
			else if (x2 < 0)
				differnce++;
		}	
		return differnce;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mult = 0;
		for(int i = 0; i < abs(x1) ; i++)
			for(int j = 0; j < abs(x2); j++)
				mult++;
		if(x1 < 0 ^ x2 < 0)
		mult = turnToNegative(mult);
		return mult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int power = 1;
		for(int i =0; i < n; i++) {
			power = times(power, x);
		}
		if(mod(n, 2) == 0)
			power =abs(power);
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int div = 1; 
		boolean flag = true;
		if(x1 == 0)
			return 0;
		while (abs(times(x2, div)) < abs(x1) && flag) {
				div++;
		if(abs(times(div, x2)) > abs(x1)){
				div--;
				flag = false;
		}
		}
		if(x1 < 0 ^ x2 < 0)
			div = turnToNegative(div);
		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		return abs(minus(x1,times(x2, div(x1, x2))));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 0; 
		if(x > 0) {
		boolean flag = true;
		while (pow(root, 2) < x && flag) {
				root++;
		if(pow(root, 2) > x) {
				root--;
				flag = false;
				}
			}
		}	
		return root;
	 }

	public static int turnToNegative(int x) {
			return minus(0, x);
	}
    public static int abs(int x) {
		int sum = 0;
		if(x >= 0)
			return x;
		else
			for (int i = 0; i > x; i--) { 
				sum++;
			}
			return sum;
	}

	  
}