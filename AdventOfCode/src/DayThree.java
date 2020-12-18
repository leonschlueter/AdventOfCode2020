import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayThree {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("daythree_input"));
		String[] array = readInput(scanner);
		scanner.close();
		System.out.println(Arrays.toString(array));
		long a = slopeCheck(1, 1, array);
		long b = slopeCheck(1, 3, array);
		long c = slopeCheck(1, 5, array);
		long d = slopeCheck(1, 7, array);
		long e = slopeCheck(2, 1, array);

		System.out.println(a * b * c * d * e);
	}

	private static String[] readInput(Scanner scanner) {
		// TODO Auto-generated method stub
		String[] array = new String[323];
		for (int i = 0; i < 323; i++) {
			array[i] = scanner.next();
			// scanner.nextLine();
		}
		return array;
	}

	private static int slopeCheck(int down, int side, String[] array) {
		int treeCounter = 0;

		int height = 0;
		int width = 0;
		String tree = "#";
		while (height != array.length - 1) {
			height = height + down;
			width = width + side;
			if (width > array[0].length() - 1) {
				width = width - array[0].length();
			}
			if (tree.equals((String.valueOf((array[height].charAt(width)))))) {
				treeCounter++;
			}
		}
		return treeCounter;
	}
}
