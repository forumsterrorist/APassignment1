package assignment1;

public abstract class Identifier implements IdentifierInterface {
	String identifierString = "";
	
	@Override
	public void init(char first) {
		if(Character.isLetter(first)) { //First char has to be a letter, so we check this input.
			identifierString += first; //if the char is a letter, we load it into the string
		}
	} 
	
	@Override
	public void add(char toAdd) {
		if(Character.isLetterOrDigit(toAdd)) { //If the char is a letter or digit, then PRE is met.
			identifierString += toAdd; //add the character to the string.
		}
	}

	@Override
	public String get() {
		return identifierString;
	}

	@Override
	public boolean equals(Identifier input) {
	/*  if(identifierString == input) {
	 *		return true;
	 *	}
	 *	
	 *	else { 
	 *		return false;
	 *	} 
	 */
	}

	@Override
	public int size() {
		if (identifierString.length() >= 1) {
			return identifierString.length();
		}
	}

} 
