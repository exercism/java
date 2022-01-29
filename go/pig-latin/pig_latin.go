package piglatin

import "strings"

type SoundType int

const (
	VOWEL_SOUND SoundType = iota
	CONSONANT_SOUND
)

func Sentence(sentence string) string {
	words := strings.Split(sentence, " ")
	var pigLatin []string

	for _, word := range words {
		pigLatin = append(pigLatin, PigLatin(word))
	}
	return strings.Join(pigLatin, " ")
}

func PigLatin(word string) string {
	start := word[0:2]

	if start == "xr" || start == "yt" {
		// Rule 1: vowel sounds at the beginning of a word
		return word + "ay"
	}

	var cluster string

	var prev rune = -1
	for i, r := range word {
		if r == 'a' || r == 'e' || r == 'i' || r == 'o' || r == 'u' {
			if r == 'u' && prev == 'q' {
				// Rule 3: u after q
				cluster += string(r)
			}
			break
		}

		if r == 'y' && i != 0 {
			// Rule 4: y after a consonant sound
			break
		}

		cluster += string(r)
		prev = r
	}

	// Rule 2: consonant sounds at the beginning of a word
	return strings.TrimPrefix(word, cluster) + cluster + "ay"
}
