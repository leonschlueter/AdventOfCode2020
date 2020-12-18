import java.io.*;
import java.util.*;

public class DayOne {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("dayone_input"));
		int[] array = readNumbers(scanner);
		scanner.close();
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				for (int k = j+1; k < array.length; k++) {
					if(array[i]+ array[j] +array[k] == 2020) {
						System.out.println(true);
						System.out.println(array[i]*array[j]*array[k]);
						System.out.println(array[i]+ " "+array[j]+ " "+array[k]);
					}
				}
			}
		}
	}

	private static int[] readNumbers(Scanner scanner) {
		// TODO Auto-generated method stub
		int[] array = new int[200];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		return array;
	}

}
