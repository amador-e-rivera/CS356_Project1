
// This should be initialized with a Question.
public interface IService<T> {

	public void setQuestion(T question);
	
	public void displayResults();
	
	public void displayQuestion();

	public void submitAnswer(Integer id, String[] answer);
}
