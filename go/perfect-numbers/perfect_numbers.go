package perfect

import "errors"

type Classification string

const (
	ClassificationDeficient Classification = "Deficient"
	ClassificationPerfect   Classification = "Perfect"
	ClassificationAbundant  Classification = "Abundant"
)

var ErrOnlyPositive = errors.New("classification is only possible for numbers greater or equal to zero (0)")

func Factors(n int64) []int64 {
	var factors []int64
	for i := int64(1); i <= n/2; i++ {
		if n%i == 0 {
			factors = append(factors, i)
		}
	}
	return factors
}

func Classify(n int64) (Classification, error) {
	if n <= 0 {
		return "", ErrOnlyPositive
	}

	factors := Factors(n)
	sum := int64(0)
	for _, factor := range factors {
		sum += factor
	}

	switch {
	case sum == n:
		return ClassificationPerfect, nil
	case sum > n:
		return ClassificationAbundant, nil
	case sum < n:
		return ClassificationDeficient, nil
	}

	return "", errors.New("no classification possible")
}
