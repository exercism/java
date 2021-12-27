package meetup

import (
	"time"
)

// Define the WeekSchedule type here.

type WeekSchedule string

const (
	First  WeekSchedule = "first"
	Second WeekSchedule = "second"
	Third  WeekSchedule = "third"
	Fourth WeekSchedule = "fourth"
	Fifth  WeekSchedule = "fifth"
	Last   WeekSchedule = "last"
	Teenth WeekSchedule = "teenth"
)

func Day(week WeekSchedule, weekday time.Weekday, month time.Month, year int) int {

	firstDayOfMonth := time.Date(year, month, 1, 0, 0, 0, 0, time.UTC)
	weekDiff := weekday - firstDayOfMonth.Weekday()
	if weekDiff < 0 {
		weekDiff = 7 + weekDiff
	}

	firstDay := firstDayOfMonth.AddDate(0, 0, int(weekDiff))

	days := make([]time.Time, 0, 5)
	currentDay := firstDay
	for currentDay.Month() == month {
		days = append(days, currentDay)
		currentDay = currentDay.AddDate(0, 0, 7)
	}

	switch week {
	case First:
		return days[0].Day()
	case Second:
		return days[1].Day()
	case Third:
		return days[2].Day()
	case Fourth:
		return days[3].Day()
	case Fifth:
		return days[4].Day()
	case Last:
		return days[len(days)-1].Day()
	default:
		// Teenth
		for _, day := range days {
			if day.Day() >= 13 && day.Day() <= 19 {
				return day.Day()
			}
		}
	}
	return firstDayOfMonth.Day()
}
