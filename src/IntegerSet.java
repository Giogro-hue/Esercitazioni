public class IntegerSet {
    private int[] elements;
    private int size;
    private int currentSize = 0;

    public IntegerSet(int size) {
        this.size = size;
        elements = new int[size];
    }

    public boolean getElement(int value) {
        for(int x: elements) {
            if(x == value) {
                return true;
            }
        }
        return false;
    }

    public void addElement(int value) {
        if(currentSize == size) {
            System.out.println("array is full");
            return;
        }
        elements[currentSize] = value;
        currentSize++;
    }
}
