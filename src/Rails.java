import java.util.Scanner;
import java.util.Stack;

public class Rails {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			if (!finishTestOrFile(line)) {
				int numberOfCoaches = Integer.parseInt(line);

				while (true) {
					line = sc.nextLine();

					if (finishTestOrFile(line)) {
						System.out.println();
						break;
					}

					printIfItIsPossibleMarshalTheCoaches(getStationAfterReorganized(line, numberOfCoaches));
				}
			}
		}
	}

	private static Boolean finishTestOrFile(String line) {
		return line.equals("0");
	}

	private static Stack<Integer> getStationAfterReorganized(String line, int numberOfCoaches) {
		int[] coaches = getCoaches(line.split(" "), numberOfCoaches);

		int pointer = 0;
		Stack<Integer> station = new Stack<Integer>();
		for (int current = 1; current <= numberOfCoaches; ++current) {
			pointer = tryMarshal(coaches, pointer, station, current);
		}

		return station;
	}

	private static int tryMarshal(int[] coaches, int pointer, Stack<Integer> station, int current) {
		station.push(current);
		while (!station.isEmpty() && station.peek() == coaches[pointer]) {
			station.pop();
			++pointer;
		}
		return pointer;
	}

	private static int[] getCoaches(String[] coachesLabels, int numberOfCoaches) {
		int[] coaches = new int[numberOfCoaches];

		for (int i = 0; i < numberOfCoaches; ++i)
			coaches[i] = Integer.parseInt(coachesLabels[i]);

		return coaches;
	}

	private static void printIfItIsPossibleMarshalTheCoaches(Stack<Integer> station) {
		if (station.isEmpty())
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
