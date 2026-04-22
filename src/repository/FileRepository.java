package repository;

import model.Attempt;
import model.Question;

import java.io.IOException;
import java.util.List;

public interface FileRepository {
    List<Question> loadQuestions();
    void saveAttempt(Attempt attempt) throws IOException;
    List<Attempt> loadAttempts();

}
