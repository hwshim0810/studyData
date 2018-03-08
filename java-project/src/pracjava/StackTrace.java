package pracjava;

public class StackTrace {
	 public void test1(){
	        test2();
	    }
	 
	    public void test2(){
	        test3();
	    }

	    public void test3(){
	        test4();
	    }
	 
	    public void test4(){
	        Thread th = Thread.currentThread();
	        StackTraceElement[] lists = th.getStackTrace();
	        
	        for (StackTraceElement list : lists) {
	            System.out.println(list);
	            System.out.println(list.getClassName() + " : " + list.getMethodName());
	        }
	    }
	 
	    public static void main(String[] args){
	        StackTrace test = new StackTrace();
	        test.test1();
	    }
	}