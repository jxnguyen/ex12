import hanoi.*;


class Q55 {
	public static void main(String[] args) {

		try {
			int[] nums = {3,2,1};
			Tower t = new Tower(nums);
			int result = t.move('a', 'c');
			System.out.println(t);
			System.out.println(t.finished());

		}
		catch (TurmException e) {
			System.out.println(e);
		}
	}
}