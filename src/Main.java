import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		sc.nextLine();
		int caseNumber = 1;

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] numbers = line.split(" ");
			Arrays.sort(numbers);

			System.out.format("Case %s: %s%n", caseNumber, Integer.parseInt(numbers[1]));
			caseNumber++;
		}
	}
}
