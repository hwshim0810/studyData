package pracjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class CollectionLoop {
    public static void main(String[] args){
    	Map<String, Integer> items = new HashMap<>();
    	items.put("A", 10);
    	items.put("B", 20);
    	items.put("C", 30);
    	items.put("D", 40);
    	items.put("E", 50);
    	items.put("F", 60);
    	
    	items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
    	
    	List<Integer> numbers = new ArrayList<>();
    	numbers.add(1);
    	numbers.add(2);
    	numbers.add(3);
    	numbers.forEach(n -> ee("" + n));
    	
    	Consumer<Integer> EE = (x) -> { System.out.println(x); };
    	 numbers.forEach(EE);
    }
    
    private static void ee(String x) {
    	System.out.println("EE! " + x);
    }
}
