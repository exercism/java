package cars

// SuccessRate is used to calculate the ratio of an item being created without
// error for a given speed
func SuccessRate(speed int) float64 {
	if speed == 0 {
		return 0.0
	}

	if speed < 5 {
		return 1.0
	}

	if speed >= 9 {
		return 0.77
	}

	return 0.9
}

// CalculateProductionRatePerHour for the assembly line, taking into account
// its success rate
func CalculateProductionRatePerHour(speed int) float64 {
	return float64(speed) * 221.0 * SuccessRate(speed)
}

// CalculateProductionRatePerMinute describes how many working items are
// produced by the assembly line every minute
func CalculateProductionRatePerMinute(speed int) int {
	return int(CalculateProductionRatePerHour(speed) / 60)
}

func CalculateLimitedProductionRatePerHour(speed int, limit float64) float64 {
    rate := CalculateProductionRatePerHour(speed)
    if rate >= limit {
        return limit
    }
    return rate
}


