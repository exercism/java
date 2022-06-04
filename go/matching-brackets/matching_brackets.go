package brackets

func Bracket(input string) bool {

	stacks := map[string]int{
		"bracket":     0, // []
		"braces":      0, // {}
		"parentheses": 0, // ()
	}

	var s []string

	for _, r := range input {
		switch r {
		case '[':
			stacks["bracket"]++
			s = append(s, "bracket")
		case '{':
			stacks["braces"]++
			s = append(s, "braces")
		case '(':
			stacks["parentheses"]++
			s = append(s, "parentheses")
		case ']':
			stacks["bracket"]--
			if stacks["bracket"] < 0 || s[len(s)-1] != "bracket" {
				return false
			}
			s = s[:len(s)-1]
		case ')':
			stacks["parentheses"]--
			if stacks["parentheses"] < 0 || s[len(s)-1] != "parentheses" {
				return false
			}
			s = s[:len(s)-1]
		case '}':
			stacks["braces"]--
			if stacks["braces"] < 0 || s[len(s)-1] != "braces" {
				return false
			}
			s = s[:len(s)-1]
		}

	}

	for _, v := range stacks {
		if v != 0 {
			return false
		}
	}

	return true
}
