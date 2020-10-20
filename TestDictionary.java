// --== CS400 File Header Information ==--
// Name: Crescentia Jung
// Email: csjung@wisc.edu
// Team: IF
// Role: Test Engineer
// TA: Mu Cai
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDictionary {

    /**
     * tests that the Dictionary.insert() method works correctly by checking the size
     */
    @Test
    void testInsert() {
        Dictionary test1 = new Dictionary();
        // insert values
        String[] syn = {"vacant", "clear"};
        Word words = new Word("empty", "containing nothing", "English", syn);
        test1.insert(words);
        if (!(test1.size() == 1))
            fail("testInsert failed");
    }

    /**
     * tests the Dictionary.get() method
     */
    @Test
    void testGet() {
        Dictionary test2 = new Dictionary();
        String[] syn = {"vacant", "clear"};
        Word words = new Word("empty", "containing nothing", "English", syn);
        test2.insert(words);

        String wordStr = "";
        words.wordStr = wordStr;
        if (test2.get(wordStr)== null)
            fail ("testGet failed");

    }

    /**
     * tests the Dictionary.print() method
     */
    @Test
    void testPrint() {
        Dictionary test3 = new Dictionary();
        String[] syn1 = {"choose", "declare"};
        Word words1 = new Word("vote", "a formal expression of opinion or choice", "Latin", syn1);
        String[] syn2 = {"hit", "crash"};
        Word words2 = new Word("slam", "to shut with force and noise", "French", syn2);
        test3.insert(words1);
        test3.insert(words2);
        test3.print();

//    test3.print();
        assertEquals(test3.print, "Your Dictionary Contains: \n- vote\n- slam\n");
    }


    /**
     * tests the Dictionary.clear() method
     */
    @Test
    void testClear() {
        Dictionary test4 = newDictionary();
        test4.clear();
        if (!(test4.size() == 0))
            fail("testClear failed");
    }

    /**
     * tests the Dictionary.size() method
     */
    @Test
    void testSize() {
        Dictionary test5 = newDictionary();
        if(!(test5.size() == 3))
            fail("testSize failed");
    }

//public static void main(String args[]) {
//  testPrint();
//}
    /**
     * helper method that creates a dictionary
     *
     * @return dictionary with 3 words and their definition, origin, and synonyms
     */
    public static Dictionary newDictionary(){
        Dictionary dictionary = new Dictionary();
        String[] syn1 = {"choose", "declare"};
        Word words1 = new Word("vote", "a formal expression of opinion or choice", "Latin", syn1);
        String[] syn2 = {"hit", "crash"};
        Word words2 = new Word("slam", "to shut with force and noise", "French", syn2);
        String[] syn3 = {"empower", "enable"};
        Word words3 = new Word("authorize", "to give authority or official power to", "Latin", syn3);
        dictionary.insert(words1);
        dictionary.insert(words2);
        dictionary.insert(words3);
        return dictionary;
    }
}