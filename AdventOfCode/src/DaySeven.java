import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DaySeven {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("07DayInput"));
		ArrayList<Bag> array = readInput(scanner);
		scanner.close();
		int counter = 0;
		for (int i = 0; i < array.size(); i++) {
			if(canHoldGold(array.get(i))){
				counter++;
			}
		}
		
	}

	private static boolean canHoldGold(Bag bag) {
		// TODO Auto-generated method stub
		
		return false;
	}

	private static ArrayList<Bag> readInput(Scanner scanner) {
		// TODO Auto-generated method stub
		ArrayList<Bag> array = new ArrayList<Bag>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<ArrayList<String>> holds = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Integer>> howMany = new ArrayList<ArrayList<Integer>>();
		while (scanner.hasNextLine()) {
			ArrayList<String> canHold = new ArrayList<String>();
			ArrayList<Integer> number = new ArrayList<Integer>();
			String name = scanner.next();
			name = name + scanner.next();
			names.add(name);
			System.out.println(name);
			scanner.next();
			scanner.next();
			String next = scanner.next();
			if (!next.equals("no")) {
				int amount = Integer.parseInt(next);
				number.add(amount);
				String name2 = scanner.next();
				name2 = name2 + scanner.next();
				canHold.add(name2);
				String bag = scanner.next();
				while (bag.endsWith(",")) {
					int amount2 = Integer.parseInt(scanner.next());
					number.add(amount2);
					String name3 = scanner.next();
					name3 = name3 + scanner.next();
					canHold.add(name3);
					bag = scanner.next();
				}
			} else {
				scanner.nextLine();
			}
			holds.add(canHold);
			howMany.add(number);
		}
		
		for (int i = 0; i < names.size(); i++) {
			int[] numArray = new int[holds.get(i).size()];
			String[] strArray = new String[holds.get(i).size()];
			for (int j = 0; j < strArray.length; j++) {
				numArray[j] = howMany.get(i).get(j);
				strArray[j] = holds.get(i).get(j);
			}
			Bag bag = new Bag(names.get(i), strArray, numArray);
			array.add(bag);
		}
		return array;
	}
}
