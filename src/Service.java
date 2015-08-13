import java.util.HashMap;
import java.util.Map;

public class Service implements IService<Question> {

	Question question;
	Map<Integer, String[]> userAnswers;
	Map<String, Integer> results;

	// Constructors
	public Service() {
		userAnswers = new HashMap<Integer, String[]>();
	}

	public Service(Question question) {
		this.question = question;
		userAnswers = new HashMap<Integer, String[]>();
	}

	// Inherited Methods

	// This method sets the answer for each unique id. If another answer is submitted
	// for the same id, it simply overwrites the previous answer.
	@Override
	public void submitAnswer(Integer id, String[] answer) {
		userAnswers.put(id, answer);
	}

	@Override
	public void setQuestion(Question question) {
		this.question = question;
	}

	// Inefficient way to display the results. Needs to be more efficient.
	@Override
	public void displayResults() {
		Map<String, Integer> results = new HashMap<String, Integer>();
		
		for(Map.Entry<Integer, String[]> userAnswer : userAnswers.entrySet()) {
			String[] answer = userAnswer.getValue();
			
			for(String value : answer) {
				if(results.containsKey(value)) {
					results.put(value, results.get(value) + 1);
				} else {
					results.put(value, 1);
				}
			}
		}
		
		for(Map.Entry<String, Integer> result : results.entrySet()) {
			System.out.println(result.getKey() + ": " + result.getValue());
		}
	}

	@Override
	public void displayQuestion() {
		question.printQuestion();
	}
}
