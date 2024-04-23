import java.util.List;

public class Question {
    private final String text;
    private final List<Answer> answers;
    private final boolean isMultiChoice;

    public Question(String text, List<Answer> answers, boolean isMultiChoice) {
        this.text = text;
        this.answers = answers;
        this.isMultiChoice = isMultiChoice;
    }

    public void display() {
        System.out.println();
        System.out.println(this.text + " " + (this.isMultiChoice ? "(Question with multiple answers)" : "(Question with single answer)"));

        for (int i = 0; i < this.answers.size(); i++) {
            System.out.println((i + 1) + ". " + this.answers.get(i).getText());
        }
    }

    public void revealAnswer() {
        System.out.print("Correct answer: ");
        for (int i = 0; i < this.answers.size(); i++) {
            if (this.answers.get(i).isCorrect()) {
                System.out.print(i + 1);
            }
        }
        System.out.println();
    }

    public boolean validateAnswer(String answer) {
        boolean isValid = true;
        String[] userAnswerIndexes = answer.split("");

        for (int i = 0; i < userAnswerIndexes.length; i++) {
            try {
                int index = Integer.parseInt(userAnswerIndexes[i]) - 1;
                if (!this.answers.get(index).isCorrect()) {
                    isValid = false;
                    break;
                }
            } catch (Exception e) {
                isValid = false;
                System.out.println("Invalid input.");
            }
        }
        return isValid;
    }
}
