import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) {
		Service service = new Service(generateSingleQuestion());
		Map<Integer, Student> students = new HashMap<Integer, Student>();

		generateUsers(students);
		generateSingleChoiceAnswers(students, service);
		service.displayResults();
	}

	public static Question generateSingleQuestion() {
		Question single = new SingleChoice();

		single.setQuestion("Am I over thining this project? ");
		single.setChoices(new String[] { "1. True", "2. false" });
		single.setAnswer(new String[] { "1" });

		return single;
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

	// This generates single choice answer for all students in a map. This assumes that
	// the user will not attempt to input any answer other than what is allowed. In an 
	// actual implementation, validation would be used.
	public static void generateSingleChoiceAnswers(Map<Integer, Student> students, IService<Question> service) {
		Integer id;
		String[] answer;
		Random rand = new Random();
	
		// Iterates through the Map of students and adds an answer for each student to the Service.
		for(Map.Entry<Integer, Student> student : students.entrySet()) {
			id = student.getValue().getId();
			
			answer = new String[]{ String.valueOf(rand.nextInt(2) + 1)}; //Choice between 1 or 2
			
			service.submitAnswer(id, answer);
		}
	}
}
