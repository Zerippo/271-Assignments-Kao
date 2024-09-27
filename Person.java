import java.util.Random;

public class Person implements Comparable<Person>, SillyActions {
    

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;
    private static final String funDance = "left, right, left, right, left, right, spin, jump, left, right, left, right, left, right, spin, jump, left, right, left, right, left,";//my ideal dance
    private static final String backwardsAlphabet = "Z Y X W V U T S R Q O N M L K J I H G F E D C B A";
    private static final String poem = "oh what a fun word/n  poems are great/n I am so poetic/n what to say I don't know/n what I do know is I am having a blast!/n OH GEE GOLLY!"; //a poem i wrote on a whim
    private static final String countToTen = "1, 3G, 3GS, 4, 4S, 5, 5C, 5S, 6, 6+, 6S, 6S+, SE, 7, 7+, 8, 8+, 10!"; //counts to 10 using iphone models
    private static final int numberOfLotteryNumbers = 6;
    private static final int possibleLotteryNumbers = 49;
    
    private String firstName;
    private String lastName;
    private int yearBorn;
    Random randomGenerator = new Random();

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /** Default constructor */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /**
     * Implements the Comparable interface to determine the relative order of two
     * persons based on their age.
     * 
     */
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } // method compareTo

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    } // method toString

    //------------------- AUTO GENERATED METHODS ------------------------------

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearBorn() {
        return this.yearBorn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }


    
    //Start of SillyActions Methods
    
    public void makeRandomSound() {
        System.out.println(PoemWords.words[randomGenerator.nextInt(PoemWords.words.length)]);
    }

    public void performSillyDance(){
        System.out.println(funDance);
    }
    
    public String reciteAlphabetBackwards(){
        return backwardsAlphabet;
    }

    //counts to 10 using iphone models
    public void countToTenWeirdly(){
        System.out.println(countToTen);
    }

    public String createWhimsicalPoem(String topic){
        return topic + " " + poem;
    }

        /** Produce numbers for the state lottery */
    public void winStateLottery(){
        System.out.println("Today's winning lottery numbers are: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(randomGenerator.nextInt(49) + 1 + " ");
        }
        System.out.println();
    }
    
}
