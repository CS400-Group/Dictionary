// --== CS400 File Header Information ==--
// Name: <the name of the team member who wrote the code in this file>
// Email: <the team member's @wisc.edu email address>
// Team: IF
// Role: <the team member's role in your team>
// TA: Mu Cai
// Lecturer: <name of the team mate's lecturer>

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Front end application of the Dictionary class, allows users to create and interact with a Dictionary object
 * @author gabeb
 */
public class FrontEnd {
	
	static Dictionary dictionary = new Dictionary();
	private static Scanner in = new Scanner(System.in);
	private static String input = "";
	
	/**
	 * Main method, calls programs methods 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("New Dictionary Created: ");
		do {
			if (input.equalsIgnoreCase("n") || !isValidInput(input)) {
				menu();
			}
			if (input.equalsIgnoreCase("q")) {
				break;
			}
			System.out.print("\nEnter another menu command, [m] to display the menu or [q] to quit: ");
			input = in.nextLine();
			while (!input.equals("m") && !input.equalsIgnoreCase("q") && !isValidInput(input)) {
				System.out.print("\nInput is invalid, please try again: ");
				input = in.nextLine();
			}
			if (isValidInput(input)) {
				commands(input);
			}
			if (input.equalsIgnoreCase("m")) {		
				System.out.println("Continuing with new command.\n");
			}
			
		} while (!input.equalsIgnoreCase("q"));
	}
	
	/**
	 * Prints a menu of commands for the user to call by entering a letter
	 */
	public static void menu() {
		System.out.print("Please input a letter corresponding to one of the following actions. \n"
				+ "   [a] Add word \n"
				+ "   [f] Add multiple words from a file \n"
				+ "   [s] Search for word \n"
				+ "   [p] Print dictionary contents \n"
				+ "   [c] Clear dictionary contents \n"
				+ "   [q] Quit \n \n"
				+ "Enter input here: ");	
		input = in.nextLine();
		while (!isValidInput(input)) {
			System.out.print("Input is invalid, please try again: ");
			input = in.nextLine();
		}	
		commands(input);
	}
	
	/**
	 * Calls commands based on user input
	 * @param input user's console input that calls various dictionary functions
	 */
	public static void commands(String userInput) {
		switch (userInput) {
			case "a": 
				addWord();
				break;
			case "f":
				readFile();
				break;
			case "s":
				search();
				break;
			case "p":
				print();
				break;
			case "c":
				clear();
				break;
			case "q":
				if (isQuitValid()) {
					System.out.println("Thank you for using Dictionary2");
					input = "q";
				} else {
					System.out.println("Quitting has been cancelled. Returning to menu.");
					menu();
				}
				break;
		}
	}
	
	/**
	 * Determines if an input is valid
	 * @param input
	 * @return true if input is confirmed to be valid
	 */
	public static boolean isValidInput(String input) {
		String[] validInputs = {"a", "s", "p", "c", "q", "f"};
		for (String values : validInputs) {
			if (values.equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Confirms whether a user wants to quit the program
	 * @return true if user confirms quitting
	 */
	public static boolean isQuitValid() {
		System.out.print("\nAre you sure you want to quit? \n"
				+ "Enter [y] for yes or [n] for no: ");
		String verify = in.nextLine();
		while (!verify.equalsIgnoreCase("y") && !verify.equalsIgnoreCase("n")) {
			System.out.print("\nInput is invalid, please try again: ");
			verify = in.nextLine();
		}
		if (verify.equalsIgnoreCase("y")) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 * Constructs a word object based on user input and adds the word to the dictionary
	 */
	public static void addWord() {
		System.out.println("\nAdding a word to the dictionary");
		System.out.print("Enter the word: ");
		String wordStr = in.nextLine();
		System.out.print("Enter the word's defintion: ");
		String definition = in.nextLine();
		System.out.print("Enter the word's origin: ");
		String origin = in.nextLine();
		System.out.print("Enter the word's synonyms (make sure to seperate synonyms by a space): ");
		String synonymsStr  = in.nextLine();
		String[] synonyms = synonymsStr.split(" ");
		Word word = new Word(wordStr, definition, origin, synonyms);
		try {
			dictionary.insert(word);
		} catch (IllegalArgumentException e) {
			System.out.println("No changes made. Word is already in dictionary.");
		}
		
	}
	
	/**
	 * Finds a specified word in the dictionary
	 */
	public static void search() {
		System.out.println("Searching for word in dictionary: ");
		System.out.print("Enter word to search for: ");
		String wordStr = in.nextLine();
		try {
			if (dictionary.get(wordStr) != null) {
				System.out.println("\nWord Found!, search results below: \n");
			}
			System.out.println(dictionary.get(wordStr).wordInfo());
		} catch (NullPointerException e) {
			System.out.println("Word is not in dictionary.");
		}
	}
	
	/**
	 * Prints the dictionary's contents
	 */
	public static void print() {
		System.out.println("Printing the dictionary's contents:");
		if (dictionary.size() == 0) {
			System.out.println("The dictionary is empty");
		} else {
			dictionary.print();
		}
	}
	
	/**
	 * Clears the dictionary of all words
	 */
	public static void clear() {
		System.out.println("Clearig dictionary's contents");
		System.out.print("Are you sure you want to clear the dictionary? \n"
				+ "Enter [y] for yes or [n] for no: ");
		input = in.nextLine();
		while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
			System.out.print("\nInput is invalid, please try again: ");
			input = in.nextLine();
		}
		if (input.equalsIgnoreCase("y")) {
			if (dictionary.size() == 0) {
				System.out.println("Dictionary is already empty");
			} else {
				dictionary.clear();
				System.out.println("Dictionary was successfully cleared, size is " + dictionary.size());
			}	
		} else if (input.equalsIgnoreCase("n")) {
			System.out.println("Operation cancelled");
		}
		
	}
	
	/**
	 * Reads in a user specified file to add words to the dictionary
	 */
	public static void readFile() {
        System.out.println("\nPlease ensure that your file displays word in this form:");
        System.out.println("\t'word,definition,origin, synonym1, synonym2, ... \n with one word per line no spaces except in the definition.");
        System.out.print("What is the path of the file you wish to add?");
        File file = new File(in.nextLine());
        int added = 0;
        int total = 0;
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { 
                String[] str = reader.nextLine().split(",");
                String wordStr = str[0].trim();
                String definition = str[1].trim();
                String origin = str[2].trim();
                String[] synonyms = new String[str.length-3];
                int count = 0;
                for (int i = 3; i < str.length; i++) {
                	synonyms[count] = str[i];
                	count++;
                }
                Word word = new Word(wordStr, definition, origin, synonyms);
                try {
        			dictionary.insert(word);
        			added++;
        			total++;
        		} catch (IllegalArgumentException e) {
        			System.out.println("No changes made. Word is already in dictionary.");
        			total++;
        		}
        		
            }
            reader.close();
            if (added == total) {
            	System.out.println(added + " words were sucessfully added");
            } else {
            	System.out.println("Error: " + added + " of " + total + " words were added");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. Please try again");
            readFile();
        }     
    }
	
}
