
class BirdCount {
    private int[] birdsPerDay;

    public BirdCount(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        if (birdsPerDay.length == 0) {
            return 0;
        }
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public int incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] = birdsPerDay[birdsPerDay.length - 1] + 1;
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public boolean hasDayWithoutBirds() {
        for (int day : birdsPerDay) {
            if (day == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;

        if (numberOfDays > birdsPerDay.length) {
            numberOfDays = birdsPerDay.length;
        }

        for (int i = 0; i < numberOfDays; i++) {
            total = total + birdsPerDay[i];
        }
        return total;
    }

    public int getBusyDays() {
        int total = 0;

        for (int day : birdsPerDay) {
            if (day >= 5) {
                total++;
            }
        }
        return total;
    }
}
