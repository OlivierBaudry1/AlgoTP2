import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
    private final Node dico = new Node();
    private final Trigram trigram = new Trigram();
    public Dictionary(String filename){
        String line;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                dico.add(line);
                trigram.add(line);
        }
        }catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }

    public Node getDico() {
        return dico;
    }

    public Trigram getTrigram() {
        return trigram;
    }

    public Boolean contains(String word){
        return dico.contains(word);
    }
}



