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
   * tests that the Dictionary.insert() method works correctly
   */
  @Test
  void testInsert() {
    Dictionary test1 = new Dictionary();
    // insert values
    String[] syn = {"vacant", "clear"};
    Word words = new Word("empty", "containing nothing", "English", syn);
    // inserting a word into dictionary
    test1.insert(words);
    // checking size, should be 1
    if (!(test1.size() == 1))
      fail("testInsert failed");
  }

  /**
   * tests that the Dictionary.get() method works correctly when getting a word within dictionary
   */
  @Test
  void testGet() {
    Dictionary test2 = new Dictionary();
    String[] syn = {"vacant", "clear"};
    Word words = new Word("empty", "containing nothing", "English", syn);
    //inserting a word into dictionary
    test2.insert(words);
    String wordStr = "";
    words.wordStr = wordStr;
    //get() method should not return null since word is in dictionary
    if (test2.get(wordStr) == null)
      fail("testGet failed");

  }

  /**
   * tests that the Dictionary.print() method works correctly when printing words into the dictionary
   */
  @Test
  void testPrint() {
    Dictionary test3 = new Dictionary();
    String[] syn1 = {"choose", "declare"};
    Word words1 = new Word("vote", "a formal expression of opinion or choice", "Latin", syn1);
    String[] syn2 = {"hit", "crash"};
    Word words2 = new Word("slam", "to shut with force and noise", "French", syn2);
    //inserting words into dictionary
    test3.insert(words1);
    test3.insert(words2);
    test3.print();

    //testing the print method by printing the contents of dictionary
    assertEquals(test3.print, "Your Dictionary Contains: \n- vote\n- slam\n");
  }


  /**
   * tests that the Dictionary.clear() method works correctly
   */
  @Test
  void testClear() {
    //dictionary with three words
    Dictionary test4 = newDictionary();
    //clearing the dictionary
    test4.clear();
    //size should be 0
    if (!(test4.size() == 0))
      fail("testClear failed");
  }

  /**
   * tests that the Dictionary.size() method works correctly
   */
  @Test
  void testSize() {
    //dictionary with three words
    Dictionary test5 = newDictionary();
    //size should be 3
    if (!(test5.size() == 3))
      fail("testSize failed");
  }

  /**
   * helper method that creates a dictionary
   *
   * @return dictionary with 3 words and their definition, origin, and synonyms
   */
  public static Dictionary newDictionary() {
    Dictionary dictionary = new Dictionary();
    String[] syn1 = {"choose", "declare"};
    Word words1 = new Word("vote", "a formal expression of opinion or choice", "Latin", syn1);
    String[] syn2 = {"hit", "crash"};
    Word words2 = new Word("slam", "to shut with force and noise", "French", syn2);
    String[] syn3 = {"empower", "enable"};
    Word words3 = new Word("authorize", "to give authority or official power to", "Latin", syn3);
    //insert words into dictionary
    dictionary.insert(words1);
    dictionary.insert(words2);
    dictionary.insert(words3);
    return dictionary;
  }
}
