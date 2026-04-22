package service;

import model.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    @Test
    @DisplayName("correct answer increments score")
    public void correctAnswerIncrementsScore(){
        List<Question>questions = List.of(new Question("What is 2+2", List.of("2","3","4","5"),2)) ;
        Quiz quiz = new Quiz(questions);
        quiz.submitAnswer(2);
        assertEquals(1,quiz.getFinalScore());

    }

    @Test
    @DisplayName("wrong answer does not  increments score")
    public void wrongAnswerDoesNotIncrementsScore(){
        List<Question>questions = List.of(new Question("What is 2+2", List.of("2","3","4","5"),2)) ;
        Quiz quiz = new Quiz(questions);
        quiz.submitAnswer(1);
        assertEquals(0,quiz.getFinalScore());

    }
    @Test
    @DisplayName("does isFinished() return true at the right time")
    public void  isFinishedReturnsTrueAfterAllQuestionsAnswered() {
        List<Question> questions = List.of(new Question("What is 2+2", List.of("2", "3", "4", "5"), 2),
                new Question("What is the capital of france", List.of("Abia", "France", "con", "dog"), 1));
        Quiz quiz = new Quiz(questions);
        quiz.submitAnswer(2);
        quiz.submitAnswer(1);
        assertTrue(quiz.isFinished());

    }

    @Test
    @DisplayName("getQuestions() throws when quiz is finished")
    public void  getQuestionThrowsWhenFinished() {
        List<Question> questions = List.of(new Question("What is 2+2", List.of("2", "3", "4", "5"), 2),
                new Question("What is the capital of france", List.of("Abia", "France", "con", "dog"), 1));
        Quiz quiz = new Quiz(questions);


        assertThrows(IllegalStateException.class, () -> {
            quiz.submitAnswer(2);
            quiz.submitAnswer(1);
            quiz.getQuestion();
        });
    }

    @Test
    @DisplayName("empty question list throws IllegalArgumentException")
    public void emptyQuestionListThrowsIllegalArgumentException(){
        List<Question> questions = List.of();

        assertThrows(IllegalArgumentException.class, () -> new Quiz(questions));
    }

    @Test
    @DisplayName("isFinished() returns false before all questions answered")
    public void isFinishedReturnsFalseBeforeAllQuestionsAnswered(){
        List<Question> questions = List.of(new Question("What is 2+2", List.of("2", "3", "4", "5"), 2),
                new Question("What is the capital of france", List.of("Abia", "France", "con", "dog"), 1));
        Quiz quiz = new Quiz(questions);
        quiz.submitAnswer(2);
        assertFalse(quiz.isFinished());

    }
}