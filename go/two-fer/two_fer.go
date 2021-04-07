// Package twofer provides a way to determine with you should share something
package twofer

// ShareWith tells who you should share something with
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}

	return "One for " + name + ", one for me."
}
