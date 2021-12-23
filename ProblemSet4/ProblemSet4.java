
public class ProblemSet4 {
	
	/********************************
	Name: Noah Buchanan
	Username: ua203
	Problem Set: PS4
	Due Date: June 26, 2020
	********************************/
	
	public static void main(String[] args) {
		
		System.out.println(addFive(0,0));
		System.out.println(findGreatestCommonDivisor(250,90));
		System.out.println(printVowels("uafscomp",0,""));
		
	}
	
	public static int addFive(int x, int i) {
		
		if(x >= 100) {
			return i;
		} else {
			x += 5;
			return addFive(x, ++i);
		}
	}
	
	public static int findGreatestCommonDivisor(int a, int b) {
		int hold = 0;
		if(a%b == 0) {
			return b;
		} else {
			hold = a%b;
			a = b;
			b = hold;
			return findGreatestCommonDivisor(a, b);
			
		}
	}
	
	public static String printVowels(String input, int i, String output) {
		
		if(i >= input.length()) {
			return output;
		} else {
			if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
				output += input.charAt(i);
			}
			return printVowels(input, ++i, output);
		}
	}

}
