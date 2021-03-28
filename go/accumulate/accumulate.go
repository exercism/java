package accumulate

func Accumulate(list []string, transformation func(string) string) []string {
	res := []string{}

	for _, elem := range list {
		res = append(res, transformation(elem))
	}

	return res
}
