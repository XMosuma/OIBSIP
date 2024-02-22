package OnlineExamination;

class Question {

    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer)
    {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() 
    {
        System.out.println(question);
        for ( int x = 0; x < options.length; x++) {
            System.out.println((x + 1) + ". " + options[x]);
        }
    }

    public boolean checkAnswer(int selectedOption) 
    {
        return selectedOption == correctAnswer;
    }

     public String[] getOptions() 
     {
        return options;
    }
}
