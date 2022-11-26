import java.util.HashMap;

public class Node {
    public HashMap<Character, Node> children = new HashMap<>();
    private boolean terminal;


    public void add(String word){
        Node current = this;
        for (char c : word.toCharArray()){
            current = current.getChildren().computeIfAbsent(c, ch -> new Node());
        }
        current.terminal = true;
    }

    public boolean contains(String word){
        Node current = this;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            Node node = current.getChildren().get(c);
            if (node == null){
                return false;
            }
            current = node;
        }
        return current.isTerminal();
    }

    private HashMap<Character, Node> getChildren(){
        return children;
    }

    private boolean isTerminal(){
        return terminal;
    }

}


