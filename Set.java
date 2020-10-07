package assignment1;

public class Set implements SetInterface {

	private Identifier[] setArray;
	private int size;

	Set() {
		setArray = new Identifier[MAX_NUMBER_OF_ELEMENTS];
		size = 0;
	}

	private Set(Set src) {
		setArray = new Identifier[MAX_NUMBER_OF_ELEMENTS];
		for (int i = 0; i < src.size; i++) {
			Identifier idt  = new Identifier(src.setArray[i]);
			setArray[i] = idt;
		}
		size = src.size;
	}

	@Override
	public void init() {
		setArray = new Identifier[MAX_NUMBER_OF_ELEMENTS];
		size = 0;
	}

	@Override
	public void add(Identifier e) {
		if (this.contains(e)) {
			return;
		}
		setArray[size] = new Identifier(e);
		size++;
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				result.append(setArray[i].get());
				continue;
			}
			result.append(setArray[i].get()).append(" ");
		}
		return result.toString();
	}

	@Override
	public Identifier get() {
		size -= 1;
		return setArray[size];
	}

	@Override
	public boolean contains(Identifier e) {
		if (size == 0) return false;
		for (int i = 0; i < size; i++) {
			if (setArray[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean equals(Set s) {
		if (!(size == s.size())) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (!s.contains(setArray[i])) return false;
		}
		return true;
	}

	@Override
	public Set union(Set s) throws Exception {
		Set result = new Set(this);
		for (int i = 0; i < s.size; i++) {
			if (!this.contains(s.setArray[i])) {
				result.add(s.setArray[i]);

				if(result.size() > MAX_NUMBER_OF_ELEMENTS) {
					throw new Exception("The set can only contain a maximum amount of 20 identifiers");
				}
			}
		} 

		return result;
	}

	@Override
	public Set difference(Set s) {
		Set result = new Set();
		for (int i = 0; i < this.size; i++) {
			if (!s.contains(this.setArray[i])) {
				result.add(this.setArray[i]);
			}
		}
		return result;
	}

	@Override
	public Set intersection(Set s) {
		Set result = new Set();
		for (int i = 0; i < this.size; i++) {
			if (s.contains(this.setArray[i])) {
				result.add(this.setArray[i]);
			}
		}
		return result;
	}

	@Override
	public Set symDifference(Set s) throws Exception{
		Set result = new Set();
		for (int i = 0; i < this.size; i++) {
			if (!s.contains(this.setArray[i])) {
				result.add(this.setArray[i]);
			}
		}
		for (int i = 0; i < s.size; i++) {
			if (!this.contains(s.setArray[i])) {
				result.add(s.setArray[i]);			
			}
		}

		if(result.size()> MAX_NUMBER_OF_ELEMENTS) {
			throw new Exception("The set can only contain a maximum amount of 20 identifiers");
		}
		return result;
	}
}