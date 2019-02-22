package prac;

import java.util.EmptyStackException;

public class MultiStackArray {

	private int stackCapacity;
	private int numberOfStacks = 3;
	private int[] sizes;
	private int[] values;

	public MultiStackArray(int stackCapacity) {
		this.stackCapacity = stackCapacity;
		sizes = new int[numberOfStacks];
		values = new int[numberOfStacks * stackCapacity];
	}

	public void push(int val, int stackNumber) {
		if (isCapacityFull(stackNumber))
			throw new StackOverflowError();
		values[topOfStack(stackNumber)] = val;
		sizes[stackNumber]++;
	}

	private int peek(int stackNumber) {
		return values[topOfStack(stackNumber) - 1];
	}

	private int pop(int stackNumber) {
		if (isStackEmpty(stackNumber))
			throw new EmptyStackException();
		int index = topOfStack(stackNumber) - 1;
		int poppedValue = values[index];
		values[index] = 0;
		sizes[stackNumber]--;
		return poppedValue;
	}

	private boolean isStackEmpty(int stackNumber) {
		return sizes[stackNumber] == 0;
	}

	private int topOfStack(int stackNumber) {
		return (stackNumber * stackCapacity) + sizes[stackNumber];
	}

	private boolean isCapacityFull(int stackNumber) {
		return sizes[stackNumber] == stackCapacity;
	}

	public static void main(String[] args) {

		MultiStackArray tsa = new MultiStackArray(3);
		System.out.println(tsa.isCapacityFull(2));
		tsa.push(11, 0);
		tsa.push(12, 0);
		tsa.push(13, 0);

		tsa.push(21, 1);
		tsa.push(22, 1);
		tsa.push(23, 1);

		tsa.push(31, 2);
		tsa.push(32, 2);
		tsa.push(33, 2);

		System.out.println("Stack Full: " + tsa.isCapacityFull(0));
		System.out.println("Stack Full: " + tsa.isCapacityFull(1));
		System.out.println("Stack Full: " + tsa.isCapacityFull(2));

		for (int i : tsa.values) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.println(tsa.peek(0));
		System.out.println(tsa.peek(1));
		System.out.println(tsa.peek(2));

		System.out.println("Popped :" + tsa.pop(0));
		System.out.println("Popped :" + tsa.pop(1));
		System.out.println("Popped :" + tsa.pop(2));

		for (int i : tsa.values) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.println("Stack Full: " + tsa.isCapacityFull(0));
		System.out.println("Stack Full: " + tsa.isCapacityFull(1));
		System.out.println("Stack Full: " + tsa.isCapacityFull(2));

		tsa.push(14, 0);
		tsa.push(24, 1);
		tsa.push(34, 2);

		System.out.println("Stack Full: " + tsa.isCapacityFull(0));
		System.out.println("Stack Full: " + tsa.isCapacityFull(1));
		System.out.println("Stack Full: " + tsa.isCapacityFull(2));

		for (int i : tsa.values) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.println(tsa.peek(0));
		System.out.println(tsa.peek(1));
		System.out.println(tsa.peek(2));
	}

}
