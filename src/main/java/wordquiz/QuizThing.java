package wordquiz;

import util.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by neilprajapati on 8/4/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class QuizThing {


    public static void main(String[] args) throws IOException{

        BufferedReader reader;
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> definitions = new ArrayList<>();

        try{
            reader = new BufferedReader(
                    new FileReader("src/main/resources/Words.txt")
            );

            String line = null;
            while((line = reader.readLine()) != null){
                String[] tokens = line.split(":");
                words.add(tokens[0]);
                definitions.add(tokens[1]);
            }
            reader.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return;
        }

        //remove random ones until only 10 left
        while(words.size() > 10)
        {
            int rand = (int) (Math.random() * words.size());
            words.remove(rand);
            definitions.remove(rand);
        }

        simpleQuiz(words, definitions);
    }

    private static void simpleQuiz(ArrayList<String> words, ArrayList<String> defiintions) {
        Input input = new Input();
        while(words.size() > 0)
        {
            System.out.println("What word means: " + defiintions.get(0));
            String userChoice = input.promptString();
            if(userChoice.toUpperCase().equals(words.get(0).toUpperCase()))
            {
                words.remove(0);
                defiintions.remove(0);
                System.out.println("Correct!\n");
            } else
            {
                System.out.println("Incorrect! It is "+words.get(0)+"\n");
                words.add(words.remove(0));
                defiintions.add(defiintions.remove(0));
            }
        }
        System.out.println("U got them all right gg :D");
    }
}