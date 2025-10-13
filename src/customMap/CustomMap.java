package customMap;

public class CustomMap {

    private static class Entry {
        int key;
        int value;
        Entry next;
        public Entry(int key, int value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Entry[] table;
    private int capacity;
    private int size;
    public CustomMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }
    private int hash(int key) {
        return key % capacity;
    }
    public void put(int key, int value) {
        int index = hash(key);
        Entry head = table[index];

        while (head != null) {
            if(head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Entry newEntry = new Entry(key, value, table[index]);
        table[index] = newEntry;
        size++;
    }
    public Integer get(int key) {
        int index = hash(key);
        Entry head = table[index];
        while (head != null) {
            if(head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        CustomMap customMap = new CustomMap(3);
        customMap.put(1,2);
        customMap.put(4,3);
        customMap.put(7,33);
        System.out.println(customMap.get(7));
    }
}
