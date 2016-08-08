package wordquiz;

import util.Input;

import java.io.*;
import java.util.ArrayList;

/**1
 * Created by neilprajapati on 8/4/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class ComplexQuiz {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = null;
        ArrayList<Word> words = new ArrayList<>();


        try{
            reader = new BufferedReader(
                    new FileReader("src/main/resources/Words2.txt")
            );

            String line = reader.readLine();
            while(line != null){
                if(line.startsWith("//")) {
                    line = reader.readLine();
                    continue;
                }
                String[] tokens = line.split(":");
                String word = tokens[0];
                String def = tokens[1].replaceFirst(":", "");
                String hint = null;
                String ex = null;
                line = reader.readLine();
                while(line != null && line.contains("\t"))
                {
                    tokens = line.split(":");
                    if(tokens[0].equals("\thint"))
                        hint = tokens[1];
                    else if(tokens[0].equals("\te.g"))
                        ex = tokens[1];
                    line = reader.readLine();
                }
                words.add(new Word(word, def, ex, hint));
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            
            return;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        //remove random ones until only 10 left
        while(words.size() > 10)
        {
            words.remove((int)(Math.random() * words.size()));
        }

        complexQuiz(words);
    }

    private static void complexQuiz(ArrayList<Word> words) {
        Input input = new Input();
        while(words.size() > 0)
        {
            System.out.println("What word means: " + words.get(0).getDefinition());
            String userChoice = input.promptString();
            userChoice = userChoice.toLowerCase();

            if(userChoice.equals("hint"))
            {
                System.out.println(words.get(0).getHint());
            }else if(userChoice.equals(words.get(0).getWord()))
            {
                words.remove(0);
                System.out.println("Correct!\n");
            } else
            {
                System.out.println("Incorrect! It is "+words.get(0).getWord());
                System.out.println("Example: " + words.get(0).getExample() + "\n");

                words.add(words.remove(0));
            }
        }
        System.out.println("U got them all right gg :D");
    }
}
