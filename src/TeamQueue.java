import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TeamQueue {
	private static int scenario = 1;

	private static Scanner scanner;

	private static String FINISHED_FILE = "0";
	private static String currentLine;

	private static Map<Integer, Integer> mappedTeams;
	private static List<Queue<Integer>> queues;
	private static Queue<Integer> teams;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			UpdateCurrentLine();

			if (currentLine.equals(FINISHED_FILE))
				break;

			PrintScenario();
			CreateQueues();

			while (!currentLine.equals("STOP")) {
				String[] caseLine = currentLine.split("[ ]+");

				if (caseLine[0].equals("ENQUEUE")) {
					enqueue(Integer.parseInt(caseLine[1]));
				} else if (caseLine[0].equals("DEQUEUE")) {
					dequeue();
				}

				UpdateCurrentLine();
			}

			scenario += 1;
			System.out.println();
		}
	}

	private static void CreateQueues() {
		int maxScenarioCases = Integer.parseInt(currentLine);
		
		mappedTeams = new HashMap<Integer, Integer>();
		queues = new ArrayList<Queue<Integer>>();
		teams = new LinkedList<Integer>();		

		for (int i = 0; i < maxScenarioCases; i++) {
			UpdateCurrentLine();
			String[] $cases = currentLine.split("[ ]+");
			for (int j = 1; j < $cases.length; j++) {
				int $case = Integer.parseInt($cases[j]);
				mappedTeams.put($case, i);
			}
		}		

		for (int i = 0; i < maxScenarioCases; ++i)
			queues.add(new LinkedList<Integer>());
	}

	private static void PrintScenario() {
		System.out.println("Scenario #" + scenario);
	}

	private static void UpdateCurrentLine() {
		currentLine = scanner.nextLine();
	}

	private static void enqueue(int val) {
		int team = mappedTeams.get(val);

		if (queues.get(team).isEmpty()) {
			teams.offer(team);
		}
		queues.get(team).offer(val);
	}

	private static void dequeue() {
		if (!teams.isEmpty()) {
			int team = teams.peek();
			int val = queues.get(team).poll();
			System.out.println(val);

			if (queues.get(team).isEmpty())
				teams.poll();
		}
	}

}
