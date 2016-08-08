package wordquiz;

/**
 * Created by neilprajapati on 8/4/16.
 * neilprajapati, dont forget to javaDoc this file.
 */
public class Word {
    private String word;
    private String definition;
    private String example;
    private String hint;

    public Word(String word, String definition, String example, String hint) {
        this.word = word;
        this.definition = definition;
        this.example = example;
        if(hint == null)
            this.hint = word.charAt(0) + word.substring(1, word.length() -1).replaceAll(".", "*") + word.charAt(word.length() -1);
        else
            this.hint = hint;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExample() {
        return example;
    }

    public String getHint() {
        return hint;
    }
}
