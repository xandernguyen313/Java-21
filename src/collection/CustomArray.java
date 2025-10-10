package collection;

import java.util.Arrays;

public class CustomArray {
	private int[] data;
	private int size;
	
	public CustomArray() {
		this.data = new int[2];
		this.size = 0;
	}
	public void add(int x) {
		checkCapacity();
		data[size] = x;
		size++;
	}
	private void resize() {
		int newCapacity = data.length * 2;
		data = Arrays.copyOf(data, newCapacity);
		System.out.println("newCapacity: " + newCapacity);
	}
	private void checkCapacity() {
		if(size + 1 <= data.length) {
			return;
		}
		resize();
	}
	
	public int get(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
        return data[index];
    }
	public int getSize() {
		return size;
	}
}
