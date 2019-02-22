import java.util.EmptyStackException;

public class MyStack<T> {
	
	private static class StackNode<T>{
		
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	
	//Method to add new items
	public void push(T item) {
	StackNode<T> t = new StackNode<T>(item);
	t.next = top;
	top = t;
	}
	
	public T pop(){
		if(top==null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public T peek() {
		if (top==null)
			throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null ? true : false;
	}
	
	public static void main(String[] args) {
	
		MyStack<Integer> myStack = new MyStack<Integer>();
		myStack.push(4);
		myStack.push(1);
		myStack.push(7);
		myStack.push(1);
		myStack.push(8);
		myStack.push(7);
		myStack.push(4);
		myStack.push(5);
		System.out.println(myStack.peek());
		System.out.println(myStack.peek());
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());

	}

}
