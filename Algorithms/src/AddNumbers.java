public class AddNumbers {

	
	static LinkedListNode addNumbers(LinkedListNode l1, LinkedListNode l2) {
        int result = 0;
        int mod = 1;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        LinkedListNode resultNode = new LinkedListNode(0);
        while(l1 != null){
            result += l1.val * mod;
            mod = 10 * mod;
            l1 = l1.next;
        }
        mod = 1; //resetting mod;
        while(l2 != null){
            result += l2.val * mod;
            mod = 10 * mod;
            l2 = l2.next;
        }
        LinkedListNode copyResult = resultNode;
        String str = Integer.toString(result);
        for(int i = str.length() - 1; i >=0; i--){
        	resultNode.next = new LinkedListNode((Character.getNumericValue(str.charAt(i))));
        	resultNode = resultNode.next;
           
        }
        return copyResult.next;
    }
	
	public static void main(String[] args) {
		
		LinkedListNode n1 = new LinkedListNode(2);
		LinkedListNode n2 = new LinkedListNode(3);
		LinkedListNode n3 = new LinkedListNode(1);
		n1.next = n2;
		n2.next = n3;
		
		LinkedListNode n4 = new LinkedListNode(1);
		LinkedListNode n5 = new LinkedListNode(1);
		n4.next = n5;
		LinkedListNode result = addNumbers(n1, n4);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}

	}

}
