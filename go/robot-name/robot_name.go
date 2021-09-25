package robotname

import (
	"errors"
	"math/rand"
)

var generatedNames = map[string]bool{}

var MAX_NAMES = 26 * 26 * 10 * 10 * 10

type Robot struct {
	name string
}

func (r *Robot) Name() (string, error) {
	if len(generatedNames) == MAX_NAMES {
		return "", errors.New("max amount of names reached")
	}

	if r.name == "" {
		r.name = newUniqueName()
	}

	return r.name, nil
}

func (r *Robot) Reset() string {
	r.name = newUniqueName()
	return r.name
}

var letterRunes = []rune("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
var numberRunes = []rune("0123456789")

func newUniqueName() string {
	name := newName()

	for generatedNames[name] {
		name = newName()
	}
	generatedNames[name] = true
	return name
}

func newName() string {
	b := []rune{
		letterRunes[rand.Intn(len(letterRunes))],
		letterRunes[rand.Intn(len(letterRunes))],
		numberRunes[rand.Intn(len(numberRunes))],
		numberRunes[rand.Intn(len(numberRunes))],
		numberRunes[rand.Intn(len(numberRunes))],
	}
	return string(b)
}
