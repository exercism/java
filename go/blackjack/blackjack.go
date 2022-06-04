package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	switch card {
	case "ace":
		return 11
	case "eight":
		return 8
	case "two":
		return 2
	case "nine":
		return 9
	case "three":
		return 3
	case "ten":
		return 10
	case "four":
		return 4
	case "jack":
		return 10
	case "five":
		return 5
	case "queen":
		return 10
	case "six":
		return 6
	case "king":
		return 10
	case "seven":
		return 7
	}
	return 0
}


// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	handScore := ParseCard(card1) + ParseCard(card2)
	dealerScore := ParseCard(dealerCard)
	switch {
	case handScore == 22:
		return "P"
	case handScore == 21:
		if dealerScore < 10 {
			return "W"
		} else {
			return "S"
		}
	case handScore >= 17 || handScore >= 12 && dealerScore < 7:
		return "S"
	default:
		return "H"
	}
}

