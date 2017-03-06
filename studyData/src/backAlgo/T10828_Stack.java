package backAlgo;

import java.util.Scanner;

class Stack {
	
	private static final String TOP = "top";
	private static final String POP = "pop";
	private static final String SIZE = "size";
	private static final String EMPTY = "empty";
	
	static class Arr_stack{
		int top;
		int[] array;
		
		Arr_stack(){
			this.top = 0;
			this.array = new int[10000];
		}
		public void push(int X){
			this.array[this.top++] = X;
		}
		
		public int top(){
			if(this.top == 0) return -1;
			else return this.array[this.top];
		}
		
		public int size(){
			
			return this.top + 1;
		}
		
		public int empty() {
			
			if(this.top == -1) return 1;
			else return 0;
		}
		
		public int pop() {
			
			if(this.top == -1) return -1;
			
			else {
				int temp = this.array[this.top];
				this.array[this.top] = 0;
				this.top--;
				return temp;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Arr_stack st = new Arr_stack();
		
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = Integer.parseInt(scan.nextLine());
			
			for(int i = 0; i < rpt; ++i) {
				String[] call = scan.nextLine().split(" ");
				
				if(call.length < 2) {
					if(call[0].equals(TOP)){
						System.out.println(st.top());
						
					} else if(call[0].equals(POP)){
						System.out.println(st.pop());
						
					} else if(call[0].equals(SIZE)){
						System.out.println(st.size());
						
					} else if(call[0].equals(EMPTY)){
						System.out.println(st.empty());
						
					}
				} 
				else {
					int X = Integer.parseInt(call[1]);
					st.push(X);
				}
				
			}
		}
		
	}

}
