import java.util.Scanner;
import java.util.Stack;

public class ParenthesesBalance {

	private static Scanner scanner;
	private static String currentLine;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		UpdateCurrentLine();

		while (scanner.hasNextLine()) {
			UpdateCurrentLine();

			if (balanced())
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

	private static boolean balanced() {
		Stack<Character> stack = new Stack<Character>();

		for (char value : currentLine.trim().toCharArray()) {
			if (isOpenCharacter(value)) {
				stack.push(value);
			} else if (isCloseParen(value)) {
				if (stack.isEmpty() || !isOpenParen(stack.pop()))
					return false;
			} else if (isCloseBracket(value)) {
				if (stack.isEmpty() || !isOpenBracket(stack.pop()))
					return false;
			}
		}

		return stack.isEmpty();
	}

	private static boolean isOpenCharacter(char item) {
		return item == '(' || item == '[';
	}

	private static boolean isCloseBracket(char item) {
		return item == ']';
	}

	private static boolean isOpenBracket(char item) {
		return item == '[';
	}

	private static boolean isOpenParen(char item) {
		return item == '(';
	}

	private static boolean isCloseParen(char item) {
		return item == ')';
	}

	private static void UpdateCurrentLine() {
		currentLine = scanner.nextLine();
	}

}
