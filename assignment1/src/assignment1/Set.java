package assignment1;

import java.util.Random;

public class Set implements SetInterface {
	
	private Identifier[] set;
	private int setSize;
	
	Set() {
		init();
	}
	
	Set(Identifier first){
		init();
		add(first);
	}
	
	Set(Set inputSet){
		Identifier temp;
		
		init();
		
		while (inputSet.size() > 0) {
			temp = inputSet.get();
			add(temp);
			inputSet.remove(temp);
		}
	}

	@Override
	public void init() {
		set = new Identifier[1];
		setSize = 0;
	}
	
	private void expand() {
		Identifier[] temp = new Identifier[setSize + 1];
		
		for (int i = 0; i < set.length; i++) {
			temp[i] = set[i];
		}
		
		set = temp;
	}

	@Override
	public void add(Identifier input) {
		if (setSize == set.length) {
			expand();
		}
		
		set[setSize - 1] = input;
	}

	@Override
	public Identifier get() {
		Identifier temp;
		Random rand = new Random();
		
		temp = set[rand.nextInt(setSize + 1)];
		
		return temp;
	}

	@Override
	public void remove(Identifier input) {
		Identifier[] temp = new Identifier[setSize - 1];
		
		for (int i = 0; i < set.length; i++) {
			if (set[i] == input) {
				continue;
			}
			temp[i] = set[i];
		}
		
		set = temp;
		setSize--;
	}

	@Override
	public int size() {
		return setSize;
	}

	@Override
	public boolean equals(Set input) {
		for (Identifier i : set) {
			if (!input.contains(i)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean contains(Identifier input) {
		for (Identifier i : set) {
			if (i.equals(input)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean exists(Identifier input) {
		for (Identifier i : set) {
			if (!i.equals(input)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public SetInterface union(Set input) throws Exception {
		if (input.size() + setSize > 20) {
			Exception SetSizeException = new Exception("Result would be too large!");
			throw SetSizeException;
		}
		
		SetInterface temp = new Set(input);
		
		for (Identifier i : set) {
			temp.add(i);
		}
		
		return temp;
	}

	@Override
	public SetInterface intersection(Set input) {
		SetInterface temp = new Set();
		
		for (Identifier i : set) {
			if (input.contains(i)) {
				temp.add(i);
			}
		}
		
		return temp;
	}

	@Override
	public SetInterface difference(Set input) {
		SetInterface temp = new Set();
		
		for (Identifier i : set) {
			if (input.contains(i)) {
				continue;
			} else {
				temp.add(i);
			}
		}
		
		return temp;
	}

	@Override
	public SetInterface symmetricDifference(Set input) throws Exception{
		SetInterface temp = new Set(input);
		int counter = 0;
		
		for (Identifier i : set) {
			if (temp.contains(i)) {
				temp.remove(i);
				counter--;
			} else {
				temp.add(i);
				counter++;
			}
			
			if (counter > 20) {
				Exception SetSizeException = new Exception("Resulting set would be too large!");
				throw SetSizeException;
			}
		}
		
		return temp;
	}
}
