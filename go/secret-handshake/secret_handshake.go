package secret

func Reverse(l []string) []string {
	reversed := make([]string, len(l))
	for i, j := 0, len(l)-1; i <= j; i, j = i+1, j-1 {
		reversed[i], reversed[j] = l[j], l[i]
	}
	return reversed
}

type Event struct {
	Name  string
	Value uint
}

var events = []Event{
	{"wink", 1},
	{"double blink", 2},
	{"close your eyes", 4},
	{"jump", 8},
}

func Handshake(code uint) []string {
	var handshake []string
	for _, event := range events {
		if code&event.Value == event.Value {
			handshake = append(handshake, event.Name)
		}
	}
	if code&16 == 16 {
		handshake = Reverse(handshake)
	}
	return handshake
}
