/*
 * Author: Brendon Baughn
 * Version: 1.2.4;
 */
import java.util.Scanner;
public class VowelCounter {
	
	/*
	 * Did NOT name these "LOWERCASE" and "UPPERCASE" because
	 * this is shorter and easier
	 */
	private static String lvowels = "aeiou"; // Lowercase Vowels
	private static String uvowels = "AEIOU"; // Uppercase Vowels

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String str = in.nextLine();

		if (str.length() == 0 || str.isEmpty()) {
			System.out.println("Must enter a string!");
			System.out.print("Enter a string: ");
			str = in.nextLine();
		}
		String foundv = "";
		int counter = 0;
		for (int i = 0; i < str.length(); ++i) { // For Length of String
			if (Character.isLowerCase(str.charAt(i))) { // If Lowercase
				for (int j = 0; j < lvowels.length(); ++j) { // For Length of Lowercase Vowels
					if (str.charAt(i) == lvowels.charAt(j)) { // If String Character == Lowercase Vowels Character
						if (foundv.length() > 0) { // If Vowels are already found
							int num = 0;
							for (int k = 0; k < foundv.length(); ++k) { // For Rotating Through Found Vowels
								 // If Character of Vowel (Changes Through Each Iteration) != Character of String (Static)
								if (foundv.charAt(k) != str.charAt(i)) {
									++num;
									if (num == foundv.length()) { // If We Found a New Vowel
										foundv = foundv + Character.toString(str.charAt(i));
									}
								}
							}
						} else { // First Vowel Found
							foundv = foundv + Character.toString(str.charAt(i));
						}
						++counter; // Always Increase Counter to Count Each Vowel
					}
				}
			} else if (Character.isUpperCase(str.charAt(i))) { // Same Concept Down Below
				for (int j = 0; j < uvowels.length(); ++j) {
					if (str.charAt(i) == uvowels.charAt(j)) {
						if (foundv.length() > 0) {
							int num = 0;
							for (int k = 0; k < foundv.length(); ++k) {
								if (foundv.charAt(k) != str.charAt(i)) {
									++num;
									if (num == foundv.length()) {
										foundv = foundv + Character.toString(str.charAt(i));
									}
								}
							}
						} else {
							foundv = foundv + Character.toString(str.charAt(i));
						}
						++counter;
					}
				}
			}
		}

		if (foundv.length() > 0) {
			System.out.println("Found Vowels: " + foundv);
			System.out.println("Number of Vowels: " + counter);
		} else {
			System.out.println("No Vowels");
		}

		in.close();
	}

}
