import hanoi.*;


class Q55 {
	public static void main(String[] args) {

		try {
			int[] nums = {3,2,1};
			Tower t = new Tower(nums);
			System.out.println(t);

			t.move('a', 'c');
			System.out.println(t);
			t.move('a', 'b');
			System.out.println(t);

			System.out.println("Number of moves: " +t.moves());
		}
		catch (TurmException e) {
			System.out.println(e);
		}
	}
}
