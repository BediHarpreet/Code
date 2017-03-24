
public class Zip {

	
	static LinkedListNode backwords(LinkedListNode pList){
        if(pList != null && pList.next != null && pList.next.next!= null)
            return backwords(pList.next);
        return pList;
    }
	
	static LinkedListNode zippit(LinkedListNode pList) {
        if(pList == null) return pList;
        while(pList != backwords(pList)){
           LinkedListNode temp = pList.next;
           LinkedListNode secondLast = backwords(pList);
           pList.next = secondLast.next;
           secondLast.next = null;
           pList.next.next = temp;
           pList = temp;
        }
        return pList;
    }
	
	
	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(1);
		LinkedListNode temp = n;
		LinkedListNode start = n;
		for(int i = 2; i <= 5; i++){
			n.next = new LinkedListNode(i);
			n = n.next;
		}
		
		zippit(temp);
		while(start != null){
			System.out.println(start.val);
			start = start.next;
		}

	}

}
