
public class BinarySearch {

	public static void main(String[] args) {

		int[] elements = { 1, 3, 4, 5, 8, 9, 14, 17, 75 };
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.binarySearchWithIteration(elements, 19));
		System.out.println(binarySearch.binarySearchWithRecursion(elements, 0, elements.length - 1, 19));

	}

	private int binarySearchWithRecursion(int[] elements, int left, int right, int key) {
		int middle = (left + right) / 2;
		if (left <= right) {
			if (elements[middle] == key)
				return middle;
			else if (elements[middle] < key)
				return binarySearchWithRecursion(elements, middle + 1, right, key);
			else if (elements[middle] > key)
				return binarySearchWithRecursion(elements, left, middle - 1, key);
		}
		return -1;
	}

	private int binarySearchWithIteration(int[] elements, int key) {
		int left = 0;
		int right = elements.length - 1;
		int middle, index = -1;
		while (left <= right) {
			middle = (left + right) / 2;
			if (key < elements[middle])
				right = middle - 1;
			else if (key > elements[middle])
				left = middle + 1;
			else if (key == elements[middle]) {
				index = middle;
				break;
			}
		}
		return index;
	}

}

