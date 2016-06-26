package hanoi;

import java.util.HashMap;
import java.util.Stack;


public class Tower {

	public HashMap<Character, Stack<Integer>> towers;
	private int discs;

	public Tower(int[] startTower) throws TurmException {
		// init start tower
		Stack<Integer> start = new Stack<Integer>();
		for (int x: startTower) start.push(x);
		discs = startTower.length;
		// init towers
		towers = new HashMap<Character, Stack<Integer>>(3);
		towers.put('a', start);
		towers.put('b', new Stack<Integer>());
		towers.put('c', new Stack<Integer>());
	}

	// MOVE | Move the top disc from start tower to end tower, with following
	// 				conditions: 1) start, end are 'a,b,c' & start != end. 2) start
	// 				is not empty. 3) top disc on start is <= top disc on end, or
	// 				end is empty. Returns number representing moved disc.
	//
	public final int move(char start, char end) throws TurmException {

		Stack<Integer> startTower = towers.get(start);
		Stack<Integer> endTower   = towers.get(end);

		if (!("abc".contains(""+start)) || !("abc".contains(""+end))) {
			throw new TurmException("start/end must be 'a', 'b' or 'c'.");
		}
		else if (start == end) {
			throw new TurmException("start/end towers must not be the same.");
		}
		else if (startTower.empty()) {
			throw new TurmException("start tower is empty.");
		}
		else if (!endTower.empty() && startTower.peek() > endTower.peek()) {
			throw new TurmException("Cannot move disc onto smaller disc.");
		}
		else {
			int top = startTower.pop();
			endTower.push(top);
			return top;
		}
	}

	// FINISHED | Return true if towers 'a' & 'b' are empty, else false
	//
	public final boolean finished() {
		return towers.get('a').empty() && towers.get('b').empty();
	}

	// //  START TOWER | Produce a copy of the start tower
	// //
	// public int[] startTower() {
	//
	// }
	//
	// // MOVES | Return the number of previous moves
	// //
	// public final int moves() {
	//
	// }

	// TO STRING | Return string representation of self.
	//
	public String toString() {
		// stacks
		Integer[] a = new Integer[discs];
		Integer[] b = new Integer[discs];
		Integer[] c = new Integer[discs];
		a = towers.get('a').toArray(a);
		b = towers.get('b').toArray(b);
		c = towers.get('c').toArray(c);
		// top spacer
		String result = "\n";
		// for each line
		for (int line = 1; line <= discs; line++) {
			Integer[][] arrs = {a, b, c};
			for (Integer[] t : arrs) {
				// space between towers
				result += "     ";

				if (t[t.length - line] == null) result += "|";
				else result += t[t.length - line];
			}
			result += "\n";
		}
		// tower bases
		result += "    ___   ___   ___\n";
		return result;
	}

}
