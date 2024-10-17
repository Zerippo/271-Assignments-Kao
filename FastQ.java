public class FastQ {

    private String[] array;
    private int size;
    private int used;
    private int front;
    private int back;

    private static final int DEFAULT_SIZE = 4;

    /** Full constructor */
    public FastQ(int size) {
        if (size <1){
            size = DEFAULT_SIZE;
        }
        this.size = size;
        this.array = new String[this.size];
        this.used = 0;
        this.front = 0;
        this.back = 0;
    } // full constructor

    /** Default constructor */
    public FastQ() {
        this(DEFAULT_SIZE);
    } // default constructor

    public boolean add(String string) {
        boolean success = false;

        if (used > size){
            success = false;
        }
        else{
            array[back] = string;
            back = (back + 1) % size;
            used++;
            success = true;
        }        

        return success;
    } // method add

    public String remove() {
        String success = null;
        
        if (used > 0){
            success = array[front];
            array[front] = null;
            used --;
            front = (front + 1) % size;;
        }
        
        return success;

        
    } // method remove
    
} // class FastQ
