
// Decided to use abstract class since the functions for a question will mostly be the 
// same. Not really sure how the type of question matters in this project.
public abstract class Question {

	private String question;
	private String[] choices;
	private String[] answer;

	// Setters

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setChoices(String... choices) {
		this.choices = choices;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	// Getters

	public String getQuestion() {
		return question;
	}

	public String[] getChoices() {
		return choices;
	}

	public String[] getAnswer() {
		return answer;
	}

	// Abstract Functions
	public abstract void printQuestion();
}
