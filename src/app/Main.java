package app;

import controller.QuizEngine;
import controller.SetUpController;
import model.Question;
import repository.FileRepository;
import service.FileService;
import service.Quiz;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SetUpController setUp =  new SetUpController();
        String questionFilePath = setUp.run();
        FileRepository fileService = new FileService(questionFilePath);
        List<Question> questions = fileService.loadQuestions();
        if (questions.isEmpty()) {
            System.out.println("No questions found");
            return;
        }
        Quiz quiz = new Quiz(questions);
        QuizEngine quizEngine = new QuizEngine(quiz,fileService);

        quizEngine.run();



    }
}
