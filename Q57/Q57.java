
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

	// MAIN
	//
	public static void main(String[] args) {
		// Integers
		Integer[] a = {1,2,3,4,5};
		System.out.println("Array of Integers:");
		for (int x : a) System.out.print(x + ", ");
		System.out.println();
		System.out.println("Swapping elements at index 0 & 3");
		swap(a,0,3);
		for (int x : a) System.out.print(x + ", ");
		System.out.printf("\n\n");

		// Doubles
		Double[] b = {0.1,0.2,0.3,0.4,0.5};
		System.out.println("Array of doubles:");
		for (Double x : b) System.out.print(x + ", ");
		System.out.println();
		System.out.println("Swapping elements at index 4 & 2");
		swap(b,4,2);
		for (Double x : b) System.out.print(x + ", ");
		System.out.printf("\n\n");

		// Characters
		Character[] c = {'a','b','c','d','e'};
		System.out.println("Array of chars:");
		for (Character x : c) System.out.print(x + ", ");
		System.out.println();
		System.out.println("Swapping elements at index 1 & 3");
		swap(c,1,3);
		for (Character x : c) System.out.print(x + ", ");
		System.out.printf("\n\n");
	}
}
