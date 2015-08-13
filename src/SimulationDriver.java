import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) {
		Service service = new Service(generateSingleChoiceQuestion());
		Map<Integer, Student> students = new HashMap<Integer, Student>();

		SingleChoiceTest(students, service);
		System.out.println();
		MultipleChoiceTest(students, service);
	}
	
	public static void SingleChoiceTest(Map<Integer, Student> students, IService<Question> service) {
		generateUsers(students);
		generateSingleChoiceAnswers(students, service);
		service.displayQuestion();
		System.out.println("\nResults");
		service.displayResults();
	}
	
	public static void MultipleChoiceTest(Map<Integer, Student> students, IService<Question> service) {
		service = new Service(generateMultipleChoiceQuestion());
		generateUsers(students);
		generateMultipleChoiceAnswers(students, service);
		service.displayQuestion();
		System.out.println("\nResults");
		service.displayResults();
	}

	// Randomly generates up to 30 students.
	public static void generateUsers(Map<Integer, Student> students) {
		Student student;
		Random rand = new Random();

		for (int i = rand.nextInt(30); i >= 0; i--) {

			// Tries a new student if the student id already exists.
			do {
				student = new Student();
			} while (students.containsKey(student.getId()));

			students.put(Integer.valueOf(student.getId()), student);
		}
	}
	
	// Does as the name suggests. The questions, choices and answers are hardcoded.
	public static Question generateSingleChoiceQuestion() {
		Question single = new SingleChoice();

		single.setQuestion("Am I over thinking this project? ");
		single.setChoices(new String[] { "1. True", "2. false" });
		single.setAnswer(new String[] { "1" });

		return single;
	}

	public static Question generateMultipleChoiceQuestion() {
		Question multiple = new MultipleChoice();
		
		multiple.setQuestion("What gives 4? ");
		multiple.setChoices(new String[] { "A. 2 + 2", "B. 2 * 1", "C. 4 + 1", "D. 2 * 2" });
		multiple.setAnswer(new String[] { "A", "D" });
		
		return multiple;
	}

	// This generates single choice answer for all students in a map. This assumes that
	// the user will not attempt to input any answer other than what is allowed. In an
	// actual implementation, validation would be used.
	public static void generateSingleChoiceAnswers(Map<Integer, Student> students, IService<Question> service) {
		Integer id;
		String[] answer;
		Random rand = new Random();

		// Iterates through the Map of students and adds an answer for each
		// student to the Service.
		for (Map.Entry<Integer, Student> student : students.entrySet()) {
			id = student.getValue().getId();

			// Choice between 1 and 2 only since it is single choice only.
			answer = new String[] { String.valueOf(rand.nextInt(2) + 1) }; 

			service.submitAnswer(id, answer);
		}
	}
	
	// This generates multiple choice answer for all students in a map. This assumes that
	// the user will not attempt to input any answer other than what is allowed. In an
	// actual implementation, validation would be used.
	public static void generateMultipleChoiceAnswers(Map<Integer, Student> students, IService<Question> service) {
		Integer id;
		String[] answer;
		String[] choices = new String[]{"A", "B", "C", "D"};
		Random rand = new Random();

		// Iterates through the Map of students and adds an answer for each
		// student to the Service.
		for (Map.Entry<Integer, Student> student : students.entrySet()) {
			id = student.getValue().getId();

			// Choice between 1 and 2 only since it is single choice only.
			answer = new String[] { choices[rand.nextInt(4)] }; 

			service.submitAnswer(id, answer);
		}
	}
}
