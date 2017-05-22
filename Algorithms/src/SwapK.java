public class SwapK {

	// static LinkedListNode swapNodes(LinkedListNode pList, int iK) {
	// if (pList == null)
	// return null;
	// LinkedListNode p1 = pList;
	// LinkedListNode p2 = pList;
	// LinkedListNode p3 = pList;
	// int i = iK;
	// while (i > 2) {
	// p1 = p1.next;
	// p2 = p2.next;
	// i--;
	// }
	//
	// while (p2.next != null) {
	// p2 = p2.next;
	// p3 = p3.next;
	// }
	//
	// LinkedListNode k, kNext, lastK, lastKNext;
	// if (iK > 1) k = p1.next;
	// else k = p1;
	// kNext = k.next;
	// lastK = p3.next;
	// lastKNext = lastK.next;
	//
	// // swapping
	// if(iK > 1) p1.next = lastK;
	// else p1 = lastK;
	// lastK.next = kNext;
	// p3.next = k;
	// k.next = lastKNext;
	// Integer.valueOf('5');
	// if(iK > 1)
	// return pList;
	// else return p1;
	//
	// }
	//
	//

	static LinkedListNode swapNodes(LinkedListNode pList, int iK) {
		if (pList == null || pList.next == null || iK < 1)
			return pList;
		LinkedListNode knode = pList;
		LinkedListNode kBeforeLastNode = pList;
		int i = 1;
		while (i < iK - 1) {
			knode = knode.next;
			i++;
		}

		LinkedListNode beforeKNode = knode;
		if (iK != 1)
			knode = knode.next;

		while (knode != null && knode.next != null && knode.next.next != null) {
			knode = knode.next;
			kBeforeLastNode = kBeforeLastNode.next;
		}

		if (iK == 1) {
			LinkedListNode kLast = kBeforeLastNode.next;
			kLast.next = beforeKNode.next;
			beforeKNode.next = null;
			kBeforeLastNode.next = beforeKNode;
			return kLast;
		} else {

			LinkedListNode kNode = beforeKNode.next;
			LinkedListNode kNextNode = kNode.next;
			if (beforeKNode == kBeforeLastNode.next)
				beforeKNode = kNode;

			LinkedListNode kLast = kBeforeLastNode.next;
			LinkedListNode kLastNext = kLast.next;
			if (kLastNext == kNode)
				kLastNext = kLast;

			beforeKNode.next = kLast;
			kLast.next = kNextNode;

			kBeforeLastNode.next = kNode;
			kNode.next = kLastNext;
			return pList;
		}

	}

	public static void main(String[] args) {
		// LinkedListNode n1 = new LinkedListNode(11);
		// LinkedListNode n2 = new LinkedListNode(4);
		// LinkedListNode n3 = new LinkedListNode(6);
		// LinkedListNode n4 = new LinkedListNode(7);
		// LinkedListNode n5 = new LinkedListNode(1);
		// LinkedListNode n6 = new LinkedListNode(-99);
		// LinkedListNode n7 = new LinkedListNode(0);
		// LinkedListNode n8 = new LinkedListNode(2);
		// n1.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		// n5.next = n6;
		// n6.next = n7;
		// n7.next = n8;

		LinkedListNode n1 = new LinkedListNode(11);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(4);
		LinkedListNode n4 = new LinkedListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		LinkedListNode result = swapNodes(n1, 3);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
