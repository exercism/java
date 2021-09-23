package lasagna

// OvenTime tells the expected oven time for the lasagna
const OvenTime = 40

// RemainingOvenTime tells the remaining oven time for the lasagna
func RemainingOvenTime(elapsed int) int {
	return OvenTime - elapsed
}

// PreparationTime tells the preparation time for a lasagna with a given
// number of layers
func PreparationTime(layers int) int {
	return layers * 2
}

// ElapsedTime tells how many minutes in the oven a lasagna with a given
// number of layers has been
func ElapsedTime(layers int, elapsed int) int {
	return PreparationTime(layers) + elapsed
}

