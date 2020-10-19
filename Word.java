public class Word implements Comparable<Word>{
    
    public String wordStr;
    public String definition;
    public String origin;
    public String[] synonyms;

    public Word() {
        // Generic Constructor for Word object
    }
    public Word(String word, String def, String orig, String[] syn) {
        wordStr = word;
        definition = def;
        origin = orig;
        synonyms = syn;
    }

    public String getWord() {
        return this.wordStr;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String[] getSynonyms() {
        return this.synonyms;
    }

    @Override
    public int compareTo(Word word) {
        return this.wordStr.compareTo(word.wordStr);
    }

    /**
	 * Overrides the toString method so that it prints all of the data
     * for a word requested by the user. 
	 * @param none
     * @return String that contains all of the word's data.
	 */
    public String wordInfo() {
        String synoString = "";
        for (String i : synonyms)
            synoString += (i + "  ");
        String wordInfo = "Word: ";
        wordInfo += (this.wordStr + "\n");
        wordInfo += ("Definition: " + this.definition + "\n");
        wordInfo += ("Origin: " + this.origin + "\n");
        wordInfo += ("Synonyms: " + synoString);
        return wordInfo;
    }

}
