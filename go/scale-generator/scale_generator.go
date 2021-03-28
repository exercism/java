package scale

import (
	"strings"
)

var flatChromatic = []string{"A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab"}
var sharpChromatic = []string{"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"}

// tonicChromatics maps tonics to their chromatic scales
var tonicChromatics = map[string][]string{
	"F": flatChromatic, "Bb": flatChromatic, "Eb": flatChromatic, "Ab": flatChromatic, "Db": flatChromatic, "Gb": flatChromatic, "d": flatChromatic, "g": flatChromatic, "c": flatChromatic, "f": flatChromatic, "bb": flatChromatic, "eb": flatChromatic,
	"G": sharpChromatic, "D": sharpChromatic, "A": sharpChromatic, "E": sharpChromatic, "B": sharpChromatic, "F#": sharpChromatic, "e": sharpChromatic, "b": sharpChromatic, "f#": sharpChromatic, "c#": sharpChromatic, "g#": sharpChromatic, "d#": sharpChromatic,
}

// intervalIncrements maps interval representations to note increments on the scale
var intervalIncrements = map[rune]int{'m': 1, 'M': 2, 'A': 3}

// ParseInterval parses an interval string into semitones above the tonic
func ParseInterval(intervals string) []int {
	if intervals == "" {
		return []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
	}
	pos := 0
	notePos := []int{}
	for _, interval := range intervals {
		notePos = append(notePos, pos)

		if inc, ok := intervalIncrements[interval]; ok {
			pos += inc
		}
	}
	return notePos
}

// ChromaticForTonic returns the chromatic scale for a given tonic and the position of the
// tonic in that scale
func ChromaticForTonic(tonic string) ([]string, int) {
	var ok bool
	var chromatic []string
	var tonicPos = 0

	// Find chromatic
	if chromatic, ok = tonicChromatics[tonic]; !ok {
		chromatic = sharpChromatic
	}

	// Find tonic position in chromatic
	for i, chromaticTonic := range chromatic {
		if strings.EqualFold(chromaticTonic, tonic) {
			tonicPos = i
			break
		}
	}
	return chromatic, tonicPos
}

// Scale returns the list of notes in scale given by a tonic and a set of intervals
func Scale(tonic, interval string) []string {
	notesPositions := ParseInterval(interval)
	chromatic, tonicPos := ChromaticForTonic(tonic)
	scale := []string{}
	for _, pos := range notesPositions {
		scale = append(scale, chromatic[(tonicPos+pos)%12])
	}
	return scale
}
