import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFour {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("dayfour_input"));
		ArrayList<String> array = readInput(scanner);
		scanner.close();
		int size = array.size();
		int valid = 0;
		for (int i = 0; i < size; i++) {
			String pass = array.get(i);
			boolean byr = false;
			boolean iyr = false;
			boolean eyr = false;
			boolean hgt = false;
			boolean hcl = false;
			boolean ecl = false;
			boolean pid = false;
			boolean cid = false;

			if (pass.contains("byr")) {
				byr = true;
			}
			if (pass.contains("iyr")) {
				iyr = true;
			}
			if (pass.contains("eyr")) {
				eyr = true;
			}
			if (pass.contains("hgt")) {
				hgt = true;
			}
			if (pass.contains("hcl")) {
				hcl = true;
			}
			if (pass.contains("ecl")) {
				ecl = true;
			}
			if (pass.contains("pid")) {
				pid = true;
			}
			if (pass.contains("cid")) {
				cid = true;
			}

			if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
				valid++;
			}

		}
		System.out.println(valid);
		printToFile(array);
		int valid2 = 0;
		ArrayList<String[]> arr = makeArrayPerPass(array);
		for (int i = 0; i < arr.size(); i++) {
			String[] passArr = arr.get(i);
			boolean byr = false;
			boolean iyr = false;
			boolean eyr = false;
			boolean hgt = false;
			boolean hcl = false;
			boolean ecl = false;
			boolean pid = false;
			boolean cid = false;
			for (int j = 0; j < passArr.length; j++) {

				String pass = passArr[j];

				if (!(pass.equals(""))) {
					if (pass.contains("byr")) {
						pass = pass.substring(4);
						if (Integer.parseInt(pass) > 1919 && Integer.parseInt(pass) < 2003) {
							byr = true;
							System.out.println("byr");
						}
					} else if (pass.contains("iyr")) {
						pass = pass.substring(4);
						if (Integer.parseInt(pass) > 2009 && Integer.parseInt(pass) < 2021) {
							iyr = true;
						}
					} else if (pass.contains("eyr")) {
						pass = pass.substring(4);
						if (Integer.parseInt(pass) > 2018 && Integer.parseInt(pass) < 2031) {
							eyr = true;
						}
					} else if (pass.contains("hgt")) {
						pass = pass.substring(4);

						if (pass.length() >= 4 && pass.length() <= 5) {

							if (pass.contains("in")) {
								pass = pass.substring(0, pass.length() - 2);
								if (Integer.parseInt(pass) > 58 && Integer.parseInt(pass) < 76) {
									hgt = true;
								}
							} else {
								pass = pass.substring(0, pass.length() - 2);

								if (Integer.parseInt(pass) > 149 && Integer.parseInt(pass) < 194) {
									hgt = true;
								}
							}

						}
					} else if (pass.contains("hcl")) {
						pass = pass.substring(4);
						if (pass.length() == 7 && pass.charAt(0) == '#') {
							pass = pass.substring(1);
							boolean[] boolArr = new boolean[pass.length()];
							for (int k = 0; k < pass.length(); k++) {
								if (Character.isLetterOrDigit(pass.charAt(k))) {
									boolArr[k] = true;
								} else {
									boolArr[k] = false;
								}
							}
							boolean check = true;
							for (int k = 0; k < boolArr.length; k++) {
								if (!boolArr[k]) {
									check = false;
								}
							}
							if (check == true) {
								hcl = true;
							}
						}
					} else if (pass.contains("ecl")) {
						pass = pass.substring(4);
						if (pass.length() == 3) {
							if (pass.equals("amb") || pass.equals("blu") || pass.equals("brn") || pass.equals("gry")
									|| pass.equals("hzl") || pass.equals("oth") || pass.equals("grn")) {
								ecl = true;
							}
						}
					} else if (pass.contains("pid")) {
						pass = pass.substring(4);
						if (pass.length() == 9) {
							pid = true;
							for (int k = 0; k < pass.length(); k++) {
								if (!(Character.isDigit(pass.charAt(k)))) {
									pid = false;
								}
							}
						}
					} else if (pass.contains("cid")) {
						pass = pass.substring(4);
					}

				}
			}
			if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
				valid2++;
			}
		}
		System.out.println(valid2);
	}

	private static ArrayList<String[]> makeArrayPerPass(ArrayList<String> array) {
		// TODO Auto-generated method stub
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		for (int i = 0; i < array.size(); i++) {
			String[] tmp = array.get(i).split(" ");
			arrayList.add(tmp);
		}
		return arrayList;
	}

	private static void printToFile(ArrayList<String> array) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("dayfourCustom");
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
				System.out.println(tmp);
				tmp = "";

			} else {
				tmp += " " + tmp2;
			}

		}
		arrayList.add("hgt:183cm cid:187 byr:2019 ecl:xry iyr:2013 pid:164cm hcl:#18171d eyr:2021");
		return arrayList;
	}

}
