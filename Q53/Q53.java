
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
		Knoten tail;

		// INSERT | insert node at beginning of list
		//
		public void insert(int i) {
			Knoten node = new Knoten(i);
			node.next = head;
			head = node;
			// if new node is last node
			if (node.next == null) tail = node;
		}

		// INSERT | insert new node after specific node
		//
		public void insert(int i, Knoten k) {
			Knoten node = new Knoten(i);
			node.next = k.next;
			k.next = node;
			// if new node is last node
			if (node.next == null) tail = node;
		}

		// DELETE | delete head of list & return true, else false
		//
		public boolean delete() {
			// if a single element in list
			if (head != null && head == tail) {
				head = tail = head.next;
				return true;
			}
			// more than one element in list
			else if (head != null) {
				head = head.next;
				return true;
			}
			// list empty
			return false;
		}

		// DELETE | delete node k from list & return true, else false
		//
		public boolean delete(Knoten k) {
			// if k is head
			if (head == k) {
				delete();
			}
			// traverse list
			for (Knoten node = head; node != null; node = node.next) {
				// if next node is k
				if (node.next == k) {
					// exclude k
					node.next = k.next;
					// update tail if needed
					if (node.next == null) tail = node;
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
}

class VerketteteSchlange extends VerketteteListe {

	// APPEND | append node to end of list
	//
	public void append(int i) {
		Knoten node = new Knoten(i);
		// if list empty
		if (head == null) {
			// single element
			head = tail = node;
		}
		else {
			// insert after tail & update tail
			tail.next = node;
			tail = node;
		}
	}

	// APPEND | append linked list to end of list
	//
	public void append(VerketteteListe l) {
		// if list empty
		if (head == null) {
			// take over list
			head = l.head;
			tail = l.tail;
		}
		else {
			// concatenate & update tail
			tail.next = l.head;
			tail = l.tail;
		}
	}
}

class Q53 {

	// MAIN
	//
	public static void main(String [] x) {

			VerketteteSchlange list = new VerketteteSchlange();
			VerketteteListe list2 = new VerketteteListe();
			// dummy values
			for (int i = 10; i > 0; i--) {
				list.insert(i);
				list2.insert(i*11);
			}

			System.out.println("Linked list:");
			list.traverse();

			System.out.println("Apppending list:");
			list.append(list2);
			list.traverse();

			System.out.println("Appending 20:");
			list.append(20);
			list.traverse();

	}
}
