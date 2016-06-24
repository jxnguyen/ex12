
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

		// CONSTRUCTOR
    public void insert(int i) {
			// Insert node at beginning of list
      Knoten node = new Knoten(i);
      node.next = head;
      head = node;
    }

		public void insert(int i, Knoten k) {
			// Insert new node with value i after node k
			Knoten node = new Knoten(i);
			node.next = k.next;
			k.next = node;
		}

		public boolean delete() {
			// Delete the head of the list & return true, else return false
			if (head != null) {head = head.next; return true;}
			return false;
		}

		public boolean delete(Knoten k) {
			// Delete node k from the list & return true, else return false

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

    public void traverse() {
			// Traverse the list & print each node
      for (Knoten node = head; node != null; node = node.next) {
          System.out.print(node.value + ", ");
      }
			System.out.println();
    }

		public Knoten nodeForValue(int i) {
			// Return the first node with the value i, else null
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

	Knoten end;

	public void append(int i) {

	}

	public void append(VerketteteListe l) {

	}
}
