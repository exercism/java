package lasagna

func PreparationTime(layers []string, averagePrepTime int) int {
	if averagePrepTime == 0 {
		averagePrepTime = 2
	}
	return len(layers) * averagePrepTime
}
func Quantities(layers []string) (int, float64) {
	noodlesCount := 0
	sauceCount := 0
	for _, value := range layers {
		if value == "noodles" {
			noodlesCount += 1
		} else if value == "sauce" {
			sauceCount += 1
		}
	}
	return noodlesCount * 50, float64(sauceCount) * float64(0.2)
}
func AddSecretIngredient(secrets []string, lasagna []string) []string {
	return append(lasagna, secrets[len(secrets)-1])
}

// TODO: define the 'ScaleRecipe()' function
func ScaleRecipe(amounts []float64, portions int) []float64 {
	var quantities []float64 = amounts[0:]
	remPortions := portions / 2
	for i, value := range quantities {
		quantities[i] = value * float64(remPortions)
	}
	return quantities
}
