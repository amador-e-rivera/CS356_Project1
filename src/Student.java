import java.util.Random;

// This is a regular class. This can probably be changed to use an
// interface or abstract class.
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
