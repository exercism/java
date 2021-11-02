package cipher

import (
	"unicode"
)

type ShiftCipher int

func NewCaesar() Cipher {
	return NewShift(3)
}

func NewShift(s int) Cipher {
	if s <= -26 || s >= 26 || s == 0 {
		return nil
	}
	if s < 0 {
		s += 26
	}
	return ShiftCipher(s)
}

func (c ShiftCipher) Encode(s string) string {
	var res string
	for _, r := range s {
		if r = encodeRuneWithShift(r, int(c)); r >= 0 {
			res += string(r)
		}
	}
	return res
}

func (c ShiftCipher) Decode(s string) string {
	var res string
	for _, r := range s {
		if r = decodeRuneWithShift(r, int(c)); r >= 0 {
			res += string(r)
		}
	}
	return res
}

func encodeRuneWithShift(r rune, shift int) rune {
	if !unicode.IsLetter(r) {
		return -1
	}

	if r >= 'a' && r <= 'z' {
		return (r-'a'+rune(shift))%26 + 'a'
	} else {
		return (r-'A'+rune(shift))%26 + 'a'
	}
}

func decodeRuneWithShift(r rune, shift int) rune {
	if r < 'a' || r > 'z' {
		return -1
	}
	return (r-'a'+rune(26-shift))%26 + 'a'
}

type VigenereCipher string

func NewVigenere(key string) Cipher {
	ok := false
	for _, r := range key {
		if r < 'a' || r > 'z' {
			return nil
		}
		if r != 'a' {
			ok = true
		}
	}
	if !ok {
		return nil
	}
	return VigenereCipher(key)
}

func (v VigenereCipher) Encode(s string) string {
	x := 0
	var res string
	for _, r := range s {
		delta := int(v[x] - 'a')
		if r = encodeRuneWithShift(r, delta); r >= 0 {
			x = (x + 1) % len(v)
			res += string(r)
		}
	}
	return res
}

func (v VigenereCipher) Decode(s string) string {
	x := 0
	var res string
	for _, r := range s {
		delta := int(v[x] - 'a')
		if r = decodeRuneWithShift(r, delta); r >= 0 {
			x = (x + 1) % len(v)
			res += string(r)
		}
	}
	return res
}
