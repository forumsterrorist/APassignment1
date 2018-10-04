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
		Identifier[] buffer = new Identifier[input.size()];
		int bufferIndex = 0;
		
		while (input.size() > 0) {
			buffer[bufferIndex] = input.get();
			input.remove(buffer[bufferIndex]);
			bufferIndex++;
		}
		
		for (Identifier i : set) {
			for (int j = 0; j < buffer.length - 1; j++) {
				if (i.equals(buffer[j]) == false) {
					return false;
				}
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
			if (i.equals(input) == false) {
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
		
		
		return temp;
	}

	@Override
	public SetInterface intersection(Set input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetInterface difference(Set input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetInterface symmetricDifference(Set input) {
		// TODO Auto-generated method stub
		return null;
	}
}
