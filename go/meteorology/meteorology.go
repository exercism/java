package meteorology

import (
	"fmt"
)

type TemperatureUnit int

const (
	Celsius    TemperatureUnit = 0
	Fahrenheit TemperatureUnit = 1
)

func (unit TemperatureUnit) String() string {
    switch unit {
        case Celsius: return "°C"
    	case Fahrenheit: return "°F"
    	default: return ""
    }
}

type Temperature struct {
	degree int
	unit   TemperatureUnit
}

func (t Temperature) String() string {
	return fmt.Sprintf("%d %s", t.degree, t.unit)
}

type SpeedUnit int

const (
	KmPerHour    SpeedUnit = 0
	MilesPerHour SpeedUnit = 1
)

func (unit SpeedUnit) String() string {
    switch unit {
        case KmPerHour: return "km/h"
    	case MilesPerHour: return "mph"
    	default: return ""
    }
}

type Speed struct {
	magnitude int
	unit      SpeedUnit
}

func (sp Speed) String() string {
	return fmt.Sprintf("%d %s", sp.magnitude, sp.unit)
}

type MeteorologyData struct {
	location      string
	temperature   Temperature
	windDirection string
	windSpeed     Speed
	humidity      int
}

func (m MeteorologyData) String() string {
	return fmt.Sprintf("%s: %s, Wind %s at %s, %d%% Humidity",
		m.location, m.temperature, m.windDirection, m.windSpeed, m.humidity)
}