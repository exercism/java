package diffiehellman

import (
	"crypto/rand"
	"math/big"
)

var TWO = big.NewInt(2)

func PrivateKey(primeP *big.Int) *big.Int {
	max := big.NewInt(0).Sub(primeP, TWO)
	random, err := rand.Int(rand.Reader, max)
	if err != nil {
		panic(err)
	}
	return random.Add(TWO, random)
}

func PublicKey(private, primeP *big.Int, primeG int64) *big.Int {
	return big.NewInt(0).Exp(big.NewInt(primeG), private, primeP)
}

func NewPair(primeP *big.Int, primeG int64) (*big.Int, *big.Int) {
	private := PrivateKey(primeP)
	return private, PublicKey(private, primeP, primeG)
}

func SecretKey(private1, public2, primeP *big.Int) *big.Int {
	return big.NewInt(0).Exp(public2, private1, primeP)
}
