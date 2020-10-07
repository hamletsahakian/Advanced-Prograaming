package assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	private PrintStream out;
	private static final int MAX_NUMBER_OF_ELEMENTS_IN_SET = 10;

	private char nextChar(Scanner in) {
		return in.next().charAt(0);
	}

	private boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c + ""));
	}

	private boolean nextCharIsDigit(Scanner in) {
		return in.hasNext("[0-9]");
	}

	private boolean nextCharIsLetter(Scanner in) {
		return in.hasNext("[A-Za-z]");
	}

	private void skipSpaces(Scanner s) {
		while (s.hasNext("\\s")) {
			nextChar(s);
		}
	}

	private boolean inputContainsCorrectSet(Scanner input, Set set) {
		Scanner s = new Scanner(input.nextLine());
		s.useDelimiter("");
		skipSpaces(s);

		if (!s.hasNext()) {
			return throwError("No input", set);
		}
		if (!nextCharIs(s, '{')) {
			return throwError("Set should start with an opening bracket: '{' ", set);
		}
		nextChar(s);
		skipSpaces(s);
		if (!s.hasNext()) {
			return throwError("No input after opening bracket: '{'", set);
		}
		return analyseSet(s, set);
	}

	private boolean analyseSet(Scanner s, Set set) {
		if (!analyseIdentifiers(s, set)) {
			return false;
		}
		if (!s.hasNext()) {
			return throwError("Set should end with a closing bracket : '}'", set);
		}
		nextChar(s);
		skipSpaces(s);
		if (s.hasNext()) {
			return throwError("No input allowed after closing bracket: '}'", set);
		}
		return true;
	}

	private boolean analyseIdentifiers(Scanner s, Set set) {
		Identifier id = new Identifier();
		if (nextCharIsDigit(s)) {
			return throwError("Identifier should begin with a letter", set);
		}
		while (s.hasNext()) {
			if (nextCharIsDigit(s) || nextCharIsLetter(s)) {
				id.add(nextChar(s));
			} else if (nextCharIs(s, '}')) {
				if (id.size() != 0)
					set.add(id);
				break;
			} else if (nextCharIs(s, ' ')) {
				skipSpaces(s);
				if (set.size() + 2 > MAX_NUMBER_OF_ELEMENTS_IN_SET) {
					return throwError("To many identifiers in set", set);
				}
				set.add(id);
				return analyseIdentifiers(s, set);
			} else {
				return throwError("Invalid identifier. Following characters are allowed: [A-Za-z][0-9]", set);
			}
		}
		return true;
	}

	private boolean throwError(String error, Set set) {
		out.print(error + "\n");
		set.init();
		return false;
	}

	private void calculateAndGiveOutput(Set set1, Set set2) throws Exception {
		out.printf("The results are as below:\n");
		out.printf("Difference = {%s}\n", set1.difference(set2).toString());
		out.printf("Intersection = {%s}\n", set1.intersection(set2).toString());
		out.printf("Union = {%s}\n", set1.union(set2).toString());
		out.printf("Symmetric difference = {%s}\n", set1.symDifference(set2).toString());
	}

	private boolean askSet(Scanner input, String question, Set set) {
		do {
			out.print(question);
			if (!input.hasNextLine()) {
				out.print("\n");    //otherwise line with ˆD will be overwritten
				return false;
			}
		} while (!inputContainsCorrectSet(input, set));
		return true;
	}

	private boolean askBothSets(Scanner input, Set set1, Set set2) {
		return askSet(input, "Give the first set : ", set1) &&
				askSet(input, "Give the second set : ", set2);
	}

	private void emptySets(Set set1, Set set2) {
		set1.init();
		set2.init();	
	}

	private void start() {
		out = new PrintStream(System.out);
		Scanner in = new Scanner(System.in);
		Set set1 = new Set(), set2 = new Set();
		while (askBothSets(in, set1, set2)) {
			out.print("\n");
			try {
				calculateAndGiveOutput(set1, set2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			emptySets(set1, set2);
		}
	}
	public static void main(String[] args) {
		new Main().start();
	}
}