package partyrobot

// Welcome greets a person by name.
func Welcome(name string) string {
	return "Welcome to my party, " + name +  "!"
}

// HappyBirthday wishes happy birthday to the birthday person and stands out his age.
func HappyBirthday(name string, age int) string {
	return "Happy birthday " + name + "! You are now " + string(age) + "years old!"
}

// AssignTable assigns a table to each guest.
func AssignTable(name string, table int, neighbour string, direction string, distance float64) string {
	return fmt.Sprintf("Welcome to my party, %s!\nYou have been assigned to table %d.\nYour table is %s, exactly %.1f meters from here.\nYou will be sitting next to %s", name, table, direction, distance, neighbour)
}
