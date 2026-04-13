import controller.QuizEngine;
import model.Question;
import repository.FileService;
import service.Quiz;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<Question> questions = fileService.loadQuestions();
        Quiz quiz = new Quiz(questions);
        QuizEngine quizEngine = new QuizEngine(quiz, fileService);

        quizEngine.run();



    }
}
