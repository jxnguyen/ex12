import hanoi.*;


class Q55 {
	public static void main(String[] args) {

		try {
			int[] nums = {1,2,3};
			Tower t = new Tower(nums);
			System.out.println(t);

			// int[] start = t.startTower();
			// for (int x : start) System.out.println(x);

			t.move('a', 'c');
			System.out.println(t);
			t.move('a', 'b');
			System.out.println(t);

			System.out.println("Number of moves: " + t.moves());
		}
		catch (TurmException e) {
			System.out.println(e);
		}
	}
}
