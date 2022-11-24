import java.util.ArrayList;

public class SpellChecker {

    private ArrayList<String> words = new ArrayList<String>();
    private Dictionary dictionary = null;

    /**
     * On essaie d'ouvrir le fichier pathToFile contenant les mots à corriger
     * Si erreur, on utilise seulement word
     *
     * @param pathToFile
     * @param word
     */
    public SpellChecker(String pathToFile, String word, Dictionary dictionary) {

    }

    /**
     * Regarde si word est dans le dictionnaire
     * sinon il affiche une liste de mot les plus proches
     *
     * @param word
     */
    public void spell(String word) {

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
