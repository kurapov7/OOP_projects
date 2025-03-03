package Week3Assignments;

public class Deck {
    private Card[] cards;
    
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++; 
            }
        }
    }
    public Deck(int n){
        this.cards = new Card[n];
    }

    public Card[] getCards(){
        return this.cards;
    }
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card);
            sb.append("\n");  // Append each card followed by a newline
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Deck deck = new Deck();
        // deck.print();
        System.out.println(deck);
    }
}
