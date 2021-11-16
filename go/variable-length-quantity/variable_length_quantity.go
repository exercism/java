package variablelengthquantity

import "errors"

// EncodeVarint encodes the given uint32s into a variable-length quantity (VLQ).
func EncodeVarint(input []uint32) []byte {
	output := make([]byte, 0)
	for _, n := range input {
		output = append(output, encodeUint32(n)...)
	}
	return output
}

func encodeUint32(n uint32) []byte {
	if n == 0 {
		return []byte{0}
	}

	// Build the encoding in reverse, from least significant to most.
	// The encoding is done 7 bits at a time and for now we're ignoring
	// setting the most significant bit in each byte.
	output := make([]byte, 0)
	for n > 0 {
		output = append(output, byte(n)&0x7f)
		n = n >> 7
	}

	// Reverse the encoding, so it goes from most significant byte to least.
	for i, j := 0, len(output)-1; i < j; i, j = i+1, j-1 {
		output[i], output[j] = output[j], output[i]
	}

	// Set most significant bit in all but the last byte.
	for i := 0; i < len(output)-1; i++ {
		output[i] = output[i] | 0x80
	}

	return output
}

func DecodeVarint(input []byte) ([]uint32, error) {
	output := make([]uint32, 0)
	var currentChunk []byte

	isLast := false
	for _, b := range input {
		currentChunk = append(currentChunk, byte(b)&0x7f)
		if b&0x80 == 0 {
			output = append(output, decodeChunk(currentChunk))
			currentChunk = []byte{}
			isLast = true
		} else {
			isLast = false
		}
	}

	if !isLast {
		return nil, errors.New("unfinished chunk")
	}

	return output, nil
}

func decodeChunk(chunk []byte) uint32 {
	var n uint32
	for _, b := range chunk {
		n = n << 7
		n = n | uint32(b&0x7f)
	}
	return n
}
