package lasagna

func PreparationTime(layers []string, avgPerLayer int) int {
    if avgPerLayer == 0 {
        avgPerLayer = 2
    }
    return len(layers) * avgPerLayer
}

func Quantities(layers []string) (int, float64) {
    noodles, sauce := 0, float64(0)
    for _, layer := range layers {
        switch layer {
            case "noodles":
        		noodles += 50
            case "sauce":
        		sauce += 0.2
        }
    }
	return noodles, sauce
}

func AddSecretIngredient(friendsList []string, myList []string) []string {
    return append(myList, friendsList[len(friendsList)-1])
}

func ScaleRecipe(list []float64, portions int) []float64 {
	output := make([]float64, len(list))
	for i := 0; i < len(list); i++ {
		output[i] = list[i] * float64(portions) / 2
	}
	return output
}
