package allergies

const (
	eggs = 1 << iota
	peanuts
	shellfish
	strawberries
	tomatoes
	chocolate
	pollen
	cats
)

var allergies = map[string]uint{
	"eggs":         eggs,
	"peanuts":      peanuts,
	"shellfish":    shellfish,
	"strawberries": strawberries,
	"tomatoes":     tomatoes,
	"chocolate":    chocolate,
	"pollen":       pollen,
	"cats":         cats,
}

func Allergies(a uint) []string {
	ret := []string{}
	for k, _ := range allergies {
		if AllergicTo(a, k) {
			ret = append(ret, k)
		}
	}
	return ret
}

func AllergicTo(i uint, allergen string) bool {
	return i&allergies[allergen] > 0
}