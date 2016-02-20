import java.util.Scanner;
import java.util.Stack;

public class Rails {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			int numberOfCoaches = Integer.parseInt(line);

			while (true) {
				line = sc.nextLine();

				if (finishTestOrFile(line))
					break;

				printIfIsPossibleMarshalTheCoaches(getStationAfterReorganized(line, numberOfCoaches));
			}

			System.out.println();
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

	private static int[] getCoaches(String[] coachesLabels, int numberOfCoaches) {
		int[] coaches = new int[numberOfCoaches];

		for (int i = 0; i < numberOfCoaches; ++i)
			coaches[i] = Integer.parseInt(coachesLabels[i]);

		return coaches;
	}

	private static int tryMarshal(int[] coaches, int pointer, Stack<Integer> station, int current) {
		station.push(current);

		/*
		 * Enquanto a estação não estiver vazia e se o vagão em cima da pilha é
		 * igual indíce do ponteiro, retire o vagão da pilha e atualize o
		 * ponteiro
		 */
		while (!station.isEmpty() && station.peek() == coaches[pointer]) {
			station.pop();
			++pointer;
		}

		return pointer;
	}

	private static void printIfIsPossibleMarshalTheCoaches(Stack<Integer> station) {
		if (station.isEmpty())
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
