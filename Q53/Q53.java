
class Knoten {

		int value;
    Knoten next;

    Knoten(int i) {
        this.value = i;
    }
}

class VerketteteListe {

    Knoten head;
		int length;

		// INSERT | insert node at beginning of list
		//
		public void insert(int i) {
			Knoten node = new Knoten(i);
			node.next = head;
			head = node;
			length++;
		}

		// INSERT | insert new node after specific node (if k in list) & return
		//				|	true, else false
		//
		public boolean insert(int i, Knoten k) {
			// if k is in list
			if (isElem(k)) {
				Knoten node = new Knoten(i);
				node.next = k.next;
				k.next = node;
				length++;
				return true;
			}
			return false;
		}

		// DELETE | delete head of list & return true, else false
		//
		public boolean delete() {
			// if at least one elem
			if (length > 1) {
				head = head.next;
				length--;
				return true;
			}
			// list empty
			return false;
		}

		// DELETE | delete node k from list & return true, else false
		//
		public boolean delete(Knoten k) {
			// if k is head
			if (head == k) return delete();
			// traverse list
			for (Knoten node = head; node != null; node = node.next) {
				// if next node is k
				if (node.next == k) {
					// exclude k
					node.next = k.next;
					length--;
					return true;
				}
			}
			// k not in list
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

		// IS ELEM | return true if k is in the list, else false
		//
		public boolean isElem(Knoten k) {
			// traverse list
			for (Knoten node = head; node != null; node = node.next) {
				if (node == k) return true;
			}
			return false;
		}
}

class VerketteteSchlange extends VerketteteListe {

	Knoten tail;

	// INSERT | insert node at beginning of list
	//
	public void insert(int i) {
		super.insert(i);
		// if new node is last node
		if (head.next == null) tail = head;
	}

	// INSERT | insert new node after specific node
	//
	public boolean insert(int i, Knoten k) {
		// insert node & set tail if new node is last
		boolean success = super.insert(i,k);
		if (success && k.next.next == null) tail = k.next;
		return success;
	}

	// DELETE | delete head of list & return true, else false
	//
	public boolean delete() {
		// delete head
		boolean success = super.delete();
		// update tail if neccessary
		if (success && length == 0) tail = null;
		return success;
	}

	// DELETE | delete node k from list & return true, else false
	//
	public boolean delete(Knoten k) {
		// delete node
		boolean success = super.delete(k);
		// if tail deleted
		if (success && tail == k) {
			tail = null;
			// traverse list
			for (Knoten node = head; node != null; node = node.next) {
				// update tail
				if (node.next == null) tail = node;
			}
		}
		return success;
	}

	// APPEND | append node to end of list
	//
	public void append(int i) {
		// if list empty
		if (length == 0) insert(i);
		else {
			// insert after tail & update tail
			Knoten node = new Knoten(i);
			tail.next = node;
			tail = node;
		}
	}

	// APPEND | append linked list to end of list
	//
	public void append(VerketteteSchlange l) {
		// if list empty, take over list
		if (length == 0) {
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

class TestSuite {

	// MAIN
	//
	public static void main(String [] x) {

			VerketteteSchlange list = new VerketteteSchlange();
			VerketteteSchlange list2 = new VerketteteSchlange();
			// dummy values
			for (int i = 10; i > 0; i--) {
				list.insert(i);
				list2.insert(i*10);
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
