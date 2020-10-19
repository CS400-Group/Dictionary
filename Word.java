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

    @Override
    public String toString() {
        String wordInfo = "Word: ";
        wordInfo += (this.wordStr + "\n");
        wordInfo += ("Definition: " + this.definition + "\n");
        wordInfo += ("Origin: " + this.origin + "\n");
        wordInfo += ("Synonyms: " + this.synonyms);
        return wordInfo;
    }

}
