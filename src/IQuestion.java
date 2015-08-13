
public interface IQuestion {

	// Setters

	public void setQuestion(String questionType);

	public void setChoices(String... choices);

	public void setAnswer(String answer);

	// Getters

	public String getQuestion();

	public String[] getChoices();

	public String getAnswer();
}
