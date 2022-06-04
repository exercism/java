package raindrops
import "strconv"

// Convert converts a number into a string that contains raindrop sounds
func Convert(inp int) string {
	res := ""
	if inp%3 == 0 {
		res += "Pling"
	}
	if inp%5 == 0 {
		res += "Plang"
	}
	if inp%7 == 0 {
		res += "Plong"
	}
	if res == "" {
		res = strconv.Itoa(inp)
	}
	return res
}