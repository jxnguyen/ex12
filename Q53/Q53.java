
class Knoten {
		// ATTRIBUTES
		int value;
    Knoten next;

		// CONSTRUCTOR
    Knoten(int i) {
        this.value = i;
    }
}

class VerketteteListe {
		// ATTRIBUTES
    Knoten head;

		// IS EMPTY | determine if list is empty
		//
		public boolean isEmpty() {

		}

		// INSERT | insert node at beginning of list
		//
    public void insert(int i) {
      Knoten node = new Knoten(i);
      node.next = head;
      head = node;
    }

		// INSERT | insert new node after specific node
		//
		public void insert(int i, Knoten k) {
			Knoten node = new Knoten(i);
			node.next = k.next;
			k.next = node;
		}

		// DELETE | delete head of list & return true, else false
		//
		public boolean delete() {
			if (head != null) {head = head.next; return true;}
			return false;
		}

		// DELETE | delete node k from list & return true, else false
		//
		public boolean delete(Knoten k) {
			// traverse list
			for (Knoten node = head; node != null; node = node.next) {
				// if next node is k
				if (node.next == k) {
					// exclude k
					node.next = k.next;
					return true;
				}
			}
			return false;
		}

		// TRAVERSE | traverse the list & print each node
		//
    public void traverse() {
      for (Knoten node = head; node != null; node = node.next) {
          System.out.print(node.value + ", ");
      }
			System.out.println();
    }

		// NODE FOR VALUE | return first node with value i, else null
		//
		public Knoten nodeForValue(int i) {
			for (Knoten node = head; node != null; node = node.next) {
				if (node.value == i) return node;
			}
			return null;
		}

		// MAIN
		//
		public static void main(String [] x) {

				VerketteteListe list = new VerketteteListe();
				// dummy values
				for (int i = 10; i > 0; i--) {
					list.insert(i);
				}

				System.out.println("Linked list:");
				list.traverse();

				System.out.println("Inserting 20 after 5:");
				Knoten node = list.nodeForValue(5);
				list.insert(20, node);
				list.traverse();

				System.out.println("Deteling head: " + list.delete());
				list.traverse();

				System.out.println("Deleting node 5: " + list.delete(node));
				list.traverse();

				node = new Knoten(12);
				System.out.println("Deleting node not in list: " + list.delete(node));
				list.traverse();

				list.head = null;
				System.out.println("Deleting from empty list: " + list.delete());
		}
}

class VerketteteSchlange extends VerketteteListe {

	Knoten tail;

	public void append(int i) {

	}

	public void append(VerketteteListe l) {

	}
}
