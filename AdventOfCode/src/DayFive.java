import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DayFive {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("05DayInput"));
		ArrayList<String> array = readInput(scanner);
		scanner.close();
		int[] ids = calcMaxFromArray(array);
		Arrays.sort(ids);
		System.out.println(Arrays.toString(ids));
		int diff = 0;
		for (int i = 11; i < 851; i++) {
			System.out.println(i + " "+ Arrays.binarySearch(ids, i));
		}
	}

	private static int[] calcMaxFromArray(ArrayList<String> array) {
		// TODO Auto-generated method stub
		int value = 0;
		int[] ids = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			int minRow = 0;
			int maxRow = 127;
			int minCol = 0;
			int maxCol = 7;
			int row = 0;
			int col = 0;
			String seat = array.get(i);
			for (int j = 0; j < seat.length(); j++) {
				if (seat.charAt(j) == 'B') {
					minRow = ((minRow + maxRow + 1) / 2);
					row = maxRow;
				} else if (seat.charAt(j) == 'F') {
					maxRow = ((minRow + maxRow) / 2);
					row = minRow;
				} else if (seat.charAt(j) == 'L') {
					maxCol = ((minCol + maxCol)/2);
					col = maxCol;
				} else if (seat.charAt(j) == 'R') {
					minCol = ((minCol + maxCol + 1)/2);
					col = minCol;
				}
			}
			int id = (8* row) + col;
			ids[i] = id;
		}
		return ids;
	}

	private static ArrayList<String> readInput(Scanner scanner) {
		// TODO Auto-generated method stub
		ArrayList<String> array = new ArrayList<String>();
		while (scanner.hasNext()) {
			array.add(scanner.next());

		}
		return array;
	}

}
