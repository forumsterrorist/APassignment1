package assignment1;

public interface IdentifierInterface {
	/*	Elements: characters
	 * 	Structure: linear
	 * 	Domain: alphanumeric
	 * 	
	 * 	Constructors:
	 * 
	 * 	Identifier();
	 * 	PRE - 
	 * 	POST - A new empty Identifier object is created.
	 * 
	 * 	Identifier(char first);
	 * 	PRE - 
	 * 	POST - A new Identifier object is created, containing the given character.
	 */
	
	void init();
	/*	PRE -
	 * 	POST - The Identifier object is initialized to an empty state.
	 */
	
	void add(char toAdd);
	/*	PRE - The Identifier object must have been initialized.
	 *  POST - the given character is appended.
	 */
	
	String get();
	/*	PRE - The Identifier object must have been initialized.
	 * 	POST - A string is returned, containing the characters representing the value of the Identifier.
	 */
	
	boolean equals(Identifier input);
	/* PRE - Both Identifier objects must have been initialized.
	 * POST - Returns true if both Identifiers contain the same sequence of characters, and false otherwise.
	 */
	
	int size();
	/* PRE - The Identifier object must have been initialized.
	 * POST - Returns the number of characters in the Identifier; if the Identifier does not contain any, returns 0.
	 */
}
