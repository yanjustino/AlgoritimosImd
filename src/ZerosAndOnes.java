import java.util.Scanner;

public class ZerosAndOnes {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		String firstLine = "";
		int queryNumber = 0;
		int caseNumbers = 1;

		while (sc.hasNextLine()) {

			firstLine = sc.nextLine();
			char[] arrayfirstLine = firstLine.toCharArray();
			int[] arrayline = new int[firstLine.length()];

			if (!firstLine.equals("")) {
				System.out.println("Case " + caseNumbers + ":");
				caseNumbers++;
			}
			
			int soma1 = 0;
			int soma0 = 0;
			
			for (int i = 0; i < arrayfirstLine.length; i++) {
				int valor = Integer.parseInt(String.valueOf(arrayfirstLine[i]));
				
				if(valor == 0)
				{
					soma0 += 1;
					arrayline[i] = soma0;
					soma1 = 0;
				}
				else
				{
					soma1 += 1;
					arrayline[i] = soma1;
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
				if (position1 > position2)
				{
					quant = position1 - position2;
					total = arrayline[position1] - arrayline[position2];
				}
				else
				{
					quant = position2 - position1;
					total = arrayline[position2] - arrayline[position1];
				}
				
				if (total == quant)
					System.out.println("Yes");
				else
					System.out.println("No");

			}

		}
	}
}
