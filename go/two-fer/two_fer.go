// Package twofer provides a way to determine with you should share something
package twofer

import "fmt"

// ShareWith tells who you should share something with
func ShareWith(name string) string {

	if name == "" {
		name = "you"
	}

	return fmt.Sprintf("One for %s, one for me.", name)
}
