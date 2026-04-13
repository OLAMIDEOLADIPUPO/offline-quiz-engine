package service;

import model.Question;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentScore;
    private int currentQuestionIndex;

   public Quiz(List<Question> questions) {
        if (questions.isEmpty()) throw new IllegalArgumentException("service.Quiz must have at least one question");
        this.questions = new ArrayList<>(questions);
        this.currentScore = 0;
        this.currentQuestionIndex = 0;
    }

    public Question getQuestion() {
        if(isFinished()){
            throw new IllegalStateException("service.Quiz is already finished,no more questions");
        }
        return questions.get(currentQuestionIndex);
    }

    public void submitAnswer(int answerIndex) {
        if(isFinished())return;
        Question current = getQuestion();
        if(current.isCorrect(answerIndex)) {
            currentScore++;
        }
        currentQuestionIndex++;

    }
    public boolean  isFinished() {
        return currentQuestionIndex == questions.size();
    }
    public int getFinalScore() {
        return currentScore;
    }
    public int getTotalQuestions() {
        return questions.size();
    }


}
