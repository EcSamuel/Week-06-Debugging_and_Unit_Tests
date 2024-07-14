public class WarGame {
    private Player player1;
    private Player player2;
    private Deck warDeck;

    public int evaluateCard(CardRank, rank) {
        return rank.getValue();
    }

    public WarGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        warDeck = new Deck();
        dealCards();
    }

    private void dealCards() {
        while (warDeck.remainingCards() > 0) {
            player1.draw(warDeck);
            if (warDeck.remainingCards() > 0) {
                player2.draw(warDeck);
            }
        }
    }

    public void playRound() {
        if (player1.getHand().isEmpty() || player2.getHand().isEmpty()) {
            System.out.println("Game over! Not enough cards to continue.");
            return;
        }

        Card card1 = player1.flip();
        Card card2 = player2.flip();

        System.out.println(player1.getName() + " plays: " + card1);
        System.out.println(player2.getName() + " plays: " + card2);

        if (card1.getValue() > card2.getValue()) {
            player1.incrementScore();
            System.out.println(player1.getName() + " wins this round!");
        } else if (card1.getValue() < card2.getValue()) {
            player2.incrementScore();
            System.out.println(player2.getName() + " wins this round!");
        } else {
            System.out.println("It's a tie!");
            // Handle war situation here if needed
        }

        System.out.println("Current scores: " + player1.getName() + ": " + player1.getScore() 
                           + ", " + player2.getName() + ": " + player2.getScore());
    }

    public void playGame(int rounds) {
        warDeck.shuffle();
        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i);
            playRound();
        }
        announceWinner();
    }

    private void announceWinner() {
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + "wins the game!");
        } else {
            System.out.println("The game is a tie.");
        }
    }
}
// War needs to shuffle the deck

// war needs to deal each player their deck (can be done by cutting he ArrayList in half and making that the new arraylist for each player)

//Players need to move the first card in their new ArrayList to their playzone

//The values of the playzones at its newest iteration needs to be compared, with a "point" added to the winner to keep score. No points awarded on ties.

//the game needs to terminate when there are no more "cards" to deal in each players PlayerDeck ArrayList

// a winner should be determined by the player with the most points at the end of the loop

// if we're having to do this by the full rules of war, there has to be a terminus to the loop otherwise the program runs ad nausaeum

// 2. Create a class called App with a main method.

// a.      Instantiate a Deck and two Players, call the shuffle method on the deck.

// b.     Using a traditional for loop, iterate 52 times calling the Draw method on the other player each iteration using the Deck you instantiated.

// c.      Using a traditional for loop, iterate 26 times and call the flip method for each player.

// Compare the value of each card returned by the two player’s flip methods. Call the incrementScore method on the player whose card has the higher value.  Print a message to say which player received a point.
// Note:  If the values are equal (it is a tie), print a message saying that no point was awarded.
// d.      After the loop, compare the final score from each player.

// e.      Print the final score of each player and either “Player 1”, “Player 2”, or “Draw” depending on which score is higher or if they are both the same.

 