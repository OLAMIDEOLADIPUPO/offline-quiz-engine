package controller;

import java.io.File;
import java.util.Scanner;

public class SetUpController {
    public String run(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Enter file path for the questions file: ");
            String filePath = input.nextLine();
            filePath = filePath.replace( "\"","");

            if(!filePath.endsWith(".json")){
                System.out.println("File is not a json file");
                continue;
            }

            File file = new File(filePath);
            if(!file.exists()){
                System.out.println("File does not exist");
                continue;
            }

            return  filePath;


        }

    }
}
