
public class Bag {
	String name;
	String[] canHold;
	int[] holds;
	public Bag(String name, String[] canHold, int[] holds) {
		this.name = name;
		this.canHold = canHold;
		this.holds = holds;
		System.out.println(name + " " + canHold.length+ " "+ holds.length);
	}
}
