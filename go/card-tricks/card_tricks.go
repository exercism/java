package cards

func validIndex[T any](slice []T, index int) bool {
	size := len(slice)
	if index < 0 || index >= size {
		return false
	}
	return true
}

// FavoriteCards returns a slice with the cards 2, 6 and 9 in that order.
func FavoriteCards() []int {
	return []int{2, 6, 9}
}

// GetItem retrieves an item from a slice at given position.
// If the index is out of range, we want it to return -1.
func GetItem(slice []int, index int) int {
	if !validIndex(slice, index) {
		return -1
	}
	return slice[index]
}

// SetItem writes an item to a slice at given position overwriting an existing value.
// If the index is out of range the value needs to be appended.
func SetItem[T any](slice []T, index int, value T) []T {
	if !validIndex(slice, index) {
		slice = append(slice, value)
	} else {
		slice[index] = value
	}
	return slice
}

// PrependItems adds an arbitrary number of values at the front of a slice.
func PrependItems[T any](slice []T, value ...T) []T {
	return append(value, slice...)
}

// RemoveItem removes an item from a slice by modifying the existing slice.
func RemoveItem[T any](slice []T, index int) []T {
	if slice == nil {
		return nil
	}

	if index >= len(slice) || index < 0 {
		return slice
	}

	return append(slice[:index], slice[index+1:]...)
}
