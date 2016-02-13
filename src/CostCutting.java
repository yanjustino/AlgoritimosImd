import java.util.Arrays;
import java.util.Scanner;

public class CostCutting {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		sc.nextLine();
		int caseNumber = 1;

		while (sc.hasNextLine()) {
			String[] numbers = sc.nextLine().split(" ");
			Arrays.sort(numbers);

			System.out.format("Case %s: %s%n", caseNumber, numbers[1]);
			caseNumber++;
		}
	}
}
