import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class CdTwo {

	private static Scanner scanner;
	private static String currentLine;
	private static Set<Integer> map;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			UpdateCurrentLine();

			StringTokenizer stk = new StringTokenizer(currentLine);
			
			int jak = Integer.parseInt(stk.nextToken());
			int jil = Integer.parseInt(stk.nextToken());			

			if (jak == 0 && jil == 0)
				break;

			int equals = calculate(jak, jil);

			System.out.println(equals);
		}
	}

	private static int calculate(int jack, int jil) {
		map = new HashSet<Integer>();

		for (int i = 0; i < jack; i++) {
			UpdateCurrentLine();
			map.add(Integer.parseInt(currentLine));
		}

		int equals = 0;
		for (int i = 0; i < jil; i++) {
			UpdateCurrentLine();

			if (map.contains(Integer.parseInt(currentLine)))
				++equals;
		}

		return equals;
	}

	private static void UpdateCurrentLine() {
		currentLine = scanner.nextLine();
	}
}
