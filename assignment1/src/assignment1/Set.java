package assignment1;

public class Set implements SetInterface {
	
	private Identifier[] set;
	private int setSize;
	private int top;
	private boolean isEmpty;
	
	Set() {
		init();
	}
	
	Set(Identifier first){
		init();
		add(first);
	}
	
	Set(Set inputSet){
		Identifier[] temp = inputSet.getAsArray();
		init();
		
		for (int i = 0; i < temp.length; i++) {
			add(temp[i]);
			System.out.println(set[i]);
		}
	}

	@Override
	public void init() {
		set = new Identifier[1];
		setSize = 0;
		top = 0;
		isEmpty = true;
		return;
	}
	
	private void expand() {
		Identifier[] temp = new Identifier[set.length + 1];
		
		for (int i = 0; i < set.length; i++) {
			temp[i] = set[i];
		}
		
		set = temp;
		return;
	}

	@Override
	public void add(Identifier input) {
		if (isEmpty) {
			set[0] = input;
			setSize++;
			isEmpty = false;
			return;
		} else {
			if (top == set.length - 1) {
				expand();
			}
			top++;
			set[top] = input;
			setSize++;
		}
		
		return;
	}

	@Override
	public Identifier get() {
		return set[top];
	}

	@Override
	public void remove(Identifier input) {
		if (isEmpty) {
			return;
		}
		
		top = 0;
		Identifier[] temp = new Identifier[setSize - 1];
		
		for (int i = 0; i < top; i++) {
			if (set[i].equals(input)) {
				continue;
			} else {
				temp[top] = set[i];
				top++;
			}
		}
		
		setSize--;
		
		if (setSize == 0) {
			isEmpty = true;
		}
		
		return;
	}

	@Override
	public int size() {
		return setSize;
	}

	@Override
	public boolean equals(Set input) {
		boolean output = true;
		
		for (int i = 0; i < set.length; i++) {
			if (!input.contains(set[i])) {
				output = false;
			}
		}
		
		return output;
	}

	@Override
	public boolean contains(Identifier input) {
		if (isEmpty) {
			return false;
		}
		
		for (int i = 0; i < set.length; i++) {
			if (set[i].equals(input)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public SetInterface union(Set input) {
		if (input.size() + setSize > 20) {
			Exception SetSizeException = new Exception("Result would be too large!");
			//throw SetSizeException;
		}
		
		SetInterface temp = new Set(input);
		System.out.println(temp.toString());
		
		for (int i = 0; i < set.length; i++) {
			temp.add(set[i]);
		}
		
		return temp;
	}

	@Override
	public SetInterface intersection(Set input) {
		SetInterface temp = new Set();
		
		for (int i = 0; i < set.length; i++) {
			if (input.contains(set[i])) {
				temp.add(set[i]);
			}
		}
		
		return temp;
	}

	@Override
	public SetInterface difference(Set input) {
		SetInterface temp = new Set();
		
		for (int i = 0; i < set.length; i++) {
			if (input.contains(set[i])) {
				continue;
			} else {
				temp.add(set[i]);
			}
		}
		
		return temp;
	}

	@Override
	public SetInterface symmetricDifference(Set input){
		SetInterface temp = new Set(input);
		int counter = 0;
		
		for (int i = 0; i < set.length; i++) {
			if (temp.contains(set[i])) {
				temp.remove(set[i]);
				counter--;
			} else {
				temp.add(set[i]);
				counter++;
			}
			
			if (counter > 20) {
				Exception SetSizeException = new Exception("Resulting set would be too large!");
				//throw SetSizeException;
			}
		}
		
		return temp;
	}
	
	public String toString() {
		String output = "";
		
		if (isEmpty) {
			return output;
		} else {
			for (int i = 0; i < setSize - 1; i++) {
				output = output + set[i].get() + " ";
			}
		}
		
		return output;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public Identifier[] getAsArray() {
		return set;
	}
}
