import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellChecker {

    private ArrayList<String> words = new ArrayList<String>();
    private Dictionary dictionary;
    int toto = 0;

    /**
     * On essaie d'ouvrir le fichier pathToFile contenant les mots à corriger
     * Si erreur, on utilise seulement word
     *
     * @param pathToFile
     * @param word
     */
    public SpellChecker(String pathToFile, String word, Dictionary dictionary) {
        try {
            Scanner scanner = new Scanner(new File(pathToFile));
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            words.add(word);
        }
        this.dictionary = dictionary;
    }

    /**
     * Regarde si word est dans le dictionnaire
     * sinon il affiche une liste de mot les plus proches
     *
     * @param word
     */
    public void spell(String word) {
        if (dictionary.contains(word)){
            System.out.println(word + " est dans le dictionnaire");
        }else{
            toto++;
            List<Map.Entry<String,Integer>> closestWords = dictionary.getTrigram().closest(word);
            List<Map.Entry<String,Integer>> distance = new ArrayList<>();

            int max = Math.min(100, closestWords.size());
            for (int i = 0; i < max; i++){
                distance.add(new AbstractMap.SimpleEntry<>(closestWords.get(i).getKey(), Levenshtein.distance(closestWords.get(i).getKey(), word)));
            }
            distance.sort(Map.Entry.comparingByValue());


            System.out.println("Vous avez entré \""+word+"\" mais cela semble mal orthographié. \nVoici cinq mots qui pourraient corespondre");
            for (int i = 0; i < 5; i++){
                System.out.println(" "+distance.get(i).getKey());
            }
        }
    }


    /**
     * Retourne la liste de tous les mot dont
     * il faut faire la correction
     *
     * @return
     */
    public ArrayList<String> getWords() {
        return words;
    }
}
