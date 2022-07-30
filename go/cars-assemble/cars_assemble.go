package cars

// CalculateWorkingCarsPerHour calculates how many working cars are
// produced by the assembly line every hour
func CalculateWorkingCarsPerHour(productionRate int, successRate float64) float64 {
	return float64(productionRate) * successRate / 100.0
}

// CalculateWorkingCarsPerMinute calculates how many working cars are
// produced by the assembly line every minute
func CalculateWorkingCarsPerMinute(productionRate int, successRate float64) int {
    workingCarsHour := CalculateWorkingCarsPerHour(productionRate, successRate)
	return int(workingCarsHour) / 60
}

const SingleCarCost = 10000
const TenCarCost = 95000

// CalculateCost works out the cost of producing the given number of cars
func CalculateCost(carsCount int) uint {
    oneCarsCost := uint(SingleCarCost * (carsCount%10))
    tenCarsCost := uint(TenCarCost * (carsCount/10))
    
	return oneCarsCost + tenCarsCost
}
