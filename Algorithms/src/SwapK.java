public class SwapK {

	static LinkedListNode swapNodes(LinkedListNode pList, int iK) {
		if (pList == null)
			return null;
		LinkedListNode p1 = pList;
		LinkedListNode p2 = pList;
		LinkedListNode p3 = pList;
		int i = iK;
		while (i > 2) {
			p1 = p1.next;
			p2 = p2.next;
			i--;
		}

		while (p2.next != null) {
			p2 = p2.next;
			p3 = p3.next;
		}

		LinkedListNode k, kNext, lastK, lastKNext;
		if (iK > 1) k = p1.next;
		else k = p1;
		kNext = k.next;
		lastK = p3.next;
		lastKNext = lastK.next;

		// swapping
		if(iK > 1) p1.next = lastK;
		else p1 = lastK;
		lastK.next = kNext;
		p3.next = k;
		k.next = lastKNext;
		Integer.valueOf('5');
		if(iK > 1)
		return pList;
		else return p1;

	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(11);
		LinkedListNode n2 = new LinkedListNode(4);
		LinkedListNode n3 = new LinkedListNode(6);
		LinkedListNode n4 = new LinkedListNode(7);
		LinkedListNode n5 = new LinkedListNode(1);
		LinkedListNode n6 = new LinkedListNode(-99);
		LinkedListNode n7 = new LinkedListNode(0);
		LinkedListNode n8 = new LinkedListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		LinkedListNode result = swapNodes(n1, 2);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

}
