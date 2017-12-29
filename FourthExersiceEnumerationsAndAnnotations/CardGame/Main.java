package FourthExersiceEnumerationsAndAnnotations.CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Player playerOne = new Player(console.readLine());
        Player playerTwo = new Player(console.readLine());

        while (playerOne.getNumberOfCardsInHand() < 5) {
            String[] input = console.readLine().split("\\s+");
            if (!DeckOfCards.isTheCardTypePresent(input[0]) || !SuitPower.isTheCardSuitPresent(input[2])){
                System.out.println("No such card exists.");
                continue;
            }

            SuitPower suitPower = Enum.valueOf(SuitPower.class, input[2]);
            DeckOfCards deckOfCards = Enum.valueOf(DeckOfCards.class, input[0]);
            if (playerOne.getFirstPlayerCards().containsKey(suitPower)) {
                if (playerOne.getFirstPlayerCards().get(suitPower).contains(deckOfCards)) {
                    System.out.println("Card is not in the deck.");
                    continue;
                }
            }

            playerOne.addCard(suitPower, deckOfCards);
        }

        while (playerTwo.getNumberOfCardsInHand() < 5) {
            String[] input = console.readLine().split("\\s+");

            if (!DeckOfCards.isTheCardTypePresent(input[0]) || !SuitPower.isTheCardSuitPresent(input[2])){
                System.out.println("No such card exists.");
                continue;
            }

            SuitPower suitPower = Enum.valueOf(SuitPower.class, input[2]);
            DeckOfCards deckOfCards = Enum.valueOf(DeckOfCards.class, input[0]);
            if (playerOne.getFirstPlayerCards().containsKey(suitPower)) {
                if (playerOne.getFirstPlayerCards().get(suitPower).contains(deckOfCards)) {
                    System.out.println("Card is not in the deck.");
                    continue;
                }
            }
            if (playerTwo.getFirstPlayerCards().containsKey(suitPower)) {
                if (playerTwo.getFirstPlayerCards().get(suitPower).contains(deckOfCards)) {
                    System.out.println("Card is not in the deck.");
                    continue;
                }
            }
            playerTwo.addCard(suitPower, deckOfCards);
        }


        if(playerOne.compareTo(playerTwo)>0) {
            CardPower cardPower = playerOne.strongestCardInHand();
            System.out.println(playerOne.getName()+" wins with "+cardPower.getCardType().name()+" of "+cardPower.getSuit().name()+".");
        }
        else {
            CardPower cardPower = playerTwo.strongestCardInHand();
            System.out.println(playerTwo.getName()+" wins with "+cardPower.getCardType().name()+" of "+cardPower.getSuit().name()+".");
        }
    }
}