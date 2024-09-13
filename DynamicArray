/**
 * A simple class to demonstrate dynamic behavior with arrays. Objects of this
 * class store strings in an array that grows to match the demand for storage.
 * 
 * The class is based on an underlying string array. Objects can be initialized
 * to any size; otherwise they'll be initialized to the default size. For
 * example,
 * 
 * DynamicArray da1 = new DynamicArray(10);
 * 
 * will have initially room for 10 strings, while
 * 
 * DynamicArray da2 = new DynamicArray();
 * 
 * will have initially room for 4 strings.
 */
public class DynamicArray {

    /** Default size for underlying array */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array for this class */
    private String[] foundation;

    private int size;

    /**
     * Full constructor. Initializes the underlying array to the specified size. The
     * size must be a positive, non zero value. Otherwise the constructor uses the
     * default size value.
     */
    public DynamicArray(int size) {
        // If size <= 0 use default -- this is a good time to demo ternary operator
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
    } // full constructor

    /** Array-based constructor -- used for testing */
    public DynamicArray(String[] data) {
        this.foundation = data;
    } // array-based constructor

    /**
     * Default constructor
     */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    // goes through the array and checks if the target is in the array
    public boolean contains(String target) {
        boolean containWord = false;
        for (int i = 0; i < size; i++) {
            if (target.equals(foundation[i])) {
                containWord = true;
            }
        }
        return containWord;
    }

    public String get(int index) {
        // returns null if the index is out of bounds
        if (index < 0 || index > size) {
            return null;
        }
        // returns the string at the index
        return foundation[index];
    }

    // deletes the string at the index and returns the string in the index
    public String remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        String removedElement = foundation[index]; // Save the element that will be removed
        String[] newFoundation = new String[size - 1];
        
        for (int i = 0, j = 0; i < size; i++) {
            if (i != index) {
                newFoundation[j] = foundation[i];
                j++;
            }
        }
        foundation = newFoundation; // Replace the old array with the new array
        size--; // Decrease size after removing the element
        
        return removedElement;
    }

    // deletes the string at the index without returning it
    public void delete(int index) {
        String[] subFoundation = foundation; // creates a placeholder for the old array
        foundation = new String[size - 1];// creates a new array that is one index smaller
        for (int i = 0; i < size; i++) {
            int j = 0;
            if (i != index) {
                foundation[j] = subFoundation[i];
                j++;
            }
        }
    }

    public void insert(String string) {
        // Checks if the array is full, and resize if needed
        if (size == foundation.length) {
            resize();
        }

        foundation[size] = string; // Add the new string to the first available position
        size++; // : increases the size to reflect the new element
    }

    private void resize() {
        // Double the size of the foundation array
        String[] newFoundation = new String[foundation.length * 2];

        // Copy existing elements into the new array
        for (int i = 0; i < foundation.length; i++) {
            newFoundation[i] = foundation[i];
        }

        // Replace the old array with the new one
        foundation = newFoundation;
    }

    /** Driver/test code */
    public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";
        // Test data
        String[] testData = { "Java", "Python", "C", "C++", "Fortran" };
        DynamicArray test = new DynamicArray(testData);
        DynamicArray tset = new DynamicArray(null);
        // Naive testing - I am ashamed to do this but I need
        // to keep things simple for now.
        String testContainsNullTarget = (!test.contains(null)) ? PASS : FAIL;
        String testContainsEmptyData = (!tset.contains("Java")) ? PASS : FAIL;
        String testContainsExisting = (test.contains(testData[1])) ? PASS : FAIL;
        String testContainsNonExisting = (!test.contains(NON_EXISTING)) ? PASS : FAIL;
        String testGetNegative = (test.get(-1) == null) ? PASS : FAIL;
        String testGet = (test.get(0).equals(testData[0])) ? PASS : FAIL;
        String testGetOutOfBounds = (test.get(testData.length + 1) == null) ? PASS : FAIL;
        String testRemove = (testData[1].equals(test.remove(1))) ? PASS : FAIL;
        String testRemoveNull = (tset.remove(1) == null) ? PASS : FAIL;
        String testRemoveOutOfBounds = (test.remove(testData.length + 1) == null) ? PASS : FAIL;
        System.out.printf("\nTest for contains(null): ............... %s", testContainsNullTarget);
        System.out.printf("\nTest for contains on null foundation: .. %s", testContainsEmptyData);
        System.out.printf("\nTest for contains (existing): .......... %s", testContainsExisting);
        System.out.printf("\nTest for contains (non existing): ...... %s", testContainsNonExisting);
        System.out.printf("\nTest for get(-1): ...................... %s", testGetNegative);
        System.out.printf("\nTest for get(0): ....................... %s", testGet);
        System.out.printf("\nTest for get(out of bounds): ........... %s\n", testGetOutOfBounds);
        System.out.printf("\nTest for remove(1): .................... %s", testRemove);
        System.out.printf("\nTest for remove(null): ................. %s", testRemoveNull);
        System.out.printf("\nTest for remove(out of bounds): ........ %s\n\n", testRemoveOutOfBounds);
        // If all is good, these two statemets will not crash the program
        test.insert("Pascal");
        test.insert("Basic");
    } // method main

} // class DynamicArray
