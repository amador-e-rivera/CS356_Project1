
public class SingleChoice extends Question {

	@Override
	public void printQuestion() {
		String[] choices = super.getChoices();
		
		System.out.println(super.getQuestion());
		for(int i = 1; i <= choices.length; i++) {
			System.out.println(i + ". " + choices[i - 1]);
		}
	}
}
