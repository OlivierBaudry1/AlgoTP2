import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class Trigram {

    final HashMap<String, ArrayList<String>> trigram = new HashMap<>();

    public ArrayList<String> trigramList (String word){
        ArrayList<String> trigramList = new ArrayList<>();
        word = "<"+word+">";
        for (int i = 0; i < word.length()-2; i++) {
            String trigramWord = word.substring(i,i+3);
            if (!trigramList.contains(trigramWord))
                trigramList.add(trigramWord);
        }
        return trigramList;
    }

    public void add(String word){
        ArrayList<String> trigramList = trigramList(word);
        for (String trigramWord : trigramList) {
            if (!trigram.containsKey(trigramWord)) {
                trigram.put(trigramWord, new ArrayList<>());
            }
            trigram.get(trigramWord).add(word);
        }
    }

    public List<Map.Entry<String, Integer>> closest(String word){
       ArrayList<String> trigramList = trigramList(word);
       HashMap<String,Integer> close = new HashMap<>();
       for (String trigramWord : trigramList){
           if (trigram.containsKey(trigramWord)){
               for (String toto : trigram.get(trigramWord)){
                   if (!close.containsKey(toto)){
                        close.put(toto,1);
                   }else {
                        close.put(toto, close.get(toto)+1);
                   }
               }
           }
       }

       List<Map.Entry<String,Integer>> closest = new LinkedList<>(close.entrySet());
       closest.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

       return closest;
    }


    private LinkedHashMap<String, Integer> sort(HashMap<String, Integer> map){
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    /*    public void add(String word){
        String newWord = "<"+word+">";

        for (int i = 0; i < newWord.length()-2; i++ ) {
            if (!trigram.containsKey(newWord.substring(i,i+3))){
                trigram.put(newWord.substring(i,i+3), new ArrayList<>());
            }
            trigram.get(newWord.substring(i,i+3)).add(word);
        }
    }*/



}