package assignment1;

public interface SetInterface {
	/*	Elements: Objects
	 * 	Structure: Unstructured
	 * 	Domain: Objects
	 * 
	 * 	Constructors:
	 * 
	 * 	SetInterface();
	 * 	PRE - 
	 * 	POST - A new empty Set is created.
	 * 
	 * 	SetInterface(Identifier first);
	 * 	PRE - 
	 * 	POST - A new Set is created with the given Identifier object as an element.
	 */	
	
	void init();
	/*	PRE - 
	 * 	POST - The Set is initialized.
	 */
	
	void add(Identifier input);
	/*	PRE - The Set has been initialized.
	 * 	POST - The input Identifier object is added to the Set.
	 */
	
	Identifier[] get();
	/*	PRE - The Set has been initialized.
	 * 	POST - An array of Identifier objects is returned, containing all elements of the Set.
	 */
	
	Identifier getAt(int i);
	/*	PRE - The Set contains at least one object.
	 * 	POST - The element at the given index is returned.
	 */
	
	int size();
	/*	PRE - The Set has been initialized. 
	 * 	POST - Returns the number of elements in the Set.
	 */
	
	boolean equals(Set input);
	/*	PRE - Both the Set and the input Set have been initialized.
	 *	POST - Returns true if both Sets contain the same elements and false otherwise. 
	 */
	
	boolean contains(Identifier input);
	/*	PRE - The Set has been initialized.
	 *	POST - Returns true if the input is contained within the Set and false otherwise. 
	 */
	
	Set union(Set input);
	/*	PRE - Both the Set and the input Set have been initialized.
	 *	POST - Returns a Set containing the union of the input Set and this Set. 
	 */
	
	Set intersection(Set input);
	/*	PRE - Both the Set and the input Set have been initialized.
	 *	POST - Returns a Set containing the intersection of the input Set and this Set. 
	 */
	
	Set difference(Set input);
	/*	PRE - Both the Set and the input Set have been initialized.
	 *	POST - Returns a Set containing the difference of the input Set and this Set. 
	 */
	
	Set symmetricDifference(Set input);
	/*	PRE - Both the Set and the input Set have been initialized.
	 *	POST - Returns a Set containing the symmetric difference of the input Set and this Set. 
	 */
}
