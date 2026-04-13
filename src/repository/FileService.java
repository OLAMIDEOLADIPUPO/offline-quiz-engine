package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Attempt;
import model.Question;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String QUESTION_FILE = "questions.json";
    private static final String ATTEMPT_FILE = "attempts.json";
    private Gson gson = new Gson();

    public List<Question> loadQuestions() {
        try(FileReader reader = new FileReader(QUESTION_FILE)){
            Type type = new TypeToken<List<Question>>(){}.getType();
            return gson.fromJson(reader, type);


        }
        catch(IOException e){
            return new ArrayList<>();
        }


    }

    public void saveAttempt(Attempt attempt) throws IOException{
        try(FileWriter writer = new FileWriter(ATTEMPT_FILE,true)){
            writer.write(gson.toJson(attempt)+"\n");
        };


    }

}
