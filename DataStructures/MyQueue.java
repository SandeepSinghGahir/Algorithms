package prac;

import java.util.NoSuchElementException;

public class MyQueue<T> {

	private QueueNode<T> front;
	private QueueNode<T> rear;
	private int queueCapacity = 0;
	private int currentCapacity = 0;
	
	public MyQueue(int capacity){
		this.queueCapacity = capacity;
	}
	
	private static class QueueNode<T>{
		private T data;
		QueueNode<T> next;
		
		private QueueNode(T data) {
			this.data = data;
		}
	}
	
	public static void print(String message) {
		System.out.println(message);
	}
	
	public void add(T data) {
		if (isQueueFull())
			throw new IllegalStateException("Queue is full");
		QueueNode<T> newNode = new QueueNode<T>(data);
		if(front==null) 
			front = newNode;
		else 
			rear.next = newNode;
		rear = newNode;
		print("Added: "+data);
		++currentCapacity;
	}
	
	private boolean isQueueFull() {
		return currentCapacity == queueCapacity;
	}

	public T remove(){
		if(isQueueEmpty())
			throw new NoSuchElementException("Queue is empty");
		T data = front.data;
		front = front.next;
		--currentCapacity;
		return data;
	}
	
	public T peek() {
		if(isQueueEmpty())
			throw new NoSuchElementException("Queue is empty");
		return front.data;
	}
	
	public boolean isQueueEmpty() {
		return front==null;
	}
	public void printQueue() {
		QueueNode<T> ptr = front;
		print("Queue : ");
		while(ptr!=null) {
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		print("");
	}
	public static void main(String[] args) {
	
		MyQueue<Integer> myQueue = new MyQueue<>(4);
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		
		myQueue.printQueue();
		print("Front: "+myQueue.peek());
		print("Removed : "+myQueue.remove());
		print("Front: "+myQueue.peek());
		myQueue.printQueue();
		
		print("Front: "+myQueue.peek());
		myQueue.printQueue();
		print("Removed : "+myQueue.remove());
		myQueue.printQueue();
		
		myQueue.add(13);
		myQueue.add(14);
		myQueue.printQueue();
		
		myQueue.add(14);
		
	}

}
