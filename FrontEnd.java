import java.util.Scanner;

public class FrontEnd {
	
	static Dictionary dictionary = new Dictionary();
	private static Scanner in = new Scanner(System.in);
	private static String input = "";
	
	/**
	 * Main method, calls programs methods 
	 * @param args
	 */
	public static void main(String[] args) {
		do {
			menu();
			if (input.equalsIgnoreCase("q")) {
				break;
			}
			System.out.print("\nEnter [m] to perform more actions or [q] to quit: ");
			input = in.nextLine();
			while (!input.equals("m") && !input.equalsIgnoreCase("q")) {
				System.out.print("\nInput is invalid, please try again: ");
				input = in.nextLine();
			}
			
			if (input.equalsIgnoreCase("q")) {
				if(isQuitValid()) {
					System.out.println("Thank you for using Dictionary");
					break;
				}
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
		System.out.print("New Dictionary Created: \n"
				+ "Please input a letter corresponding to one of the following actions. \n"
				+ "   [a] Add word \n"
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
		switch (input) {
			case "a": 
				addWord();
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
					System.out.println("Thank you for using Dictionary");
					break;
				} else {
					System.out.println("Quitting has been cancelled. Returning to menu.");
					break;
				}
		}
	}
	
	
	/**
	 * Determines if an input is valid
	 * @param input
	 * @return true if input is confirmed to be valid
	 */
	public static boolean isValidInput(String input) {
		String[] validInputs = {"a", "s", "p", "c", "q"};
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
		dictionary.insert(word);
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
			dictionary.clear();
			System.out.println("Dictionary was successfully cleared, size is " + dictionary.size());
		} else if (input.equalsIgnoreCase("n")) {
			System.out.println("Operation cancelled");
		}
		
	}
	
}
