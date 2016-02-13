import java.util.Scanner;

public class MotherBear {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String frase = sc.nextLine().replaceAll(" ", "").replaceAll("[!.,?]", "").toLowerCase();

			String palindromes = "";

			for (int j = frase.length() -1; j >= 0; j--) {
				palindromes += frase.toCharArray()[j];
			}
			
			if (frase.equals(palindromes)) System.out.println("You won't be eaten!");
			else System.out.println("Uh oh..");
		}
	}
}
