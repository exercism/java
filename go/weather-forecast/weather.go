// Package weather contains functionaly related to weather logs 
package weather

var (
    // CurrentCondition represents the current condition
	CurrentCondition string
    // CurrentLocation represents the current location
	CurrentLocation  string
)

// Log creates a log entry with the weather conditions at the location
func Log(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
