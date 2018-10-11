package assignment1;

import java.util.Scanner;
import java.io.PrintStream;

public class main{
    static final int MAX_NUMBER_OF_ELEMENTS = 10;
    static PrintStream out;

    public static boolean askSet (Scanner input, String question, Set set) {
        do{
            out.printf("%s", question);
            if (!input.hasNextLine()) {
                out.printf("\n"); // otherwise line with ^D will be overwritten
                return false;
            }
        } 
        while (!inputContainsCorrectSet(input, set));
        return true;
    }


	private static boolean inputContainsCorrectSet(Scanner input, Set set) {
		if(input.next().charAt(0) != '{') { //Input has to start with {, otherwise invalid input.
            out.printf("missing {\n"); 
            return false; //We return false, which means that the input is incorrect.
        }
		while (input.hasNext()) { //if first char = {, and there are more chars, then execute while loop.
			char characterToAdd = input.next().charAt(0);
			Identifier identifier = new Identifier(); 
            boolean newIdentifier = true;  
            System.out.println(input.hasNext());
            if (!Character.isLetterOrDigit(characterToAdd) || !Character.isWhitespace(characterToAdd)) {	
            	if(input.hasNext()){
                    out.printf("Only alpanumeric characters\n");
                } 
            	else{
            		if(characterToAdd != '}'){
                        out.printf("missing }\n");
                    }
                }
                return false;
            }
            else if (Character.isWhitespace(characterToAdd)){
                if(newIdentifier == false){   
                    identifier.init(characterToAdd);
                    set.add(identifier);
                }
                newIdentifier = true;
            }
            else {
                if(newIdentifier = true){
                    if(!Character.isLetter(characterToAdd)){
                        out.printf("first character should be a letter");
                        return false;
                    }
                    identifier.add(characterToAdd);
                    newIdentifier = false;
                } 
                else {
                    identifier.add(characterToAdd);
                }
            }      	
		}
		return true;
	}
       

	static boolean  askBothSets (Scanner input, Set set1, Set set2){
        return askSet(input, "Give first set : ", set1) &&
               askSet(input, "Give second set : ", set2);
    }
	
	private static void calculateAndGiveOutput(Set set1, Set set2){
		try {
			set1.union(set2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        set1.intersection(set2);
        set1.difference(set2);
        try {
			set1.symmetricDifference(set2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    static void start () {
        Scanner in = new Scanner(System.in);
        Set set1 = new Set(),
            set2 = new Set();

        while (askBothSets(in, set1, set2)) {
            calculateAndGiveOutput(set1, set2);
        }
    }
    public static void main(String[] args) {
        out = new PrintStream(System.out);
        main.start();
    }
}


/* The method inputContainsCorrectSet(Scanner input, Set set) should, while
   reading the input (the answer), check whether the input is correct.

   If the input is not correct this method should (1) give an error explaining
   what was wrong with the input, (2) skip the remaining characters of the input
   and (3) return false.

   If the input is correct this method should (1) assign to the parameter set
   the value of the set of identifiers on the input and (2) return true.

   N.B. Do not try to give too intelligent errors. This is not an exercise in
        artificial intelligence.
        For instance, if the input is "{abc def} gh" instead of "{abc def gh}",
        an (relatively easy) error like "no input allowed after '}' is fine. You
        don't have to write a program that seems to understand what you were 
        trying to do and would give an error like "by accident you put the '}'
        before the last identifier instead of after it. Please correct this."
*/
 
