public class TrainLine {

    /** The name of the trainline */
    private String name;
    /** Points to the first station in the trainline */
    private TrainStation head;
    /** Points to the last station in the trainline */
    private TrainStation tail;
    /** Keeps a running tally of train stations in the trainline */
    private int numberOfStations;

    /** Full constructor */
    public TrainLine(String name, TrainStation head) {
        this.name = name;
        this.head = head;
        this.numberOfStations = 0;
        if (this.head != null) {
            // If head is not null, there is one station in the line
            this.numberOfStations = 1;
        }
        // At initialization head and tail point to the same station even if null
        this.tail = null;
    } // full constructor

    /** Basic constructor */
    public TrainLine(String name) {
        this(name, null);
    } // basic constructor

    /**
     * Creates a new station with the given name and adds it to the end of the line.
     */
    public void add(String name) {
        // Create the new station to add
        TrainStation newStation = new TrainStation(name);
        // Determine where to place the new station
        if (this.head == null) {
            // Trainline is empty, make new station the head of the line
            this.head = newStation;
        } else {
            // When there is a head station already, add the new station after the last
            // station in the line.
            this.tail.setNext(newStation);
        }
        // The new station becomes the tail station of the line
        this.tail = newStation;
        // Update station count
        this.numberOfStations++;
    } // method add

    /** Returns the number of stations in the line >= 0 */
    public int getNumberOfStations() {
        return numberOfStations;
    } // method getNumberOfStations

    public TrainStation remove(int position) {
        TrainStation removedStation = null;
        if (position >= 1 && position <= this.numberOfStations) {
            // Commence safe operations
            if (position == 1) {
                // Remove head
                removedStation = this.head;
                this.head = this.head.getNext();
            } else {
                // Find the station prior to the one to be removed
                TrainStation cursor = this.head;
                for (int i = 1; i < position-1; i++) {
                    cursor = cursor.getNext();
                }
                // cursor should be at the prior station
                if (cursor.getNext() == this.tail) {
                    this.tail = cursor;
                }
                removedStation = cursor.getNext();
                cursor.setNext(cursor.getNext().getNext());
            }
            this.numberOfStations--;
            removedStation.setNext(null);
        }
        return removedStation;
    }

    
    public void insert(String name, int position) {
        if (position < 1 || position > numberOfStations) {
            throw new IllegalArgumentException("Position out of range");
        }

        TrainStation newStation = new TrainStation(name);

        // If inserting at position 1, we must insert after the first station (head)
        if (position == 1) {
            newStation.setNext(this.head.getNext());
            this.head.setNext(newStation);
        } else {
            TrainStation cursor = this.head;
            // Traverse to the station right before the insertion point
            for (int i = 1; i < position; i++) {
                cursor = cursor.getNext();
            }
            // Insert the new station after the current one
            newStation.setNext(cursor.getNext());
            cursor.setNext(newStation);

            // If the new station was added to the end, update the tail
            if (newStation.getNext() == null) {
                this.tail = newStation;
            }
        }

        numberOfStations++;
    }

    
    @Override
    public String toString() {
        TrainStation current = this.head;
        String result = "";
        String line = "";
        int charCount = 0;
        boolean leftToRight = true;
        int maxLineLength = 80;
        boolean firstLine = true;
        int indent = 0;

        while (current != null) {
            String stationName = current.getName();

            // Handle left-to-right direction
            if (leftToRight) {
                maxLineLength = 80;
                // Check if we can fit the station name in the current line
                
                if (charCount + stationName.length() + 5 <= maxLineLength) {
                    if (charCount == 0){
                        if (!firstLine){
                            for (int i = 0; i < indent; i++){
                                line += " ";
                                charCount++;
                            }
                            
                            line += "+-- ";
                        }
                    }
                    if (charCount != 0)
                        line += " --> ";
                    line += stationName;
                    
                    charCount += stationName.length() + 5;
                } else {
                    // End the line and switch direction
                    result += line + " --+\n";
                    for (int i = 0; i<charCount - 2; i++){
                        result += " ";
                    }
                    result += "|\n";
                    line = "";
                    maxLineLength = charCount;
                    charCount = 0;
                    leftToRight = false;  // Switch to right-to-left
                }
                firstLine = false;
                indent = 0;
            }

            // Handle right-to-left direction
            if (!leftToRight) {
                // Check if we can fit the station name in the current line
                if (charCount + stationName.length() + 5 <= maxLineLength) {
                    if (charCount == 0) {
                        line =  stationName + " --+ " + line;
                    } else {
                        line = stationName + " <-- " + line;
                    }
                    charCount += stationName.length() + 5;
                } else {
                    // End the line and switch back to left-to-right
                    line = "+-- " + line;
                    for (int i = charCount; i<maxLineLength - 4; i++){
                        line = " " + line;
                        indent ++;
                    }
                    
                    
                    result += line + "\n";
                    for (int i = 0; i < indent; i++){
                        result += " ";
                        
                    }
                    result +=  "|\n" ;
                    line = "";
                    charCount = 0;
                    leftToRight = true;  // Switch to left-to-right
                }
            }

            current = current.getNext();  // Move to the next station
        }

        // Handle the final station and add "null" correctly
        if (!leftToRight) {
            result += "null\n" + line;
        } else {
            result += line.substring(0, line.length() - 5) + "\n" + " ".repeat(maxLineLength - 3) + "|\nnull";
        }

        return result;
    }
public static void main(String[] args) {
        // A few station names
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        // A populated trainline
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
        }
        // An empty trainline
        prep_TrainLine brownLineSB = new prep_TrainLine("Brown Line SB");
        // A random station name
        String randomName = "Oak Park";
    } // method main


    
     
    
} // class TrainLine
