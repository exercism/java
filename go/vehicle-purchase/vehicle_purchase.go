package purchase

// NeedsLicence determines whether a licence is need to drive a type of vehicle. Only "car" and "truck" require a licence.
func NeedsLicense(kind string) bool {
	return kind == "car" || kind == "truck"
}

// ChooseVehicle recommends a vehicle for selection. It always recommends the vehicle that comes first in dictionary order.
func ChooseVehicle(option1, option2 string) string {
	if option1 < option2 {
        return option1 + " is clearly the better choice."
    }
	return option2 + " is clearly the better choice."
}

// CalculateResellPrice calculates how much a vehicle can resell for at a certain age.
func CalculateResellPrice(originalPrice, age float64) float64 {
	percent := 0.5
    if age < 3 {
        percent = 0.8
    } else if age < 10 {
    	percent = 0.7
    }
	return originalPrice * percent
}

