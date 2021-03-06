import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class RecursiveMergeSort {
	
	public static void main(String[] args){
		String[] strs = {"push 20", "pop", "inc 2 3", "push 40"};
		superStack(strs);
		
	}
	
    static void superStack(String[] operations) {
        
        StackImpl stack = new StackImpl();
        for(int i = 0; i < operations.length; i++){
            String str = operations[i];
            String command = str.split(" ")[0];
            switch(command.toLowerCase()){
                case "push":
                    Integer value = Integer.valueOf(str.split(" ")[1]);
                    stack.push(value);
                    stack.peak();
                    break;
                case "pop":
                    Integer popped = stack.pop();
                    stack.peak();
                    break;
                case "inc":
                    Integer elementNumber = Integer.valueOf(str.split(" ")[1]);
                    stack.inc(elementNumber, Integer.valueOf(str.split(" ")[2]));
                    stack.peak();
                    break;
                    
                  
                   
            }
        }

    }

public static class StackImpl{
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public void push(Integer i){
        list.add(i);
    }
    
    public Integer pop(){
        if(!list.isEmpty())
           return list.remove(list.size() - 1);
        else return null;
        
    }
    
    public void peak(){
        if(list.size() > 0)
        System.out.println(list.get(list.size() - 1));
        else System.out.println("EMPTY");
    }
    
    public void inc(int elementsChanged, int incrementBy){
        int val = elementsChanged;
        while( val > 0){
            int oldValue = list.get(val - 1);
            list.set(val - 1, oldValue + incrementBy);
        }
    }
    
}

}
