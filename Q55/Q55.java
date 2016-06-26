import hanoi.*;


class Q55 {
	public static void main(String[] args) {

		try {
			int[] nums = {1,2,3,4,5};
			Tower t = new Tower(nums);
			System.out.println(t);

			solve(t);
		}
		catch (TurmException e) {
			System.out.println(e);
		}
	}

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
