package Week3Assignments;
/* Exercise 11.2 
In the board game Scrabble, each tile contains a letter, which is used to spell
words in rows and columns, and a score, which is used to determine the value of words. 

The point of this exercise is to practice the mechanical part of creating a new class definition:
 */
public class Tile {
    // 1. Write a definition for a class named Tile that represents Scrabble tiles. The instance variables should include a character named letter and an integer named value.
    private char letter;
    private int value;
    
    // 2. Write a constructor that takes parameters named letter and value, and initializes the instance variables.
    public Tile(char letter, int value){
        this.letter = letter;
        this.value = value;
    }
    
    // 3. Write a method named printTile that takes a Tile object as a parameter and displays the instance variables in a reader-friendly format.
    public static void printTile(Tile tile) {
        System.out.println("Letter: "+tile.letter+", Value: "+tile.value);
    }

    // 5. Implement the toString and equals methods for a Tile.
    public String toString(){
        return "Tile { letter = '"+letter+"', value = "+value+" }";
    }
    
    public boolean equals(Tile that){
        return this.letter == that.letter && this.value == that.value;
    }
    
    // 6. Create getters and setters for each of the attributes.
    public char getLetter() { 
        return letter; 
    }
    public int getValue() { 
        return value; 
    }
    public void setLetter(char letter) { 
        this.letter = letter; 
    }
    public void setValue(int value) { 
        this.value = value; 
    }
    
    
    // 4. Write a main method that creates a Tile object with the letter Z and the value 10, and then uses printTile to display the state of the object.
    public static void main(String[] args) {
        // create a Tile w/ letter Z and value 10
        Tile tile = new Tile('Z', 10); 
        Tile tile2 = new Tile('Z', 10);
        Tile tile3 = new Tile('X', 9);
        
        // display tile info using printTile() method
        printTile(tile); 
        
        // using toString()
        System.out.println(tile); 
        
        // Test equals()
        System.out.println(tile.equals(tile2)); // true
        System.out.println(tile.equals(tile3)); // false
    }
}
