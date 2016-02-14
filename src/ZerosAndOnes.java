import java.util.Scanner;

public class ZerosAndOnes {
	private static Scanner sc;
	private static String firstLine;
	private static int queryNumber = 0;
	private static int caseNumbers = 1;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			firstLine = sc.nextLine();

			if (firstLine.isEmpty())
				break;

			System.out.println("Case " + caseNumbers + ":");
			caseNumbers++;

			char[] arr = firstLine.toCharArray();
			int[] aux = new int[firstLine.length()];

			int soma1 = 0;
			int soma0 = 0;

			for (int i = 0; i < arr.length; i++) {
				int valor = Integer.parseInt(String.valueOf(arr[i]));

				if (valor == 0) {
					soma0 += 1;
					aux[i] = soma0;
					soma1 = 0;
				} else {
					soma1 += 1;
					aux[i] = soma1;
					soma0 = 0;
				}
			}

			queryNumber = Integer.parseInt(sc.nextLine());

			for (int i = 0; i < queryNumber; i++) {
				String[] arrayQuery = sc.nextLine().split(" ");

				int position1 = Integer.parseInt(arrayQuery[0]);
				int position2 = Integer.parseInt(arrayQuery[1]);

				int quant = 0;
				int total = 0;
				if (position1 > position2) {
					quant = position1 - position2;
					total = aux[position1] - aux[position2];
				} else {
					quant = position2 - position1;
					total = aux[position2] - aux[position1];
				}

				if (total == quant)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
		}
	}
}
