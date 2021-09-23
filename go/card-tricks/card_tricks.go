package cards

func validIndex(slice []int, index int) bool {
	size := len(slice)
	if index < 0 || index >= size {
		return false
	}
	return true
}

// GetItem retrieves an item from a slice at given position. The second return value indicates whether
// a the given index existed in the slice or not.
func GetItem(slice []int, index int) (int, bool) {
	if !validIndex(slice, index) {
		return 0, false
	}
	return slice[index], true
}

// SetItem writes an item to a slice at given position overwriting an existing value.
// If the index is out of range it is be appended.
func SetItem(slice []int, index int, value int) []int {
	if !validIndex(slice, index) {
		slice = append(slice, value)
	} else {
		slice[index] = value
	}
	return slice
}

// PrefilledSlice creates a slice of given length and prefills it with the given value.
func PrefilledSlice(value, length int) []int {
    if length <= 0 {
        return []int{}
    }
	var res []int
	for i := 0; i < length; i++ {
		res = append(res, value)
	}
	return res
}

// RemoveItem removes an item from a slice by modifying the existing slice.
func RemoveItem(slice []int, index int) []int {
	if slice == nil {
		return nil
	}

	if index >= len(slice) || index < 0 {
		return slice
	}

	return append(slice[:index], slice[index+1:]...)
}
