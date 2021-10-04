package rotationalcipher

import "unicode"

func rotate(r rune, shift int) rune {
    if !unicode.IsLetter(r) {
        return r
    }

    if unicode.IsLower(r) {
        return 'a' + ((r - 'a' + rune(shift)) %26)
    } else {
    	return 'A' + ((r - 'A' + rune(shift)) %26)
    }
}

// RotationalCipher encodes the given s with a rot-shift ASCII cipher
func RotationalCipher(s string, shift int) string {
	var cipher []rune
	for _,r := range s {
        cipheredRune := rotate(r, shift)
		cipher = append(cipher, cipheredRune)
	}
	return string(cipher)
}