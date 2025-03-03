package Week3Assignments;

import java.util.Arrays;

public class Card {
    // class variables
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7", 
        "8", "9", "10", "Jack", "Queen", "King"};
    
    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};
    
    // instance variables
    private final int rank;
    private final int suit;
    
    // constructor
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    } 
    public boolean equals(Card that) {
        return this.rank == that.rank && this.suit == that.suit;
    }
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1; }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1; 
        }
        return 0; 
    }
    
    // getters
    public int getRank() {
        return this.rank;
    }
    public int getSuit() {
        return this.suit;
    }
    
    public static Card[] newDeck(){
        Card[] deck = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck[index] = new Card(rank, suit);
                index++;
            } 
        }
        return deck;
    }
    // search for flush -- return suit of flush if it exists
    public static int flushSuit(Card[] hand){
        int[] suitCount = new int[4]; // 0=C, 1=D, 2=H, 3=S

        for(Card card : hand){
            suitCount[card.getSuit()]++;
            if(suitCount[card.getSuit()] >= 5) {
                return card.getSuit();
            }
        }
        return -1;
    }
    
    public static boolean hasFlush(Card[] hand){
        return flushSuit(hand) != -1; // returns true if flush exists.
    }
    public static boolean hasRoyal(Card[] hand){
        int flushSuit = flushSuit(hand);
        if(flushSuit == -1) return false; // if no flush, can't be a royal flush

        int[] royalRanks = {1,10,11,12,13};
        boolean[] found = new boolean[5];

        // compare each card in hand to a royal rank
        for(Card card : hand){
            if(card.getSuit() == flushSuit){
                for(int i = 0; i < royalRanks.length; i++){
                    if(card.getRank() == royalRanks[i]){
                        found[i] = true;
                    }
                }
            }
        }
        //check if all royal ranks were found
        for(boolean b: found){
            if(!b) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // Card threeofClubs = new Card(3, 0);
        // Card card = new Card(11, 1);
        // System.out.println("Card: " + threeofClubs);
        // System.out.println(card);
        // Card[] deck = Card.newDeck();
        // System.out.println(Arrays.toString(deck));

        Card[] hand = {
            new Card(10, 2), // 10 of Hearts
            new Card(11, 2), // Jack of Hearts
            new Card(12, 2), // Queen of Hearts
            new Card(13, 2), // King of Hearts
            new Card(1, 2),  // Ace of Hearts
            new Card(3, 1),  // 3 of Diamonds
            new Card(5, 0)   // 5 of Clubs
        };
        if(hasRoyal(hand)){
            System.out.println("You have a Royal Flush!");
        }else if(hasFlush(hand)){
            System.out.println("You have a Flush!");
        }else{
            System.out.println("You have neither a Flush or a Royal Flush :(");
        }
    }
}
