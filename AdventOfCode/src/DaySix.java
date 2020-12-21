import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DaySix {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("06DayInput"));
		ArrayList<String> array = readInput(scanner);
		scanner.close();
		printToFile(array);
		int yes = 0;
		for (int i = 0; i < array.size(); i++) {
			yes = yes + newYesQuestions(array.get(i));
		}
		// System.out.println(yes);
		int everYes = 0;
		for (int i = 0; i < array.size(); i++) {
			String[] strarray = array.get(i).split(" ");
			List<String> input = Arrays.asList(strarray);
			Collection<Character> col = findCommonCharsfor(input);
			//System.out.println(col.size());
			everYes = everYes + col.size();
		}
		System.out.println(everYes);
	}

	private static Collection<Character> findCommonCharsfor(List<String> strings) {

		Set<Character> commonChars = convertStringToSetOfChars(strings.get(1));
		strings.stream().skip(1).forEach(s -> commonChars.retainAll(convertStringToSetOfChars(s)));

		return commonChars;

	}

	private static Set<Character> convertStringToSetOfChars(String string) {

		Set<Character> set = new HashSet<>(string.length() + 10);
		for (char c : string.toCharArray()) {
			set.add(c);
		}

		return set;
	}

	private static int newYesQuestions(String string) {
		// TODO Auto-generated method stub
		boolean[] questions = new boolean[26];

		if (string.contains("a")) {
			questions[0] = true;
		}
		if (string.contains("b")) {
			questions[1] = true;
		}
		if (string.contains("c")) {
			questions[2] = true;
		}
		if (string.contains("d")) {
			questions[3] = true;
		}
		if (string.contains("e")) {
			questions[4] = true;
		}
		if (string.contains("f")) {
			questions[5] = true;
		}
		if (string.contains("g")) {
			questions[6] = true;
		}
		if (string.contains("h")) {
			questions[7] = true;
		}
		if (string.contains("i")) {
			questions[8] = true;
		}
		if (string.contains("j")) {
			questions[9] = true;
		}
		if (string.contains("k")) {
			questions[10] = true;
		}
		if (string.contains("l")) {
			questions[11] = true;
		}
		if (string.contains("m")) {
			questions[12] = true;
		}
		if (string.contains("n")) {
			questions[13] = true;
		}
		if (string.contains("o")) {
			questions[14] = true;
		}
		if (string.contains("p")) {
			questions[15] = true;
		}
		if (string.contains("q")) {
			questions[16] = true;
		}
		if (string.contains("r")) {
			questions[17] = true;
		}
		if (string.contains("s")) {
			questions[18] = true;
		}
		if (string.contains("t")) {
			questions[19] = true;
		}
		if (string.contains("u")) {
			questions[20] = true;
		}
		if (string.contains("v")) {
			questions[21] = true;
		}
		if (string.contains("w")) {
			questions[22] = true;
		}
		if (string.contains("x")) {
			questions[23] = true;
		}
		if (string.contains("y")) {
			questions[24] = true;
		}
		if (string.contains("z")) {
			questions[25] = true;
		}
		int yes = 0;
		for (int i = 0; i < questions.length; i++) {
			if (questions[i]) {
				yes++;
			}
		}
		return yes;
	}

	private static void printToFile(ArrayList<String> array) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("06InputCustom");
		String string = "";
		for (int i = 0; i < array.size(); i++) {
			string = string + array.get(i) + "\n";
		}
		Files.writeString(path, string);
	}

	private static ArrayList<String> readInput(Scanner scanner) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();

		String tmp = "";
		while (scanner.hasNextLine()) {

			String tmp2 = scanner.nextLine();
			if (tmp2.equals("")) {
				arrayList.add(tmp);
				tmp = "";

			} else {
				tmp += " " + tmp2;
			}

		}
		arrayList.add(" rcyshqp jbdnpe zgp pnjtz");
		return arrayList;
	}
}
