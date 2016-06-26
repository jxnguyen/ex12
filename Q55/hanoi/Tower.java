package hanoi;

import java.util.HashMap;
import java.util.Stack;


public class Tower {

	public HashMap towers;

	public Tower(int[] startTower) throws TurmException {
		// init start tower
		Stack start = new Stack();
		for (int x: startTower) start.push(x);
		// init towers
		towers = new HashMap(3);
		towers.put('a', start);
		towers.put('b', new Stack());
		towers.put('c', new Stack());
	}

	// MOVE | move the top disc from start tower to end tower, with following
	// 				conditions: 1) start, end are 'a,b,c' & start != end. 2) start
	// 				is not empty. 3) top disc on start is <= top disc on end, or
	// 				end is empty. Returns number representing moved disc.
	//
	public final int move(char start, char end) throws TurmException {

		Stack startTower = (Stack)towers.get(start);
		Stack endTower = (Stack)towers.get(end);

		if (!("abc".contains(""+start)) || !("abc".contains(""+end))) {
			throw new TurmException("start/end must be 'a', 'b' or 'c'.");
		}
		else if (start == end) {
			throw new TurmException("start/end towers must not be the same.");
		}
		else if (startTower.empty()) {
			throw new TurmException("start tower is empty.");
		}
		else if (!endTower.empty() && (int)startTower.peek() > (int)endTower.peek()) {
			throw new TurmException("Cannot move disc onto smaller disc.");
		}
		else {
			int top = (int)startTower.pop();
			endTower.push(top);
			return top;
		}
	}

	// FINISHED | return true if towers 'a' & 'b' are empty, else false
	//
	public final boolean finished() {
		return ((Stack)towers.get('a')).empty() && ((Stack)towers.get('b')).empty();
	}

	// //  START TOWER | produce a copy of the start tower
	// //
	// public int[] startTower() {
	//
	// }
	//
	// // MOVES | return the number of previous moves
	// //
	// public final int moves() {
	//
	// }

	public String toString() {
		Stack a = (Stack)towers.get('a');
		Stack b = (Stack)towers.get('b');
		Stack c = (Stack)towers.get('c');
		return a.toString() + "\n" + b.toString() + "\n" + c.toString();
	}

}
