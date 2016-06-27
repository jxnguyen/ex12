
class Swap {
	// SWAP | Swap the two elements at list[x] & list[y].
	//
	public static <T> void swap(T[] list, int x, int y) {
		try {
			T temp = list[x];
			list[x] = list[y];
			list[y] = temp;
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds!");
		}
	}

	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5};
		for (int x : a) System.out.print(x + ", ");
		System.out.println();
		swap(a,0,3);
		for (int x : a) System.out.print(x + ", ");
		System.out.println();
	}
}
