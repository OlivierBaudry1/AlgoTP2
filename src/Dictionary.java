import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
    public HashMap<String, HashSet<String> > dico = new HashMap<>();
    public Dictionary(String filename){
        String line;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                trigram(line);
        }
        }catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }

    private void trigram(String word){
        String test = "<"+word+">";

        for (int i = 0; i < test.length()-2; i++ ) {
            if (!dico.containsKey(test.substring(i,i+3))){
                dico.put(test.substring(i,i+3), new HashSet<>());
            }
            dico.get(test.substring(i,i+3)).add(word);
        }
    }
}


