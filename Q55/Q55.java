import hanoi.*;


class Q55 {
	public static void main(String[] args) {

		int[] nums;

		try {
			// default problem
			if (args.length == 1) nums = new int[Integer.valueOf(args[0])];
			// user defined problem size
			else nums = new int[3];
			// populate discs
			for (int i = 0; i < nums.length; i++) nums[i] = i+1;
			// init tower
			Tower t = new Tower(nums);
			System.out.println(t);
			// solve problem
			HanoiSolution.solve(t);
		}
		catch (TurmException e) {
			System.out.println(e);
		}
	}


}

class HanoiSolution {
	// SOLVE | Iterative solution to Tower of Hanoi problem.
	//
	static void solve(Tower t) throws TurmException {

			while (!t.finished()) {
				// if even number of discs
				if (t.discs % 2 == 0) {
					t.anyMove('a','b');
					if (t.finished()) break;
					t.anyMove('a','c');
					if (t.finished()) break;
					t.anyMove('b','c');
				}
				else {
					t.anyMove('a','c');
					if (t.finished()) break;
					t.anyMove('a','b');
					if (t.finished()) break;
					t.anyMove('c','b');
				}
			}
			System.out.println("Solved in " + t.moves() + " moves!");
	}
}
