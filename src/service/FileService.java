package service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import model.Attempt;
import model.Question;
import repository.FileRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileService implements FileRepository {
    private String questionFilePath;
    private static final String attemptFilePath = "attempts.json";
    private final Gson gson = new Gson();

    public FileService(String  questionFilePath) {
        this.questionFilePath = questionFilePath;
    }

    public List<Question> loadQuestions()  {
        try(FileReader reader = new FileReader(questionFilePath)){
            Type type = new TypeToken<List<Question>>(){}.getType();
            return gson.fromJson(reader, type);


        }
        catch (IOException e) {
            return new ArrayList<>();
        }


    }

    public void saveAttempt(Attempt attempt) throws IOException{
        try(FileWriter writer = new FileWriter(attemptFilePath,true)){
            writer.write(gson.toJson(attempt)+"\n");
        };


    }
    public List<Attempt> loadAttempts() {
        List<Attempt> attempts = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(attemptFilePath))){
            String line;
            while((line = reader.readLine())!= null){
                try{
                attempts.add(gson.fromJson(line, Attempt.class));}
                catch(JsonSyntaxException e){
                    System.out.println("Skipping corrupted line "+line);
                }
            }
        }
        catch(FileNotFoundException e){
            return new ArrayList<>();
        }
        catch(IOException e){
            System.out.println("Error reading file "+ e.getMessage());
        }
        return attempts;
    }

}
