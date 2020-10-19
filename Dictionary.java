import java.util.LinkedList;

public class Dictionary extends RedBlackTree<Word> {
    
    private RedBlackTree<Word> dictionary;

    public Dictionary() {
        dictionary = new RedBlackTree<Word>();
    }

    public void insert(Word word) {
        dictionary.insert(word);
    }

    public Word get(String wordStr) throws IllegalArgumentException{
        if (wordStr == null)
            throw new IllegalArgumentException("Word Must Not Be Null");
        Node<Word> current = dictionary.root;
        Word wordToFind = new Word();
        wordToFind.wordStr = wordStr;
        // The following loop will determine if the word is in 
        // the dictionary and will return it. 
        while (current != null) {
            if (current.data.compareTo(wordToFind) == 0) {
                Word foundWord = new Word(wordStr, current.data.definition,
                current.data.origin, current.data.synonyms);
                return foundWord;
            } 
            else if (current.data.compareTo(wordToFind) > 0) {
                current = current.leftChild;
            }
            else if (current.data.compareTo(wordToFind) < 0) {
                current = current.rightChild;
            }
        }
        // If the code reaches here the word does not exist. 
        return null;
    }

    public void print() {
        Node<Word> root = dictionary.root;
        System.out.println("Your Dictionary Contains: ");
        printHelper(root, "- ");
    }

    public void printHelper(Node<Word> word, String prefix) {
        if (word == null) return;
        System.out.println(prefix + word.data.wordStr);
        printHelper(word.rightChild, prefix);
        printHelper(word.leftChild, prefix);
    }

    public void clear() {

    }

    public int size() {
        return 0;
    }
}
