// Package proverb provides functionality to make proverbs
package proverb

import "fmt"

// Proverb makes a proverb with the given rhymes
func Proverb(rhyme []string) []string {
	var res []string

	size := len(rhyme)

	if size < 1 {
		return res
	}

	for i := 0; i < size-1; i++ {
		verse := fmt.Sprintf("For want of a %s the %s was lost.", rhyme[i], rhyme[i+1])
		res = append(res, verse)
	}

	res = append(res, fmt.Sprintf("And all for the want of a %s.", rhyme[0]))

	return res
}
