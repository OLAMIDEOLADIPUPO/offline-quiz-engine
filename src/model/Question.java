package model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;
    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = new ArrayList<>(options);
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return new ArrayList<>(options);
    }
    public boolean isCorrect(int userAnswer) {
        return correctAnswerIndex == userAnswer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(questionText).append("\n");

        for (int i = 0; i < options.size(); i++) {
            char label = (char) ((i % 26) + 'A');
            sb.append(label).append(". ").append(options.get(i)).append("\n");
        }

        return sb.toString();
    }


}
