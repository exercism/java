package twelve

import (
	"strings"
)

var items = []struct{
	day int
	dayOrdinal string
	quantifier string
	itemName string
}{
	{1, "first", "one","a Partridge in a Pear Tree"},
	{2, "second","two","Turtle Doves"},
	{3, "third","three","French Hens"},
	{4, "fourth","four","Calling Birds"},
	{5, "fifth","five","Gold Rings"},
	{6, "sixth","six","Geese-a-Laying"},
	{7, "seventh","seven","Swans-a-Swimming"},
	{8, "eighth","eight","Maids-a-Milking"},
	{9, "ninth","nine","Ladies Dancing"},
	{10, "tenth","ten","Lords-a-Leaping"},
	{11, "eleventh","eleven","Pipers Piping"},
	{12, "twelfth","twelve","Drummers Drumming"},
}

func Verse(n int) string {
	var s strings.Builder

	s.WriteString("On the " + items[n-1].dayOrdinal + " day of Christmas my true love gave to me: ")

	for i := n-1; i>=0; i-- {
		if i == 0 {
			if n != 1{
				s.WriteString( "and " + items[i].itemName)
			} else {
				s.WriteString( items[i].itemName)
			}

		} else {
			s.WriteString( items[i].quantifier + " " + items[i].itemName)
		}

		if i != 0 {
			s.WriteString(", ")
		} else {
			s.WriteString(".")
		}
	}
	return s.String()
}

func Song() string {

	var song strings.Builder

	for _, item := range items {
		song.WriteString(Verse(item.day))

		if item.day != 12 {
			song.WriteRune('\n')
		}
	}

	return song.String()
}