/*
 Hashing Strings and Separate Chaining
--------------------------------------
By hashing strings, we mean that we are going to take a string and we're going to hash it into a number. 
- 'a' has a character code of 97. If 'a' has a character code of 97, we're going to subtract 96 from all the letters that are entered - meaning that 'a' is going to have a value of 1
- Then, we are going to cycle through the rest of the letters in the String, and we are going to run this algoirthm on each letter to hash them.
	- (hashValue * 27 + charCode) % arraySize  (Here, 27 represents every character available, plus a space)
- Then, we're going to add all the results to each other, and hash until we are complete. 

Examples:
- Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1  (Here, a is basically 1)
- Hash Key Value 1 * 27 + Character Code 23 % arraySize 11 = 6  (The previous result, i.e. 1, is being fed here as the hash key value)
- Hash Key Value 6 * 27 + Character Code 5 % arraySize 11 = 2

------------------------------------------
Separate Chaining
------------------------------------------
- Instead of adding an item to the next index when a collision is detected, store a list in each index of the array.
 */

import java.util.Scanner;

public class HashFunction3 {

	// Create a mini dictionary that going to hold all common English words that are
	// 3 letters in length, and that start with the letter 'a'
	WordList[] theArray;
	int arraySize;
	public String[][] elementsToAdd = {
			{ "ace", "Very good" },
			{ "act", "Take action" },
			{ "add", "Join (something) to something else" },
			{ "age", "Grow old" },
			{ "ago", "Before the present" },
			{ "aid", "Help, assist, or support" },
			{ "aim", "Point or direct" },
			{ "air", "Invisible gaseous substance" },
			{ "all", "Used to refer to the whole quantity" },
			{ "amp", "Unit of measure for the strength of an electrical current" },
			{ "and", "Used to connect words" }, { "ant", "A small insect" },
			{ "any", "Used to refer to one or some of a thing" },
			{ "ape", "A large primate" },
			{ "apt", "Appropriate or suitable in the circumstances" },
			{ "arc", "A part of the circumference of a curve" },
			{ "are", "Unit of measure, equal to 100 square meters" },
			{ "ark", "The ship built by Noah" },
			{ "arm", "Two upper limbs of the human body" },
			{ "art", "Expression or application of human creative skill" },
			{ "ash", "Powdery residue left after the burning" },
			{ "ask", "Say something in order to obtain information" },
			{ "asp", "Small southern European viper" },
			{ "ass", "Hoofed mammal" },
			{ "ate", "To put (food) into the mouth and swallow it" },
			{ "atm", "Unit of pressure" },
			{ "awe", "A feeling of reverential respect" },
			{ "axe", "Edge tool with a heavy bladed head" },
			{ "aye", "An affirmative answer" } };

	HashFunction3(int size) {
		arraySize = size;
		theArray = new WordList[size];

		for (int index = 0; index < arraySize; index++) {
			theArray[index] = new WordList();
		}

		addTheArray(elementsToAdd);
	}
	
	public void insert(Word newWord) {
		String wordToHash = newWord.theWord;
		
		// Calculate the hash key from a word
		int hashKey = stringHashFunction(wordToHash);
		
		// Add the new word to the array and set the key for the word
		theArray[hashKey].insert(newWord, hashKey);
	}
	
	public void addTheArray(String[][] elementsToAdd) {
		for (int index = 0; index < elementsToAdd.length; index++) {
			String word = elementsToAdd[index][0];
			String definition = elementsToAdd[index][1];
			
			Word newWord = new Word(word, definition);
			
			insert(newWord); // Insert the new word into the array
		}
	}
	
	/**
	 * This method will find the specific word in the hashmap, and print out the relevant definition
	 * @param wordToFind - the word whose definition that you would like to find
	 * @return - the definition of the word specified in the parameter
	 */
	public Word find(String wordToFind) {
		int hashKey = stringHashFunction(wordToFind);
		
		Word theWord = theArray[hashKey].find(hashKey, wordToFind);
		
		return theWord;
	}

	/**
	 * This method is used to hash the strings into values
	 * 
	 * @param wordToHash is the word / string that is to be hashed
	 * @return an integer value representing the hash value
	 */
	public int stringHashFunction(String wordToHash) {
		int hashKeyValue = 0;

		// Cycle through all the different letters in the String that are passed over
		for (int index = 0; index < wordToHash.length(); index++) {
			// The character code for 'a' is 97. The reason why we are subtracting 96 from
			// it is to ensure that the letters start out from the value 1
			int charCode = wordToHash.charAt(index) - 96;
			int hashKeyValueTemp = hashKeyValue;

			hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;

			System.out.println("Hash Key Value " + hashKeyValueTemp + " * 27 + Character Code " + charCode
					+ " % arraySize " + arraySize + " = " + hashKeyValue);
		}

		System.out.println();

		return hashKeyValue;
	}
	
	public void displayTheArray() {
		for (int index = 0; index < arraySize; index++) {
			System.out.println("theArray Index " + index);
			theArray[index].displayTheWordList();
		}
	}
}

class Word {
	public String theWord;
	public String definition;
	public int key;
	public Word next; // Reference to the next word in the list

	/**
	 * The constructor here initializes the word and the definition
	 * 
	 * @param theWord    - the word that you enter
	 * @param definition - the definition of that word
	 */
	public Word(String theWord, String definition) {
		this.theWord = theWord;
		this.definition = definition;
	}

	@Override
	public String toString() {
		return theWord + " : " + definition;
	}

}

class WordList {
	// Create a reference to the first word in our list. This is actually the last
	// word that was added to our list
	public Word firstWord = null;

	public void insert(Word newWord, int hashKey) {
		Word previous = null;
		Word current = firstWord;

		newWord.key = hashKey;

		// Enter the new words in order, inside of our word list. Inserting the words in
		// order will speed up the process of finding words in the list
		while (current != null && newWord.key > current.key) {
			previous = current;
			current = current.next;
		}

		if (previous == null) {
			firstWord = newWord; // Since newWord is the firstWord in the list
		} else {
			previous.next = newWord;
		}

		newWord.next = current;
	}

	/**
	 * This method will display the way how everything's structured in the list
	 */
	public void displayTheWordList() {
		Word currentWord = firstWord;

		while (currentWord != null) {
			System.out.println(currentWord);
			currentWord = currentWord.next; // Set it to the next word item in the list
		}
	}

	public Word find(int hashKey, String wordToFind) {
		Word currentWord = firstWord;

		// Search for the key. We will stop searching if the hashkey is less than what
		// we're searching for
		while (currentWord != null && currentWord.key <= hashKey) {
			if (currentWord.theWord.equals(wordToFind)) {
				return currentWord;
			}

			// If the hashKey cannot be found, switch to the next word in the list
			currentWord = currentWord.next;
		}

		// If anything cannot be found, return null
		return null;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		HashFunction3 wordHashTable = new HashFunction3(11);
		
		String wordLookUp = "a";
		
		// Keep accepting inputs from the user as long as they don't enter the letter 'x'
		while(!wordLookUp.equalsIgnoreCase("x")) {
			System.out.println(": ");
			wordLookUp = input.nextLine();
			System.out.println(wordHashTable.find(wordLookUp));
			
		}
		
		wordHashTable.displayTheArray();
	}
}
