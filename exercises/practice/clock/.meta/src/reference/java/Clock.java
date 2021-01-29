class Clock {
    private static final int MINUTES_IN_AN_HOUR = 60;
    private static final int HOURS_IN_A_DAY = 24;

    private int hours;
    private int minutes;

    Clock(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        sanitiseTime();
    }

    void add(int minutes) {
        this.minutes += minutes;
        sanitiseTime();
    }

    private void sanitiseTime() {
        while (minutes < 0) {
            minutes += MINUTES_IN_AN_HOUR;
            hours--;
        }
        while (hours < 0) {
            hours += HOURS_IN_A_DAY;
        }
        int minutesOverflow = minutes / MINUTES_IN_AN_HOUR;
        minutes = minutes % MINUTES_IN_AN_HOUR;
        hours = (hours + minutesOverflow) % HOURS_IN_A_DAY;
    }

    @Override
    public String toString() {
        return toTimeString(hours) + ":" + toTimeString(minutes);
    }

    private String toTimeString(int number) {
        if (number < 10) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Clock)) {
            return false;
        }
        Clock clock = (Clock) obj;
        return hours == clock.hours && minutes == clock.minutes;
    }
}
