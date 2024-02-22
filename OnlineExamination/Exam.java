package OnlineExamination;
import java.util.Scanner;

class Exam {
    private Question[] questions;
    private int durationMinutes;

    public Exam(Question[] questions, int durationMinutes) {
        this.questions = questions;
        this.durationMinutes = durationMinutes;
    }

    public void startExam() {
        try (Scanner scanner = new Scanner(System.in)) {
            int score = 0;

            for (Question question : questions) {
                question.displayQuestion();

                System.out.print("Select your answer (1-" + question.getOptions().length + "): ");
                int selectedOption = scanner.nextInt();

                if (question.checkAnswer(selectedOption)) {
                    score++;
                }
            }

            System.out.println("Exam completed. Your score: " + score + "/" + questions.length);
        }
    }
}