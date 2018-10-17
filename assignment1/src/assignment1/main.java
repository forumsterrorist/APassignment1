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
		String temp = input.nextLine();
		String identifierCandidate;
		Identifier identifier;
		Scanner process;
		int counter = 0;
		
		if (temp.isEmpty()) {
			set = new Set();
			return false;
		} else if (temp.charAt(0) == '{' && temp.charAt(temp.length() - 1) == '}') {
			temp = temp.substring(1, temp.length() - 1);
			process = new Scanner(temp);
		} else {
			out.println("Input missing { or }");
			set = new Set();
			return false;
		}
		
		while (process.hasNext()) {
			identifierCandidate = process.next();
			if (!Character.isLetter(identifierCandidate.charAt(0))) {
				out.println("One or more identifiers invalid");
				process.close();
				set = new Set();
				return false;
			} else {
				identifier = new Identifier(identifierCandidate.charAt(0));
				for (char i : identifierCandidate.substring(1).toCharArray()) {
					if (!Character.isLetterOrDigit(i)) {
						out.println("One or more identifiers invalid");
						process.close();
						set = new Set();
						return false;
					} else {
						identifier.add(i);
					}
				}
				set.add(identifier);
			}
			
			if (counter == 10) {
				out.println("Input set too large");
				process.close();
				set = new Set();
				return false;
			} else {
				counter++;
			}
		}
		
		process.close();
		return true;
	}
       

	static boolean  askBothSets (Scanner input, Set set1, Set set2){
        return askSet(input, "Give first set : ", set1) &&
               askSet(input, "Give second set : ", set2);
    }
	
	
	private static void calculateAndGiveOutput(Set set1, Set set2){
		/*try {
			out.println("Union: {" + set1.union(set2).toString() + "}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("Intersection: {" + set1.intersection(set2).toString() + "}");
		out.println("Difference: {" + set1.difference(set2).toString() + "}");
        try {
			out.println("Symmetric difference: {" + set1.symmetricDifference(set2).toString() + "}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		SetInterface set3;
		
		set3 = set1.union(set2);
		out.println("Union: {" + set3.toString() + "}");
		set3 = set1.intersection(set2);
		out.println("Intersection: {" + set3.toString() + "}");
		set3 = set1.difference(set2);
		out.println("Difference: {" + set3.toString() + "}");
		set3 = set1.symmetricDifference(set2);
        out.println("Symmetric difference: {" + set3.toString() + "}");
		
		set1.init();
		set2.init();
		
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
 