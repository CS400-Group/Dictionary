public class Dictionary extends RedBlackTree<Word> {
    
    private RedBlackTree<Word> dictionary;

    public Dictionary() {
        dictionary = new RedBlackTree<Word>();
    }

    /**
	 * Insert method used to insert a word into the dictionary 
	 * @param word that is the word requested to insert by user
	 */
    public void insert(Word word) {
        dictionary.insert(word);
    }

    /**
	 * get() method returns a Word object if requested by the user,
     * which is then sent to toString to display that words data. 
	 * @param wordStr- the String representation of the word
     * @return Word that was requested by user. 
	 */
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

    /**
	 * Print method used to print every word in the dictionary
     * for the user to view.
	 * @param none
	 */
    public void print() {
        Node<Word> root = dictionary.root;
        System.out.println("Your Dictionary Contains: ");
        printHelper(root, "- ");
    }

    /**
	 * Helper method for the print() method that recursively
     * prints every element of the dictionary for the user to view.
	 * @param word the current word being printed, if it isn't null
     * @param prefix the prefix put before every word in the list.
	 */
    public void printHelper(Node<Word> word, String prefix) {
        if (word == null) return;
        System.out.println(prefix + word.data.wordStr);
        printHelper(word.rightChild, prefix);
        printHelper(word.leftChild, prefix);
    }

    /**
	 * Main method, calls programs methods 
	 * @param args
	 */
    public void clear() {

    }

    /**
	 * Size() method used to return the size of the dictionary
	 * @param none
     * @return int that is the size of the dictionary
	 */
    public int size() {
        Node<Word> root = dictionary.root;
        return sizeHelper(root);
    }

    /**
	 * Helper method for the size() method. This recursively adds every
     * element in the dictionary.
	 * @param word the word that is currently being added to overall size
     * @return int that is the size of the dictionary
	 */
    public int sizeHelper(Node<Word> word) {
        if(word == null)
            return 0;

        return 1 + sizeHelper(word.leftChild) + sizeHelper(word.rightChild);
    }
}
