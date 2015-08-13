import java.util.Random;

public class Student {

	private int id;

	public Student() {
		generateId();
	}

	private void generateId() {
		Random rand = new Random();
		id = rand.nextInt();
	}

	public int getId() {
		return id;
	}

}
