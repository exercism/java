// Package proverb provides functionality to make proverbs
package proverb

// Proverb makes a proverb with the given rhymes
func Proverb(rhyme []string) []string {
	size := len(rhyme)
	if size < 1 {
		return nil
	}

	var res []string
	for i := 0; i < size-1; i++ {
		res = append(res, "For want of a "+rhyme[i]+" the "+rhyme[i+1]+" was lost.")
	}
	res = append(res, "And all for the want of a "+rhyme[0]+".")
	return res
}
