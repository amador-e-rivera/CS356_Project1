import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) {
		Map<Integer, Student> students = new HashMap<Integer, Student>();

		generateUsers(students);
		
		// IService can and accept answers
		//  - submitAnswer(String answer)
		
		System.out.println("Hello");
	}

	public static void generateUsers(Map<Integer, Student> students) {
		Student student;
		Random rand = new Random();

		for (int i = rand.nextInt(30); i >= 0; i--) {

			do {
				student = new Student();
			} while (students.containsKey(student.getId()));

			students.put(Integer.valueOf(student.getId()), student);
		}
	}

	public static void generateQuestion() {
		
	}

}
