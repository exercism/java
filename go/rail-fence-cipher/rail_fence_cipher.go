package railfence

func Encode(s string, rails int) string {
	rs := []rune(s)
	size := len(rs)
	res := make([]rune, size)

	for cipherPos, strPos := range makePattern(rails, size) {
		res[cipherPos] = rs[strPos]
	}
	return string(res)
}

func Decode(s string, rails int) string {
	rs := []rune(s)
	size := len(rs)
	res := make([]rune, size)

	for cipherPos, strPos := range makePattern(rails, size) {
		res[strPos] = rs[cipherPos]
	}
	return string(res)
}

func makePattern(rails int, inputLen int) []int {
	railPats := railsPattern(rails, inputLen)
	return flatRailsPattern(railPats)
}

func railsPattern(rails int, inputLen int) [][]int {
	downward := true

	rail := 0
	res := make([][]int, rails)
	for i := 0; i < inputLen; i++ {
		res[rail] = append(res[rail], i)
		if downward {
			rail++
		} else {
			rail--
		}
		if rail == 0 || rail == rails-1 {
			downward = !downward
		}
	}
	return res
}

func flatRailsPattern(pattern [][]int) []int {
	var res []int
	for _, rail := range pattern {
		res = append(res, rail...)
	}
	return res
}
