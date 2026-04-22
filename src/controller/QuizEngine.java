package controller;

import model.Attempt;
import model.Question;
import repository.FileRepository;
import service.FileService;
import service.Quiz;

import java.io.IOException;
import java.util.Scanner;

public class QuizEngine {
    private Quiz quiz;
    private FileRepository fileRepository;
    public QuizEngine(Quiz quiz, FileRepository fileRepository  ) {
        this.quiz = quiz;
        this.fileRepository = fileRepository;
    }
    public void run(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        while(!quiz.isFinished()){
            Question currentQuestion =quiz.getQuestion();
            System.out.println(currentQuestion);
            System.out.println("Enter your answer (e.g A,B,C,D)");
            int answerIndex = -1;
            while(answerIndex >= currentQuestion.getOptions().size() || answerIndex < 0){
                String answer = input.nextLine().trim().toUpperCase();
                if(answer.isEmpty()){
                    System.out.println("Please enter a valid answer.");
                    continue;

                }
                answerIndex = answer.charAt(0) - 'A';
                if(answerIndex >= 0 && answerIndex < currentQuestion.getOptions().size()){
                    break;
                }
                else{
                    System.out.println("Error: Invalid answer entered.Try again!");
                }
            }
            quiz.submitAnswer(answerIndex);
            if(!currentQuestion.isCorrect(answerIndex)){
                System.out.println("Wrong answer, Correct answer is "+currentQuestion.getCorrectAnswerText());
            }

        }
        int finalScore = quiz.getFinalScore();
        int total = quiz.getTotalQuestions();
        double percentage = (finalScore * 100.0) / total;

        System.out.println("\n===== QUIZ COMPLETE =====");
        System.out.println("Player : " + username);
        System.out.println("Score  : " + finalScore + " / " + total);
        System.out.printf("Grade  : %.1f%%%n", percentage);

        Attempt attempt = new Attempt(username, finalScore);
        try{
            fileRepository.saveAttempt(attempt);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }


    }
}
