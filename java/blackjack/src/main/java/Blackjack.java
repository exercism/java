public class Blackjack {

    public int parseCard(String card) {
        switch (card) {
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
            case "jack":
            case "queen":
            case "king":
                return 10;
            case "ace":
                return 11;
            default:
                return 0;
        }
    }

    public boolean isBlackjack(String card1, String card2) {
        return parseCard(card1) + parseCard(card2) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) {
            return "P";
        } else if (dealerScore < 10) {
            return "W";
        }
        return "S";
    }

    public String smallHand(int handScore, int dealerScore) {

        if (handScore >= 17) {
            // If your cards sum up to 17 or higher you should always stand.
            return "S";
        } else if (handScore <= 11) {
            // If your cards sum up to 11 or lower you should always hit.
            return "H";
        } else if (handScore >= 12 && handScore <= 16 && dealerScore < 7) {
            //If your cards sum up to a value within the range [12, 16] you should always stand unless the dealer has a 7 or higher.
            return "S";
        }

        // Hit otherwise
        return "H";

    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
