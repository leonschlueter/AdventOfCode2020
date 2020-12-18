import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("daytwo_input"));
		int valid = readNumbers(scanner);
		scanner.close();
		System.out.println(valid);
	}

	private static int readNumbers(Scanner scanner) {
		// TODO Auto-generated method stub
		int valid = 0;

		for (int i = 0; i < 1000; i++) {
			// Splits Numbers into array values[] whereas values[0] = min and values[1] =
			// max
			String numbers = scanner.next();
			String[] splittedInput = numbers.split("\\-");

			int max = Integer.parseInt(splittedInput[1]);
			int min = Integer.parseInt(splittedInput[0]);
			String letter = scanner.next();
			String password = scanner.next();
			letter = letter.substring(0, 1);

			if (checkIfValid(min, max, letter, password)) {
				valid++;
			}

		}
		return valid;
	}

	private static boolean checkIfValid(int min, int max, String letter, String password) {
		// TODO Auto-generated method stub

		String[] pw = password.split("");
		boolean a = false;
		boolean b = false;
		if (pw[min-1].equals(letter)) {
			a = true;
		}
		if (pw[max-1].equals(letter)) {
			b = true;
		}

		if ((a && !b) || (!a && b)) {
			return true;
		} else {
			return false;
		}

	}

}
