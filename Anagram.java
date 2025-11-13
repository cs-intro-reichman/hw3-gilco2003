/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am m weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  
	public static int numRepeatition(String str, char c){
		int counter = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)
				counter++;
		}
		return  counter;
	}
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess2(str1).toLowerCase();
		str2 = preProcess2(str2).toLowerCase();
		if(str1.length() != str2.length())
			return false;
		for(int i=0; i < str1.length(); i++){
			if(numRepeatition(str2, str1.charAt(i)) != numRepeatition(str1,  str1.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		if(str == null ) return "";
		/*String newStr = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) !=  ' ' && str.charAt(i) !=  '\n' && str.charAt(i) !=  '\r' && str.charAt(i) !=  '\t')
				newStr += str.charAt(i);
		}*/
		return str.toLowerCase();
	} 
		public static String preProcess2(String str) {
		if(str == null ) return "";
		String newStr = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) !=  ' ' && str.charAt(i) !=  '\n' && str.charAt(i) !=  '\r' && str.charAt(i) !=  '\t')
				newStr += str.charAt(i);
		}
		return newStr.toLowerCase();
	} 
	//A helper function that receives a string and an index and return an identical string without the character at said index.
	   public static String removeAtIndex(String str, int index) {
		String newStr = "";
		for(int i = 0; i<str.length();i++){
			if(i != index)
				newStr += str.charAt(i);
		}
		return newStr;
	   }
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		if(str == null ) return "";
		str = preProcess2(str);
		String newStr = "";
		int length = str.length();
		int rand; 
		//iteraitin over the string, adding a new character from the string each iteration 
		//and removing it from the og string in order to not repeat it
		while (length > 0) {
			rand = (int)(Math.random()*(length));
			newStr += str.charAt(rand);
			str = removeAtIndex(str, rand);
			length --;
		}
		
		return newStr;
	}
}
