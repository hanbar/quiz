import java.util.List;
import java.util.Scanner;

public class Quiz {
    private final List<Question> questions;
    private int totalPoints;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.totalPoints = 0;
    }

    public static void main(String[] args) {
        List<Answer> qOneAnswers = List.of(new Answer("Paris", true),
                new Answer("Berlin", false),
                new Answer("Rome", false),
                new Answer("Madrid", false));
        Question one = new Question("What is the capital of France?", qOneAnswers);

        List<Answer> qTwoAnswers = List.of(new Answer("2", true),
                new Answer("3", true),
                new Answer("4", false),
                new Answer("5", true),
                new Answer("6", false));
        Question two = new Question("Which of the following are prime numbers?", qTwoAnswers);

        List<Answer> qThreeAnswers = List.of(new Answer("Jupiter", true),
                new Answer("Mars", false),
                new Answer("Earth", false),
                new Answer("Saturn", false));
        Question three = new Question("What is the largest planet in our solar system?", qThreeAnswers);

        List<Question> questions = List.of(one, two, three);

        System.out.println("Hello, welcome to Java quiz!");
        System.out.println("The quiz has 3 questions with one or more correct answers.");

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            question.display();
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim();
            if (question.validateAnswer(answer)) {
                this.countCorrectAnswer();
            }
            question.revealAnswer();
        }
        System.out.println("Quiz ended. You had: " + this.totalPoints + "/" + this.questions.size() + " answers correct");
    }

    private void countCorrectAnswer() {
        this.totalPoints++;
    }
}